package model;

import javax.xml.transform.Result;
import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {

    private static Connection conn = null;

    public static Connection getConnection(){
        if( conn == null )
        {
            try {
                Properties props = loadProperties();
                String url = props.getProperty("url");
                conn = DriverManager.getConnection(url, props);
            }
            catch (SQLException e)
            {
                throw new RuntimeException(e);
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
                throw new RuntimeException(e);
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
            throw new RuntimeException(e);
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
                throw new RuntimeException(e);
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
                throw new RuntimeException(e);
            }
        }
    }
}
