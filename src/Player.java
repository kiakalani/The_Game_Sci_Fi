import javafx.event.Event;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class Player extends ImageView {
    public Player() {
        this.setImage(new Image("img/something.png"));
        this.setFitHeight(Run.relativeY(10));
        this.setFitWidth(Run.relativeX(10));
    }

    public void setOnPressed(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                setTranslateY(getTranslateY()-Run.relativeY(0.7));
                break;
            case S:
                setTranslateY(getTranslateY()+Run.relativeY(0.7));
                break;
            case A:
                setTranslateX(getTranslateX()-Run.relativeX(0.7));
                break;
            case D:
                setTranslateX(getTranslateX()+Run.relativeX(0.7));
                break;

        }
        System.out.println(1);
    }
}
