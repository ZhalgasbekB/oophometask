package com.example.oophometask.services;

import com.example.oophometask.entities.Adam;
import com.example.oophometask.repositories.AdamRepository;
import com.example.oophometask.services.interfaces.IAdamService;
import org.springframework.stereotype.Service;

@Service
public class AdamService implements IAdamService {


    private  final AdamRepository adamRepository;

    public AdamService (AdamRepository adamRepository){
        this.adamRepository = adamRepository;
    }
    @Override
    public Adam signUpSave(Adam adam) {
        return adamRepository.save(adam);
    }

    @Override
    public Adam getAdamByEmail(String email) {
         return  adamRepository.findByEmail(email);
    }

    @Override
    public void deleteAdamById(int id) {
        adamRepository.deleteById(id);
    }

    @Override
    public Adam createAdam(Adam adam) {
        return adamRepository.save(adam);
    }
}
