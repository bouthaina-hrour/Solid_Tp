package services;

import org.json.simple.JSONObject;

import java.sql.*;

public class DbPokemonService implements PokemonService{


    @Override
    public Object getPokemon(int id) {
        Connection conn = null;
        ResultSet rs=null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:\\Users\\HP\\Desktop\\SOLID_TP\\sujet_TP\\ressources\\pokemondatabase.sqlite";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");

            PreparedStatement stmt  = conn.prepareStatement("SELECT name, description,height,weight FROM pokemons WHERE id = ?");
            stmt.setInt(1, id);
             rs  = stmt.executeQuery();
            rs.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }
}
