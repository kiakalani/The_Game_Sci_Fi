import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.awt.*;

/**
 * @author Kia
 * @version 1.00
 * <code>Run</code> class is responsible for running the project.
 */
public class Run extends Application {
    /**
     * The actual stage of the game.
     */
    private static Stage stage;
    /**
     * The dimensions of the screen of the player
     */
    private static final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
    /**
     * This method would return the position according to the percentage provided
     * for the x axis
     * @param x refers to the percentage of the x axis
     * @return the actual position by considering the percentage provided
     */
    public static double relativeX(double x){
        return (x/100.0)*screen.getWidth();

    }
    /**
     * This method would return the position according to the percentage provided
     * for the y axis
     * @param y refers to the percentage of the y axis
     * @return the actual position by considering the percentage provided
     */
    public static double relativeY(double y) {
        return (y/100.0)*screen.getHeight();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        changeScene(new MainMenu().getScene());
        stage.getIcons().add(new Image("img/icon.png"));
        stage.setFullScreen(true);
        stage.setFullScreenExitKeyCombination(KeyCombination.NO_MATCH);
        stage.show();
    }

    /**
     * This method would switch to the preferred scene.
     * @param scene refers to the new scene.
     */
    public static void changeScene(Scene scene) {
        stage.setScene(scene);
        stage.setFullScreen(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
