/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonprofit;

import java.util.ArrayList;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author Mark
 */
public class BuildSearchAccount {
    
    String url = "http://larsonheatingandac.com/";
    String phoneNumber = "sds";
    String email = "dse";
    
    
    GetHTML html = new GetHTML();
    String content = html.Run(url);
    
    public void Run(){
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
        
        //List<String> tempPhoneNumbers = new ArrayList<String>();
        //List<String> tempEmails = new ArrayList<String>();
        
        for (Element link : links) { 
            urlList.add(link.attr("abs:href"));
            //System.out.println(link.attr("href"));
        }
        
        
        
        //Remove duplicates & outbound links
        //CleanURLs cleaner = new CleanURLs();
        //urlList = cleaner.Run(urlList, url);

        //Iterate through list
        //for(int i =0; i < urlList.size(); i++)
        //{
        //System.out.println(urlList.get(i));
        //}
        
        
        CommonWords words = new CommonWords();
        words.Run(url);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //for(int i =0; i < urlList.size(); i++)
        //{
            //CheckLinkType checkLink = new CheckLinkType();
            //Boolean isInternal = checkLink.Run(urlList.get(i), url);
            
            //Boolean isInternal = checkLinkType(urlList.get(i), url);
            
                        //if(isInternal){
                            
                        //System.out.println(urlList.get(i));

                        //Get the HTML of the page.
                        //GetHTML html = new GetHTML();
                        //String newContent = html.Run(urlList.get(i));

                        //String newContent = getHTML(urlList.get(i));

                        //Get the phone numbers.
                        //MatchPhone phone = new MatchPhone();
                        //tempPhoneNumbers = phone.Run(newContent);


                        //Iterate through phone numbers and store them into master array list.
                        //for(int j =0; j < tempPhoneNumbers.size(); j++)
                        //    {
                        //        System.out.println(tempPhoneNumbers.get(j));
                        //    }

                        //Get the e-mails
                        //MatchEmail email = new MatchEmail();
                        //tempEmails = email.Run(newContent);

                        //Iterate emails and store them into master array list.
                        //for(int k =0; k < tempEmails.size(); k++)
                        //    {
                        //        System.out.println(tempEmails.get(k));
                        //    }
                        //}
                    
                        //else{
                        //    urlList.remove(i);
                        //}

                        
        

        //}

        
        

    }
    catch (Exception e){
        System.out.println(e.getMessage());
    }
    
    }
    
}
