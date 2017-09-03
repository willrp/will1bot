/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.will.will1bot.service;

import jp.will.will1bot.web.TranslateWeb;

/**
 *
 * @author Will
 */
public class TranslateService {
    private final String requesterName;
    private final String args;
    
    TranslateService(String requesterName, String args) {
        this.requesterName = requesterName;
        this.args = args;
    }
    
    String process(){
        new TranslateWeb().translate("let's go to japan");
        return this.requesterName + ": \"" + args + "\" means \"vamos ao Japão.\"";
    }       
}