/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot.controller.parser.message;

/**
 *
 * @author Will
 */
public class Topic {
    private long id;
    private String name;   

    Topic() {
        
    }

    Topic(long id, String name) {
        this.id = id;
        this.name = name;
    }    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   
}