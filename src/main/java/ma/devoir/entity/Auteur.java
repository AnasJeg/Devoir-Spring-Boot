package ma.devoir.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Auteur extends Personne{
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="auteur_livres",
            joinColumns= @JoinColumn(name="auteurs_id"),
            inverseJoinColumns= @JoinColumn(name="livres_id"))
    private Collection<Livre> livres;
}
