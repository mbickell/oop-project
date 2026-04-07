package oopproject;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import oopproject.service.LibraryService;

public class Controller {

  private LibraryService libraryService;
  @FXML
  ListView<String> itemListView;
  @FXML
  ComboBox<String> userComboBox;
  @FXML
  Label itemInfoLabel;
  @FXML
  Label userInfoLabel;
  @FXML
  Button borrowButton;
  @FXML
  Button returnButton;
  @FXML
  Label statusLabel;

  public void initialize() {
    libraryService = new LibraryService();
    libraryService.addItem("Children of Time");
    libraryService.addItem("Children of Ruin");
    libraryService.addItem("Abbadons Gate");
    itemListView.setItems(FXCollections.observableArrayList(libraryService.getItems()));

    userComboBox.setItems(FXCollections.observableArrayList("Student", "Teacher", "Guest"));
    userComboBox.getSelectionModel().select(0);
  }

  @FXML
  protected void onBorrow(ActionEvent event) {
    String selectedItem = itemListView.getSelectionModel().getSelectedItem();
    String selectedUser = userComboBox.getSelectionModel().getSelectedItem();

    if (selectedItem != null && selectedUser != null) {
      statusLabel.setText(libraryService.borrowItem(selectedUser, selectedItem));
    } else {
      statusLabel.setText("User or item not selected");
    }
  }

  @FXML
  protected void onReturn(ActionEvent event) {
    String selectedItem = itemListView.getSelectionModel().getSelectedItem();
    String selectedUser = userComboBox.getSelectionModel().getSelectedItem();

    if (selectedItem != null && selectedUser != null) {
      statusLabel.setText(libraryService.returnItem(selectedUser, selectedItem));
    } else {
      statusLabel.setText("User or item not selected");
    }
  }
}