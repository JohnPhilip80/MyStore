package john.bookApp.service;

import java.util.List;
import java.util.Scanner;

import john.bookApp.model.Book;
import john.bookApp.repository.BookRepository;

public class BookService {
	private BookRepository repo;
	private List<Book> books;
	public BookService() {
		repo = new BookRepository();
	}
	public void showAllBooks() {
		books = repo.getAllItems();
		System.out.println(String.format("%-20s", "Id") + String.format("%-20s", "Title") + String.format("%-20s", "Author") + String.format("%-20s", "Price"));
		for(int i=0;i<books.size();i++) {
			System.out.println(
					String.format("%-20s", books.get(i).getId()) + 
					String.format("%-20s", books.get(i).getTitle()) + 
					String.format("%-20s", books.get(i).getAuthor()) + 
					String.format("%-20s", books.get(i).getPrice())
					);  
					
		}
	}
	public void addNewBook() {
		Scanner scan = new Scanner(System.in);
		Book book = new Book();
		System.out.println("Enter Id");
		book.setId(scan.nextLong());scan.nextLine();
		System.out.println("Enter Title");
		book.setTitle(scan.nextLine());
		System.out.println("Enter Author");
		book.setAuthor(scan.nextLine());
		System.out.println("Enter Price");
		book.setPrice(scan.nextDouble());
		repo.addNewItem(book);
	}
	
	public void updateBook() {
		Scanner scan = new Scanner(System.in);
		Book book = new Book();
		System.out.println("Enter Id to update:");
		book.setId(scan.nextLong());scan.nextLine();
		System.out.println("Enter Title:");
		book.setTitle(scan.nextLine());
		System.out.println("Enter Author:");
		book.setAuthor(scan.nextLine());
		System.out.println("Enter Price:");
		book.setPrice(scan.nextDouble());
		repo.updateItem(book);
	}
	public void deleteBook() {
		Long id;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Id to delete:");
		id = scan.nextLong();
		repo.deleteItem(id);
	}
}
