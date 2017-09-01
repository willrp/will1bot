/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import jp.will.will1bot.controller.marshalling.Reply;
import jp.will.will1bot.controller.parser.Message;

/**
 *
 * @author Will
 */

@Path("/")
public class Webhook {
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Reply processRequest(Message income){       
        return new Reply("Hello " + income.fromWhomName() + "! :smile:", income.fromWhomId());
    }
}
