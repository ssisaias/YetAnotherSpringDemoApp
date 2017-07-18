package br.ufc.demo1.publisher;

import br.ufc.demo1.pub.Pub;
import br.ufc.demo1.pub.Tipo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

/**
 * Created by LuizI on 18/07/2017.
 */
@RestController
@RequestMapping("/publishers")
public class PublisherController {

    @Autowired
    private PublisherRepository publisherRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Publisher>> queryAllPublishers(){
        return ResponseEntity.ok(
          publisherRepository.findAll()
        );
    }

    @RequestMapping(value="/{id}", method = RequestMethod.GET)
    public ResponseEntity<Publisher> queryOnePublisher(@PathVariable int id){
        Publisher publisher = publisherRepository.findOne(id);
        if (publisher == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(publisher);
    }

    @RequestMapping( method = RequestMethod.POST)
    public ResponseEntity<String> createPublisher(@RequestBody Publisher publisher) throws MalformedURLException, URISyntaxException {
        if(publisherRepository.save(publisher)==null){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Publisher already exists");
        };
        URL createdURL = new URL("http://localhost:8080/publishers/" + publisher.getId());
        return ResponseEntity.created(createdURL.toURI()).build();
    }

    @RequestMapping(value="/{id}",method = RequestMethod.PUT)
    public ResponseEntity<Publisher> updatePublisher(@PathVariable int id, @RequestBody Publisher publisher){
        if(publisherRepository.update(id, publisher)==null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(publisher);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePublisher(@PathVariable int id) {
        publisherRepository.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Deleted");
    }

}
