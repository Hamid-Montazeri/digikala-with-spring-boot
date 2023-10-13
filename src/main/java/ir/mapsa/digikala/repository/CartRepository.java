package ir.mapsa.digikala.repository;

import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.model.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends GenericRepository<Cart, Long> {

}
