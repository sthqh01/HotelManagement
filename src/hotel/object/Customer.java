/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.object;

import java.util.Date;

/**
 *
 * @author danielhuynh
 */
public class Customer 
{
    private final String firstName, lastName, phoneNumber, email, gender, address, city, state, zipCode, country;
    private final Integer age;
    private final Date birthday;
    
    public Customer(String firstName, String lastName, Date birthday, Integer age, String gender, String phoneNumber, String email, String address, String city, String state, String zipCode, String country)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getStateProvince() {
        return state;
    }

    public String getZipcode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }
    
    public Date getBirthday()
    {
        return birthday;
    }
}
