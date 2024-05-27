import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n Projeto Fabrica departamentos \n");


        Connection conexao = null;
        Statement stado = null;
        ResultSet res = null;
        
        try{
            conexao = DB.getConnection();
            stado = conexao.createStatement();
            res = stado.executeQuery("select * from alunos");
            while (res.next())
            {
                System.out.println(
                        "["+res.getRow()+"] -> "+
                                res.getInt("id") +" - "+
                                res.getString("nome") +" / "+
                                res.getString("sobrenome")  +" - "+
                                res.getString("email")  +" - "+
                                res.getDouble("peso")  );
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DB.closeResult(res);
            DB.closeStatement(stado);
            DB.closeConnection();
        }
    }
}