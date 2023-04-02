package ma.devoir.repository;

import ma.devoir.entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface AuteurRepo extends JpaRepository<Auteur, Integer> {
    Auteur findById(int id);
    Auteur findByCin(String cin);
   List<Auteur> findByDateN(Date date);
}
