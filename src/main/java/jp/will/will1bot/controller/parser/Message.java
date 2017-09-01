/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot.controller.parser;

/**
 *
 * @author Will
 */
public class Message {
    private Topic topic;
    private Post post;
    private String directMessage;

    public Message(){
        
    }
    
    public Message(Topic topic, Post post, String directMessage) {
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

