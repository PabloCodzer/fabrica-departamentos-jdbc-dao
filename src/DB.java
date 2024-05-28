import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection() throws SQLException {
        if( conn == null )
        {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("url");
                conn = DriverManager.getConnection(url, props);
            }
            catch (SQLException e)
            {
                throw new DbException(e.getMessage());
            }
        }
        return conn;
    }

    public static void closeConnection()
    {
        if(conn != null)
        {
            try{
                conn.close();
            }
            catch (SQLException e)
            {
                throw new DbException(e.getMessage());
            }
        }
    }

    private static Properties loadProperties(){
        try(FileInputStream fs = new FileInputStream("db.proprieties")){
            Properties props = new Properties();
            props.load(fs);
            return props;
        }
        catch (IOException e)
        {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeStatement(Statement st)
    {
        if(st != null)
        {
            try{
                st.close();
            }
            catch (SQLException e)
            {
                throw new DbException(e.getMessage());
            }
        }
    }

    public static void closeResult(ResultSet res)
    {
        if(res != null)
        {
            try{
                res.close();
            }
            catch (SQLException e)
            {
                throw new DbException(e.getMessage());
            }
        }
    }
}
