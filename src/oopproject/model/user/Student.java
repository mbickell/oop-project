package oopproject.model.user;

public class Student extends LibraryUser {
  private String studentNumber;

  public Student(String userID, String name, String studentNumber) {
    super(userID, name);
    this.studentNumber = studentNumber;
  }

  @Override
  public int getMaxBorrowable() {
    return 3;
  }

  @Override
  public String getUserType() {
    return "Student";
  }

  public String getStudentNumber() {
    return studentNumber;
  }

  public void setStudentNumber(String studentNumber) {
    this.studentNumber = studentNumber;
  }
}
