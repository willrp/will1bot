/*
 * Parsing class for messages received from TypeTalk
 */
package jp.will.will1bot.controller.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import jp.will.will1bot.controller.parser.message.Topic;
import jp.will.will1bot.controller.parser.message.Post;

/**
 *
 * @author Will
 */
public class MessageParser {
    private Topic topic;
    private Post post;
    private String directMessage;

    public MessageParser(){
        
    }
    
    public MessageParser(Topic topic, Post post, String directMessage) {
        this.topic = topic;
        this.post = post;
        this.directMessage = directMessage;
    }
    
    public long fromWhomId(){
        return this.post.getAccountId();
    }
    
    public String fromWhomName(){
        return this.post.getAccountName();
    }
    
    public int getHour(){
        String createdAt = this.post.getCreatedAt();
        Pattern regex = Pattern.compile("T[0-9]+:");
        Matcher m = regex.matcher(createdAt);
        m.find();
        return Integer.parseInt(m.group().substring(1, 3));
    }
    
    public String getMessage(){
        return this.post.getMessage();
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDirectMessage() {
        return directMessage;
    }

    public void setDirectMessage(String directMessage) {
        this.directMessage = directMessage;
    }
}

