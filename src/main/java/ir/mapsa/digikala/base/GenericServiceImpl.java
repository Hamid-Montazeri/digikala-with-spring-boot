package ir.mapsa.digikala.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class GenericServiceImpl<T, D, PK> implements GenericService<T, D, PK> {

    private Class<T> classType;
    private final String className;

    protected abstract GenericRepository<T, PK> getRepository();

    protected abstract GenericMapper<T, D> getEntityMapper();

    public GenericServiceImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        classType = (Class<T>) pt.getActualTypeArguments()[0];
        String templateName = classType.getName(); //Class name generate here include entity.classname it doesn't useful for HQl
        this.className = templateName.substring(templateName.lastIndexOf('.') + 1, templateName.length());
    }

    @Override
    public T save(D dto) {
        return getRepository().save(getEntityMapper().toEntity(dto));
    }

    @Override
    public D update(D dto, PK id) {
        T existingEntity = getRepository().findById(id).orElseThrow(() -> {
            String errorMessage = String.format("The %s with id %s not found.", className, id);
            return new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
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
                    String errorMessage = String.format("The %s with id %s not found.", className, id);
                    return new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
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
