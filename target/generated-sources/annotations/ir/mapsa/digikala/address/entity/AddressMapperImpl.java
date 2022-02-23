package ir.mapsa.digikala.address.entity;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-02-24T01:20:10+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toEntity(AddressDTO addressDTO) {
        if ( addressDTO == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( addressDTO.getId() );
        address.setState( addressDTO.getState() );
        address.setCity( addressDTO.getCity() );
        address.setMainStreet( addressDTO.getMainStreet() );
        address.setAlley( addressDTO.getAlley() );
        address.setNumberPlate( addressDTO.getNumberPlate() );
        address.setApartmentNumber( addressDTO.getApartmentNumber() );
        address.setPostalCode( addressDTO.getPostalCode() );
        address.setLatitude( addressDTO.getLatitude() );
        address.setLongitude( addressDTO.getLongitude() );

        return address;
    }

    @Override
    public AddressDTO toDTO(Address address) {
        if ( address == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( address.getId() );
        addressDTO.setState( address.getState() );
        addressDTO.setCity( address.getCity() );
        addressDTO.setMainStreet( address.getMainStreet() );
        addressDTO.setAlley( address.getAlley() );
        addressDTO.setNumberPlate( address.getNumberPlate() );
        addressDTO.setApartmentNumber( address.getApartmentNumber() );
        addressDTO.setPostalCode( address.getPostalCode() );
        addressDTO.setLatitude( address.getLatitude() );
        addressDTO.setLongitude( address.getLongitude() );

        return addressDTO;
    }

    @Override
    public List<Address> toEntities(List<AddressDTO> addressDTOs) {
        if ( addressDTOs == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( addressDTOs.size() );
        for ( AddressDTO addressDTO : addressDTOs ) {
            list.add( toEntity( addressDTO ) );
        }

        return list;
    }

    @Override
    public List<AddressDTO> toDTOs(List<Address> addresses) {
        if ( addresses == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( addresses.size() );
        for ( Address address : addresses ) {
            list.add( toDTO( address ) );
        }

        return list;
    }
}
