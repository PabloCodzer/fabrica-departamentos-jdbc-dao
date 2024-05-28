package model.dao;
import model.entities.Vendedor;

import java.util.List;

public interface vendedorDao {
    void insert(Vendedor dep);
    void update(Vendedor dep);
    void deleteById(Vendedor dep);
    Vendedor findByid(Integer id);

    List<Vendedor> findAll();
}
