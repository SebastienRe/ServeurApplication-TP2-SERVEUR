package sr;
import jakarta.ejb.Remote;

@Remote
public interface IStatefull {
    public String salut(String s);
    public String re_salut();
}
