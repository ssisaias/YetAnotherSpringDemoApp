package br.ufc.demo1.author;

import java.util.Collection;
import java.util.List;

/**
 * Created by LuizI on 17/07/2017.
 */
public interface AuthorRepository {
    Iterable<Author> findAll();

    Author save(Author author);

    void delete(int id);

    Author update(int id, Author author);
}
