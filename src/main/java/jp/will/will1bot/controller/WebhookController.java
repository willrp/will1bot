/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.ProcessingException;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import jp.will.will1bot.controller.marshalling.ReplyMarshall;
import jp.will.will1bot.controller.parser.MessageParser;
import jp.will.will1bot.service.RequestService;

/**
 *
 * @author Will
 */

@Path("/")
public class WebhookController {
    @Context
    private ServletContext context;
    
    //POST JSON /webhook
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public ReplyMarshall processRequest(MessageParser income){   
        try{            
            String configpath = context.getRealPath("/WEB-INF/will1bot.properties");
            Properties props = new Properties();
            props.load(new FileInputStream(new File(configpath)));
            
            RequestService rservice = new RequestService(props);
            return rservice.process(income);
        }  
        catch(IllegalArgumentException e){
            return new ReplyMarshall(income.fromWhomName() + ", " + e.getMessage(), income.fromWhomId());
        }
        catch(ProcessingException | IOException e){
            return new ReplyMarshall(income.fromWhomName() + ", the service is currently unavailable. Please try again later.", income.fromWhomId());
        }
    }
}

/*
            else if(e.getMessage().equals("args")){
                return new ReplyMarshall(income.fromWhomName() + ", command argument missing.", income.fromWhomId());
            }
            else{
                return new ReplyMarshall(income.fromWhomName() + ", invalid command " + e.getMessage(), income.fromWhomId());
            }
*/
