import java.util.List;

interface Category {}

class BookCategory implements Category {
    private String genre;
    public BookCategory(String genre) { this.genre = genre; }
    public String getGenre() { return genre; }
    public String toString() { return "Book [" + genre + "]"; }
}

class ClothingCategory implements Category {
    private String size;
    public ClothingCategory(String size) { this.size = size; }
    public String getSize() { return size; }
    public String toString() { return "Clothing [" + size + "]"; }
}

class GadgetCategory implements Category {
    private String brand;
    public GadgetCategory(String brand) { this.brand = brand; }
    public String getBrand() { return brand; }
    public String toString() { return "Gadget [" + brand + "]"; }
}

class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() { return name; }
    public double getPrice() { return price; }
    public T getCategory() { return category; }
    public void setPrice(double price) { this.price = price; }
    public String toString() { return name + " ($" + price + ") - " + category; }
}

class MarketplaceUtils {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double discount = product.getPrice() * (percentage / 100);
        product.setPrice(product.getPrice() - discount);
    }
}
