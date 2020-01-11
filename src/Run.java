import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.awt.*;

/**
 * @author Kia
 * @version 1.00
 * <code>Run</code> class is responsible for running the project.
 */
public class Run extends Application {
    private static Stage stage;
    private static final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();

    public static double relativeX(double x){
        return (x/100.0)*screen.getWidth();

    }
    public static double relativeY(double y) {
        return (y/100.0)*screen.getHeight();
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        changeScene(new GamePage().getScene());
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
    }

    public static void main(String[] args) {
        launch(args);
    }
}
