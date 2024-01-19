package ir.mapsa.digikala.service;

import ir.mapsa.digikala.dto.CategoryDTO;
import ir.mapsa.digikala.dto.ProductDTO;
import ir.mapsa.digikala.model.Product;
import ir.mapsa.digikala.model.ProductType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @Test
    void testSave() {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("test product");

        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setTitle("test category");
        categoryService.save(categoryDTO);

        productDTO.setCategory(categoryDTO);
        productDTO.setProductType(ProductType.NORMAL);
        productDTO.setSalePrice(1000d);
        productDTO.setRegularPrice(1200d);

        Product savedProduct = productService.save(productDTO);

        assertThat(savedProduct).isNotNull();
        assertThat(savedProduct.getId()).isNotNull();
        assertThat(savedProduct.getCategory()).isNotNull();
    }

}