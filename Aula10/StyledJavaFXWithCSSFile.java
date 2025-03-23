import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StyledJavaFXWithCSSFile extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Digite seu nome:");
        label.setId("nome");
        TextField nomeField = new TextField();
        Button botao = new Button("Dizer Olá");
        Label resultado = new Label();
        //resultado.setId("resultado");
        resultado.getStyleClass().add("resultado");

        botao.setOnAction(event -> {
            String nome = nomeField.getText();
            resultado.setText("Olá, " + (nome.isEmpty() ? "Mundo" : nome) + "!");
        });

        VBox layout = new VBox(10);
        layout.getChildren().addAll(label, nomeField, botao, resultado);

        Scene scene = new Scene(layout, 300, 200);
        // Carrega o arquivo CSS externo
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        
        primaryStage.setTitle("JavaFX com CSS Externo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
