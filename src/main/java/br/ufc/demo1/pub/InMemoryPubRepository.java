package br.ufc.demo1.pub;

import br.ufc.demo1.author.Author;
import br.ufc.demo1.publisher.Publisher;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by LuizI on 18/07/2017.
 */
@Repository
public class InMemoryPubRepository implements PubRepository{
    private static final List<Pub> PUBS =  new ArrayList<>();

    static{
        Author author = new Author(1, "Glauco", "Aquino");
        Publisher publisher = new Publisher(2, "Saraiva", "http://www.editorasaraiva.com.br/","Presente no segmento editorial desde 1917, a Saraiva Educação integra a SOMOS Educação desde dezembro de 2015. ");
        PUBS.addAll(
                Arrays.asList(
                    new Pub(1, "Livro", Tipo.LIVRO, author, publisher)
                )
        );
    }

    @Override
    public Iterable<Pub> findAll() {
        return Collections.unmodifiableList(PUBS);
    }

    @Override
    public Pub findOne(int id) {
        for (Pub pub: PUBS){
            if(pub.getId()==id){
                return pub;
            }
        }
        return null;
    }

    @Override
    public Pub save(Pub pub) {
        boolean invalid = false;
        for (Pub pub1: PUBS){
            if(pub1.getId()==pub.getId()){
                invalid = true;
            }
        }
        if(!invalid){
            PUBS.add(pub);
            return pub;
        }
        return null;
    }

    @Override
    public Pub update(int id, Pub pub) {
        for (Pub pub1: PUBS){
            if(pub1.getId()==pub.getId()){
                int index = PUBS.indexOf(pub);
                PUBS.add(index, pub);
                PUBS.remove(pub1);
                return pub;
            }
        }

        return null;
    }

    @Override
    public void delete(int id) {
        for (Pub pub: PUBS){
            if(pub.getId()==id){
                PUBS.remove(pub);
                break;
            }
        }
    }

}
