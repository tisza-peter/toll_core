package com.example.toll_core.listvignettaforvehicle.storage;

import java.util.List;

public interface VignettesStorage {
    public List<VignetteStorageDAO> findVignettesByRegistrationNumber(String registrationNumber);

}
