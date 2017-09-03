/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot.controller.parser.weather;

/**
 *
 * @author Will
 */
public class Wind {
    private float speed;

    Wind() {
        
    }

    Wind(float speed) {
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Wind{" + "speed=" + speed + '}';
    }
}
