import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controller {
    @FXML
    private TextField nomeField;

    @FXML
    private Label resultado;

    @FXML
    private void dizerOla() {
        String nome = nomeField.getText();
        resultado.setText("Olá, " + (nome.isEmpty() ? "Mundo" : nome) + "!");
    }
}