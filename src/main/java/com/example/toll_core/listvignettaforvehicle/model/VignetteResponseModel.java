package com.example.toll_core.listvignettaforvehicle.model;

import com.example.toll_core.listvignettaforvehicle.entity.MotorwayVignetteEntity;

import java.util.Date;

public class VignetteResponseModel {

   private Boolean valid;
   private Date validFrom;
   private Date validTo;
   private String vehicleCategoryOfVignette;
   private Date dateOfPurchase;

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
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

    public String getVehicleCategoryOfVignette() {
        return vehicleCategoryOfVignette;
    }

    public void setVehicleCategoryOfVignette(String vehicleCategoryOfVignette) {
        this.vehicleCategoryOfVignette = vehicleCategoryOfVignette;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public void setByEntity(MotorwayVignetteEntity vignetteEntity) {
        this.dateOfPurchase=vignetteEntity.getDateOfPurchase();
        this.valid=vignetteEntity.isValid();
        this.validFrom=vignetteEntity.getValidFrom();
        this.validTo=vignetteEntity.getValidTo();
        this.vehicleCategoryOfVignette=vignetteEntity.getVehicleCategory();
    }
}
