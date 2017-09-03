/*
 * Model class that represents a complete weather entity
 */
package jp.will.will1bot.model;

/**
 *
 * @author Will
 */
public class Weather {
    private String name;
    private int hour;
    private String state;
    private String description;
    private float temperature;
    private float pressure;
    private int humidity;
    private float wind;
    private float uvindex;

    public Weather(String name, int hour, String state, String description, float temperature, float pressure, int humidity, float wind, float uvindex) {
        this.name = name;
        this.hour = hour;
        this.state = state;
        this.description = description;
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
        this.wind = wind;
        this.uvindex = uvindex;
    }

    public String weatherReport(){
        return "weather condition at " + this.name +  ": " + this.stateReport() + " - Temperature: " + this.temperatureReport() + " - Pressure: " + this.pressureReport() + " - Humidity: " + this.humidityReport() + " - Wind: " + this.windReport() + " - UV: " + this.uvReport();
    }
    
    private String stateReport(){
        return this.state + ", " + this.description;
    }
    
    private String temperatureReport(){
        return Math.round(this.temperature - 273.15) + " °C";
    }
    
    private String pressureReport(){
        return Math.round(this.pressure) + "hPa";
    }
    
    private String humidityReport(){
        return this.humidity + "%";
    }
    
    //Wind report according to Beaufort scale
    private String windReport(){        
        if(this.wind < 0.3){
            return "Calm (" + this.wind + "m/s)";
        }
        else if(this.wind >= 0.3 && this.wind < 1.6){
            return "Light air (" + this.wind + "m/s)";
        }
        else if(this.wind >= 1.6 && this.wind < 3.4){
            return "Light breeze (" + this.wind + "m/s)";
        }
        else if(this.wind >= 3.4 && this.wind < 5.5){
            return "Gentle breeze (" + this.wind + "m/s)";
        }
        else if(this.wind >= 5.5 && this.wind < 8.0){
            return "Moderate breeze (" + this.wind + "m/s)";
        }
        else if(this.wind >= 8.0 && this.wind < 10.8){
            return "Fresh breeze (" + this.wind + "m/s)";
        }
        else if(this.wind >= 10.8 && this.wind < 13.9){
            return "Strong breeze (" + this.wind + "m/s). Avoid using umbrella";
        }
        else if(this.wind >= 13.9 && this.wind < 17.2){
            return "Moderate gale (" + this.wind + "m/s). Be careful when walking";
        }
        else if(this.wind >= 17.2 && this.wind < 20.8){
            return "Gale (" + this.wind + "m/s). Better wait inside";
        }
        else if(this.wind >= 20.8 && this.wind < 24.5){
            return "Strong gale (" + this.wind + "m/s). ALERT: Don't go outside";
        }
        else if(this.wind >= 24.5 && this.wind < 28.5){
            return "Storm (" + this.wind + "m/s). ALERT: Don't go outside. Consider looking for shelter";
        }
        else if(this.wind >= 28.5 && this.wind < 32.7){
            return "Violent storm (" + this.wind + "m/s). ALERT: Look for precautions and shelter";
        }
        else{
            return "Hurricane force (" + this.wind + " m/s). ALERT: Look for shelter immediatelly";
        }
    }
    
    //International standard UV index report
    private String uvReport(){
        if(this.hour >= 10 && this.hour < 17){
            if(this.uvindex < 3.0){
                return "Low";
            }
            else if(this.uvindex >= 3.0 && this.wind < 6.0){
                return "Moderate. Seek shade when possible";
            }
            else if(this.uvindex >= 6.0 && this.wind < 8.0){
                return "High. Consider applying suncreen";
            }
            else if(this.uvindex >= 8.0 && this.wind < 11.0){
                return "Very high. Wear sun protective clothing and apply sunscreen";
            }
            else{
                return "Extreme. Avoid being outdoors";
            }
        }
        else{
            return "N/A";
        }
    }
}