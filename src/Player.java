import javafx.animation.AnimationTimer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.util.LinkedList;

public class Player extends ImageView {
    /**
     * The horizontal speed for updating the position
     */
    private double verticalSpeed;
    /**
     * The vertical speed for updating the position
     */
    private double horizontalSpeed;
    private double angle = 0;
    private LinkedList<Bullet> bullets = new LinkedList<>();
    private ObservableList<Node> group;

    /**
     * Gameplay
     */
    private double totalHP;
    private double currentHP;
    private double currentMagazineAmmo;
    private double totalAmmo;

    private void checkBoundaries() {
        if (getTranslateX()<0) {
            setTranslateX(0);
        }
        if (getTranslateX()+getFitWidth()>Run.relativeX(100)) {
            setTranslateX(Run.relativeX(99.9)-getFitWidth());
        }
        if (getTranslateY()<0) {
            setTranslateY(0);
        }
        if (getTranslateY()+getFitHeight()>Run.relativeY(100)) {
            setTranslateY(Run.relativeY(99.9)-getFitHeight());
        }
    }

    public Player(ObservableList<Node> group,LinkedList<Zombie> zombies) {

        totalHP = 100;
        currentHP = totalHP;
        currentMagazineAmmo = 20;
        totalAmmo = 100;

        this.group = group;
        this.setImage(new Image("img/Character.jpg"));
        this.setFitHeight(Run.relativeX(7));
        this.setFitWidth(Run.relativeX(7));
        update(zombies, this);
    }

    /**
     * Constantly updating the position of the player
     */
    private void update(LinkedList<Zombie> zombies, Player player) {
        AnimationTimer a = new AnimationTimer() {
            @Override
            public void handle(long now) {
                setTranslateX(getTranslateX() + horizontalSpeed);
                setTranslateY(getTranslateY() + verticalSpeed);
                setRotate(angle);
                updateBullets();
                deleteBullets();
                checkBoundaries();
                for (Zombie zombie: zombies) {
                    zombie.update(player);
                }
                for (Bullet bullet:bullets) {
                    for (Zombie zombie:zombies) {
                        if (zombie.loseLife(bullet)){
                            bullet.setImage(null);
                            bullets.remove(bullet);
                        }
                        if (zombie.getCurrentHP()<0) {
                            zombie.setImage(null);
                            zombies.remove(zombie);
                        }
                    }

                }
            }
        };
        a.start();
    }



    /**
     * Setting the speed of the player movements according to the keys pressed
     *
     * @param event
     */
    public void setOnPressed(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                verticalSpeed = -Run.relativeY(0.7);
                break;
            case S:
                verticalSpeed = Run.relativeY(0.7);
                break;
            case A:
                horizontalSpeed = -Run.relativeX(0.7);
                break;
            case D:
                horizontalSpeed = Run.relativeX(0.7);
                break;
            case R:
                reload();

        }

    }

    private void reload(){
        if (totalAmmo > 0 && totalAmmo < 20){
            currentMagazineAmmo = totalAmmo;
            totalAmmo = 0;
        } else if (totalAmmo > 0){
            currentMagazineAmmo = 20;
            totalAmmo -= 20;
        }
    }

    /**
     * When user stops pressing a button should stop moving
     *
     * @param event
     */
    public void setOnReleased(KeyEvent event) {
        if (event.getCode() == KeyCode.W || event.getCode() == KeyCode.S) {
            verticalSpeed = 0;
        }
        if (event.getCode() == KeyCode.A || event.getCode() == KeyCode.D) {
            horizontalSpeed = 0;
        }

    }

    public void setOnMoved(MouseEvent event) {
        angle = Math.toDegrees(Math.atan2(getTranslateY() - event.getY() , getTranslateX() - event.getX())) + 180;
//        if (getTranslateX() > event.getX()) {
//            angle += 180;
//        }
    }
    public void shoot(MouseEvent event, ObservableList<Node> parent) {

        if (currentMagazineAmmo  == 0){
            reload();
        }

        if (event.getButton() == MouseButton.PRIMARY) {
            new Audio("Audio/bullet.wav").playNormal();
            double initialx = getTranslateX() + (getFitWidth() / 2);
            double initialy = getTranslateY() + (getFitHeight() / 2);
            //Sin is for y
            // Cos is for x
            //Travel to x, y by implementing the sin and cos of the angle
            bullets.add(new Bullet(angle));
            bullets.get(bullets.size()-1).setRotate(angle);
            parent.add(bullets.get(bullets.size()-1));
            bullets.get(bullets.size() - 1).setTranslateX(initialx);
            bullets.get(bullets.size() - 1).setTranslateY(initialy);
        }

    }
    private void updateBullets() {
        if (bullets.size()!=0) {
            for (Bullet bullet:bullets) {
                bullet.setTranslateX(Math.cos(Math.toRadians(bullet.getAngle()))*Run.relativeX(5)+bullet.getTranslateX());
                bullet.setTranslateY(Math.sin(Math.toRadians(bullet.getAngle()))*Run.relativeX(5)+bullet.getTranslateY());
            }
        }
    }




    private void deleteBullets() {
        for (Bullet bullet:bullets) {
            if (bullet == null) {
                bullets.remove(bullet);
                group.remove(bullet);
            }
            if (bullet.getTranslateX()>Run.relativeX(100)) {
                group.remove(bullet);
                bullets.remove(bullet);
            }
            if (bullet.getTranslateY()>Run.relativeY(100)) {
                group.remove(bullet);
                bullets.remove(bullet);
            }
            if (bullet.getTranslateX()<0) {
                group.remove(bullet);
                bullets.remove(bullet);
            }
            if (bullet.getTranslateY()<0) {
                group.remove(bullet);
                bullets.remove(bullet);
            }
        }
    }

    public LinkedList<Bullet> getBullets() {
        return bullets;
    }

    public void setBullets(LinkedList<Bullet> bullets) {
        this.bullets = bullets;
    }

    public void setCurrentHP(double currentHP) {
        this.currentHP = currentHP;
    }

    public double getCurrentHP() {
        return currentHP;
    }
}
