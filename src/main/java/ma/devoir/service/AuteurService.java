package ma.devoir.service;

import ma.devoir.Dao.Dao;
import ma.devoir.entity.Auteur;
import ma.devoir.repository.AuteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AuteurService implements Dao<Auteur> {

    @Autowired
    private AuteurRepo auteurRepo;

    @Override
    public Auteur save(Auteur o) {
        return auteurRepo.save(o);
    }

    @Override
    public Auteur findById(int id) {
        return auteurRepo.findById(id);
    }

    @Override
    public List<Auteur> findAll() {
        return auteurRepo.findAll();
    }

    @Override
    public void delete(Auteur o) {
            auteurRepo.delete(o);
    }

    @Override
    public void update(Auteur o) {
            auteurRepo.save(o);
    }

    public Auteur findByCIN(String cin){
        return auteurRepo.findByCin(cin);
    }
    public List<Auteur> findByDate(Date date){
        return auteurRepo.findByDateN(date);
    }

}
