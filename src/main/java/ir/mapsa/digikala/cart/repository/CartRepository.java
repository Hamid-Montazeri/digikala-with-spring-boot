package ir.mapsa.digikala.cart.repository;

import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.cart.entity.Cart;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends GenericRepository<Cart, Long> {

}
