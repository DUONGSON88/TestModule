package manager;

import java.util.List;

public interface iManager<P> {
    void add(P p);
    boolean update(int id,P p);
    boolean delete(int id);
    List<P> findAll();
    List<P> searchByName(String name);
    List<P> searchByType(String type);
    P searchById(int id);
    int findIndexById(int id);
}
