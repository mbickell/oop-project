package oopproject.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import oopproject.model.item.LibraryItem;
import oopproject.model.user.LibraryUser;

public class LibraryService {
  private List<LibraryItem> items = new ArrayList<LibraryItem>();

  public void addItem(LibraryItem item) {
    items.add(item);
  }

  public List<LibraryItem> getItems() {
    return Collections.unmodifiableList(items);
  }

  public String borrowItem(LibraryUser user, LibraryItem item) {
    if (!item.getIsAvailable()) {
      return "This item is not available";
    }

    if (!user.canBorrow()) {
      return user.getName() + " cannot borrow this item";
    }

    user.borrowItem(item);
    return "Borrowing: " + item.getTitle() + "\nfor: " + user;
  }

  public String returnItem(LibraryUser user, LibraryItem item) {
    if (item.getIsAvailable()) {
      return "This item is not borrowed";
    }

    user.returnItem(item);
    return "Returning: " + item.getTitle() + " for " + user;
  }
}
