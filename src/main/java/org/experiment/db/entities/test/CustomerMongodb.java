package org.experiment.db.entities.test;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

/**
 * Created by sepetean on 9/29/2015.
 */

public class CustomerMongodb implements Serializable{

    @Id
    public String id;

    public String firstName;
    public String lastName;

    public CustomerMongodb() {
    }

    public CustomerMongodb(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return String.format(
                "Customer[id=%s, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerMongodb that = (CustomerMongodb) o;

        if (!id.equals(that.id)) return false;
        if (!firstName.equals(that.firstName)) return false;
        return lastName.equals(that.lastName);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + firstName.hashCode();
        result = 31 * result + lastName.hashCode();
        return result;
    }
}