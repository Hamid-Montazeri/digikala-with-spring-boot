package ir.mapsa.digikala.mapper;

import ir.mapsa.digikala.dto.AddressDTO;
import ir.mapsa.digikala.model.Address;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-10T20:45:32+0330",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
)
@Component
public class AddressMapperImpl implements AddressMapper {

    @Override
    public Address toEntity(AddressDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Address address = new Address();

        address.setId( dto.getId() );
        address.setState( dto.getState() );
        address.setCity( dto.getCity() );
        address.setMainStreet( dto.getMainStreet() );
        address.setAlley( dto.getAlley() );
        address.setNumberPlate( dto.getNumberPlate() );
        address.setApartmentNumber( dto.getApartmentNumber() );
        address.setPostalCode( dto.getPostalCode() );
        address.setLatitude( dto.getLatitude() );
        address.setLongitude( dto.getLongitude() );

        return address;
    }

    @Override
    public AddressDTO toDto(Address entity) {
        if ( entity == null ) {
            return null;
        }

        AddressDTO addressDTO = new AddressDTO();

        addressDTO.setId( entity.getId() );
        addressDTO.setState( entity.getState() );
        addressDTO.setCity( entity.getCity() );
        addressDTO.setMainStreet( entity.getMainStreet() );
        addressDTO.setAlley( entity.getAlley() );
        addressDTO.setNumberPlate( entity.getNumberPlate() );
        addressDTO.setApartmentNumber( entity.getApartmentNumber() );
        addressDTO.setPostalCode( entity.getPostalCode() );
        addressDTO.setLatitude( entity.getLatitude() );
        addressDTO.setLongitude( entity.getLongitude() );

        return addressDTO;
    }

    @Override
    public List<Address> toEntities(List<AddressDTO> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<Address> list = new ArrayList<Address>( dtos.size() );
        for ( AddressDTO addressDTO : dtos ) {
            list.add( toEntity( addressDTO ) );
        }

        return list;
    }

    @Override
    public List<AddressDTO> toDTOs(List<Address> entities) {
        if ( entities == null ) {
            return null;
        }

        List<AddressDTO> list = new ArrayList<AddressDTO>( entities.size() );
        for ( Address address : entities ) {
            list.add( toDto( address ) );
        }

        return list;
    }

    @Override
    public void partialUpdate(Address entity, AddressDTO dto) {
        if ( dto == null ) {
            return;
        }

        if ( dto.getId() != null ) {
            entity.setId( dto.getId() );
        }
        if ( dto.getState() != null ) {
            entity.setState( dto.getState() );
        }
        if ( dto.getCity() != null ) {
            entity.setCity( dto.getCity() );
        }
        if ( dto.getMainStreet() != null ) {
            entity.setMainStreet( dto.getMainStreet() );
        }
        if ( dto.getAlley() != null ) {
            entity.setAlley( dto.getAlley() );
        }
        if ( dto.getNumberPlate() != null ) {
            entity.setNumberPlate( dto.getNumberPlate() );
        }
        if ( dto.getApartmentNumber() != null ) {
            entity.setApartmentNumber( dto.getApartmentNumber() );
        }
        if ( dto.getPostalCode() != null ) {
            entity.setPostalCode( dto.getPostalCode() );
        }
        if ( dto.getLatitude() != null ) {
            entity.setLatitude( dto.getLatitude() );
        }
        if ( dto.getLongitude() != null ) {
            entity.setLongitude( dto.getLongitude() );
        }
    }
}
