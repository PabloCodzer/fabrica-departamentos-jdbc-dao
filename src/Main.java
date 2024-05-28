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
        Departamento dep = new Departamento(1, "Livros");

        Vendedor vendedor = new Vendedor(21, "Bob", "bob@gmail.com", new Date(), 4000.0, dep);

        System.out.println(vendedor);
        System.out.println(dep);
    }
}