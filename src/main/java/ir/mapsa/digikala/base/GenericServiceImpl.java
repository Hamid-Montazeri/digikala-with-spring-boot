package ir.mapsa.digikala.base;

import java.util.NoSuchElementException;

public abstract class GenericServiceImpl<T, D, PK> implements GenericService<T, D, PK> {

    protected abstract GenericRepository<T, PK> getRepository();

    protected abstract GenericMapper<T, D> getEntityMapper();

    @Override
    public T save(D dto) {
        return getRepository().save(getEntityMapper().toEntity(dto));
    }

    @Override
    public D update(D dto, PK id) {
        T existingEntity = getRepository().findById(id).orElseThrow(() -> {
            String errorMessage = String.format("Requested type with id %s not found.", id);
            return new NoSuchElementException(errorMessage);
        });

        getEntityMapper().partialUpdate(existingEntity, dto);

        T updatedEntity = save(getEntityMapper().toDto(existingEntity));

        return getEntityMapper().toDto(updatedEntity);
    }

    @Override
    public T findById(PK id) {
        return getRepository()
                .findById(id)
                .orElseThrow(() -> {
                    String errorMessage = String.format("Requested type with id %s not found.", id);
                    return new NoSuchElementException(errorMessage);
                });
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
