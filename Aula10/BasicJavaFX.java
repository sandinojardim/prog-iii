import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class BasicJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Bem-vindo ao JavaFX.");
        Scene scene = new Scene(label, 200, 100);
        primaryStage.setTitle("Exemplo Básico");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}