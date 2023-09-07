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
    public ResponseEntity<?> addImobil(@RequestBody Proprietate proprietate) {
        if (proprietate.getTipImobil() == null) {
            return new ResponseEntity<>("Specificati tipul de imobil", HttpStatus.BAD_REQUEST);
        } else {
            proprietateRepository.saveAndFlush(proprietate);
            return new ResponseEntity<>("Imobil adaugat cu succes", HttpStatus.CREATED);
        }
    }
//    public List<Proprietate> getLocatieSiPret(Map<String, String> params) {
//        if(params.containsKey("locatie") && params.containsKey("pret")) {
//            return proprietateRepository.findImobilLocatieSiPret(params.get("locatie"), params.get("pret"));
//        }
//        return null;
//    }
}
