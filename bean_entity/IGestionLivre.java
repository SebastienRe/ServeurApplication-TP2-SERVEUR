package bean_entity;

import jakarta.ejb.Remote;

@Remote
public interface IGestionLivre {

    public void nouveauLivre(String isbn, String titre);
    public void supprimerLivre(String isbn);
    public void emprunterLivre(String isbn, int numemp);
    public void rendreLivre(String isbn, int numemp);

    public void nouveauEmprunteur(int numemp, String nom);
}
