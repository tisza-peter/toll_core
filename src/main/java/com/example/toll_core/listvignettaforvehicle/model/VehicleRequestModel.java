package com.example.toll_core.listvignettaforvehicle.model;

import org.json.JSONException;
import org.json.JSONObject;

public class VehicleRequestModel {

    private String registrationNumber;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public JSONObject getJson()  {
        JSONObject json= new JSONObject();
        try {
            json.put("registrationNumber",registrationNumber);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return json;
    }


    public void setByJson(JSONObject json) {
        try {
            this.registrationNumber=json.getString("registrationNumber");
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }
}
