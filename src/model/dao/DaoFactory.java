package model.dao;

import model.DB;
import model.daiJDBC.VendedorDaoJDBC;

import java.sql.SQLException;

public class DaoFactory {


    // classe auxiliar que instancia objetos de acesso ao banco
    // emula injeção de dependencia sem mostrar a instanciação, somente interface

    public static vendedorDao createVendedorDAO()
    {
        return new VendedorDaoJDBC(DB.getConnection());
    }

}
