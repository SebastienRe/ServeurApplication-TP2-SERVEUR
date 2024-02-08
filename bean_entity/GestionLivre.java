package bean_entity;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionManagement;
import jakarta.ejb.TransactionAttribute;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

@Stateless
public class GestionLivre implements IGestionLivre { // bean
    @PersistenceContext(unitName="monUnite")
    protected EntityManager em;

    public void nouveauLivre(String isbn, String titre) {
        Livre l = new Livre(isbn, titre);
        em.persist(l);
        
        // Enregistrement du livre dans la base de données
        // ...

        System.out.println("Livre enregistré: " + l);
    }

    public void supprimerLivre(String isbn) {
        Livre l = em.find(Livre.class, isbn);
        if (l != null) {
            em.remove(l);
            System.out.println("Livre supprimé: " + l);
        }
    }

    public void emprunterLivre(String isbn) {
        Livre l = em.find(Livre.class, isbn);
        if (l != null) {
            if (l.getDispo() > 0) {
                l.setDispo(0);
                em.merge(l);
                System.out.println("Livre emprunté: " + l);
            } else {
                System.out.println("Livre non disponible: " + l);
            }
        }
    }

    public void rendreLivre(String isbn) {
        Livre l = em.find(Livre.class, isbn);
        if (l != null) {
            l.setDispo(1);
            em.merge(l);
            System.out.println("Livre rendu: " + l);
        }
    }
}
