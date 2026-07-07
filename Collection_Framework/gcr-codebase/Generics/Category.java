import java.util.ArrayList;
import java.util.List;

abstract class Category {
}

class BookCategory extends Category {
}

class ClothingCategory extends Category {
}

class GadgetCategory extends Category {
}

class Product<T extends Category> {
    String name;
    double price;
    T category;

    Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String toString() {
        return name + " Price: " + price;
    }
}

public class MarketplaceDemo {

    static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        product.price -= product.price * percentage / 100;
    }

    public static void main(String[] args) {

        List<Product<?>> catalog = new ArrayList<>();

        Product<BookCategory> book =
                new Product<>("Java Book", 800, new BookCategory());

        Product<ClothingCategory> cloth =
                new Product<>("Jacket", 2000, new ClothingCategory());

        Product<GadgetCategory> gadget =
                new Product<>("Laptop", 60000, new GadgetCategory());

        catalog.add(book);
        catalog.add(cloth);
        catalog.add(gadget);

        applyDiscount(gadget, 10);

        for (Product<?> p : catalog) {
            System.out.println(p);
        }
    }
}