/*
 * Parsing class for account object in message from Typetalk
 */
package jp.will.will1bot.controller.parser.message;

/**
 *
 * @author Will
 */
public class Account {
    private long id;
    private String name;
    private String fullName;

    Account(){
        
    }
    
    Account(long id, String name, String fullName) {
        this.id = id;
        this.name = name;
        this.fullName = fullName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
}
