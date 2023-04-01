package ma.devoir.repository;

import ma.devoir.entity.Auteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuteurRepo extends JpaRepository<Auteur, Integer> {
    Auteur findById(int id);
    Auteur findAuteurByCin(String cin);
}
