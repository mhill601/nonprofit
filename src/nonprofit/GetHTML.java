/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nonprofit;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *
 * @author Mark
 */
public class GetHTML {
    
        public String Run(String url){
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
        
}
