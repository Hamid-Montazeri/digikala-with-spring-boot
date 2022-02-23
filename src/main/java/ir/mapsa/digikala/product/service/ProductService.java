package ir.mapsa.digikala.product.service;

import ir.mapsa.digikala.category.entity.Category;
import ir.mapsa.digikala.category.service.ICatService;
import ir.mapsa.digikala.exception.ConflictException;
import ir.mapsa.digikala.exception.NotFoundException;
import ir.mapsa.digikala.product.entity.Product;
import ir.mapsa.digikala.product.repository.ProductRepo;
import ir.mapsa.digikala.user.entity.User;
import ir.mapsa.digikala.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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

        if (productRepo.existsById(product.getId())) {
            throw new ConflictException("The \"product\" with ID \"" + product.getId() + "\" already exists");
        }

        return productRepo.save(product);
    }

    @Override
    public Product update(Product product) {
        Optional<Product> optionalProduct = productRepo.findById(product.getId());
        if (optionalProduct.isEmpty()) {
            throw new NotFoundException("The Product \"" + product.getName() + "\" with ID \"" + product.getId() + "\" not found");
        }

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
            throw new NotFoundException("The requested Product with ID \"" + id + "\" not found");
        }

        return optionalProduct.get();
    }

    @Override
    @Cacheable(value = "product")
    public List<Product> getAllProducts() {
        List<Product> products = (List<Product>) productRepo.findAll();
        if (products.isEmpty()) {
            throw new NotFoundException("No Product found!");
        }
        return products;
    }

    @Override
    @Cacheable(value = "product", key = "#catId")
    public List<Product> getAllProductsByCatId(Long catId) {
        List<Product> products = productRepo.findAllByCategory_Id(catId);

        if (products.isEmpty()) {
            throw new NotFoundException("No Product found!");
        }

        return products;
    }


}
