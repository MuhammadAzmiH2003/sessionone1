package network;

import javax.imageio.IIOException;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class ConnectURL {


    private final String USER_AGENT = "Mozila/5.0";

    public static URL buildurl(String urlQwery) {
        URL url = null;
        try {
            url = new URL(urlQwery.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        //Log.v(TAG, "Built URL " + url);
        return url;

    }


    public static String getResponseFromHttpurl(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        try {
            InputStream in = urlConnection.getInputStream();

            Scanner Scanner = new Scanner(in);
            Scanner.useDelimiter("\\A");


            boolean hasilinput = Scanner.hasNext();
            if (hasilinput) {
                return Scanner.next();
            } else {
                return null;
            }

        } finally {
            urlConnection.disconnect();
        }
    }
        public void postJson (URL addres, String jsonData) throws IOException {
            HttpURLConnection con = (HttpURLConnection) addres.openConnection();

            con.setRequestMethod("POST");
            con.setRequestProperty("User-Agent", USER_AGENT);
            con.setRequestProperty("Accept-Language", "UTF-8");

            con.setDoOutput(true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(con.getOutputStream());
            outputStreamWriter.write(jsonData.toString());
            outputStreamWriter.flush();

            int responscode = con.getResponseCode();
            System.out.println("\nSending 'POST' request to URL : " + addres);
            System.out.println("Post parameters : ");
            System.out.println("Response code : " + responscode);

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputline;
            StringBuffer response = new StringBuffer();

            while ((inputline = in.readLine()) != null) {
                response.append(inputline);
            }
            in.close();
            System.out.println("Responses are = " + response.toString());

        }

    }


