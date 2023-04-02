package ma.devoir.repository;

import ma.devoir.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface LivreRepo extends JpaRepository<Livre,Integer> {
    Livre findById(int id);
    Livre findByIsbn(String isbn);
    List<Livre> findByDateEditionBetween(Date dateD,Date dateF);
}
