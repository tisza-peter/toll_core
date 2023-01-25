package com.example.toll_core.listvignettaforvehicle.entity;

import com.example.toll_core.listvignettaforvehicle.enums.MotorWayVignetteType;

import java.util.Date;

public class MotorwayVignetteEntity {
    private Date dateOfPurchase;
    private Date validFrom;
    private Date validTo;
    private String vehicleCategory;

    private MotorWayVignetteType motorWayVignetteType;
    private Float price;


    public Boolean isValid() {
        return false;
    }


    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public MotorWayVignetteType getMotorWayVignetteType() {
        return motorWayVignetteType;
    }

    public void setMotorWayVignetteType(MotorWayVignetteType motorWayVignetteType) {
        this.motorWayVignetteType = motorWayVignetteType;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}
