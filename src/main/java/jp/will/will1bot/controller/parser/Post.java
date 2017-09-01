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
public class Post {
    private long id;
    private long topicdId;
    private String message;
    private Account account;

    public Post(){
        
    }
    
    public Post(long id, long topicdId, String message, Account account) {
        this.id = id;
        this.topicdId = topicdId;
        this.message = message;
        this.account = account;
    }
    
    public long getAccountId(){
        return this.account.getId();
    }
    
    public String getAccountName(){
        return this.account.getFullName().split(" ")[0];
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getTopicdId() {
        return topicdId;
    }

    public void setTopicdId(long topicdId) {
        this.topicdId = topicdId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
