package ir.mapsa.digikala.address.controller;

import ir.mapsa.digikala.address.entity.Address;
import ir.mapsa.digikala.address.entity.AddressDTO;
import ir.mapsa.digikala.address.entity.AddressMapper;
import ir.mapsa.digikala.address.service.IAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    private final IAddressService addressService;
    private final AddressMapper addressMapper;


    @Autowired
    public AddressController(IAddressService addressService, AddressMapper addressMapper) {
        this.addressService = addressService;
        this.addressMapper = addressMapper;
    }

    @PostMapping("/save")
    public ResponseEntity<Address> save(@RequestBody AddressDTO addressDTO) {
        Address savedAddress = addressService.save(addressMapper.toEntity(addressDTO));
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }

    @PutMapping("/update")
    public ResponseEntity<Address> update(@RequestBody AddressDTO addressDTO) {
        Address updatedAddress = addressService.update(addressMapper.toEntity(addressDTO));
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedAddress);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> delete(@RequestBody AddressDTO addressDTO) {
        addressService.deleteById(addressDTO.getId());
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {
        Address address = addressService.getById(id);
        AddressDTO addressDTO = addressMapper.toDTO(address);
        return ResponseEntity.ok(addressDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<AddressDTO>> getAll() {
        List<Address> addresses = addressService.getAllAddresses();
        List<AddressDTO> addressDTOs = addressMapper.toDTOs(addresses);
        return ResponseEntity.ok(addressDTOs);
    }

}
