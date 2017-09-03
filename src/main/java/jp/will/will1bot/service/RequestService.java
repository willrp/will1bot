/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot.service;

import java.util.Properties;
import javax.ws.rs.ProcessingException;
import jp.will.will1bot.controller.marshalling.ReplyMarshall;
import jp.will.will1bot.controller.parser.MessageParser;

/**
 *
 * @author Will
 */
public class RequestService {
    private String command;
    private String args;
    private long requesterId;
    private String requesterName;
    private int hour;
    private Properties props;
    
    public RequestService(Properties props){
        this.props = props;
    }
    
    private void init(String request) throws IllegalArgumentException{
        String[] tokens = request.split("\\s", 3);
        if(tokens.length <  2){
            throw new IllegalArgumentException("please input a command.");
        }
        else{
            this.command = tokens[1];
            if(tokens.length == 3){
                this.args = tokens[2];
            }
            else{
                this.args = null;
            }
        }
    }
    
    public ReplyMarshall process(MessageParser income) throws IllegalArgumentException, ProcessingException{
        this.init(income.getMessage());
        this.requesterId = income.fromWhomId();
        this.requesterName = income.fromWhomName();
        this.hour = income.getHour();
        
        System.out.println(this);
        
        switch(this.command.toLowerCase()){
            case "konnichiwa":
            case "hi":
            case "hello":
                GreetingsService gservice = new GreetingsService(this.requesterName);
                return new ReplyMarshall(gservice.process(), this.requesterId);
            case "weather":
                WeatherService wservice = new WeatherService(this.requesterName, this.hour, this.props);
                return new ReplyMarshall(wservice.process(), this.requesterId);
            case "translate":
                TranslateService tservice = new TranslateService(this.requesterName, this.args);
                return new ReplyMarshall(tservice.process(), this.requesterId);
            default:
                return new ReplyMarshall("Sorry " + this.requesterName + ", couldn't understand command " + this.command + ".",this.requesterId);
        }
    }

    @Override
    public String toString() {
        return "RequestService{" + "command=" + command + ", args=" + args + ", requesterId=" + requesterId + ", requesterName=" + requesterName + '}';
    }
}