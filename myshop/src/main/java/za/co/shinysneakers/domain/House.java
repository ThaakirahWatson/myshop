package za.co.shinysneakers.domain;

import jakarta.persistence.Entity;

@Entity
public class House extends Address {

    private double erfSize;

    protected House() {} // JPA requires default constructor

    private House(Builder builder) {
        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.suburb = builder.suburb;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
        this.erfSize = builder.erfSize;
    }

    public double getErfSize() {
        return erfSize;
    }

    public static class Builder {
        private String unitNumber;
        private String complexName;
        private String streetNumber;
        private String streetName;
        private String suburb;
        private String city;
        private String postalCode;
        private double erfSize;

        public Builder unitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder complexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public Builder streetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder streetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder suburb(String suburb) {
            this.suburb = suburb;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public Builder postalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder erfSize(double erfSize) {
            this.erfSize = erfSize;
            return this;
        }

        public House build() {
            return new House(this);
        }
    }
}
