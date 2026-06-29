import java.util.*;

class Contact {
    String name;
    String phone;
    String email;

    Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {
        return name + " | " + phone + " | " + email;
    }
}

class AddressBookApp {
    private ArrayList<Contact> contacts;
    private HashMap<String, Contact> nameIndex;
    private HashSet<String> phoneSet;

    public AddressBookApp() {
        contacts = new ArrayList<>();
        nameIndex = new HashMap<>();
        phoneSet = new HashSet<>();
    }

    public boolean addContact(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number! Contact not added.");
            return false;
        }
        Contact c = new Contact(name, phone, email);
        contacts.add(c);
        nameIndex.put(name.toLowerCase(), c);
        phoneSet.add(phone);
        System.out.println("Contact added: " + name);
        return true;
    }

    public Contact searchByName(String name) {
        return nameIndex.get(name.toLowerCase());
    }

    public boolean deleteContact(String name) {
        Contact c = nameIndex.remove(name.toLowerCase());
        if (c != null) {
            contacts.remove(c);
            phoneSet.remove(c.phone);
            System.out.println("Contact deleted: " + name);
            return true;
        }
        System.out.println("Contact not found: " + name);
        return false;
    }

    public void displaySorted() {
        if (contacts.isEmpty()) {
            System.out.println("Address book is empty.");
            return;
        }
        ArrayList<Contact> sorted = new ArrayList<>(contacts);
        Collections.sort(sorted, (a, b) -> a.name.compareToIgnoreCase(b.name));
        System.out.println("\n--- Contacts (sorted by name) ---");
        for (Contact c : sorted) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        AddressBookApp app = new AddressBookApp();
        app.addContact("Alice", "111-222-3333", "alice@email.com");
        app.addContact("Bob", "444-555-6666", "bob@email.com");
        app.addContact("Charlie", "777-888-9999", "charlie@email.com");
        app.addContact("Alice", "111-222-3333", "alice2@email.com"); // duplicate phone

        System.out.println("\nSearch for 'bob': " + app.searchByName("bob"));

        app.deleteContact("Charlie");
        app.displaySorted();
    }
}
