package services;

import colors.ConsoleColor;
import inserface.ICheckConnection;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class CheckInternetConnection implements ICheckConnection {
    @Override
    public  boolean checkConnection() {
        boolean connected = false;
        try {
            URL url = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("HEAD");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                return connected = true;
            } else {
                return false;
            }
        } catch (IOException e) {

            System.out.println(ConsoleColor.RED_BOLD + "Internet Connection is Field !! ");
            System.exit(0);
        }
        return connected;
    }


}
