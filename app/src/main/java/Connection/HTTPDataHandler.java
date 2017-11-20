package Connection;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Seth Cohen on 10/29/2017.
 */

public class HTTPDataHandler {

    static String stream = null;

    public HTTPDataHandler(){

    }

    public String getHTTPData(String urlString) {
        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection)url.openConnection();

            if(connection.getResponseCode() == HttpURLConnection.HTTP_OK){
                InputStream inputStream = new BufferedInputStream(connection.getInputStream());
                BufferedReader buffReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder strBuilder = new StringBuilder();
                String line;
                while ((line = buffReader.readLine()) != null){
                    strBuilder.append(line);
                    stream = strBuilder.toString();
                    connection.disconnect();
                }
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stream;
    }
}
