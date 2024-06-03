package ir.mapsa.digikala.service;

import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.base.BaseRepository;
import ir.mapsa.digikala.base.BaseServiceImpl;
import ir.mapsa.digikala.dto.AddressDTO;
import ir.mapsa.digikala.mapper.AddressMapper;
import ir.mapsa.digikala.model.Address;
import ir.mapsa.digikala.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressServiceImpl extends BaseServiceImpl<Address, AddressDTO, Long> implements AddressService {

    private final AddressRepository addressRepository;
    private final AddressMapper addressMapper;

    @Override
    protected BaseRepository<Address, Long> getRepository() {
        return addressRepository;
    }

    @Override
    protected BaseMapper<Address, AddressDTO> getEntityMapper() {
        return addressMapper;
    }


}
