package bean_entity;

import java.util.List;

import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceContextType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NonUniqueResultException;
import jakarta.persistence.Query;

@jakarta.ejb.Stateful
public class InfosLivres implements IInfosLivres{
    @PersistenceContext(unitName="monUnite", type = PersistenceContextType.EXTENDED)
    protected EntityManager em;

    public List<LivreEmp> listeLivreDispo() {
        return em.createNamedQuery("livresNonEmprunte",LivreEmp.class).getResultList(); 
    }

    public String titreLivre(String isbn) throws EntityNotFoundException, NonUniqueResultException {
        Query query = em.createQuery("SELECT l.titre FROM LivreEmp l WHERE l.isbn = :isbn");
        query.setParameter("isbn", isbn);
        return (String) query.getSingleResult();
            // – si le nombre de résultats est > 1, une exception NonUniqueResultException est levée
            // – si aucun résultat n’est trouvé, une exception EntityNotFoundException est levée
    }   
}
