// Additional 3: Food Delivery Partner System

interface FoodDelivery {
    default void trackOrder() {
        System.out.println("[FoodDelivery] Order is being prepared at the restaurant.");
    }
}

interface GroceryDelivery {
    default void trackOrder() {
        System.out.println("[GroceryDelivery] Groceries are being packed at the store.");
    }

    static String generateDeliveryCode() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder code = new StringBuilder("DEL");
        for (int i = 0; i < 6; i++) {
            code.append(chars.charAt((int) (Math.random() * chars.length())));
        }
        return code.toString();
    }
}

class DeliveryExecutive implements FoodDelivery, GroceryDelivery {
    private String name;
    private String[] customers;
    private String[] types; // "Food" or "Grocery"

    public DeliveryExecutive(String name, String[] customers, String[] types) {
        this.name = name;
        this.customers = customers;
        this.types = types;
    }

    @Override
    public void trackOrder() {
        FoodDelivery.super.trackOrder();
        GroceryDelivery.super.trackOrder();
        System.out.println("[DeliveryExecutive] Executive " + name + " is on the way!");
    }

    public void processDeliveries() {
        System.out.println("\nDelivery Executive: " + name);
        System.out.println("====================================\n");

        for (int i = 0; i < customers.length; i++) {
            System.out.println("Order " + (i + 1) + ": " + customers[i]);
            System.out.println("  Type: " + types[i]);
            trackOrder();
            System.out.println("  Delivery Code: " + GroceryDelivery.generateDeliveryCode());
            System.out.println();
        }
    }
}

public class Additional3_FoodDelivery {
    public static void main(String[] args) {
        System.out.println("=== Additional 3: Food Delivery Partner System ===\n");

        String[] customers = { "Alice", "Bob", "Charlie", "Diana" };
        String[] types = { "Food", "Grocery", "Food", "Grocery" };

        DeliveryExecutive executive = new DeliveryExecutive("Rahul", customers, types);
        executive.processDeliveries();
    }
}
