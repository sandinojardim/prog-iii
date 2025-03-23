import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXListDemo extends Application {
    private ObservableList<String> items;

    @Override
    public void start(Stage primaryStage) {
        // Dados iniciais fornecidos no código
        items = FXCollections.observableArrayList(
            "Item 1", "Item 2", "Item 3", "Item 4", "Item 5"
        );

        // Componentes
        Label titleLabel = new Label("Gerenciamento de Lista");
        titleLabel.setId("title-label");

        // ListView para exibir os itens
        ListView<String> listView = new ListView<>(items);
        listView.setPrefHeight(200); // Altura fixa
        ScrollPane listScroll = new ScrollPane(listView);
        listScroll.setFitToWidth(true);
        listScroll.setPrefHeight(200);

        // Campo de entrada
        TextField inputField = new TextField();
        inputField.setPromptText("Digite um novo item ou edite aqui");

        // Botões
        Button addButton = new Button("Adicionar");
        addButton.setId("add-button");

        Button updateButton = new Button("Atualizar");
        updateButton.setId("update-button");

        Button removeButton = new Button("Remover");
        removeButton.setId("remove-button");

        // Eventos
        addButton.setOnAction(event -> {
            String newItem = inputField.getText().trim();
            if (!newItem.isEmpty() && !items.contains(newItem)) {
                items.add(newItem);
                inputField.clear();
            }
        });

        updateButton.setOnAction(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            String newValue = inputField.getText().trim();
            if (selectedItem != null && !newValue.isEmpty() && !items.contains(newValue)) {
                int index = items.indexOf(selectedItem);
                items.set(index, newValue);
                inputField.clear();
            }
        });

        removeButton.setOnAction(event -> {
            String selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                items.remove(selectedItem);
                inputField.clear();
            }
        });

        // Seleção na lista preenche o campo de texto
        listView.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal != null) {
                inputField.setText(newVal);
            }
        });

        // Layout dos botões
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(addButton, updateButton, removeButton);

        // Layout principal
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(15));
        layout.getChildren().addAll(titleLabel, listScroll, inputField, buttonBox);

        // Cena
        Scene scene = new Scene(layout, 400, 350);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Palco
        primaryStage.setTitle("Demonstração de Lista Interativa");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}