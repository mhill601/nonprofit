/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonprofit;

/**
 *
 * @author Mark
 */
public class CheckLinkType {
        public Boolean Run(String url, String baseurl){
        Boolean value = false;
     
            String regexValue1 = ".com";
            
            int lastIndex = baseurl.lastIndexOf( regexValue1 );
        
            int beginIndex = 0;
           
            String rootDomain = baseurl.substring(beginIndex, lastIndex);
            
            
            
           value = url.matches("(.*)" + rootDomain + "(.*)");
        
        
        return value;
    }
}
