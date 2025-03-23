import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LayoutJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Digite seu nome:");
        TextField nomeField = new TextField();
        Button botao = new Button("Dizer Olá");
        Label resultado = new Label();

        VBox layout = new VBox(10); // Espaçamento de 10px
        layout.setPadding(new Insets(10));
        layout.getChildren().addAll(label, nomeField, botao, resultado);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Layout com VBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}