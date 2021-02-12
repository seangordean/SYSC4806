package Model;

import javax.persistence.*;

@Entity
public class BuddyInfo
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name;
    private String phoneNumber;
    @ManyToOne
    private AddressBook addressBook;

    public BuddyInfo()
    {
    }
    public BuddyInfo(String name, String phoneNumber)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }
    public String getName()
    {
        return name;
    }
    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setName(String name){

        this.name = name;
    }

    public void setNumber(String number){

        phoneNumber = number;
    }


    public AddressBook getAddressBook() {
        return addressBook;
    }
}