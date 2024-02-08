package bean_session;
import jakarta.ejb.Stateful;

@Stateful
public class StatefullServer implements IStatefull {
    private String nom;

    public String salut(String s) {
        nom = s;
        return "Salut " + s;
    }

    public String re_salut() {
        return "Bonjour " + nom + " !";
    }
}
