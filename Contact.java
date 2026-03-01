package edu.snhu.contact;
// Author: Michael McLean
public class Contact {
    private String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        setContactId(contactId);
        setFirstName(firstName);
        setLastName(lastName);
        setPhone(phone);
        setAddress(address);
    }
    public String getContactId() {
        return contactId;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {

        return phone;
    }
    public String getAddress() {
        return address;
    }
    private void setContactId(String contactId) {
        if(contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("The contact object shall have a required unique contact ID string that cannot be longer than 10 characters");
        }
        this.contactId = contactId;
    }
    public void setFirstName(String firstName) {
        if(firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("The contact object shall have a required firstName String field that cannot be longer than 10 characters. The firstName field shall not be null.");
        }
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        if(lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("The contact object shall have a required lastName String field that cannot be longer than 10 characters. The lastName field shall not be null.");
        }
        this.lastName = lastName;
    }
    public void setPhone(String phone) {
        if(phone == null || phone.length() != 10 || !phone.matches("\\d{10}")) {
            throw new IllegalArgumentException("The contact object shall have a required phone String field that must be exactly 10 digits. The phone field shall not be null.");
        }
        this.phone = phone;
    }
    public void setAddress(String address) {
        if(address == null || address.length() > 30) {
            throw new IllegalArgumentException("The contact object shall have a required address field that must be no longer than 30 characters. The address field shall not be null.");
        }
        this.address = address;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "contactId='" + contactId + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
    
}
