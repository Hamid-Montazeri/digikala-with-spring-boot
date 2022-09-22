package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.GenericMapper;
import ir.mapsa.digikala.base.GenericRepository;
import ir.mapsa.digikala.base.GenericServiceImpl;
import ir.mapsa.digikala.dto.AddressDTO;
import ir.mapsa.digikala.mapper.AddressMapper;
import ir.mapsa.digikala.model.Address;
import ir.mapsa.digikala.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl extends GenericServiceImpl<Address, AddressDTO, Long> implements IAddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    protected GenericRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    protected GenericMapper<Address, AddressDTO> getEntityMapper() {
        return addressMapper;
    }


}
