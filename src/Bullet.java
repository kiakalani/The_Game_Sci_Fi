import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Bullet extends ImageView {
    public Bullet() {
        this.setImage(new Image("img/Bullet.png"));
        this.setFitWidth(Run.relativeX(0.5));
        this.setFitHeight(Run.relativeY(0.5));
    }
}
