package ir.mapsa.digikala.product;

import ir.mapsa.digikala.category.Category;
import ir.mapsa.digikala.category.ICatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private final ProductRepo productRepo;
    private final ICatService catService;

    @Autowired
    public ProductService(ProductRepo productRepo, ICatService catService) {
        this.productRepo = productRepo;
        this.catService = catService;
    }

    @Override
    public Product save(Product product, Long catId) {
        Category category = catService.getCatById(catId);
        product.setCategory(category);
        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) {
        Optional<Product> optionalProduct = productRepo.findById(product.getId());
        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("'Product' not found with requested 'id'");
        }//ControllerAdvice

        Product savedProduct = optionalProduct.get();

        savedProduct.setName(product.getName());
        savedProduct.setCategory(product.getCategory());
        savedProduct.setRegularPrice(product.getRegularPrice());
        savedProduct.setSalePrice(product.getSalePrice());
        savedProduct.setImage(product.getImage());
        savedProduct.setType(product.getType());
//        savedProduct.setUser(product.getUser());

        return productRepo.save(savedProduct);
    }

    @Override
    public void deleteById(Long id) {
        productRepo.deleteById(id);
    }

    @Override
    public Product getById(Long id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("'Product' not found");
        }

        return optionalProduct.get();
    }

    @Override
    public List<Product> getAllProducts() {
        return (List<Product>) productRepo.findAll();
    }
}
