public interface LibraryADT {
    void addBook(int isbn, String title, String author);
    
    Book searchBook(int isbn);
    
    void borrowBook(int isbn);
    
    void viewHistory();
}
