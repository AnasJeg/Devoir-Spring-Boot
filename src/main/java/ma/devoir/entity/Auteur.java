package ma.devoir.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Auteur extends Personne{
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Livre> livres;
}
