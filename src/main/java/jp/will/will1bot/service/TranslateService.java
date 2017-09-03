/*
 * Service class that manages the bot phrase translation functionality
 */
package jp.will.will1bot.service;

import javax.ws.rs.ProcessingException;
import jp.will.will1bot.web.TranslateWeb;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Will
 */
public class TranslateService {
    private String requesterName;
    private String args;
    
    TranslateService(String requesterName, String args) {
        this.requesterName = requesterName;
        this.args = args;
    }
    
    String process() throws ProcessingException, ParseException{
        if(this.args == null || this.args.equals("")){
            return this.requesterName + ", please input a phrase for translation.";
        }
        else{
            String translation = new TranslateWeb().translate(this.args);
            return this.requesterName + ": \"" + this.args + "\" means \"" + translation + "\" in Portuguese.";
        }        
    }       
}