package ir.mapsa.digikala.category.controller;

import ir.mapsa.digikala.category.entity.Category;
import ir.mapsa.digikala.category.entity.CategoryDTO;
import ir.mapsa.digikala.category.entity.CategoryMapper;
import ir.mapsa.digikala.category.service.CatService;
import ir.mapsa.digikala.category.service.ICatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CatController {

    private final ICatService catService;
    private final CategoryMapper mapper;

    @Autowired
    public CatController(CatService catService, CategoryMapper mapper) {
        this.catService = catService;
        this.mapper = mapper;
    }

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody CategoryDTO categoryDTO) {
        Category category = mapper.toEntity(categoryDTO);
        Category savedCategory = catService.save(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody CategoryDTO categoryDTO) {
        Category category = mapper.toEntity(categoryDTO);
        Category updatedCategory = catService.update(category);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        catService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDTO> getCategoryById(@PathVariable Long id) {
        Category category = catService.getCatById(id);
        CategoryDTO categoryDTO = mapper.toDTO(category);
        return ResponseEntity.ok(categoryDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAll() {
        List<Category> categories = catService.getAllCats();
        List<CategoryDTO> categoryDTOS = mapper.toDTOs(categories);
        return ResponseEntity.ok(categoryDTOS);
    }


}
