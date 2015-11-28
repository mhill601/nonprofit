/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonprofit;

import java.util.List;

/**
 *
 * @author Mark
 */
public class MultipleContactPair {
    List<String> phones;
    List<String> emails;
    
    public void setPhones(List<String> text){
        phones = text;
    }
    
    public void setEmails(List<String> text){
        emails = text;
    }
    
    public List<String> getPhones(){
        return phones;
    }
    
    public List<String> getEmails(){
        return emails;
    }
    
}
