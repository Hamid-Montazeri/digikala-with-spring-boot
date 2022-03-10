package ir.mapsa.digikala.repository;

import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.model.Address;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends GenericRepository<Address, Long> {

}
