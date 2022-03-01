package ir.mapsa.digikala.category.controller;

import ir.mapsa.digikala.category.entity.Category;
import ir.mapsa.digikala.category.entity.CategoryDTO;
import ir.mapsa.digikala.category.entity.CategoryMapper;
import ir.mapsa.digikala.category.service.CatServiceImpl;
import ir.mapsa.digikala.category.service.ICatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categories")
public class CatController {

    private final ICatService catService;
    private final CategoryMapper mapper;

    @Autowired
    public CatController(CatServiceImpl catServiceImpl, CategoryMapper mapper) {
        this.catService = catServiceImpl;
        this.mapper = mapper;
    }

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody CategoryDTO categoryDTO) {
        Category savedCategory = catService.save(categoryDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCategory);
    }

    @PutMapping("/update")
    public ResponseEntity<Category> update(@RequestBody CategoryDTO categoryDTO) {
        Optional<Category> optionalCategory = catService.findById(categoryDTO.getId());

        if (optionalCategory.isEmpty()) {
            throw new NotFoundException("The requested \"Category\" not found.");
        }

        Category savedCategory = optionalCategory.get();

        savedCategory.setName(categoryDTO.getName());

        Category updatedCategory = catService.save(mapper.toDto(savedCategory));

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
            throw new NotFoundException("The requested \"Category\" not found.");
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
