/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonprofit;

import java.util.List;

/**
 *
 * @author Mark's PC
 */
public class NonProfit {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        
        
        //retreiveNonprofit np = new retreiveNonprofit();
        //String query = np.getSingle();
        //System.out.println(query);
        
        
        
        //Query against the Bing API to return the top results
        //collectURLS urls = new collectURLS();
        //List<String> urlList = urls.Run(query);
        
        
        
        //Print out all of the results.
        //for(int i =0; i < urlList.size(); i++)
        //{
        //    AlexaWebsites websiteList = new AlexaWebsites();
        //    Boolean result = websiteList.crossReference(urlList.get(i));
                 
            
            //pass to function
            
            //if zero delete from list
            
            //if one, keep it
        //    System.out.println(urlList.get(i));
        //}
        
        
        
        
        
        
        String testURL = "http://www.abacinc.net";
        
        //Parse out the email and phone number.
        Parser parser = new Parser();
        List<String> websiteInfo = parser.Run(testURL);
        
        
        //Print out all of the results.
        for (String websiteInfo1 : websiteInfo) {
            System.out.println("Contact: " + websiteInfo1);
        }
        
        ChooseTop top = new ChooseTop();
        
        SingleContactPair contactInfo = new SingleContactPair();
        
        contactInfo = top.Run(websiteInfo);
        
        System.out.println("Top Phone: " + contactInfo.getPhone());
        System.out.println("Top Email: " + contactInfo.getEmail());
//BuildSearchAccount account = new BuildSearchAccount();
        //account.Run();
        
  }
       
        
        
        
    }

