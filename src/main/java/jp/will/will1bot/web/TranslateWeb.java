/*
 * Class responsible for fetching data from the translator API. Like a DAO, but
 * for data from Internet
 */
package jp.will.will1bot.web;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Will
 */
public class TranslateWeb {
    private String source = "en";
    private String target = "pt";
    private String format = "text";
    
    public TranslateWeb(){
        
    }
    
    public String translate(String phrase) throws ProcessingException, ParseException{                
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("https://translate.googleapis.com")
                                    .path("translate_a/single")
                                    .queryParam("client", "gtx")
                                    .queryParam("sl", "en")
                                    .queryParam("tl", "pt")
                                    .queryParam("dt", "t")
                                    .queryParam("q", phrase);
        System.out.println(webTarget.getUri().toString());    
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        String translation = response.readEntity(String.class);
        //Had do use JSONParser since Moxy can't handle multidimensional arrays, currently bugged.
        JSONParser parser = new JSONParser();
        JSONArray json = (JSONArray) parser.parse(translation);
        JSONArray json1 = (JSONArray) json.toArray()[0];
        JSONArray json2 = (JSONArray) json1.toArray()[0];
        return (String) json2.toArray()[0];
    }
}