package bean_entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Emprunteur {

    @Id
    private int numemp;
    private String nom;
    private int nblivresemp;

    public Emprunteur() {
    }

    public Emprunteur(int numemp, String nom) {
        this.numemp = numemp;
        this.nom = nom;
        this.nblivresemp = 0;
    }

    public String toString() {
        return "num : " + numemp + " - " + nom + " - Nombre de livres empruntés: " + nblivresemp;
    }

    public int getNblivresEmp() {
        return nblivresemp;
    }

    public void setNblivresEmp(int i) {
        nblivresemp = i;
    }
}
