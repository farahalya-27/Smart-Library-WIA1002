public interface LibraryADT {
    void addBook(Book Book);
    
    Book searchBook(int isbn);
    
    void borrowBook(int isbn);
    
    void viewHistory();
}