package oopproject.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LibraryService {
  private List<String> items = new ArrayList<String>();

  public void addItem(String item) {
    items.add(item);
  }

  public List<String> getItems() {
    return Collections.unmodifiableList(items);
  }

  public String borrowItem(String user, String item) {
    return "Borrowing: " + item + " for " + user;
  }

  public String returnItem(String user, String item) {
    return "Returning: " + item + " for " + user;
  }
}
