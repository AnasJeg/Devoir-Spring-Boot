package ma.devoir.Dao;

import java.util.List;

public interface Dao<T> {

    T save(T o);
    T findById(int id);
    List<T> findAll();
    void delete(T o);
    void update(T o);
}
