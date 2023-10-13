package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.dto.AddressDTO;
import ir.mapsa.digikala.mapper.AddressMapper;
import ir.mapsa.digikala.model.Address;
import ir.mapsa.digikala.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;
    private final AddressMapper addressMapper;

    @PostMapping
    public ResponseEntity<AddressDTO> save(@RequestBody AddressDTO addressDTO) {
        Address savedAddress = addressService.save(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(addressMapper.toDto(savedAddress));
    }

    @PutMapping
    public ResponseEntity<AddressDTO> update(@RequestBody AddressDTO addressDTO) {
        return ResponseEntity
                .status(HttpStatus.NO_CONTENT)
                .body(addressService.update(addressDTO, addressDTO.getId()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        addressService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAll() {
        addressService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {
        Address savedAddress = addressService.findById(id);
        return ResponseEntity.ok(addressMapper.toDto(savedAddress));
    }

    @GetMapping
    public ResponseEntity<List<AddressDTO>> getAll() {
        List<Address> addresses = (List<Address>) addressService.findAll();
        List<AddressDTO> addressDTOs = addressMapper.toDTOs(addresses);
        return ResponseEntity.ok(addressDTOs);
    }

}
