package com.example.Mobimob.Controller;

import com.example.Mobimob.Entity.Proprietate;
import com.example.Mobimob.Service.ProprietateService;
import jakarta.websocket.OnClose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/imobile")
public class ProprietateController {

    private ProprietateService proprietateService;

    @Autowired
    public ProprietateController(ProprietateService proprietateService) {
        this.proprietateService = proprietateService;
    }
    @GetMapping("/{id}")
    public ResponseEntity<Object> getImobilById(@PathVariable Long id) {
        return new ResponseEntity<>(proprietateService.getImobilById(id), HttpStatus.OK);
    }
//    @GetMapping()
//    public ResponseEntity<Object> getLocatie(@RequestParam Map<String, String> params) {
//        return new ResponseEntity<>(proprietateService.getLocatieSiPret(params), HttpStatus.OK);
//    }

    @PostMapping()
    public ResponseEntity<Object> addImobil(@RequestBody Proprietate proprietate) {
        proprietateService.addImobil(proprietate);
        return new ResponseEntity<>("Proprietate adaugata cu succes.", HttpStatus.CREATED);
    }
}
