import javafx.scene.image.ImageView;

import java.util.Random;

public class Zombie extends ImageView {

    private final Random rand = new Random();

    private double currentHP;
    private double maxHP;

    private double angle = 0;

    public Zombie() {

        //generates a random position for zombie when it spawns
        double randPosX = (double)(rand.nextInt(99)+1);
        double randPosY = (double)(rand.nextInt(99)+1);
        this.setTranslateX(Run.relativeX(randPosX));
        this.setTranslateY(randPosY);

    }

    public void update(Player player){

        //rotates the zombie towards the player on the update
        angle = Math.toDegrees(Math.atan2(getTranslateY() - player.getY() , getTranslateX() - player.getX())) + 180;
        setRotate(angle);
        updatePosition();

    }

    private void updatePosition(){
        this.setTranslateX(Math.cos(Math.toRadians(angle))*Run.relativeX(5)+this.getTranslateX());
        this.setTranslateY(Math.sin(Math.toRadians(angle)*Run.relativeY(5)+this.getTranslateY()));
    }

    public void hit(Player player){
        player.setCurrentHP(player.getCurrentHP() - 20);
    }



}
