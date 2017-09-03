/*
 * Marshalling class for the bot replies on Typetalk
 */
package jp.will.will1bot.controller.marshalling;

/**
 *
 * @author Will
 */
public class ReplyMarshall {
    private String message;
    private long replyTo;

    public ReplyMarshall() {
        
    }

    public ReplyMarshall(String message, long replyTo) {
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
