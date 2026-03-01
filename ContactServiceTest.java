package edu.snhu.contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit test for simple App.
 */
public class ContactServiceTest 
{
    @Test
    void testAddContactSuccess() {
        ContactService contactService = new ContactService();
        contactService.addContact("Michael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        assertEquals(1, contactService.getAllContacts().size());
        assertEquals("Michael", contactService.getContact("C1").getFirstName());
    }
    @Test
    void testDeleteContactSuccess() {
        ContactService contactService = new ContactService();
        contactService.addContact("Michael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        Contact deletedContact = contactService.deleteContact("C1");
        assertEquals("C1", deletedContact.getContactId());
        assertEquals(0, contactService.getAllContacts().size());
    }
    @Test
    void testUpdateContactFirstNameSuccess() {
        ContactService contactService = new ContactService();
        contactService.addContact("Michael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        contactService.updateContactFirstName("C1", "Joseph");
        assertEquals("Joseph", contactService.getContact("C1").getFirstName());
    }
    @Test
    void testUpdateContactLastNameSuccess() {
        ContactService contactService = new ContactService();
        contactService.addContact("Michael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        contactService.updateContactLastName("C1", "Thomas");
        assertEquals("Thomas", contactService.getContact("C1").getLastName());
    }
    @Test
    void testUpdateContactPhoneSuccess() {
        ContactService contactService = new ContactService();
        contactService.addContact("Michael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        contactService.updateContactPhone("C1", "6034730016");
        assertEquals("6034730016", contactService.getContact("C1").getPhone());
    }
    @Test
    void testUpdateContactAddressSuccess() {
        ContactService contactService = new ContactService();
        contactService.addContact("Michael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        contactService.updateContactAddress("C1", "75 River ST, Lynn MA");
        assertEquals("75 River ST, Lynn MA", contactService.getContact("C1").getAddress());
    }
    @Test
    void testDeleteContactNotFound() {
        ContactService contactService = new ContactService();
        contactService.addContact("Michael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        Exception exception = org.junit.jupiter.api.Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.deleteContact("C2");
        });
        assertEquals("Contact with ID C2 does not exist.", exception.getMessage());
    }
    @Test
    void testContactsHaveUniqueIDs() {
        ContactService contactService = new ContactService();
        contactService.addContact("Michael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        contactService.addContact("Joseph", "Thomas", "6034730016", "75 River ST, Lynn MA");
        assertEquals("C1", contactService.getContact("C1").getContactId());
        assertEquals("C2", contactService.getContact("C2").getContactId());
    }
}
