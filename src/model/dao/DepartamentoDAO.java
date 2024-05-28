package model.dao;

import model.entities.Departamento;

import java.util.List;

public interface DepartamentoDAO {

    void insert(Departamento dep);
    void update(Departamento dep);
    void deleteById(Departamento dep);
    Departamento findByid(Integer id);

    List<Departamento> findAll();
}
