/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot.controller.parser.message;

/**
 *
 * @author Will
 */
public class Post {
    private long id;
    private long topicdId;
    private String message;
    private Account account;
    private String createdAt;

    Post(){
        
    }
    
    Post(long id, long topicdId, String message, Account account, String createdAt) {
        this.id = id;
        this.topicdId = topicdId;
        this.message = message;
        this.account = account;
        this.createdAt = createdAt;
    }
    
    public long getAccountId(){
        return this.account.getId();
    }
    
    public String getAccountName(){
        return this.account.getFullName().split("\\s", 2)[0];
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

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
}
