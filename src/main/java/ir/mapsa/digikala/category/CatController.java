package ir.mapsa.digikala.category;

import org.springframework.beans.factory.annotation.Autowired;
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
    public Category save(@RequestBody CategoryDTO categoryDTO) {
        Category category = mapper.toEntity(categoryDTO);
        return catService.save(category);
    }

    @PutMapping("/update")
    public Category update(@RequestBody CategoryDTO categoryDTO) {
        Category category = mapper.toEntity(categoryDTO);
        return catService.update(category);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        catService.deleteById(id);
    }

    @GetMapping("/{id}")
    public CategoryDTO getCategoryById(@PathVariable Long id) {
        Category category = catService.getCatById(id);
        return mapper.toDTO(category);
    }

    @GetMapping("/")
    public List<CategoryDTO> getAll() {
        List<Category> categories = catService.getAllCats();
        return mapper.toDTOs(categories);
    }


}
