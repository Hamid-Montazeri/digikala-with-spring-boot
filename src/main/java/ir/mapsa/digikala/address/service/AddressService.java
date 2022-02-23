package ir.mapsa.digikala.address.service;

import ir.mapsa.digikala.address.entity.Address;
import ir.mapsa.digikala.address.repository.AddressRepository;
import ir.mapsa.digikala.exception.ConflictException;
import ir.mapsa.digikala.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService implements IAddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address address) {
        if (addressRepository.existsById(address.getId())) {
            throw new ConflictException("The address with ID \"" + address.getId() + "\" already exists");
        }
        return addressRepository.save(address);
    }

    @Override
    public Address update(Address address) {
        Optional<Address> optionalAddress = addressRepository.findById(address.getId());

        if (optionalAddress.isEmpty()) {
            throw new NotFoundException("The requested \"Address\" not found");
        }

        Address savedAddress = optionalAddress.get();

        savedAddress.setState(address.getState());
        savedAddress.setCity(address.getCity());
        savedAddress.setMainStreet(address.getMainStreet());
        savedAddress.setAlley(address.getAlley());
        savedAddress.setNumberPlate(address.getNumberPlate());
        savedAddress.setApartmentNumber(address.getApartmentNumber());
        savedAddress.setPostalCode(address.getPostalCode());
        savedAddress.setLatitude(address.getLatitude());
        savedAddress.setLongitude(address.getLongitude());

        return addressRepository.save(savedAddress);
    }

    @Override
    public void deleteById(Long id) {
        addressRepository.deleteById(id);
    }

    @Override
    public Address getById(Long id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isEmpty()) {
            throw new NotFoundException("The requested \"Address\" with id \"" + id + "\" not found.");
        }

        return optionalAddress.get();
    }

    @Override
    @Cacheable(value = "address")
    public List<Address> getAllAddresses() {
        List<Address> addresses = (List<Address>) addressRepository.findAll();

        if (addresses.isEmpty()) {
            throw new NotFoundException("No address found.");
        }

        return addresses;
    }

}
