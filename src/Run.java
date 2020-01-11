import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author Kia
 * @version 1.00
 * <code>Run</code> class is responsible for running the project.
 */
public class Run extends Application {
    private static Stage stage;
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        changeScene(new Scene(null));
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
