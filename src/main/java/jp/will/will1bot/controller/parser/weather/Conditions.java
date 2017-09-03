/*
 * Parsing class for main object in weather informations from API
 */
package jp.will.will1bot.controller.parser.weather;

/**
 *
 * @author Will
 */
public class Conditions {
    private float temperature;
    private float pressure;
    private int humidity;

    Conditions() {
        
    }

    Conditions(float temperature, float pressure, int humidity) {
        this.temperature = temperature;
        this.pressure = pressure;
        this.humidity = humidity;
    }

    public float getTemp() {
        return temperature;
    }

    public void setTemp(float temperature) {
        this.temperature = temperature;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    @Override
    public String toString() {
        return "Conditions{" + "temperature=" + temperature + ", pressure=" + pressure + ", humidity=" + humidity + '}';
    }
}
