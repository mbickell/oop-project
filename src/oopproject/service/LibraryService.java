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

  public void borrowItem(String user, String item) {
  }

  public void returnItem(String user, String item) {
  }
}
