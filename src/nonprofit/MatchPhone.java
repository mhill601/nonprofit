/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonprofit;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mark
 */
public class MatchPhone {
    public List<String> Run(String content){
    //Match phone number
    List<String> tempPhoneNumbers = new ArrayList<String>();    
    String match = null;    
        //\\d{3}.\\d{3}.\\d{4}
    String initialPattern = "\\d{3}[\\-\\.\\s]\\d{3}[\\-\\.\\s]\\d{4}";
    Pattern pattern = Pattern.compile(initialPattern);
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            tempPhoneNumbers.add(matcher.group(0));
            //match = matcher.group(0);
            
            System.out.println("THIS MATCHED: " + matcher.group(0));
        }
        else{
            return tempPhoneNumbers;
        }
        
        return tempPhoneNumbers;
    }
    
}
