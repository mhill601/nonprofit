/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonprofit;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import org.jsoup.Jsoup;

/**
 *
 * @author Mark
 */
public class CommonWords {
  
    public List<Object> Run(String url){
        
    
        //Re-code to have the HTML retreived once earlier on, and then passed to this method.
        GetHTML html = new GetHTML();
        String content = html.Run(url);
        
        GetURLS urlRetrieval = new GetURLS();
        List<String> urlList = urlRetrieval.Run(url);
        
        
        String text = Jsoup.parse(content,"ISO-8859-1").select("body").text();
        //System.out.println(text);
        
        String[] words = text.split("\\s+");
        
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].replaceAll("[^\\w]", "");
        }
        
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        
        List<Object> mostCommonWords = Arrays.asList(words);
        removeCommon(mostCommonWords);
        
        return mostCommonWords;
    }
 
    
    List<Object> removeCommon(List<Object> words){
        List<Object> cleanedList = null;
        
        Connection conn1 = null;    
        Statement st = null;
        ResultSet rs = null;    

        String query = null;

        try {
                // connect way #1
                //String url1 = "jdbc:mysql://108.167.189.45/ab18911_adwords";
                //String user = "ab18911_jsix";
                //String password = "G7-Chord";

                //connect to local
                String url1 = "jdbc:mysql://localhost:3306/test";
                String user = "root";
                String password = "G7-Chord";        

                conn1 = DriverManager.getConnection(url1, user, password);
                if (conn1 != null) {
                    System.out.println("working");
                    for (int i = 0; i < words.size(); i++) {
                        st = conn1.createStatement();
                        rs = st.executeQuery("SELECT * FROM test.top20k WHERE `word` = '" + words.get(i) + "';");

                        if (rs.next()) {
                            WordList wordObj = new WordList();
                            
                            Integer tempCount = Integer.parseInt(rs.getString(2));
                            
                            wordObj.setWord(rs.getString(1));
                            wordObj.setCount(tempCount);
                            
                            cleanedList.add(wordObj);
                            
                            //query = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3); 
                            
                            //System.out.println(words.get(i) + "   " + rs.getString(1) + "  " + rs.getString(2));  
                        }
                        else{
                            System.out.println(words.get(i) + "    not in top20k");  
                        }
                        
                    }
                } 
         }
            catch (SQLException ex) {
                System.out.println("An error occurred. Maybe user/password is invalid");
                ex.printStackTrace();
            }
        
        
        
        
        
        return cleanedList;
    }
}
