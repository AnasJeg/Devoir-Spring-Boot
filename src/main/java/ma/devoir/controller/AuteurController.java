package ma.devoir.controller;

import ma.devoir.entity.Auteur;
import ma.devoir.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/auteur")
public class AuteurController {

    @Autowired
    private AuteurService auteurService;

    @GetMapping("/")
    public List<Auteur> findAll(){
        return auteurService.findAll();
    }
    @PostMapping("/save")
    public void save(@RequestBody Auteur a){
        auteurService.save(a);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id){
        auteurService.delete(auteurService.findById(id));
    }

    @PutMapping("/update")
    public void update(@RequestBody Auteur a){
        auteurService.update(a);
    }
    @GetMapping("/id")
    public Auteur findById(@RequestParam int id){
        return auteurService.findById(id);
    }

    @GetMapping("/date")
    public List<Auteur> findByDate(@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date date){
        return auteurService.findByDate(date);
    }

    @GetMapping("/cin")
    public Auteur findByCIN(@RequestParam String cin){
       return auteurService.findByCIN(cin);
    }
}
