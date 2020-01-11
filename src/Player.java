import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class Player extends ImageView {
    /**
     * The horizontal speed for updating the position
     */
    private double verticalSpeed;
    /**
     * The vertical speed for updating the position
     */
    private double horizontalSpeed;

    private double mouseX = 0, mouseY = 0;
    private double angle = 0;

    /**
     * Constantly updating the position of the player
     */
    private void update() {
        AnimationTimer a = new AnimationTimer() {
            @Override
            public void handle(long now) {
                setTranslateX(getTranslateX() + horizontalSpeed);
                setTranslateY(getTranslateY() + verticalSpeed);
                setRotate(angle);
            }
        };
        a.start();
    }

    public Player() {
        this.setImage(new Image("img/something.png"));
        this.setFitHeight(Run.relativeY(10));
        this.setFitWidth(Run.relativeX(10));
        update();
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
        angle = Math.toDegrees(Math.atan((event.getY() - getTranslateY()) / (event.getX() - getTranslateX())));
        if (getTranslateX() > event.getX()) {
            angle += 180;
        }
    }
}
