import java.util.ArrayList;
import java.util.List;

abstract class WarehouseItem {
    String name;

    WarehouseItem(String name) {
        this.name = name;
    }

    public String toString() {
        return getClass().getSimpleName() + " : " + name;
    }
}

class Electronics extends WarehouseItem {
    Electronics(String name) {
        super(name);
    }
}

class Groceries extends WarehouseItem {
    Groceries(String name) {
        super(name);
    }
}

class Furniture extends WarehouseItem {
    Furniture(String name) {
        super(name);
    }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();

    void addItem(T item) {
        items.add(item);
    }

    List<T> getItems() {
        return items;
    }
}

public class WarehouseDemo {

    static void displayItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {

        Storage<Electronics> electronics = new Storage<>();
        electronics.addItem(new Electronics("Laptop"));
        electronics.addItem(new Electronics("Mobile"));

        Storage<Groceries> groceries = new Storage<>();
        groceries.addItem(new Groceries("Rice"));
        groceries.addItem(new Groceries("Milk"));

        displayItems(electronics.getItems());
        displayItems(groceries.getItems());
    }
}