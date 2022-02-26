package ir.mapsa.digikala.product.service;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import ir.mapsa.digikala.category.service.ICatService;
import ir.mapsa.digikala.product.entity.Product;
import ir.mapsa.digikala.product.entity.ProductDTO;
import ir.mapsa.digikala.product.entity.ProductMapper;
import ir.mapsa.digikala.product.repository.ProductRepo;
import ir.mapsa.digikala.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService extends GenericServiceImpl<Product, ProductDTO, Long> implements IProductService {

    private final ProductRepo productRepo;
    private final ProductMapper productMapper;
//    private final ICatService catService;
//    private final IUserService userService;

/*    @Autowired
    public ProductService(ProductRepo productRepo, ProductMapper productMapper, ICatService catService, IUserService userService) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
        this.catService = catService;
        this.userService = userService;
    }*/
    @Autowired
    public ProductService(ProductRepo productRepo, ProductMapper productMapper) {
        this.productRepo = productRepo;
        this.productMapper = productMapper;
    }

    @Override
    protected GenericRepository<Product, Long> getRepository() {
        return productRepo;
    }

    @Override
    protected GenericMapper<Product, ProductDTO> getEntityMapper() {
        return productMapper;
    }
}
