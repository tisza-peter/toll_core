package com.example.toll_core.listvignettaforvehicle.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class VehicleWithVignettesResponseModel {
    private VehicleResponseModel vehicle;
    private List<VignetteResponseModel> vignettes;

    public JSONObject getJSONObject()
    {
        JSONObject result=new JSONObject();
        try {
            JSONObject vehicleObject=new JSONObject();
            vehicleObject.put("Model",vehicle.getModel());
            vehicleObject.put("VehicleCategory",vehicle.getVehicleCategory());
            vehicleObject.put("RegistrationNumber",vehicle.getRegistrationNumber());
            vehicleObject.put("Make",vehicle.getMake());
            vehicleObject.put("NumberOfSeats",vehicle.getNumberOfSeats());

            JSONArray ownersObject= new JSONArray();
            for (OwnerResponseModel owner:vehicle.getOwners()) {
                JSONObject ownerObject = new JSONObject();
                ownerObject.put("Name",owner.getName());
                ownerObject.put("Address",owner.getAddress());
                ownersObject.put(ownerObject);
            }

            JSONArray vignettesObject= new JSONArray();
            for (VignetteResponseModel vignette:vignettes) {
                JSONObject vignetteObject = new JSONObject();
                vignetteObject.put("VehicleCategoryOfVignette",vignette.getVehicleCategoryOfVignette());
                vignetteObject.put("Valid",vignette.getValid());
                vignetteObject.put("DateOfPurchase",vignette.getDateOfPurchase());
                vignetteObject.put("ValidTo",vignette.getValidTo());
                vignetteObject.put("ValidFrom",vignette.getValidFrom());
                vignettesObject.put(vignetteObject);
            }

            result.put("vehicle",vehicleObject);
            result.put("owners",ownersObject);
            result.put("vignettes",vignettesObject);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public VehicleResponseModel getVehicle() {
        return vehicle;
    }

    public void setVehicle(VehicleResponseModel vehicle) {
        this.vehicle = vehicle;
    }

    public List<VignetteResponseModel> getVignettes() {
        return vignettes;
    }

    public void setVignettes(List<VignetteResponseModel> vignettes) {
        this.vignettes = vignettes;
    }
}
