package bookstore;

import java.util.*;
import java.util.Scanner;

public class Bookstore implements StoreInterface {

	private final int MAX_ITEMS			= 10;		// Số quyển sách lớn nhất mà kho sách chứa được
	private List<Book> listItems			= null;
	
	public Bookstore(){listItems	= new LinkedList<Book>();
	}
	
	public int getItemPosition(String bookID){
		Iterator<Book> itr = listItems.iterator();
		int i = 0;
		while (itr.hasNext()){
			if(bookID.equals( itr.next().getID())) return i;
			i++;
		}
		return -1;
	}
	
	// checkFull
	public boolean checkFull(){
		return getTotalItems() == MAX_ITEMS;
	}
	
	// checkEmpty
	public boolean checkEmpty(){
		return listItems.isEmpty();
	}

	public int getTotalItems() {
		return listItems.size();
	}

	// Add book
	@Override
	public void add(Object obj) {
		Book bookObj = (Book) obj;
		if(!this.checkFull()){
			listItems.add(bookObj);
			System.out.println("Add successfull!");
		}else{
			System.out.println("Store is full!");
		}
	}
	
	// Edit book
	public void edit(String bookID, String bookName, double bookPrice){
		int bookPosition	= this.getItemPosition(bookID);
		if(bookPosition == -1){
			System.out.println("This book is not exist!");
		}else{
			listItems.get(bookPosition).setName(bookName);
			listItems.get(bookPosition).setPrice(bookPrice);
			System.out.println("Edit successfull!");
		}
	}
	
	// Delete book
	public void delete(String bookID){
		int bookPosition	= this.getItemPosition(bookID);
		if(bookPosition == -1){
			System.out.println("This book is not exist!");
		}else{
			listItems.remove(bookPosition);
			System.out.println("Delete successfull!");
		}
	}
	
	// Find book
	public void find(String bookID){
		int bookPosition	= this.getItemPosition(bookID);
		if(bookPosition == -1){
			System.out.println("This book is not exist!");
		}else{
			System.out.println(listItems.get(bookPosition));
		}
	}
	
	// list book
	public void list(){
		if(this.checkEmpty() == false){
			Iterator<Book> itr = listItems.iterator();
			int i = 0;
			while (itr.hasNext()){
				System.out.println(itr.next());
				i++;
			}
		}else{
			System.out.println("Store is empty!");
		}
	}
	// Sort Name theo thu tu tang dan
	public void sortNameAZ(){
		Collections.sort(listItems, new NameAZComparator());
	}
	public void sortNameZA(){
			Collections.sort(listItems, new NameZAComparator());
	}
	public void sortPriceAZ(){
		Collections.sort(listItems, new PriceAZComparator());
	}
	public void sortPriceZA(){
		Collections.sort(listItems, new PriceAZComparator());
		Collections.reverse(listItems);
	}

	public void findMax(){
		if(!this.checkEmpty()){
			Book bookObj = Collections.max(listItems, new PriceAZComparator());
			System.out.println(bookObj);
		}else{
			System.out.println("Store is empty!");
		}
	}
	public void findMin(){
		if(!this.checkEmpty()){
			sortPriceAZ();
			System.out.println(listItems.get(0));
		}else{
			System.out.println("Store is empty!");
		}
	}
}
