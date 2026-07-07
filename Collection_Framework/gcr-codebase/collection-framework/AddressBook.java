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

    @Override
    public String toString() {
        return "Name: " + name +
               ", Phone: " + phone +
               ", Email: " + email;
    }
}

public class AddressBook {
    ArrayList<Contact> contacts = new ArrayList<>();
    HashMap<String, Contact> map = new HashMap<>();
    HashSet<String> phoneSet = new HashSet<>();

    // Add Contact
    public void addContact(String name, String phone, String email) {
        if (phoneSet.contains(phone)) {
            System.out.println("Duplicate phone number! Contact not added.");
            return;
        }

        Contact c = new Contact(name, phone, email);
        contacts.add(c);
        map.put(name, c);
        phoneSet.add(phone);

        System.out.println("Contact Added Successfully.");
    }

    // Search Contact
    public void searchContact(String name) {
        Contact c = map.get(name);

        if (c != null)
            System.out.println(c);
        else
            System.out.println("Contact Not Found.");
    }

    // Delete Contact
    public void deleteContact(String name) {
        Contact c = map.remove(name);

        if (c != null) {
            contacts.remove(c);
            phoneSet.remove(c.phone);
            System.out.println("Contact Deleted.");
        } else {
            System.out.println("Contact Not Found.");
        }
    }

    // Display Sorted Contacts
    public void displayContacts() {
        Collections.sort(contacts, new Comparator<Contact>() {
            public int compare(Contact c1, Contact c2) {
                return c1.name.compareToIgnoreCase(c2.name);
            }
        });

        System.out.println("\nAddress Book:");
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public static void main(String[] args) {
        AddressBook ab = new AddressBook();

        ab.addContact("John", "9876543210", "john@gmail.com");
        ab.addContact("Alice", "9123456789", "alice@gmail.com");
        ab.addContact("Bob", "9988776655", "bob@gmail.com");

        // Duplicate phone number
        ab.addContact("Sam", "9876543210", "sam@gmail.com");

        System.out.println("\nSearch Result:");
        ab.searchContact("Alice");

        System.out.println("\nAfter Deleting Bob:");
        ab.deleteContact("Bob");

        ab.displayContacts();
    }
}