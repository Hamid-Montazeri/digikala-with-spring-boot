package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.base.BaseController;
import ir.mapsa.digikala.base.BaseMapper;
import ir.mapsa.digikala.base.BaseService;
import ir.mapsa.digikala.dto.AddressDTO;
import ir.mapsa.digikala.mapper.AddressMapper;
import ir.mapsa.digikala.model.Address;
import ir.mapsa.digikala.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController extends BaseController<Address, AddressDTO, Long> {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @Override
    protected BaseService<Address, AddressDTO, Long> getBaseService() {
        return addressService;
    }

    @Override
    protected BaseMapper<Address, AddressDTO> getBaseMapper() {
        return addressMapper;
    }
}
