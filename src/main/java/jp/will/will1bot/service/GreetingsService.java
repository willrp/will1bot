/*
 * Service class that manages the bot greetings functionality
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