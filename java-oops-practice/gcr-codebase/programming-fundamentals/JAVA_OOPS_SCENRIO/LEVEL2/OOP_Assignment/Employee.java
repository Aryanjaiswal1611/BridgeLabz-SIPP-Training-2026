class Employee {

```
static String companyName =
        "Google";

static int totalEmployees = 0;

String name;
final int id;
String designation;

public Employee(String name,
                int id,
                String designation) {

    this.name = name;
    this.id = id;
    this.designation = designation;

    totalEmployees++;
}

public static void displayTotalEmployees() {
    System.out.println("Total Employees : " + totalEmployees);
}

public void display() {

    System.out.println("Name : " + name);
    System.out.println("ID : " + id);
    System.out.println("Designation : " + designation);
}

public static void main(String[] args) {

    Employee e1 =
            new Employee(
                    "Yash",
                    1,
                    "Developer"
            );

    if (e1 instanceof Employee) {
        e1.display();
    }

    displayTotalEmployees();
}

# ==========================

# Product.java

# ==========================

cat > Product.java << 'EOF'
class Product {

```
static double discount = 10;

final int productID;

String productName;
double price;
int quantity;

public Product(int productID,
               String productName,
               double price,
               int quantity) {

    this.productID = productID;
    this.productName = productName;
    this.price = price;
    this.quantity = quantity;
}

public static void updateDiscount(double newDiscount) {
    discount = newDiscount;
}

public void display() {

    System.out.println("Product ID : " + productID);
    System.out.println("Product : " + productName);
    System.out.println("Price : " + price);
    System.out.println("Quantity : " + quantity);
    System.out.println("Discount : " + discount + "%");
}

public static void main(String[] args) {

    Product p =
            new Product(
                    101,
                    "Laptop",
                    50000,
                    2
            );

    if (p instanceof Product) {
        p.display();
    }

    updateDiscount(15);
}
```

}
