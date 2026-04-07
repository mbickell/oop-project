package oopproject;

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

  public void initialize() {

  }
}