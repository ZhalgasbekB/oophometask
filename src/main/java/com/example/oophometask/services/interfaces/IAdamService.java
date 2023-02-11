package com.example.oophometask.services.interfaces;

import com.example.oophometask.entities.Adam;


public interface IAdamService {

    Adam signUpSave(Adam adam);

    Adam getAdamByEmail (String emaail);

    void deleteAdamById(int id);

    Adam createAdam (Adam adam);
}
