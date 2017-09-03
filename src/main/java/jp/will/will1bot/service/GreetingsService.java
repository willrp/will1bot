/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot.service;

/**
 *
 * @author Will
 */
public class GreetingsService {
    private final String requesterName;
    
    GreetingsService(String requesterName){
        this.requesterName = requesterName;
    }
    
    String process(){
        return "Hello " + this.requesterName + "! Hope you have a nice day :smile:";
    }   
}