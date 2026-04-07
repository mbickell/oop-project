package oopproject;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import oopproject.service.LibraryService;

public class Controller {

  @FXML
  ListView<String> itemListView;
  @FXML
  ComboBox<String> userComboBox;
  Label itemInfoLabel;
  Label userInfoLabel;
  Button borrowButton;
  Button returnButton;
  Label statusLabel;

  public void initialize() {
    LibraryService libraryService = new LibraryService();
    libraryService.addItem("Children of Time");
    libraryService.addItem("Children of Ruin");
    libraryService.addItem("Abbadons Gate");
    itemListView.setItems(FXCollections.observableArrayList(libraryService.getItems()));

    userComboBox.setItems(FXCollections.observableArrayList("Student", "Teacher", "Guest"));
  }

  @FXML
  protected void onBorrow(ActionEvent event) {
    System.out.println("Test");
  }

  @FXML
  protected void onReturn(ActionEvent event) {
    System.out.println("Test");
  }
}