package model.daiJDBC;

import model.dao.DepartamentoDAO;
import model.dao.vendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class VendedorDaoJDBC implements vendedorDao {

    // esqueleto de implementação, a partir daqui.

    private Connection conn;

    public VendedorDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Vendedor dep) {

    }

    @Override
    public void update(Vendedor dep) {

    }

    @Override
    public void deleteById(Vendedor dep) {

    }

    @Override
    public Vendedor findByid(Integer id)
    {
        PreparedStatement stado = null;
        ResultSet resultSet = null;
        try{
            stado = conn.prepareStatement(
                    "select * from escola.alunos where id = ?"
            );

            stado.setInt(1,id);
            resultSet = stado.executeQuery();
            if(resultSet.next())
            {
                Integer idDB = resultSet.getInt("id");
                String  deppart = resultSet.getNString("nome");
                String  email = resultSet.getNString("email");
                Date  dates = resultSet.getDate("created_at");
                Double sall = resultSet.getDouble("peso");
                Departamento dp = new Departamento(idDB, deppart);
                Vendedor obj = new Vendedor(idDB,deppart, email, dates, sall, dp);
            }
            return null;
        }
        catch (SQLException e)
        {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Vendedor> findAll() {
        return null;
    }
}
