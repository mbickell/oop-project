package oopproject.model.item;

public class Book extends LibraryItem {
  private String author;
  private String ISBN;

  public Book(String itemID, String title, String author, String ISBN) {
    super(itemID, title);
    this.author = author;
    this.ISBN = ISBN;
  }

  public String getAuthor() {
    return author;
  }

  public String getISBN() {
    return ISBN;
  }

  @Override
  public int getBorrowingDays() {
    return 14;
  }

  @Override
  public String getType() {
    return "Book";
  }

  @Override
  public String getDisplayInfo() {
    String title = "Title: " + this.getTitle();
    String author = "Author: " + this.getAuthor();
    String ISBN = "ISBN: " + this.getISBN();
    String loanPeriod = "Loan period: " + this.getBorrowingDays() + " days";

    return String.join("\n", title, author, ISBN, loanPeriod);
  }
}
