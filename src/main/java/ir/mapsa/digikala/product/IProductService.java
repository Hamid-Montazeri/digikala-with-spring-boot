package ir.mapsa.digikala.product;

import java.util.List;

public interface IProductService {

    Product save(Product product, Long catId, Long userId);

    Product update(Product product);

    void deleteById(Long id);

    Product getById(Long id);

    List<Product> getAllProducts();


}
