package john.bookApp.crudOperation;

import java.util.List;

public interface CRUDoperations<T1,T2> {
	public List<T1> getAllItems();
	public void addNewItem(T1 item);
	public void updateItem(T1 item);
	public void deleteItem(T2 id);
}
