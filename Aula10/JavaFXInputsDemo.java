import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXInputsDemo extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Inputs
        Label titleLabel = new Label("Demonstração de Inputs no JavaFX");
        titleLabel.setId("title-label");

        TextField textField = new TextField();
        textField.setPromptText("Digite algo aqui");

        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Digite uma senha");

        TextArea textArea = new TextArea();
        textArea.setPromptText("Digite um texto longo");
        textArea.setPrefHeight(80);

        CheckBox checkBox = new CheckBox("Opção ativada?");
        
        ToggleGroup radioGroup = new ToggleGroup();
        RadioButton radio1 = new RadioButton("Opção 1");
        radio1.setToggleGroup(radioGroup);
        radio1.setSelected(true);
        RadioButton radio2 = new RadioButton("Opção 2");
        radio2.setToggleGroup(radioGroup);

        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Item A", "Item B", "Item C");
        comboBox.setPromptText("Selecione um item");

        ChoiceBox<String> choiceBox = new ChoiceBox<>();
        choiceBox.getItems().addAll("Escolha 1", "Escolha 2", "Escolha 3");
        choiceBox.setValue("Escolha 1");

        Slider slider = new Slider(0, 100, 50);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        Spinner<Integer> spinner = new Spinner<>(0, 10, 5);

        DatePicker datePicker = new DatePicker();

        ColorPicker colorPicker = new ColorPicker();

        Button submitButton = new Button("Enviar");
        submitButton.setId("submit-button");

        // Resultado com ScrollPane
        Label resultLabel = new Label("Resultados aparecerão aqui");
        resultLabel.getStyleClass().add("result-text");
        ScrollPane resultScroll = new ScrollPane(resultLabel);
        resultScroll.setFitToWidth(true); // Ajusta a largura ao conteúdo
        resultScroll.setPrefHeight(150);  // Altura fixa com rolagem

        // Evento do botão
        submitButton.setOnAction(event -> {
            StringBuilder result = new StringBuilder("Entradas:\n");
            result.append("Texto: ").append(textField.getText()).append("\n");
            result.append("Senha: ").append(passwordField.getText()).append("\n");
            result.append("Texto Longo: ").append(textArea.getText()).append("\n");
            result.append("CheckBox: ").append(checkBox.isSelected() ? "Sim" : "Não").append("\n");
            result.append("Radio: ").append(radioGroup.getSelectedToggle() == radio1 ? "Opção 1" : "Opção 2").append("\n");
            result.append("ComboBox: ").append(comboBox.getValue()).append("\n");
            result.append("ChoiceBox: ").append(choiceBox.getValue()).append("\n");
            result.append("Slider: ").append(slider.getValue()).append("\n");
            result.append("Spinner: ").append(spinner.getValue()).append("\n");
            result.append("Data: ").append(datePicker.getValue()).append("\n");
            result.append("Cor: ").append(colorPicker.getValue());
            resultLabel.setText(result.toString());
        });

        // Layout
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(
            titleLabel, textField, passwordField, textArea, checkBox, 
            radio1, radio2, comboBox, choiceBox, slider, spinner, 
            datePicker, colorPicker, submitButton, resultScroll
        );

        // Cena
        Scene scene = new Scene(layout, 400, 600);
        scene.getStylesheets().add(getClass().getResource("styles2.css").toExternalForm());

        // Palco
        primaryStage.setTitle("Demonstração de Inputs com Scroll");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}