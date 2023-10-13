package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.dto.CategoryDTO;
import ir.mapsa.digikala.mapper.CategoryMapper;
import ir.mapsa.digikala.model.Category;
import ir.mapsa.digikala.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService catService;
    private final CategoryMapper mapper;

    @PostMapping
    public ResponseEntity<CategoryDTO> save(@RequestBody CategoryDTO categoryDTO) {
        Category savedCategory = catService.save(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(savedCategory));
    }

    @PutMapping
    public ResponseEntity<CategoryDTO> update(@RequestBody CategoryDTO categoryDTO) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(catService.update(categoryDTO, categoryDTO.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        catService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        return ResponseEntity.ok(mapper.toDto(catService.findById(id)));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<Category> categories = (List<Category>) catService.findAll();
        List<CategoryDTO> categoryDTOS = mapper.toDTOs(categories);
        return ResponseEntity.ok(categoryDTOS);
    }

}
