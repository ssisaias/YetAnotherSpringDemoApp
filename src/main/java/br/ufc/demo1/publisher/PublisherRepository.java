package br.ufc.demo1.publisher;

/**
 * Created by LuizI on 18/07/2017.
 */
public interface PublisherRepository {
    Iterable<Publisher> findAll();

    Publisher findOne(int id);

    Publisher save(Publisher publisher);

    Publisher update(int id, Publisher publisher);

    void delete(int id);
}
