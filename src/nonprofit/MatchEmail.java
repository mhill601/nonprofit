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
public class MatchEmail {
 
    public List<String> Run(String content){ 
    List<String> tempEmails = new ArrayList<String>();    
    String match = null;
   
   Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(content);
   
    while (m.find()) {
        tempEmails.add(m.group());
    }
    
    return tempEmails;
   }

}
