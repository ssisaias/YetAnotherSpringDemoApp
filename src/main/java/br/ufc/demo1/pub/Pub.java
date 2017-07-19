package br.ufc.demo1.pub;

import br.ufc.demo1.author.Author;
import br.ufc.demo1.publisher.Publisher;

import javax.persistence.*;

/**
 * Created by LuizI on 18/07/2017.
 */
@Entity(name = "publications")
public class Pub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column
    private String name;
    @Column
    private Tipo tipo;
    @ManyToOne
    private Author author;
    @ManyToOne
    Publisher publisher;

    public  Pub(){};

    public Pub(int id, String name, Tipo tipo, Author author, Publisher publisher){
        this.setId(id);
        this.setName(name);
        this.setTipo(tipo);
        this.setAuthor(author);
        this.setPublisher(publisher);
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

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }


}
