package ir.mapsa.digikala.address.repository;

import ir.mapsa.digikala.address.entity.Address;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {

    @Override
    boolean existsById(Long id);



}
