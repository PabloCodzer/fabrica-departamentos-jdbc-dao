import model.dao.DaoFactory;
import model.dao.vendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n Projeto Fabrica departamentos \n");
        vendedorDao vdd = DaoFactory.createVendedorDAO();

        Vendedor vd = vdd.findByid(2);

        System.out.println(vd);
    }
}