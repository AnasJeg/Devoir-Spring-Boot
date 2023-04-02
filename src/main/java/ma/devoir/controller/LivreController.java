package ma.devoir.controller;

import ma.devoir.entity.Livre;
import ma.devoir.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/livre")
public class LivreController {

    @Autowired
    private LivreService livreService;

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

    @GetMapping("/id")
    public Livre findByID(@RequestParam int id){
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

    @GetMapping("/isbn")
    public Livre findByISBN(@RequestParam String isbn){
        return livreService.findByISBN(isbn);
    }

    @GetMapping("/dateD/{dd}/dateF/{df}")
    public List<Livre> findBetweenDates(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd")Date dd,
                                        @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") Date df){
        return livreService.findBetweenDates(dd,df);
    }
}
