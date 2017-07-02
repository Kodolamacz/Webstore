package com.packt.webstore.domain;

import java.io.Serializable;

/**
 * Created by Blazej on 27.06.2017.
 */
public class Address implements Serializable {

     private static final long serialVersionUID = -530086768384258062L;
     private String doorNo;
     private String streetName;
     private String areaNema;
     private String state;
     private String country;
     private String zipCode;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (!doorNo.equals(address.doorNo)) return false;
        if (!streetName.equals(address.streetName)) return false;
        if (!areaNema.equals(address.areaNema)) return false;
        if (!state.equals(address.state)) return false;
        if (!country.equals(address.country)) return false;
        return zipCode.equals(address.zipCode);
    }

    @Override
    public int hashCode() {
        int result = doorNo.hashCode();
        result = 31 * result + streetName.hashCode();
        result = 31 * result + areaNema.hashCode();
        result = 31 * result + state.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + zipCode.hashCode();
        return result;
    }

    public String getDoorNo() {

        return doorNo;
    }

    public void setDoorNo(String doorNo) {
        this.doorNo = doorNo;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getAreaNema() {
        return areaNema;
    }

    public void setAreaNema(String areaNema) {
        this.areaNema = areaNema;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }
}
