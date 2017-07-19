package br.ufc.demo1.publisher;

import br.ufc.demo1.pub.Pub;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

/**
 * Created by LuizI on 18/07/2017.
 */
@Entity(name = "publisher")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private String website;
    @Column
    private String description;

    @OneToMany(mappedBy = "publisher")
    @JsonIgnore
    private Collection<Pub> publications;

    public Publisher(){

    }
    public Publisher(int id, String name, String website, String description){
        this.setId(id);
        this.setName(name);
        this.setWebsite(website);
        this.setDescription(description);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public Collection<Pub> getPublications() {
        return publications;
    }

    public void setPublications(Collection<Pub> publications) {
        this.publications = publications;
    }
}
