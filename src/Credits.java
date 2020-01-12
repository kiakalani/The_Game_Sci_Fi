import javafx.animation.AnimationTimer;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class Credits extends DefaultScreen {
    private Label label = new Label();
    private ImageView masha;
    public Credits() {
        setBkg();
        masha = new ImageView(new Image("img/credits/Masha.jpg"));
        masha.setFitWidth(relativeX(60));
        masha.setFitHeight(relativeY(80));
        getChildren().add(masha);
        String text = "Chief Executive Developer: Kia Kalani\n" +
                "Chief and Programming Assistant: Mikhail Pyatakhin\n" +
                "Music Composer and Lead Graphic Designer: Alireza Teimoori\n" +
                "Project Manager and Graphic Designer: Vanya Chirkov\n";
        label.setText(text);
        label.setTranslateY(relativeY(110));
        masha.setTranslateY(relativeY(135));
        label.setFont(new Font(35));
        label.setTextFill(Color.WHITE);
        getChildren().add(label);
        AnimationTimer a = new AnimationTimer() {
            @Override
            public void handle(long now) {
                label.setTranslateY(label.getTranslateY()-relativeY(0.3));
                masha.setTranslateY(masha.getTranslateY()-relativeY(0.3));
                if (masha.getTranslateY()+masha.getFitHeight()<0) {
                    this.stop();
                    Run.changeScene(new MainMenu().getScene());

                }
            }
        };
        a.start();
    }
    private void setBkg() {
        ImageView view = new ImageView(new Image("img/mainBackground.jpg"));
        view.setFitWidth(relativeX(100));
        view.setFitHeight(relativeY(100));
        getChildren().add(view);
    }
}
