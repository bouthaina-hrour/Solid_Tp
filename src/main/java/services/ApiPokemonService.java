package services;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * The low level service gets data from api
 * it implements the abstraction
 */
public class ApiPokemonService implements PokemonService {
    @Override
    public Map<String,Object> getPokemonData(int id) {
        Map<String,Object> datas= new HashMap<String,Object>();
        String jsonResponse = "";

        JSONObject obj=new JSONObject();
        try {

            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpGet request = new HttpGet("https://pokeapi.co/api/v2/pokemon/"+id);
            request.addHeader("content-type", "application/json");
            HttpResponse result = httpClient.execute(request);
            jsonResponse = EntityUtils.toString(result.getEntity(), "UTF-8");

            JSONParser parser = new JSONParser();
            Object resultObject = parser.parse(jsonResponse);
            if (resultObject instanceof JSONObject) {
                /**
                 * gets data from api as JSON object
                 */
                obj =(JSONObject)resultObject;
                /**
                 * puts data from JSON object in a hash map
                 */
                Set keys=obj.keySet();
                Iterator<String> it=keys.iterator();
                while (it.hasNext()){
                    String key= it.next();
                    Object value=obj.get(key);
                    datas.put(key,value);

                }


            } else {
                System.err.println("Error, we expected a JSON Object from the API");
            }


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Could not parse the response given by the API as JSON");
            System.err.println("Response body is :");
            System.err.println(jsonResponse);
            e.printStackTrace();
        }
        /**
         * returns the hash map
         */
        return datas;
    }
    }

