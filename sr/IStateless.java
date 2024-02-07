package sr;
import jakarta.ejb.Remote;

@Remote
public interface IStateless {
    public String salut(String s);
}