package za.co.shinysneakers.domain;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long addressId;

    protected String unitNumber;
    protected String complexName;
    protected String streetNumber;
    protected String streetName;
    protected String suburb;
    protected String city;
    protected String postalCode;

    // Getters
    public Long getAddressId() {
        return addressId;
    }

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getSuburb() {
        return suburb;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }
}
