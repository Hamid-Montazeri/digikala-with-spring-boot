package ir.mapsa.digikala.address.service;

import ir.mapsa.digikala.address.entity.Address;

import java.util.List;

public interface IAddressService {

    Address save(Address address);

    Address update(Address address);

    void deleteById(Long id);

    Address getById(Long id);

    List<Address> getAllAddresses();

}
