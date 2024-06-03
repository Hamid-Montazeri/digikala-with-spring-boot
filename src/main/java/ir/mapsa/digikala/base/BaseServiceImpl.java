package ir.mapsa.digikala.base;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public abstract class BaseServiceImpl<T, D, PK> implements BaseService<T, D, PK> {

    private final String className;

    protected abstract BaseRepository<T, PK> getRepository();

    protected abstract BaseMapper<T, D> getEntityMapper();

    public BaseServiceImpl() {
        Type t = getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) t;
        Class<T> classType = (Class<T>) pt.getActualTypeArguments()[0];
        String templateName = classType.getName(); //Class name generate here include entity.classname it doesn't useful for HQl
        this.className = templateName.substring(templateName.lastIndexOf('.') + 1, templateName.length());
    }

    @Override
    public D save(D dto) {
        T entity = getEntityMapper().toEntity(dto);
        T savedEntity = getRepository().save(entity);
        return getEntityMapper().toDto(savedEntity);
    }

    @Override
    public D update(D dto, PK id) {
        T existingEntity = getRepository().findById(id).orElseThrow(() -> {
            String errorMessage = String.format("%s مورد نظر با آیدی %s یافت نشد", className, id);
            return new ResponseStatusException(HttpStatus.NOT_FOUND, errorMessage);
        });

        getEntityMapper().partialUpdate(existingEntity, dto);

        return save(getEntityMapper().toDto(existingEntity));
    }

    @Override
    public T findById(PK id) {
        return getRepository()
                .findById(id)
                .orElseThrow(() -> {
                    String errorMessage = String.format("%s مورد نظر با آیدی %s یافت نشد", className, id);
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
