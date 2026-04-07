package oopproject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Controller {

  @FXML
  ListView<String> itemListView;
  Label itemInfoLabel;
  ComboBox<String> userComboBox;
  Label userInfoLabel;
  Button borrowButton;
  Button returnButton;
  Label statusLabel;

  public void initialize() {

  }

  protected void onBorrow(ActionEvent event) {
    System.out.println("Test");
  }

  protected void onReturn(ActionEvent event) {
    System.out.println("Test");
  }
}