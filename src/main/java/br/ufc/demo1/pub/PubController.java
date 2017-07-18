package br.ufc.demo1.pub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by LuizI on 18/07/2017.
 */
@RestController
@RequestMapping("/pubs")
public class PubController {

    @Autowired
    private PubRepository pubRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Pub>> queryAllPublications(){
        return ResponseEntity.ok(
                pubRepository.findAll()
        );
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Pub> queryOnePublication(@PathVariable int id){
        Pub publisher = pubRepository.findOne(id);
        if (publisher == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(publisher);
    }

    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<String> createPub(@RequestBody Pub publisher) throws MalformedURLException, URISyntaxException {
        if(pubRepository.save(publisher)==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Publication already exists");
        };
        URL createdURL = new URL("http://localhost:8080/pubs/" + publisher.getId());
        return ResponseEntity.created(createdURL.toURI()).build();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Pub> updatePub(@PathVariable int id, @RequestBody Pub publisher){
        if(pubRepository.update(id, publisher)==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(publisher);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePub(@PathVariable int id) {
        pubRepository.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

}
