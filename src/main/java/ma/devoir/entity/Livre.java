package ma.devoir.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isbn;
    private String titre;
    private Date dateEdition;

    @ManyToMany(mappedBy = "livres", fetch = FetchType.EAGER)
    private Collection<Auteur> auteurs;
}
