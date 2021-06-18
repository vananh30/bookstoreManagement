package bookstore;

import java.util.Comparator;

public class NameZAComparator implements Comparator<Book> {
    @Override
    public int compare(Book bookObj2, Book bookObj1) {
        return bookObj2.getName().compareToIgnoreCase(bookObj1.getName());
    }
}
