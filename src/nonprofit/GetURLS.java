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
public class GetURLS {
    
    List<String> Run(String url){
        List<String> urls = null;
        
        GetHTML html = new GetHTML();
        String content = html.Run(url);
        
        Document doc = Jsoup.parse(content, url);
        
        //Get html from url
        //Document doc = Jsoup.connect(url).get();
        
        Elements links = doc.select("a[href]");
        //Elements media = doc.select("[src]");
        //Elements imports = doc.select("link[href]");
        
        List<String> urlList = new ArrayList<String>();

        for (Element link : links) { 
            urlList.add(link.attr("abs:href"));
            //System.out.println(link.attr("href"));
        }
        
        return urls;
    }
    
    
}
