import java.util.List;

abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
}

class Electronics extends WarehouseItem {
    private int warrantyPeriod;

    public Electronics(String name, double price, int warrantyPeriod) {
        super(name, price);
        this.warrantyPeriod = warrantyPeriod;
    }

    public int getWarrantyPeriod() { return warrantyPeriod; }
}

class Groceries extends WarehouseItem {
    private String expiryDate;

    public Groceries(String name, double price, String expiryDate) {
        super(name, price);
        this.expiryDate = expiryDate;
    }

    public String getExpiryDate() { return expiryDate; }
}

class Furniture extends WarehouseItem {
    private String material;

    public Furniture(String name, double price, String material) {
        super(name, price);
        this.material = material;
    }

    public String getMaterial() { return material; }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new java.util.ArrayList<>();

    public void addItem(T item) { items.add(item); }
    public T getItem(int index) { return items.get(index); }
    public List<T> getAllItems() { return items; }
    public int getCount() { return items.size(); }
}

class WarehouseUtils {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (WarehouseItem item : items) {
            System.out.println("Item: " + item.getName() + ", Price: $" + item.getPrice());
        }
    }
}
