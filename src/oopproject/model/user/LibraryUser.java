package oopproject.model.user;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import oopproject.model.item.LibraryItem;

abstract public class LibraryUser {
  private String userID;
  private String name;
  private List<LibraryItem> borrowedItems;

  public LibraryUser(String userID, String name) {
    this.userID = userID;
    this.name = name;
    this.borrowedItems = new ArrayList<LibraryItem>();
  }

  abstract public int getMaxBorrowable();

  abstract public String getUserType();

  public String getUserID() {
    return userID;
  }

  public String getName() {
    return name;
  }

  public List<LibraryItem> getBorrowedItems() {
    return Collections.unmodifiableList(borrowedItems);
  }

  public boolean canBorrow() {
    return borrowedItems.size() < getMaxBorrowable();
  }

  public boolean borrowItem(LibraryItem item) {
    if (canBorrow()) {
      borrowedItems.add(item);
      item.setAvailable(false);
      return true;
    }

    return false;
  }

  public boolean returnItem(LibraryItem item) {
    if (borrowedItems.size() <= 0 || item.getIsAvailable()) {
      return false;
    }

    int borrowedBookIndex = 0;
    ;

    for (int i = 0; i < borrowedItems.size(); i++) {
      if (borrowedItems.get(i).getItemID().compareTo(item.getItemID()) == 0) {
        borrowedBookIndex = i;
      }
    }

    borrowedItems.remove(borrowedBookIndex);
    item.setAvailable(true);
    return true;
  }

  @Override
  public String toString() {
    return getUserType() + ": " + getName() + " (limit: " + getMaxBorrowable() + ")";
  }

}
