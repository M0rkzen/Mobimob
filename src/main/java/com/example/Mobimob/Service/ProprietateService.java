package com.example.Mobimob.Service;

import com.example.Mobimob.Entity.Proprietate;
import com.example.Mobimob.Repository.ProprietateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProprietateService {

    private ProprietateRepository proprietateRepository;

    @Autowired

    public ProprietateService(ProprietateRepository proprietateRepository) {
        this.proprietateRepository = proprietateRepository;
    }

    public Proprietate getImobilById(Long id){

        return proprietateRepository.getReferenceById(id);
    }

    public void addImobil(Proprietate proprietate) {

        proprietateRepository.saveAndFlush(proprietate);
    }

    public List<Proprietate> getProprietateByFilters(Map<String, String> params) {
        if(params.containsKey("locatie")) {
            return proprietateRepository.findProprietateByLocatie(params.get("locatie"));
        } else if (params.containsKey("pret")) {
            return proprietateRepository.findProprietateByPret(params.get("pret"));

        }
        return null;
    }


    public Proprietate updateProprietate(Long proprietateId, Proprietate updatedProprietate) {
        Optional<Proprietate> optionalProprietate = proprietateRepository.findById(proprietateId);
        if (optionalProprietate.isPresent()) {
            Proprietate existingProprietate = optionalProprietate.get();
            existingProprietate.setTipImobil(updatedProprietate.getTipImobil());
            existingProprietate.setPret(updatedProprietate.getPret());
            existingProprietate.setLocatie(updatedProprietate.getLocatie());
            existingProprietate.setPersoanaContact(updatedProprietate.getPersoanaContact());
            existingProprietate.setTelefon(updatedProprietate.getTelefon());
            existingProprietate.setDisponibil(updatedProprietate.isDisponibil());
            return proprietateRepository.save(existingProprietate);
        } else {
            return null;
        }
    }

    public void setProprietateDisponibila(Long proprietateId, boolean disponibil) {
        Optional<Proprietate> optionalProprietate = proprietateRepository.findById(proprietateId);
        if (optionalProprietate.isPresent()) {
            Proprietate proprietate = optionalProprietate.get();
            proprietate.setDisponibil(disponibil);
            proprietateRepository.saveAndFlush(proprietate);
        } else {
            // Tratarea cazului în care proprietatea nu a fost găsită
        }
    }

    public void deleteProprietateById(Long proprietateId) {
        proprietateRepository.deleteById(proprietateId);
    }
}
