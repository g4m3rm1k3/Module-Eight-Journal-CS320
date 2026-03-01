package edu.snhu.contact;
// Author: Michael McLean
import java.util.HashMap;
import java.util.Map;

public class ContactService {
    private Map<String, Contact> contacts;
    private int contactIdCounter = 0;
    public ContactService() {
        contacts = new HashMap<>();
    }
    public void addContact(String firstName, String lastName, String phone, String address) {
        String contactId = generateContactId();
        Contact newContact = new Contact(contactId, firstName, lastName, phone, address);
        contacts.put(contactId, newContact);
    }
    private String generateContactId() {
        return "C" + (++contactIdCounter);
    }
    public Contact deleteContact(String contactId) {
        if(!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(message(contactId));
        }
        Contact removeContact = contacts.get(contactId);
        contacts.remove(contactId);
        return removeContact;
        
    }
    private String message(String contactId) {
        return "Contact with ID " + contactId + " does not exist.";
    }
    public void updateContactFirstName(String contactId, String firstName) {
        if(!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(message(contactId));
        }
        contacts.get(contactId).setFirstName(firstName);
    }
    public void updateContactLastName(String contactId, String lastName) {
        if(!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(message(contactId));
        }
        contacts.get(contactId).setLastName(lastName);
    }
    public void updateContactPhone(String contactId, String phone) {
        if(!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(message(contactId));
        }
        contacts.get(contactId).setPhone(phone);
    }
    public void updateContactAddress(String contactId, String address) {
        if(!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(message(contactId));
        }
        contacts.get(contactId).setAddress(address);
    }
    // public void displayContacts() {
    //     if (contacts.isEmpty()) {
    //         System.out.println("No contacts available.");
    //         return;
    //     }
    //     for(Contact contact : contacts.values()) {
    //         System.out.println(contact.toString());
    //     }
    // }
    public Contact getContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException(message(contactId));
        }
        return contacts.get(contactId);
    }
    public Map<String, Contact> getAllContacts() {
        return contacts;
    }
}
