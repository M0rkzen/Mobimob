package com.example.Mobimob.Repository;

import com.example.Mobimob.Entity.Proprietate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface ProprietateRepository extends JpaRepository<Proprietate, Long> {

    //List<Proprietate> findImobilLocatieSiPret(String locatie, String pret);
//    List<Proprietate> findTipImobil(String tipImobil);
}
