package ir.mapsa.digikala.base;


public interface BaseService<T, D, PK> {

    D save(D dto);

    D update(D dto, PK id);

    T findById(PK id);

    boolean existsById(PK id);

    Iterable<T> findAll();

    long count();

    void deleteById(PK id);

    void delete(T entity);

    void deleteAll();


}
