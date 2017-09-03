/*
 * Service class that manages the bot weather condition report functionality
 */
package jp.will.will1bot.service;

import java.util.Properties;
import javax.ws.rs.ProcessingException;
import jp.will.will1bot.model.Weather;
import jp.will.will1bot.web.WeatherWeb;

/**
 *
 * @author Will
 */
public class WeatherService {
    private String requesterName;
    private int hour;
    private Properties props;
    
    WeatherService(String requesterName, int hour, Properties props) {
        this.requesterName = requesterName;
        this.hour = hour;
        this.props = props;
    }
    
    String process() throws ProcessingException{
        Weather weather = new WeatherWeb(props.getProperty("weatherappkey")).cast(this.hour);
        return this.requesterName + ", " + weather.weatherReport() + ".";
    }
}