package org.experiment.db.entities.test;

/**
 * Created by sepetean on 9/29/2015.
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;

    protected CustomerEntity() {}

    public CustomerEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName(){
        return this.lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "CustomerEntity[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
