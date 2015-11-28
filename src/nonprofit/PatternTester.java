/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonprofit;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Mark
 */
public class PatternTester {
    
      public static void main(String[] args) throws Exception {
     
      
      
      String url = "http://www.abacinc.net/contacts.php";
      
      String newContent = getHTML(url);
      

      List<String> contactInfo = matchPhoneNumber(newContent);
      
      for(String info : contactInfo){
          System.out.println("start");
          System.out.println(info);
      }
          
          
      }
    
        public static String getHTML(String url){
        String content = null;

        URLConnection connection = null;
        try {
          connection =  new URL(url).openConnection();
          Scanner scanner = new Scanner(connection.getInputStream());
          scanner.useDelimiter("\\Z");
          content = scanner.next();
          return content;
        }catch ( Exception ex ) {
            ex.printStackTrace();
            return content;
        }
    }
    
    
    
    public static List<String> matchPhoneNumber(String content){
    //Match phone number
    List<String> tempPhoneNumbers = new ArrayList<String>();    
    String match = null;    
        
    Pattern pattern = Pattern.compile("\\d{3}[\\-\\.\\s]\\d{3}[\\-\\.\\s]\\d{4}");
        Matcher matcher = pattern.matcher(content);
        if (matcher.find()) {
            tempPhoneNumbers.add(matcher.group(0));
            //match = matcher.group(0);
            
            //System.out.println(matcher.group(0));
        }
        else{
            return tempPhoneNumbers;
        }
        
        return tempPhoneNumbers;
    }
    
    
    
    
   public static List<String> matchEmail(String content){ 
    List<String> tempEmails = new ArrayList<String>();    
    String match = null;
   
   Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(content);
   
    while (m.find()) {
        tempEmails.add(m.group());
    }
    
    return tempEmails;
   }
    
    
    
    
    
}
