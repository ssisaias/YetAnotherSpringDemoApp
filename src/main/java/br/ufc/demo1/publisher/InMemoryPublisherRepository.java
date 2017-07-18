package br.ufc.demo1.publisher;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by LuizI on 18/07/2017.
 */
@Repository
public class InMemoryPublisherRepository implements PublisherRepository {

    private static final List<Publisher> PUBLISHERS =  new ArrayList<>();

    static{
        PUBLISHERS.addAll(
                Arrays.asList(
                        new Publisher(1, "Pearson", "https://www.pearson.com/","A Pearson, há 173 anos no mercado, é líder em educação no mundo e está presente em mais de 70 países com 35 mil colaboradores."),
                        new Publisher(2, "Saraiva", "http://www.editorasaraiva.com.br/","Presente no segmento editorial desde 1917, a Saraiva Educação integra a SOMOS Educação desde dezembro de 2015. ")
                )
        );
    }

    @Override
    public Iterable<Publisher> findAll() {
        return Collections.unmodifiableList(PUBLISHERS);
    }

    @Override
    public Publisher findOne(int id) {
        for (Publisher publisher: PUBLISHERS){
            if(publisher.getId()==id){
                return publisher;
            }
        }
        return null;
    }

    @Override
    public Publisher save(Publisher publisher) {
        boolean invalid = false;
        for (Publisher pub: PUBLISHERS){
            if(pub.getId()==publisher.getId()){
                invalid = true;
            }
        }
        if(!invalid){
            PUBLISHERS.add(publisher);
            return publisher;
        }
        return null;
    }

    @Override
    public Publisher update(int id, Publisher publisher) {
        for (Publisher pub: PUBLISHERS){
            if(pub.getId()==publisher.getId()){
                int index = PUBLISHERS.indexOf(pub);
                PUBLISHERS.add(index, publisher);
                PUBLISHERS.remove(pub);
                return publisher;
            }
        }

        return null;
    }

    @Override
    public void delete(int id) {
        for (Publisher pub: PUBLISHERS){
            if(pub.getId()==id){
                PUBLISHERS.remove(pub);
                break;
            }
        }
    }
}
