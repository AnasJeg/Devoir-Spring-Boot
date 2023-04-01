package ma.devoir.controller;

import ma.devoir.entity.Auteur;
import ma.devoir.entity.Livre;
import ma.devoir.service.AuteurService;
import ma.devoir.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("api/livre")
public class LivreController {

    @Autowired
    private LivreService livreService;
    @Autowired
    private AuteurService auteurService;

    @GetMapping("/")
    public List<Livre> findAll(){
       return livreService.findAll();
    }
    @PostMapping("/save")
    public void save(@RequestBody Livre l){
        livreService.save(l);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        livreService.delete(livreService.findById(id));
    }
    @PutMapping("/update")
    public void update(@RequestBody Livre l){
        livreService.update(l);
    }

    @GetMapping("/{id}")
    public Livre findID(@PathVariable int id){
        return livreService.findById(id);
    }

    @PostMapping("/affect/livre/{idL}/auteur/{idA}")
    public void affectLivreToAuteur(@PathVariable int idL,@PathVariable int idA){
            livreService.affectLivreToAuteur(idL,idA);
    }

    @GetMapping("/auteur/{id}")
    public Collection<Livre> findAllByAuteur(@PathVariable int id){
       return livreService.findAllByAuteur(id);
    }
}
