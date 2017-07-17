package br.ufc.demo1.author;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by LuizI on 17/07/2017.
 */
@Component
public class InMemoryAuthorRepository implements AuthorRepository {
    private static final List<Author> AUTHORS = new ArrayList<>();

    static{
        AUTHORS.addAll(
                Arrays.asList(
                        new Author(1, "Glauco", "Aquino"),
                        new Author(2, "Felipe", "Pinheiro"),
                        new Author(3, "Machado", "de Assis")
                )
        );
    }

    @Override
    public  Iterable<Author> findAll(){
        return Collections.unmodifiableList(AUTHORS);
    }

    @Override
    public Author save(Author author){
        boolean invalid = false;
        for (Author author1: AUTHORS){
            if(author1.getId()==author.getId()){
                invalid = true;
            }
        }
        if(!invalid){
            AUTHORS.add(author);
            return author;
        }
        return null;
    }

    @Override
    public void delete(int id){

        for (Author author1 : AUTHORS) {
            if (id==author1.getId()){
                AUTHORS.remove(author1);
                break;
            }
        }
    }

    @Override
    public Author update(int id, Author author) {
        for (Author author1 : AUTHORS) {
            if (id==author1.getId()){
                int index = AUTHORS.indexOf(author1);
                AUTHORS.add(index, author);
                AUTHORS.remove(author1);
                return author;
            }
        }
        return null;
    }
}
