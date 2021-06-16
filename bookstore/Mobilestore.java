package bookstore;

public class Mobilestore implements StoreInterface {
    @Override
    public boolean checkFull() {
        return false;
    }

    @Override
    public boolean checkEmpty() {
        return false;
    }

    @Override
    public void add(Object obj) {

    }

    @Override
    public void edit(String ID, String Name, double Price) {

    }

    @Override
    public void delete(String ID) {

    }

    @Override
    public void find(String ID) {

    }

    @Override
    public void list() {

    }
}
