package services;



import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 * low level service gets data from database
 * it implements the interface
 */
public class DbPokemonService implements PokemonService{

    String dbfile;

    public DbPokemonService(String dbfile) {
        this.dbfile = dbfile;
    }

    @Override
    public Map<String,Object> getPokemonData(int id) {
        Map<String,Object> datas =new HashMap<String,Object>();
        Connection conn = null;
        ResultSet rs=null;
        try {
            /**
             * db parameters
             */
            String url = "jdbc:sqlite:"+dbfile;
            /**
             * create a connection to the database
             */
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt  = conn.prepareStatement("SELECT name, description,height,weight FROM pokemons WHERE id = ?");
            stmt.setInt(1, id);
             rs  = stmt.executeQuery();
            /**
             * gets data into a ResultSet object
             */
            rs.next();
            /**
             * puts data into a hash map
             */
            datas.put("name",rs.getString("name"));
            datas.put("description",rs.getString("description"));
            datas.put("height",rs.getInt("height"));
            datas.put("weight",rs.getInt("weight"));

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        /**
         * returns the hash map
         */
        return datas;
    }
}
