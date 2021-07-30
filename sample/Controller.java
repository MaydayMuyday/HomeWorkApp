package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class Controller {
    @FXML
    public TextField textField;
    @FXML
    public TextArea textArea;

    @FXML
    public void sendMsg() {
       textArea.appendText(textField.getText()+ "\n");
       textField.clear();
       textField.requestFocus();
    }
}
