package br.ufc.demo1.author;

import br.ufc.demo1.pub.Pub;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by LuizI on 17/07/2017.
 */
@Entity(name = "author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String firstName;
    @Column
    private String lastName;

    @OneToMany(mappedBy = "author")
    @JsonIgnore
    private Collection<Pub> publications;

    public Author(){

    }
    public Author(int id, String firstName, String lastName){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Collection<Pub> getPublications() {
        return publications;
    }

    public void setPublications(Collection<Pub> publications) {
        this.publications = publications;
    }
}
