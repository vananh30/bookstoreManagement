package bookstore;

import java.util.Scanner;

public class Bookstore implements StoreInterface {


	private static int totalItems		= 0;		// Số quyển sách hiện tại trong kho sách
	private final int MAX_ITEMS			= 10;		// Số quyển sách lớn nhất mà kho sách chứa được
	private Book[] listItems			= null;
	
	public Bookstore(){
		listItems	= new Book[MAX_ITEMS];
	}
	
	public int getItemPosition(String bookID){
		for(int i = 0; i < totalItems; i++){
			if(bookID.equals(listItems[i].getID())==true) return i;
		}
		return -1;
	}
	
	// checkFull
	public boolean checkFull(){
		return totalItems == MAX_ITEMS;
	}
	
	// checkEmpty
	public boolean checkEmpty(){
		return totalItems == 0;
	}

	public static int getTotalItems() {
		return totalItems;
	}

	public static void setTotalItems(int totalItems) {
		Bookstore.totalItems = totalItems;
	}

	// Add book
	@Override
	public void add(Object obj) {
		Book bookObj = (Book) obj;
		if(!this.checkFull()){
			this.listItems[totalItems]	= bookObj;
			setTotalItems(Bookstore.getTotalItems()+1);
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
			listItems[bookPosition].setName(bookName);
			listItems[bookPosition].setPrice(bookPrice);
			System.out.println("Edit successfull!");
		}
	}
	
	// Delete book
	public void delete(String bookID){
		int bookPosition	= this.getItemPosition(bookID);
		if(bookPosition == -1){
			System.out.println("This book is not exist!");
		}else{
			for(int i = bookPosition; i < totalItems - 1; i++){
				listItems[i] = listItems[i+1];
			}
			Bookstore.setTotalItems(Bookstore.getTotalItems()-1);
			System.out.println("Delete successfull!");
		}
	}
	
	// Find book
	public void find(String bookID){
		int bookPosition	= this.getItemPosition(bookID);
		if(bookPosition == -1){
			System.out.println("This book is not exist!");
		}else{
			System.out.println(listItems[bookPosition]);
		}
	}
	
	// list book
	public void list(){
		if(this.checkEmpty() == false){
			for(int i = 0; i < totalItems; i++){
				System.out.println(this.listItems[i]);
			}
		}else{
			System.out.println("Store is empty!");
		}
	}
}
