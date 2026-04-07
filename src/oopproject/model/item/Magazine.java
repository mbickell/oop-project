package oopproject.model.item;

public class Magazine extends LibraryItem {
  private String publisherName;
  private int issueNumber;

  public Magazine(String itemID, String title, String publisherName, int issueNumber) {
    super(itemID, title);
    this.publisherName = publisherName;
    this.issueNumber = issueNumber;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public int getIssueNumber() {
    return issueNumber;
  }

  @Override
  public int getBorrowingDays() {
    return 7;
  }

  @Override
  public String getType() {
    return "Magazine";
  }

  @Override
  public String getDisplayInfo() {
    String title = "Title: " + this.getTitle();
    String author = "Publisher: " + this.getPublisherName();
    String ISBN = "Issue: " + this.getIssueNumber();
    String loanPeriod = "Loan period: " + this.getBorrowingDays() + " days";

    return String.join("\n", title, author, ISBN, loanPeriod);
  }
}
