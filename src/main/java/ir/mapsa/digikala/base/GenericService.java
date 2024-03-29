package ir.mapsa.digikala.base;


public interface GenericService<T, D, PK> {

    T save(D dto);

    D update(D dto, PK id);

    T findById(PK id);

    boolean existsById(PK id);

    Iterable<T> findAll();

    long count();

    void deleteById(PK id);

    void delete(T entity);

    void deleteAll();


}
