package com.example.toll_core.listvignettaforvehicle.model;

import com.example.toll_core.listvignettaforvehicle.enums.VehicleType;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class VehicleResponseModel {
    private String registrationNumber;
    private VehicleType vehicleCategory;
    private String make;
    private String model;
    private Integer numberOfSeats;

    private List<OwnerResponseModel> owners;
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleType getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(VehicleType vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public List<OwnerResponseModel> getOwners() {
        return owners;
    }

    public void setOwners(List<OwnerResponseModel> owners) {
        this.owners = owners;
    }

    public void setByJson(JSONObject vehicleResponseModelJSON) {
        System.out.println(vehicleResponseModelJSON.toString());
        try {

            this.model= (String) vehicleResponseModelJSON.get("model");
            this.make= (String) vehicleResponseModelJSON.get("make");
            this.registrationNumber= (String) vehicleResponseModelJSON.get("registrationNumber");
            this.owners=new ArrayList<>();
            JSONArray ownersObject = (JSONArray) vehicleResponseModelJSON.get("owners");
            for (int i = 0; i < ownersObject.length(); i++) {
                JSONObject ownerObject = (JSONObject) ownersObject.get(i);

                OwnerResponseModel owner=new OwnerResponseModel();
                owner.setName((String) ownerObject.get("name"));
                owner.setAddress((String) ownerObject.get("address"));
                this.owners.add(owner);
            }
            this.vehicleCategory= VehicleType.valueOf((String) vehicleResponseModelJSON.get("vehicleType")) ;
            this.numberOfSeats= (Integer) vehicleResponseModelJSON.get("numberOfSeats");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }
}
