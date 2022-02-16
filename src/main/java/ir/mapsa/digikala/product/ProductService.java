package ir.mapsa.digikala.product;

import ir.mapsa.digikala.category.Category;
import ir.mapsa.digikala.category.ICatService;
import ir.mapsa.digikala.user.IUserService;
import ir.mapsa.digikala.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    private final ProductRepo productRepo;
    private final ICatService catService;
    private final IUserService userService;

    @Autowired
    public ProductService(ProductRepo productRepo, ICatService catService, IUserService userService) {
        this.productRepo = productRepo;
        this.catService = catService;
        this.userService = userService;
    }

    @Override
    public Product save(Product product, Long catId, Long userId) {
        Category category = catService.getCatById(catId);
        User user = userService.getUserById(userId);

        product.setCategory(category);
        product.setUser(user);

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
        savedProduct.setUser(product.getUser());

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
