/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot.web;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Will
 */
public class TranslateWeb {
    private String source = "en";
    private String target = "pt";
    private String format = "text";
    
    public TranslateWeb(){
        
    }
    
    public String translate(String phrase){                
        Client client = ClientBuilder.newClient();
        WebTarget webTarget = client.target("https://translate.googleapis.com")
                                    .path("translate_a/single")
                                    .queryParam("client", "gtx")
                                    .queryParam("sl", "en")
                                    .queryParam("tl", "pt")
                                    .queryParam("dt", "t")
                                    .queryParam("q", phrase);
        System.out.println(webTarget.getUri().toString());    
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.TEXT_PLAIN);
        Response response = invocationBuilder.get();
        System.out.println(response.getStatus());
        System.out.println(response.readEntity(String.class));
        return "";
    }
}