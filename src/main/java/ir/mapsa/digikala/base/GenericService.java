package ir.mapsa.digikala.base;


import java.util.Optional;

public interface GenericService<T, D, PK> {

    T save(T entity);

    Optional<T> findById(PK id);

    boolean existsById(PK id);

    Iterable<T> findAll();

    long count();

    void deleteById(PK id);

    void delete(T entity);

    void deleteAll();


}
