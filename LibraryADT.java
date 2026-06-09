/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.smartlibrary;

/**
 *
 * @author 24001
 */
public interface LibraryADT {
    void addBook(Book Book);
    
    void searchBook(int isbn);
    
    void borrowBook(int isbn);
    
    void viewHistory();
}
