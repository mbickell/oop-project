package oopproject.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import oopproject.model.item.LibraryItem;

public class LibraryService {
  private List<LibraryItem> items = new ArrayList<LibraryItem>();

  public void addItem(LibraryItem item) {
    items.add(item);
  }

  public List<LibraryItem> getItems() {
    return Collections.unmodifiableList(items);
  }

  public String borrowItem(String user, LibraryItem item) {
    if (item.getIsAvailable()) {
      item.setAvailable(false);
      return "Borrowing: " + item.getTitle() + " for " + user;
    }

    return "This item is not available";
  }

  public String returnItem(String user, LibraryItem item) {
    if (item.getIsAvailable()) {
      return "This item is not borrowed";
    }

    item.setAvailable(true);
    return "Returning: " + item.getTitle() + " for " + user;
  }
}
