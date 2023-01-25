package com.example.toll_core.listvignettaforvehicle;


import com.example.toll_core.listvignettaforvehicle.api.ListOfVehicleWithVignettesInteractor;
import com.example.toll_core.listvignettaforvehicle.api.VehicleWithVignettesResponsePresenter;
import com.example.toll_core.listvignettaforvehicle.model.*;
import com.example.toll_core.listvignettaforvehicle.entity.MotorwayVignetteEntity;
import com.example.toll_core.listvignettaforvehicle.storage.VignetteStorageDAO;
import com.example.toll_core.listvignettaforvehicle.storage.VignettesStorage;
import com.example.vehicle_core.Interactor_Interface;
import com.example.vehicle_core.UI_Presenter_Interface;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListOfVehicleWithVignettes implements ListOfVehicleWithVignettesInteractor,UI_Presenter_Interface {
    private VehicleWithVignettesResponsePresenter myUIPresenter = null;
    private VignettesStorage myStore = null;
    private Interactor_Interface myVehicleCoreInteractor = null;

    public VehicleResponseModel myVehicleResponseModel=null;

    public void setUIPresenter(VehicleWithVignettesResponsePresenter uiPresenter)
    {
        myUIPresenter = uiPresenter;
    }

    public void SetStore(VignettesStorage store)
    {
        myStore = store;
    }

    public void SetVehicleCoreInteractor(Interactor_Interface interactor)
    {
        myVehicleCoreInteractor = interactor;
    }

    @Override
    public void DisplayOneVehicle(JSONObject vehicleResponseModelJSON) {
        myVehicleResponseModel=new VehicleResponseModel();
        myVehicleResponseModel.setByJson(vehicleResponseModelJSON);
    }

    @Override
    public void DisplaySaveStatus(JSONObject jsonObject) {

    }

    @Override
    public void listOfVehicleWithVignettes(String requestDTO) {
        vehicleValidate(requestDTO);

        VehicleWithVignettesRequestModel tollRequestModel = vehicleParse(requestDTO);
        String registrationNumber = tollRequestModel.getRegistrationNumber();
        VehicleRequestModel vehicleRequestModel = new VehicleRequestModel();
        vehicleRequestModel.setRegistrationNumber(registrationNumber);
        myVehicleCoreInteractor.get(vehicleRequestModel.getJson());

        VehicleWithVignettesResponseModel responseModel = new VehicleWithVignettesResponseModel();
        List<VignetteStorageDAO> vignetteDAOs = myStore.findVignettesByRegistrationNumber(registrationNumber);

        List<MotorwayVignetteEntity> VignetteEntities = new ArrayList<>();
        for (VignetteStorageDAO vignetteDAO:vignetteDAOs) {
            VignetteEntities.add(vignetteDAO.getVignette());
        }

        List<VignetteResponseModel> VignetteResponseModels= new ArrayList<>();
        for (MotorwayVignetteEntity vignetteEntity:VignetteEntities) {
            VignetteResponseModel vignetteResponseModel= new VignetteResponseModel();
            vignetteResponseModel.setByEntity(vignetteEntity);
            VignetteResponseModels.add(vignetteResponseModel);
        }
        responseModel.setVehicle(myVehicleResponseModel);
        responseModel.setVignettes(VignetteResponseModels);
        myUIPresenter.DisplayOneVehicleWithVignettes(responseModel.getJSONObject().toString());

    }

    private void vehicleValidate(String requestDTO) {
        VehicleWithVignettesRequestModel requestModel = vehicleParse(requestDTO);
    }

    private VehicleWithVignettesRequestModel vehicleParse(String requestDTO) {
        VehicleWithVignettesRequestModel result=new VehicleWithVignettesRequestModel();
        result.setByJson(requestDTO);
        return result;
    }

}