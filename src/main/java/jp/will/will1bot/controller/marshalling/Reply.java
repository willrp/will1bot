/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot.controller.marshalling;

/**
 *
 * @author Will
 */
public class Reply {
    private String message;
    private long replyTo;

    public Reply() {
        
    }

    public Reply(String message, long replyTo) {
        this.message = message;
        this.replyTo = replyTo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getReplyTo() {
        return replyTo;
    }

    public void setReplyTo(long replyTo) {
        this.replyTo = replyTo;
    }
    
}
