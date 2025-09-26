import java.util.ArrayList;

public class ContactManager {
    private ArrayList<Contact> contacts = new ArrayList<Contact>();

    public void addContact(Contact contact) {
        for (Contact c : contacts) {
            if (c.getPhone().equals(contact.getPhone())) {
                System.out.println("Contact already exists (same phone).");
                return;
            }
        }
        contacts.add(contact);
        System.out.println("Contact added successfully.");
    }

    public void viewContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
            return;
        }
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }

    public void updateContact(String name, String newPhone, String newEmail) {
        for (Contact c : contacts) {
            if (c.getName().equalsIgnoreCase(name)) {
                c.setPhone(newPhone);
                c.setEmail(newEmail);
                System.out.println("Contact updated successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void deleteContact(String name) {
        for (int i = 0; i < contacts.size(); i++) {
            if (contacts.get(i).getName().equalsIgnoreCase(name)) {
                contacts.remove(i);
                System.out.println("Contact deleted successfully.");
                return;
            }
        }
        System.out.println("Contact not found.");
    }

    public void searchContact(String keyword) {
        boolean found = false;
        String lower = keyword.toLowerCase();
        for (Contact c : contacts) {
            if (c.getName().toLowerCase().contains(lower)
                    || c.getPhone().contains(keyword)
                    || c.getEmail().toLowerCase().contains(lower)) {
                System.out.println(c);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No matching contact found.");
        }

    }
public void displayContacts() {
    if (contacts.isEmpty()) {
        System.out.println("No contacts found.");
    } else {
        for (Contact c : contacts) {
            System.out.println(c);
        }
    }
}

public void removeContact(String name) {
    boolean removed = contacts.removeIf(c -> c.getName().equalsIgnoreCase(name));
    if (removed) {
        System.out.println("Contact removed successfully.");
    } else {
        System.out.println("Contact not found.");
    }
}

}