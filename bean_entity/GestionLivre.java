package bean_entity;
import jakarta.ejb.Stateless;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.EntityManager;

@Stateless
public class GestionLivre implements IGestionLivre { // bean
    @PersistenceContext(unitName="monUnite")
    protected EntityManager em;
    Emprunteur emp;

    public void creerSession(int numemp){
        emp = em.find(Emprunteur.class, numemp);
    }

    public void nouveauLivre(String isbn, String titre) {
        LivreEmp l = new LivreEmp(isbn, titre);
        em.persist(l);

        System.out.println("Livre enregistré: " + l);
    }

    public void supprimerLivre(String isbn) {
        LivreEmp l = em.find(LivreEmp.class, isbn);

        int empnum = l.getEmprunteur();
        Emprunteur emp = em.find(Emprunteur.class, empnum);
        emp.rendreLivre();

        em.remove(l);
        System.out.println("Livre supprimé: " + l);
    }

    public void emprunterLivre(String isbn) {
        LivreEmp l = em.find(LivreEmp.class, isbn);

        l.setEmprunteur(emp.getNumemp());
        emp.emprunterLivre();
        em.merge(emp); // update emprunteur

        System.out.println("Livre emprunté: " + l);
    }

    public void rendreLivre(String isbn) {
        LivreEmp l = em.find(LivreEmp.class, isbn);

        l.setEmprunteur(0);
        emp.rendreLivre();
        em.merge(emp); // update emprunteur

        System.out.println("Livre rendu: " + l);
    }

    public void nouveauEmprunteur(int numemp, String nom) {
        Emprunteur emp = new Emprunteur(numemp, nom);
        em.persist(emp);

        System.out.println("Emprunteur enregistré: " + emp);
    }
}
