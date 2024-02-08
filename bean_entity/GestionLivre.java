package bean_entity;
import jakarta.ejb.Stateless;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

@Stateless
public class GestionLivre implements IGestionLivre { // bean
    @PersistenceContext(unitName="monUnite")
    protected EntityManager em;

    public void nouveauLivre(String isbn, String titre) {
        LivreEmp l = new LivreEmp(isbn, titre);

        em.persist(l);
        System.out.println("Livre enregistré: " + l);
    }

    public void supprimerLivre(String isbn) {
        LivreEmp l = em.find(LivreEmp.class, isbn);
        if (l != null) {
            Emprunteur emp = l.getEmprunteur();
            emp.setNblivresEmp(l.getEmprunteur().getNblivresEmp() - 1);

            em.merge(emp);
            em.remove(l);
            System.out.println("Livre supprimé: " + l);
        }
    }

    public void emprunterLivre(String isbn, int numemp) {
        LivreEmp l = em.find(LivreEmp.class, isbn);
        if (l != null) {
            if (l.getEmprunteur() == null) {
                Emprunteur emp = em.find(Emprunteur.class, numemp);
                l.setEmprunteur(emp);
                emp.setNblivresEmp(emp.getNblivresEmp() + 1);

                em.merge(l);
                em.merge(emp);
                System.out.println("Livre emprunté: " + l);
            } else {
                System.out.println("Livre non disponible: " + l);
            }
        }
    }

    public void rendreLivre(String isbn, int numemp) {
        LivreEmp l = em.find(LivreEmp.class, isbn);
        if (l != null) {
            if (l.getEmprunteur() != null) {
                Emprunteur emp = em.find(Emprunteur.class, numemp);
                l.setEmprunteur(null);
                emp.setNblivresEmp(emp.getNblivresEmp() - 1);

                em.merge(l);
                em.merge(emp);
                System.out.println("Livre rendu: " + l);
            } else {
                System.out.println("Livre déjà rendu: " + l);
            }
        }
    }

    public void nouveauEmprunteur(int numemp, String nom) {
        Emprunteur emp = new Emprunteur(numemp, nom);
        em.persist(emp);

        System.out.println("Emprunteur enregistré: " + emp);
    }
}
