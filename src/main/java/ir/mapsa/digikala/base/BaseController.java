package ir.mapsa.digikala.base;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public abstract class BaseController<T, D, PK> {

    protected abstract BaseService<T, D, PK> getBaseService();

    protected abstract BaseMapper<T, D> getBaseMapper();

    @PostMapping
    public ResponseEntity<D> save(@RequestBody D dto) {
        return ResponseEntity.ok(getBaseService().save(dto));
    }

    @PutMapping
    public ResponseEntity<D> update(@RequestBody D dto, PK id) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(getBaseService().update(dto, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable PK id) {
        getBaseService().deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<D> getById(@PathVariable PK id) {
        T entity = getBaseService().findById(id);
        return ResponseEntity.ok(getBaseMapper().toDto(entity));
    }

    @GetMapping
    public ResponseEntity<Page<D>> getAll(@RequestParam int page, @RequestParam int size) {
        List<T> entities = new ArrayList<>();
        Iterable<T> iterable = getBaseService().findAll();
        iterable.iterator().forEachRemaining(entities::add);
        PageImpl<D> pageDto = new PageImpl<>(getBaseMapper().toDTOs(entities), PageRequest.of(page, size), entities.size());
        return ResponseEntity.ok(pageDto);
    }

}
