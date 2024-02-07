package sr;
import jakarta.ejb.Stateless;

@Stateless
public class StatelessServer implements IStateless { // bean
    public String salut(String s) {
        return "Salut " + s;
    }
}