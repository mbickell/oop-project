package oopproject;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import oopproject.model.item.Book;
import oopproject.model.item.LibraryItem;
import oopproject.model.item.Magazine;
import oopproject.model.user.Guest;
import oopproject.model.user.LibraryUser;
import oopproject.model.user.Staff;
import oopproject.model.user.Student;
import oopproject.service.LibraryService;

public class Controller {

  private LibraryService libraryService;
  @FXML
  ListView<LibraryItem> itemListView;
  @FXML
  ComboBox<LibraryUser> userComboBox;
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
    userComboBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<LibraryUser>() {
      @Override
      public void changed(ObservableValue<? extends LibraryUser> observable,
          LibraryUser oldValue,
          LibraryUser newValue) {
        updateUserInfo(newValue);
      }
    });

    itemListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<LibraryItem>() {
      @Override
      public void changed(ObservableValue<? extends LibraryItem> observable, LibraryItem oldValue,
          LibraryItem newValue) {
        itemInfoLabel.setText(newValue.getDisplayInfo());
      }
    });

    libraryService = new LibraryService();
    libraryService.addItem(new Book("1", "Children of Time", "Adrian Tchaikovsky", "978-1-4472-7328-8"));
    libraryService.addItem(new Book("2", "Children of Ruin", "Adrian Tchaikovsky", "978-0-3164-5253-3"));
    libraryService.addItem(new Magazine("3", "National Geographic", "NG Media", 1));
    libraryService.addItem(new Magazine("4", "Rolling Stone", "Brian Szejka", 1));

    Guest guest = new Guest("1", "Matthew Bickell");
    Student student = new Student("2", "John Wayne", "451265");
    Staff staff = new Staff("3", "Matti Tuomaala", "IT");

    userComboBox.setItems(FXCollections.observableArrayList(student, staff, guest));
    userComboBox.getSelectionModel().select(0);

    updateItems();
  }

  @FXML
  protected void onBorrow(ActionEvent event) {
    LibraryItem selectedItem = itemListView.getSelectionModel().getSelectedItem();
    LibraryUser selectedUser = userComboBox.getSelectionModel().getSelectedItem();

    if (selectedItem != null && selectedUser != null) {
      statusLabel.setText(libraryService.borrowItem(selectedUser, selectedItem));
    } else {
      statusLabel.setText("User or item not selected");
    }

    updateItems();
    updateUserInfo(selectedUser);
  }

  @FXML
  protected void onReturn(ActionEvent event) {
    LibraryItem selectedItem = itemListView.getSelectionModel().getSelectedItem();
    LibraryUser selectedUser = userComboBox.getSelectionModel().getSelectedItem();

    if (selectedItem != null && selectedUser != null) {
      statusLabel.setText(libraryService.returnItem(selectedUser, selectedItem));
    } else {
      statusLabel.setText("User or item not selected");
    }

    updateItems();
    updateUserInfo(selectedUser);
  }

  private void updateItems() {
    itemListView.setItems(FXCollections.observableArrayList(libraryService.getItems()));
  }

  private void updateUserInfo(LibraryUser user) {
    String borrowedItems = "";

    for (LibraryItem item : user.getBorrowedItems()) {
      borrowedItems += "\n" + item;
    }

    userInfoLabel.setText(
        "Type: " + user.getUserType() +
            "\nBorrow Limit: " + user.getBorrowedItems().size() + "/" + +user.getMaxBorrowable() +
            "\nBorrowed Items: " + borrowedItems);
  }
}