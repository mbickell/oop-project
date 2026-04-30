package oopproject.model.user;

public class Guest extends LibraryUser {
  public Guest(String userID, String name) {
    super(userID, name);
  }

  @Override
  public int getMaxBorrowable() {
    return 1;
  }

  @Override
  public String getUserType() {
    return "Guest";
  }
}
