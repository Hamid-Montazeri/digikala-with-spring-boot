package ir.mapsa.digikala.address.repository;

import ir.mapsa.digikala.address.entity.Address;
import ir.mapsa.digikala.base.GenericRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends GenericRepository<Address, Long> {

}
