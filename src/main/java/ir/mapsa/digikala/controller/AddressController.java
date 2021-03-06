package ir.mapsa.digikala.controller;

import ir.mapsa.digikala.dto.AddressDTO;
import ir.mapsa.digikala.mapper.AddressMapper;
import ir.mapsa.digikala.model.Address;
import ir.mapsa.digikala.service.IAddressService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addresses")
@AllArgsConstructor
public class AddressController {

    private final IAddressService addressService;
    private final AddressMapper addressMapper;

    @PostMapping("/save")
    public ResponseEntity<Address> save(@RequestBody AddressDTO addressDTO) {
        Address savedAddress = addressService.save(addressDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedAddress);
    }

    @PutMapping("/update")
    public ResponseEntity<Address> update(@RequestBody AddressDTO addressDTO) {
        Address savedAddress = addressService.findById(addressDTO.getId()).orElseThrow();

        savedAddress.setState(addressDTO.getState());
        savedAddress.setCity(addressDTO.getCity());
        savedAddress.setMainStreet(addressDTO.getMainStreet());
        savedAddress.setAlley(addressDTO.getAlley());
        savedAddress.setNumberPlate(addressDTO.getNumberPlate());
        savedAddress.setApartmentNumber(addressDTO.getApartmentNumber());
        savedAddress.setPostalCode(addressDTO.getPostalCode());
        savedAddress.setLatitude(addressDTO.getLatitude());
        savedAddress.setLongitude(addressDTO.getLongitude());

        Address updatedAddress = addressService.save(addressMapper.toDto(savedAddress));

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(updatedAddress);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        addressService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> deleteAll() {
        addressService.deleteAll();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {
        Optional<Address> optionalAddress = addressService.findById(id);

        if (optionalAddress.isEmpty()) {
            throw new RuntimeException("The required \"Address\" not found");
        }

        Address savedAddress = optionalAddress.get();
        AddressDTO addressDTO = addressMapper.toDto(savedAddress);
        return ResponseEntity.ok(addressDTO);
    }

    @GetMapping("/")
    public ResponseEntity<List<AddressDTO>> getAll() {
        List<Address> addresses = (List<Address>) addressService.findAll();
        List<AddressDTO> addressDTOs = addressMapper.toDTOs(addresses);
        return ResponseEntity.ok(addressDTOs);
    }

}
