package ma.devoir.service;

import ma.devoir.Dao.Dao;
import ma.devoir.entity.Auteur;
import ma.devoir.entity.Livre;
import ma.devoir.repository.AuteurRepo;
import ma.devoir.repository.LivreRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

@Service
public class LivreService implements Dao<Livre> {
    @Autowired
    private LivreRepo livreRepo;
    @Autowired
    private AuteurRepo auteurRepo;

    @Override
    public Livre save(Livre o) {
        return livreRepo.save(o);
    }

    @Override
    public Livre findById(int id) {
        return livreRepo.findById(id);
    }

    @Override
    public List<Livre> findAll() {
        return livreRepo.findAll();
    }

    @Override
    public void delete(Livre o) {
            livreRepo.delete(o);
    }

    @Override
    public void update(Livre o) {
            livreRepo.save(o);
    }

    public Livre findByISBN(String isbn){
        return livreRepo.findByIsbn(isbn);
    }
    public Collection<Livre> findAllByAuteur(int id){
        return auteurRepo.findAll().stream().filter(auteur -> auteur.getId()==id).findFirst()
                .orElse(null)
                .getLivres();
    }
    public void affectLivreToAuteur(int idL,int idA){
        Livre l=livreRepo.findById(idL);
        Auteur a=auteurRepo.findById(idA);
        a.getLivres().add(l);
        auteurRepo.save(a);
    }
    public List<Livre> findBetweenDates(Date d1,Date d2){
        return livreRepo.findByDateEditionBetween(d1,d2);
    }
}
