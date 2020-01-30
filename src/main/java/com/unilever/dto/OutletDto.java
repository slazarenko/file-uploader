package com.unilever.dto;

import com.opencsv.bean.CsvBindByName;

public class OutletDto {
    @CsvBindByName
    private long id;
    @CsvBindByName
    private String lastName;
    @CsvBindByName
    private String location;
    @CsvBindByName
    private String outletName;
    @CsvBindByName
    private String outletType;

    public OutletDto() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOutletName() {
        return outletName;
    }

    public void setOutletName(String outletName) {
        this.outletName = outletName;
    }

    public String getOutletType() {
        return outletType;
    }

    public void setOutletType(String outletType) {
        this.outletType = outletType;
    }
}
