package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.dto.CategoryDTO;
import ir.mapsa.digikala.mapper.CategoryMapper;
import ir.mapsa.digikala.model.Category;
import ir.mapsa.digikala.service.ICategoryService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final ICategoryService catService;
    private final CategoryMapper mapper;

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody CategoryDTO categoryDTO) {
        Category savedCategory = catService.save(mapper.toEntity(categoryDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody CategoryDTO categoryDTO) {
        Category updatedCategory = catService.save(mapper.toEntity(categoryDTO));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        catService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        Optional<Category> optionalCategory = catService.findById(id);

        if (optionalCategory.isEmpty()) {
            throw new RuntimeException("The requested \"Category\" not found.");
        }

        CategoryDTO categoryDTO = mapper.toDto(optionalCategory.get());
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<Category> categories = (List<Category>) catService.findAll();
        List<CategoryDTO> categoryDTOS = mapper.toDTOs(categories);
        return ResponseEntity.ok(categoryDTOS);
    }

}
