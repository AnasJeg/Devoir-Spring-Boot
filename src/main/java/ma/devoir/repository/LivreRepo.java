package ma.devoir.repository;

import ma.devoir.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivreRepo extends JpaRepository<Livre,Integer> {
    Livre findById(int id);

    Livre findLivreByIsbn(String isbn);
}
