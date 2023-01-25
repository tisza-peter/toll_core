package com.example.toll_core.listvignettaforvehicle.storage;

import com.example.toll_core.listvignettaforvehicle.entity.MotorwayVignetteEntity;

import java.util.Date;

public class VignetteStorageDAO {
    private MotorwayVignetteEntity vignette;
    private Date lastSyncDateTime;


    public MotorwayVignetteEntity getVignette() {
        return vignette;
    }

    public void setVignette(MotorwayVignetteEntity vignette) {
        this.vignette = vignette;
    }

    public Date getLastSyncDateTime() {
        return lastSyncDateTime;
    }

    public void setLastSyncDateTime(Date lastSyncDateTime) {
        this.lastSyncDateTime = lastSyncDateTime;
    }
}
