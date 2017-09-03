/*
 * Parsing class for weather object in weather informations from API
 */
package jp.will.will1bot.controller.parser.weather;

/**
 *
 * @author Will
 */
public class Weather {
    private String main;
    private String description;

    Weather() {
    
    }

    Weather(String main, String description) {
        this.main = main;
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Weather{" + "main=" + main + ", description=" + description + '}';
    }
}
