package com.example.Mobimob.Repository;

import com.example.Mobimob.Entity.Proprietate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProprietateRepository extends JpaRepository<Proprietate, Long> {

    List<Proprietate> findProprietateByLocatie(String locatie);
    List<Proprietate> findProprietateByPret(String pret);
}
