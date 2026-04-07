package oopproject.model.item;

public abstract class LibraryItem implements Borrowable {
  private String itemID;
  private String title;
  private boolean isAvailable;

  public LibraryItem(String itemID, String title) {
    this.itemID = itemID;
    this.title = title;
    this.isAvailable = true;
  }

  public String getItemID() {
    return itemID;
  }

  public String getTitle() {
    return title;
  }

  public boolean getIsAvailable() {
    return isAvailable;
  }

  public void setAvailable(boolean isAvailable) {
    this.isAvailable = isAvailable;
  }

  @Override
  public String toString() {
    return "[" + getType() + "]" + " " + this.title + (this.isAvailable ? "" : " (Borrowed)");
  }
}
