package bean_entity;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface IInfosLivres {
    public List<LivreEmp> listeLivreDispo();
    public String titreLivre(String isbn);
}
