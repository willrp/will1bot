/*
 * Parsing class for informations about UV from weather API
 */
package jp.will.will1bot.controller.parser;

/**
 *
 * @author Will
 */
public class UVParser {
    private float lat;
    private float lon;
    private float value;

    public UVParser() {
        
    }

    public UVParser(float lat, float lon, float value) {
        this.lat = lat;
        this.lon = lon;
        this.value = value;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "UVParser{" + "lat=" + lat + ", lon=" + lon + ", value=" + value + '}';
    }
}
