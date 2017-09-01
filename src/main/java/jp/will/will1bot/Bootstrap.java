/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot;

import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author Will
 */

@ApplicationPath("webhook")
public class Bootstrap extends ResourceConfig{
    public Bootstrap(){
        packages("jp.will.will1bot.controller");
    }
}
