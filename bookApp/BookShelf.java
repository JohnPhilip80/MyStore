package john.bookApp;

import java.util.Scanner;

import john.bookApp.service.BookService;

public class BookShelf {

	public static void main(String[] args) {
		int choice=0;
		Scanner scan = new Scanner(System.in);
		BookService service = new BookService();
		service.showAllBooks();
		while(choice !=5) {
			System.out.println("1 - CREATE, 2 - READ, 3 - UPDATE, 4 - DELETE, 5 - EXIT. Select your choice:");
			choice = scan.nextInt();
			switch(choice) {
			case 1:
				service.addNewBook();
				break;
			case 2:
				service.showAllBooks();
				break;
			case 3:
				service.updateBook();
				break;
			case 4:
				service.deleteBook();
				break;
			default:
				choice = 5;
			}
		}

	}

}
