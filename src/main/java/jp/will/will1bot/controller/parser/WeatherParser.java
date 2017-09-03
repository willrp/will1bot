/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot.controller.parser;

import jp.will.will1bot.controller.parser.weather.Weather;
import jp.will.will1bot.controller.parser.weather.Wind;
import jp.will.will1bot.controller.parser.weather.Conditions;

/**
 *
 * @author Will
 */
public class WeatherParser {
    private Weather weather;
    private Conditions main;
    private Wind wind;
    private String name;
    private long dt;

    public WeatherParser() {
        
    }

    public WeatherParser(Weather weather, Conditions main, Wind wind, String name) {
        this.weather = weather;
        this.main = main;
        this.wind = wind;
        this.name = name;
    }

    public String getState(){
        return this.weather.getMain();
    }
    
    public String getDescription(){
        return this.weather.getDescription();
    }
    
    public float getTemperature(){
        return this.main.getTemp();
    }
    
    public float getPressure(){
        return this.main.getPressure();
    }
    
    public int getHumidity(){
        return this.main.getHumidity();
    }
    
    public float getWindSpeed(){
        return this.wind.getSpeed();
    }
    
    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Conditions getMain() {
        return main;
    }

    public void setMain(Conditions main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }
}