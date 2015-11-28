/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonprofit;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author Mark
 */
public class CleanURLs {
    public List<String> Run(List<String> urlList, String rootDomain){ 
        
        
/*        
        for(int i =0; i < urlList.size(); i++)
        {
            //Check to see if link is internal or external
            CheckLinkType checkLink = new CheckLinkType();
            Boolean isInternal = checkLink.Run(urlList.get(i), rootDomain);
            
                //If link is internal, cross reference it against the other links to find duplicates
                if(isInternal){
                        //It'll be added back in the following function.
                        urlList.remove(i);
                        urlList = isDupe(urlList, urlList.get(i));
                        
                        //if(duplicate){
                        urlList.add(urlList.get(i));    
                        //}
                    
                }
                
                //If the link is external, remove it from the array
                else{
                    urlList.remove(i);
                }
        
        }

                for(int i =0; i < urlList.size(); i++)
        {
            //Check to see if link is internal or external
            CheckLinkType checkLink = new CheckLinkType();
            Boolean isInternal = checkLink.Run(urlList.get(i), rootDomain);
            
                //If link is internal, cross reference it against the other links to find duplicates
                if(isInternal){
                        //It'll be added back in the following function.
                        urlList.remove(i);
                        urlList = isDupe(urlList, urlList.get(i));
                        
                        //if(duplicate){
                        urlList.add(urlList.get(i));    
                        //}
                    
                }
                
                //If the link is external, remove it from the array
                else{
                    urlList.remove(i);
                }
        
        }

        
    return urlList;    
    }
 */   
        Boolean loopStatus = true;
        Integer i = 0;
        Integer size = urlList.size();
        
        CheckLinkType checkLink = new CheckLinkType();
        Boolean isInternal;
        
        
        
        while(loopStatus){

            
            //Check to see if link is internal or external
            
            isInternal = checkLink.Run(urlList.get(0), rootDomain);
            
                //If link is internal, cross reference it against the other links to find duplicates
                if(isInternal){
                        //It'll be added back in the following function.
                        String tempStorage = urlList.get(0);
                        urlList.remove(urlList.get(0));
                        
                        urlList = isDupe(urlList, tempStorage);
                        
                        //if(duplicate){
                        urlList.add(tempStorage);    
                        //}
                    
                }
                
                //If the link is external, remove it from the array
                else{
                    urlList.remove(0);
                }
        i++;
        //size = urlList.size();
        
        if(i.equals(size))
        {
            loopStatus = false;
        }
    }

        
    return urlList;    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
        public List<String> isDupe(List<String> urlList, String url){
            
            
            for(int i =0; i < urlList.size(); i++)
            {
                String shortened = removeLastChar(url);
                String longer = url + "/";
                String currentItem = urlList.get(i);
                
                if(currentItem.equals(url)){
                    urlList.remove(i);
                    //System.out.println("DUPLICATE!!!!!!!!!!!!!!!!!!!!");
                    i = i - 1;
                } 
                
                else if(currentItem.equals(longer)){
                    urlList.remove(i);
                    //System.out.println("DUPLICATE!!!!!!!!!!!!!!!!!!!!");
                    i = i - 1;
                }
                
                else if(shortened.equals(currentItem)){
                    urlList.remove(i);
                    //System.out.println("DUPLICATE!!!!!!!!!!!!!!!!!!!!");
                    i = i - 1;
                }
                
                //Integer distance = StringUtils.getLevenshteinDistance(urlList.get(i), url);
                        
                //if(distance < 1){
                //    urlList.remove(i);
                //    System.out.println("SIMILAR!!!!!!!!!!!!!!!!!!!!");
                //    i = i -1;

                //}
              
            
            }
            
            
            return urlList;
        }
        
        public String removeLastChar(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            return s.substring(0, s.length()-1);
        }
        
}
