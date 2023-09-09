package com.example.Mobimob.Controller;


import com.example.Mobimob.Entity.Proprietate;
import com.example.Mobimob.Service.ProprietateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/imobile")
public class ProprietateController {

    private ProprietateService proprietateService;

    @Autowired
    public ProprietateController(ProprietateService proprietateService) {
        this.proprietateService = proprietateService;
    }
    @PostMapping()
    public ResponseEntity<Object> addImobil(@RequestBody Proprietate proprietate) {
        proprietateService.addImobil(proprietate);
        return new ResponseEntity<>("Proprietate adaugata cu succes.", HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getImobilById(@PathVariable Long id) {
        return new ResponseEntity<>(proprietateService.getImobilById(id), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<Object> getProprietateByFilters(@RequestParam Map<String, String> params) {
        if (params.isEmpty()) {
            return new ResponseEntity<>("Nu a fost găsit niciun imobil care să îndeplinească criteriile de căutare.", HttpStatus.NOT_FOUND);
        } else {
            List<Proprietate> proprietati = proprietateService.getProprietateByFilters(params);
            if (proprietati.isEmpty()) {
                return new ResponseEntity<>("Nu am găsit nicio proprietate care să corespundă filtrelor furnizate.", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(proprietati, HttpStatus.OK);
            }
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateProprietate(@PathVariable Long id, @RequestBody Proprietate updatedProprietate) {
        Proprietate proprietate = proprietateService.updateProprietate(id, updatedProprietate);
        if (proprietate != null) {
            return ResponseEntity.ok(proprietate);
        } else {
            return new ResponseEntity<>("Proprietatea nu a fost gasita", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProprietate(@PathVariable Long id) {
        proprietateService.deleteProprietateById(id);
        return new ResponseEntity<>("Proprietate eliminat cu succes!", HttpStatus.OK);
    }



}
