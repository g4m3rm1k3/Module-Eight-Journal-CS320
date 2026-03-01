package edu.snhu.contact;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Unit test for simple App.
 */
public class ContactTest 
{
    //Happy path
   @Test
    void testContactClassSuccess() {
        Contact contact = new Contact("C1", "Michael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        
        assertAll("Contact State",
            () -> assertEquals("C1", contact.getContactId()),
            () -> assertEquals("Michael", contact.getFirstName()),
            () -> assertEquals("McLean", contact.getLastName()),
            () -> assertEquals("6035156280", contact.getPhone()),
            () -> assertEquals("98 Kings hwy, Middleton, NH", contact.getAddress())
        );
    }
    @Test
    void TestContactIDNull(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Michael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        });
        assertEquals("The contact object shall have a required unique contact ID string that cannot be longer than 10 characters", exception.getMessage());
    }
    @Test
    void TestContactIDTooLong(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C12345678901", "Michael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        });
        assertEquals("The contact object shall have a required unique contact ID string that cannot be longer than 10 characters", exception.getMessage());
    }
    @Test
    void ContactFirstNameNull(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C1", null, "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        });
        assertEquals("The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.", exception.getMessage());
    }
    @Test
    void ContactFirstNameTooLong(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C1", "MichaelMichael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH");
        });
        assertEquals("The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.", exception.getMessage());
    }
    @Test
    void ContactLastNameNull(){ 
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C1", "Michael", null, "6035156280", "98 Kings hwy, Middleton, NH");
        });
        assertEquals("The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.", exception.getMessage());
    }   
    @Test
    void ContactLastNameTooLong(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C1", "Michael", "McLeanMcLean", "6035156280", "98 Kings hwy, Middleton, NH");
        });
        assertEquals("The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.", exception.getMessage());
    }   
    @Test
    void ContactPhoneNull(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C1", "Michael", "McLean", null, "98 Kings hwy, Middleton, NH");
        });
        assertEquals("The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.", exception.getMessage());
    }       
    @Test
    void ContactPhoneWrongLength(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C1", "Michael", "McLean", "60351562801", "98 Kings hwy, Middleton, NH");
        });
        assertEquals("The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.", exception.getMessage());
    }   
    @Test
    void ContactPhoneNonNumeric(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C1", "Michael", "McLean", "60351A6280", "98 Kings hwy, Middleton, NH");
        });
        assertEquals("The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.", exception.getMessage());
    }   
    @Test
    void ContactAddressNull(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C1", "Michael", "McLean", "6035156280", null);
        });
        assertEquals("The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.", exception.getMessage());
    }   
    @Test
    void ContactAddressTooLong(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new Contact("C1", "Michael", "McLean", "6035156280", "98 Kings hwy, Middleton, NH 03887-1234");
        });
        assertEquals("The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.", exception.getMessage());
    }


}
