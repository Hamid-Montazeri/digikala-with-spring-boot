package ir.mapsa.digikala.repository;

import ir.mapsa.digikala.base.BaseRepository;
import ir.mapsa.digikala.model.Cart;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends BaseRepository<Cart, Long> {

}
