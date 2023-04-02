package ma.devoir.repository;

import ma.devoir.entity.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface LivreRepo extends JpaRepository<Livre,Integer> {
    Livre findById(int id);
    Livre findByIsbn(String isbn);
    List<Livre> findByDateEditionBetween(Date dateD,Date dateF);

    @Query("select l from Livre l where l.dateEdition between :d and :f")
    List<Livre> findLivresByDateEditionBetween(@Param("d") Date d,@Param("f") Date f);
}
