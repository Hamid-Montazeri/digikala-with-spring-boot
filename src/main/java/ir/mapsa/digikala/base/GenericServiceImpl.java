package ir.mapsa.digikala.base;

import java.util.Optional;

public abstract class GenericServiceImpl<T, D, PK> implements GenericService<T, D, PK> {

    protected abstract GenericRepository<T, PK> getRepository();
    protected abstract GenericMapper<T, D> getEntityMapper();

    @Override
    public T save(D dto) {
        T entity = getEntityMapper().toEntity(dto);
        return getRepository().save(entity);
    }

    @Override
    public Optional<T> findById(PK id) {
        return getRepository().findById(id);
    }

    @Override
    public boolean existsById(PK id) {
        return getRepository().existsById(id);
    }

    @Override
    public Iterable<T> findAll() {
        return getRepository().findAll();
    }

    @Override
    public long count() {
        return getRepository().count();
    }

    @Override
    public void deleteById(PK id) {
        getRepository().deleteById(id);
    }

    @Override
    public void delete(T entity) {
        getRepository().delete(entity);
    }

    @Override
    public void deleteAll() {
        getRepository().deleteAll();
    }

}
