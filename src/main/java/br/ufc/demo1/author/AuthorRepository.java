package br.ufc.demo1.author;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

/**
 * Created by LuizI on 17/07/2017.
 */
@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer>{
}
