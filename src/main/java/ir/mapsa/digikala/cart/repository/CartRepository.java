package ir.mapsa.digikala.cart.repository;

import ir.mapsa.digikala.cart.entity.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends PagingAndSortingRepository<Cart, Long> {

    @Override
    boolean existsById(Long id);

}
