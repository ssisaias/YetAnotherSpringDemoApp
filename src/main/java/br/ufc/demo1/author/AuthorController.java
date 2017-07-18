package br.ufc.demo1.author;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

/**
 * Created by LuizI on 17/07/2017.
 */
@RestController
@RequestMapping("/authors")
public class AuthorController {

    @Autowired
    private AuthorRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Author>> queryAllAuthors() {
        return ResponseEntity.ok(
            repository.findAll()
        );
    }

    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<String> createAuthor(@RequestBody Author author) throws MalformedURLException, URISyntaxException {
        if(repository.save(author)==null){
          return ResponseEntity.status(HttpStatus.CONFLICT).body("Author already exists");
        };
        URL createdURL = new URL("http://localhost:8080/author/" + author.getId());
        return ResponseEntity.created(createdURL.toURI()).build();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Author> updateAuthor(@PathVariable int id, @RequestBody Author author){
        if(repository.update(id, author)==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(author);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteAuthor(@PathVariable int id) {
        repository.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }
}
