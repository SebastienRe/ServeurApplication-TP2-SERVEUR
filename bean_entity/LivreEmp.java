package bean_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.persistence.ManyToOne;

@Entity
@Table(name = "livre_emp")
public class LivreEmp {

    @Id
    private String isbn;
    private String titre;

    @ManyToOne
    @JoinColumn(name = "numemp")
    private Emprunteur numemp;

    public LivreEmp() {
    }

    public LivreEmp(String isbn, String titre) {
        this.titre = titre;
        this.isbn = isbn;
        this.numemp = null;
    }

    public String toString() {
        return "Livre: " + isbn + " - " + titre + " - Emprunteur: {" + numemp + "}";
    }

    public Emprunteur getEmprunteur() {
        return numemp;
    }

    public void setEmprunteur(Emprunteur numemp) {
        this.numemp = numemp;
    }

    
}