/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonprofit;

import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mark
 */


public class ChooseTop {
    
    public SingleContactPair Run(List<String> info){
        SingleContactPair top = new SingleContactPair();
        
        String topPhone = "";
        String topEmail = "";
        
        int previousCountPhone = 0;
        int previousCountEmail = 0;
        
        int currentCount;
        
        
        for (String websiteInfo1 : info) {
            
            currentCount = Collections.frequency(info, websiteInfo1);
            
            Boolean phone = isPhone(websiteInfo1);
            
            if(phone)
            {
                if(currentCount > previousCountPhone){
                    topPhone = websiteInfo1;
                }
            }
            else{
                if(currentCount > previousCountEmail){
                    topEmail = websiteInfo1;
                }
            }
            
            
            
            System.out.println("Contact: " + websiteInfo1);
        }
        
        top.setEmail(topEmail);
        top.setPhone(topPhone);
            
        
        return top;
    }
    
    public Boolean isPhone(String text){
        Boolean isPhone = false;
        
        
        
        Pattern pattern = Pattern.compile("\\d{3}[\\-\\.\\s]\\d{3}[\\-\\.\\s]\\d{4}");
        Matcher matcher = pattern.matcher(text);
        if (matcher.find()) {
            isPhone = true;
            return isPhone;
        }
        else{
            return isPhone;
        }
        
        
    }
    
    
    
}
