import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.io.File;
import java.util.LinkedList;

public class MainMenu extends DefaultScreen {
    private LinkedList<ImageView> buttons = new LinkedList<>();
    private void setButtons() {
        for (int i=1;i<4;i++) {
            buttons.add(new ImageView(new Image("img/buttons/"+i+".png")));
            buttons.get(i-1).setTranslateX(Run.relativeX(30));
            buttons.get(i-1).setFitWidth(Run.relativeX(40));
            buttons.get(i-1).setFitHeight(Run.relativeY(20));
            buttons.get(i-1).setTranslateY((Run.relativeY(25)*i));
            getChildren().add(buttons.get(i-1));
            final int index = i-1;
            buttons.get(i-1).setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    if (index == 2) {
                        System.exit(0);
                    } else{
                        if (index == 0) {
                            Run.changeScene(new GamePage().getScene());
                        }
                        if (index == 1) {
                            // Run the credits
                            System.out.println("Credits");
                        }
                    }
                }
            });
        }
        buttons.get(0).setFitWidth(Run.relativeX(80));
        buttons.get(0).setTranslateX(Run.relativeX(10));
        buttons.get(0).setFitHeight(Run.relativeY(40));
        buttons.get(0).setTranslateY(Run.relativeX(10));
        buttons.get(1).setFitWidth(Run.relativeX(40));
        buttons.get(1).setFitHeight(Run.relativeY(20));
        buttons.get(1).setTranslateX(Run.relativeX(10));
        buttons.get(1).setTranslateY(Run.relativeY(60));
        buttons.get(2).setTranslateX(Run.relativeX(52));
        buttons.get(2).setTranslateY(buttons.get(1).getTranslateY());
        buttons.get(2).setFitWidth(Run.relativeX(38));
    }
    public MainMenu() {
        setBackground();
        setButtons();
    }
    private void setBackground() {
        ImageView background = new ImageView(new Image("img/mainBackground.jpg"));
        background.setFitWidth(Run.relativeX(100));
        background.setFitHeight(Run.relativeY(100));
        getChildren().add(background);
    }
}
