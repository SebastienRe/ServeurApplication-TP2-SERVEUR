package bean_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livre_emp")
public class LivreEmp {

    @Id
    private String isbn;
    private String titre;
    private int empruntepar;

    public LivreEmp() {
    }

    public LivreEmp(String isbn, String titre) {
        this.titre = titre;
        this.isbn = isbn;
        this.empruntepar = 0; // pas emprunté
    }

    public String toString() {
        return "Livre: " + isbn + " - " + titre + " - Emprunteur: {" + empruntepar + "}";
    }

    public int getEmprunteur() {
        return empruntepar;
    }

    public void setEmprunteur(int numemp) {
        this.empruntepar = numemp;
    }

    
}