import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CadastroJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) {
        Label titleLabel = new Label("Cadastro de Usuário");
        TextField nomeField = new TextField();
        nomeField.setPromptText("Digite seu nome");
        TextField emailField = new TextField();
        emailField.setPromptText("Digite seu e-mail");
        Button cadastrarButton = new Button("Cadastrar");
        Button limparButton = new Button("Limpar");
        TextArea resultadoArea = new TextArea();
        resultadoArea.setPrefHeight(100);
        resultadoArea.setEditable(false);

        // Evento do botão Cadastrar
        cadastrarButton.setOnAction(event -> {
            String nome = nomeField.getText();
            String email = emailField.getText();

            // #TODO 1: Validar o nome (mínimo 3 caracteres) e o e-mail (contém "@" e ".")
            // Se inválido, exibir mensagem de erro no resultadoArea
            // Dica: Use contains() para verificar "@" e "."

            // #TODO 2: Se válido, adicionar no formato "Nome: [nome] - E-mail: [email]" ao resultadoArea
            // Dica: Use appendText() para adicionar uma linha
        });

        // #TODO 3: Adicionar evento ao botão Limpar
        // Deve limpar os campos nomeField, emailField e resultadoArea
        // Dica: Use clear() nos componentes

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(titleLabel, nomeField, emailField, cadastrarButton, limparButton, resultadoArea);

        Scene scene = new Scene(layout, 350, 250);
        // #TODO 4: Carregar um arquivo CSS externo para estilizar
        // Requisitos: 
        // - Botão "Cadastrar" com fundo azul (#007BFF)
        // - Texto do resultadoArea com fonte tamanho 14px

        primaryStage.setTitle("Sistema de Cadastro");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}