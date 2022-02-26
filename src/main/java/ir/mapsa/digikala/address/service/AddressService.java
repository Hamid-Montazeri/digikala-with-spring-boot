package ir.mapsa.digikala.address.service;

import ir.mapsa.digikala.address.entity.Address;
import ir.mapsa.digikala.address.entity.AddressDTO;
import ir.mapsa.digikala.address.entity.AddressMapper;
import ir.mapsa.digikala.address.repository.AddressRepository;
import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService extends GenericServiceImpl<Address, AddressDTO, Long> implements IAddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Autowired
    public AddressService(AddressRepository addressRepository, AddressMapper addressMapper) {
        this.addressRepository = addressRepository;
        this.addressMapper = addressMapper;
    }

    @Override
    protected GenericRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    protected GenericMapper<Address, AddressDTO> getEntityMapper() {
        return addressMapper;
    }


}
