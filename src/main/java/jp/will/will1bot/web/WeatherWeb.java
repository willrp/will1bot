/*
 * Class responsible for fetching data from the weather API. Like a DAO, but
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
import jp.will.will1bot.controller.parser.UVParser;
import jp.will.will1bot.controller.parser.WeatherParser;
import jp.will.will1bot.model.Weather;

/**
 *
 * @author Will
 */
public class WeatherWeb {        
    private String appid;
    
    public WeatherWeb(String appid){
        this.appid = appid;
    }
    
    public Weather cast(int hour) throws ProcessingException{
        WeatherParser wparser = this.weather();
        UVParser uparser = this.uvindex();
        return new Weather(wparser.getName(), hour, wparser.getState(), wparser.getDescription(), wparser.getTemperature(), wparser.getPressure(), wparser.getHumidity(), wparser.getWindSpeed(), uparser.getValue());
    }
    
    private WeatherParser weather() throws ProcessingException{
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://api.openweathermap.org")
                                    .path("data/2.5/weather")
                                    .queryParam("id", "1863967")
                                    .queryParam("appid", this.appid);
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        return response.readEntity(WeatherParser.class);
    } 
    
    private UVParser uvindex() throws ProcessingException{
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("http://api.openweathermap.org")
                                    .path("data/2.5/uvi")
                                    .queryParam("appid", this.appid)
                                    .queryParam("lat", "-18.91")
                                    .queryParam("lon", "-48.27");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        return response.readEntity(UVParser.class);
    }
}