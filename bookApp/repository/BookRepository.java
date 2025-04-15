package john.bookApp.repository;

import java.util.ArrayList;
import java.util.List;

import john.bookApp.crudOperation.CRUDoperations;
import john.bookApp.model.Book;

public class BookRepository implements CRUDoperations<Book,Long> {
	private List<Book> books;
	public BookRepository() {
		books=  new ArrayList<Book>();
		books.add(new Book(1L,"Java","Arun",250.00));
		books.add(new Book(2L,"HTML","Chandrika",560.00));
		books.add(new Book(3L,"Phython","Pragathi",690.00));
		books.add(new Book(4L,"Javascript","John",700.00));
	}
	
	@Override
	public List<Book> getAllItems(){
		return books;
	}
	
	@Override
	public void addNewItem(Book book) {
		books.add(book);
	}
	
	@Override
	public void updateItem(Book book) {
		int index = 0;
		for(int i=0;i<books.size();i++)
			if(books.get(i).getId() == book.getId())
				index = i;
		books.set(index, book);
	}
	
	@Override
	public void deleteItem(Long id) {
		int index = 0;
		for(int i=0;i<books.size();i++)
			if(books.get(i).getId() == id)
				index = i;
		books.remove(index);
	}

	
	
}
