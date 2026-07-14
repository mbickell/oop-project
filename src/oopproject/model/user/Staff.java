package oopproject.model.user;

public class Staff extends LibraryUser {
  private String department;

  public Staff(String userID, String name, String department) {
    super(userID, name);
    this.department = department;
  }

  @Override
  public int getMaxBorrowable() {
    return 5;
  }

  @Override
  public String getUserType() {
    return "Staff";
  }

  public String getDepartment() {
    return department;
  }

  public void setDepartment(String department) {
    this.department = department;
  }
}
