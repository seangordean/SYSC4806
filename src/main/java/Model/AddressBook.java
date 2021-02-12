package Model;

import Model.BuddyInfo;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;

@Entity
public class AddressBook
{
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy = "addressBook")
    private Collection<BuddyInfo> buddies;
    private String name;
    /** Creates a new instance of Team */
    public AddressBook() {
        buddies = new HashSet();
        this.name = name;
    }
    /**
     * Gets the id of this Team.
     * @return the id
     */

    public Long getId() {
        return this.id;
    }

    /**
     * Sets the id of this Team to the specified value.
     * @param id the new id
     */
    public void setId(Long id) {
        this.id = id;
    }


    public Collection<BuddyInfo> getBuddies() {
        return buddies;
    }

    public void setBuddies(Collection<BuddyInfo> buddies) {
        this.buddies = buddies;
    }
    public void addBuddy(BuddyInfo b){
        buddies.add(b);
    }
}
