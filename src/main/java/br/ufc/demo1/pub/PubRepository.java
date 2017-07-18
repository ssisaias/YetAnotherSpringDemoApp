package br.ufc.demo1.pub;

/**
 * Created by LuizI on 18/07/2017.
 */
public interface PubRepository {
    Iterable<Pub> findAll();

    Pub findOne(int id);

    Pub save(Pub publisher);

    Pub update(int id, Pub publisher);

    void delete(int id);

}
