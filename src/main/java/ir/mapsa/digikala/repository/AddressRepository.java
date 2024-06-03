package ir.mapsa.digikala.repository;

import ir.mapsa.digikala.base.BaseRepository;
import ir.mapsa.digikala.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends BaseRepository<Address, Long> {

}
