package bean_entity;

import jakarta.ejb.Remote;

@Remote
public interface IGestionLivre {

    public void creerSession(int numemp);

    public void nouveauLivre(String isbn, String titre);
    public void supprimerLivre(String isbn);
    public void emprunterLivre(String isbn);
    public void rendreLivre(String isbn);

    public void nouveauEmprunteur(int numemp, String nom);
}
