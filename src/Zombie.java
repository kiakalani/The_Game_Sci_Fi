import javafx.animation.Animation;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.Random;

public class Zombie extends ImageView {

    private final Random rand = new Random();

    private double currentHP;
    private double maxHP;

    private double angle = 0;
    private boolean alive;

    public Zombie(ObservableList<Node> children) {

        maxHP = 100;
        currentHP = maxHP;
        //generates a random position for zombie when it spawns
        double randPosX = (double)(rand.nextInt(99)+1);
        double randPosY = (double)(rand.nextInt(99)+1);
        this.setTranslateX(Run.relativeX(randPosX));
        this.setTranslateY(randPosY);
        alive = true;
        setFitHeight(Run.relativeY(10));
        setFitWidth(Run.relativeX(10));
        this.setImage(new Image("img/something.png"));
        children.add(this);

    }

    public void update(Player player){

        //rotates the zombie towards the player on the update
        angle = Math.toDegrees(Math.atan2(getTranslateY() - player.getTranslateY() , getTranslateX() - player.getTranslateX())) + 180;
        setRotate(getAngle());
        updatePosition();

    }

    private void updatePosition(){
        this.setTranslateX((Math.cos(Math.toRadians(angle)))*Run.relativeX(0.1)+this.getTranslateX());
        this.setTranslateY(this.getTranslateY()+Math.sin(Math.toRadians(angle))*Run.relativeY(0.1));
    }

    public void hit(Player player){
        player.setCurrentHP(player.getCurrentHP() - 20);
    }

    public boolean loseLife(Bullet bullet) {
        if (bullet.getBoundsInParent().intersects(this.getBoundsInParent())) {
            currentHP-=40;
            System.out.println(currentHP);
            new Audio("C:\\Users\\Kia\\IdeaProjects\\TombOfOsiris\\Audio\\death.wav").playNormal();
            return true;
        }
        return false;
    }

    public double getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(double currentHP) {
        this.currentHP = currentHP;
    }

    public double getMaxHP() {
        return maxHP;
    }

    public void setMaxHP(double maxHP) {
        this.maxHP = maxHP;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
