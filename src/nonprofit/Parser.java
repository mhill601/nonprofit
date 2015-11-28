/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonprofit;

import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static jdk.nashorn.internal.objects.Global.print;
import static jdk.nashorn.tools.ShellFunctions.input;
import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author Mark's PC
 */


public class Parser {
    
    public List<String> Run(String url){
        

    
    
    
    String content = getHTML(url);
    List<String> tempPhoneNumbers = new ArrayList<String>();
    List<String> tempEmails = new ArrayList<String>();
//-----------------------------------------------------------------
    try{
        //Get html from string
        Document doc = Jsoup.parse(content, url);
        
        //Get html from url
        //Document doc = Jsoup.connect(url).get();
        
        Elements links = doc.select("a[href]");
        //Elements media = doc.select("[src]");
        //Elements imports = doc.select("link[href]");
        
        List<String> urlList = new ArrayList<String>();
        //List<String> phoneNumbers = new ArrayList<String>();
        //List<String> emails = new ArrayList<String>();
        
        
        
        for (Element link : links) { 
            urlList.add(link.attr("abs:href"));
            System.out.println(link.attr("href"));
        }
        
        for (String urlList1 : urlList) {
            //Check to see if link is external or internal. If internal, strip phone & e-mail.
            Boolean isInternal = checkLinkType(urlList1, url);
            if (isInternal) {
                System.out.println(urlList1);
                
                //Get the HTML of the page.
                String newContent = getHTML(urlList1);
                System.out.println("url:" + urlList1);
                //Get the phone numbers.
                tempPhoneNumbers.addAll(matchPhoneNumber(newContent));
                //Iterate through phone numbers and store them into master array list.
                for (String tempPhoneNumber : tempPhoneNumbers) {
                    //System.out.println(tempPhoneNumber);
                }
                //Get the e-mails
                tempEmails.addAll(matchEmail(newContent));
                //Iterate emails and store them into master array list.
                for(int k =0; k < tempEmails.size(); k++)
                {
                    //System.out.println(tempEmails.get(k));
                }
            }
            else{
                //System.out.println("external");
            }
        }
        
        
        
        
        

    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }
        


       

//-------------------------------------------------------------------
  
    

        

    
    
    
    
    
    
    
    
    ArrayList<String> nonprofitInfo = new ArrayList<String>();
    nonprofitInfo.addAll(tempPhoneNumbers);
    nonprofitInfo.addAll(tempEmails);
    
    return nonprofitInfo;   
    
    }
    
    public Boolean checkLinkType(String url, String baseurl){
        //baseurl is the root url we started with, and "url" is one of the links on the baseurl page
        Boolean value = false;
     
            String regexValue1 = ".com";
            
            //Search for the baseurl in the url. If matched, this is an internal url.
            //If it doesn't match it might still be internal because it could be relative.
            //Search for http or www if you don't find anything, it's an internal relative link.
            //Check for anchor # symbol, and flag as external if found (we don't want anchors).
            
            Boolean criteria1 = false;
            Boolean criteria2 = false;        
            
            
            
            Pattern r1 = Pattern.compile(baseurl);
            
            Matcher m = r1.matcher(url);
            if (m.find( )) {
               criteria1 = true;
            } else {
               System.out.println("NO MATCH");
            }
            
            
            if(!criteria1){         
                    String pattern = "http|https|www";

                    // Create a Pattern object
                    Pattern r2 = Pattern.compile(pattern);

                    // Now create matcher object.
                    Matcher m2 = r2.matcher(url);
                    if (m2.find( )) {
                       criteria2 = true;
                    } else {
                       System.out.println("NO MATCH");
                    }
            }
            
            
            
            
            if(criteria1 || !criteria1 && !criteria2){
                value = true;
            }
           /* 
            int lastIndex = baseurl.lastIndexOf( regexValue1 );
        
            int beginIndex = 0;
  
            if(lastIndex > 0){
            String rootDomain = baseurl.substring(beginIndex, lastIndex);
            value = url.matches("(.*)" + rootDomain + "(.*)");
            }
        */
                
        return value;
    }
    
    
    
    public String getHTML(String url){
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
    
    
    
    public List<String> matchPhoneNumber(String content){
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
    
    
    
    
   public List<String> matchEmail(String content){ 
    List<String> tempEmails = new ArrayList<String>();    
    String match = null;
   
   Matcher m = Pattern.compile("[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+").matcher(content);
   
    while (m.find()) {
        tempEmails.add(m.group());
    }
    
    return tempEmails;
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
