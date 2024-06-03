package ir.mapsa.digikala;

import com.github.javafaker.Faker;
import ir.mapsa.digikala.model.Product;
import ir.mapsa.digikala.model.ProductType;
import ir.mapsa.digikala.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
@RequiredArgsConstructor
public class Application implements ApplicationRunner {

    private final ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (productRepository.count() > 0)
            return;

        Faker faker = new Faker();

        for (int i = 0; i < 100; i++) {
            Product product = new Product();
            product.setName(faker.commerce().productName());
            product.setProductType(ProductType.NORMAL);
            product.setRegularPrice(Double.valueOf(faker.commerce().price()));
            product.setSalePrice(product.getRegularPrice());
            product.setImageUrl(faker.internet().image());
            productRepository.save(product);
        }
    }
}
