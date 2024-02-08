package bean_entity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Livre {

    @Id
    // @Column(name = "isbn", nullable = false)
    private String isbn;

    // @Column(name = "titre")
    private String titre;

    // @Column(name = "dispo", nullable = false)
    private int dispo;

    // Constructeur par défaut requis par JPA
    public Livre() {}

    // Constructeur avec isbn et titre
    public Livre(String isbn, String titre) {
        this.isbn = isbn;
        this.titre = titre;
        this.dispo = 1;
    }

    // getDispo
    public int getDispo() {
        return dispo;
    }
    // setDispo
    public void setDispo(int dispo) {
        this.dispo = dispo;
    }

    public String toString() {
        return "Livre: " + isbn + " - " + titre + " - " + dispo;
    }

    
}
