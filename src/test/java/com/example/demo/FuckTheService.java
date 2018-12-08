package com.example.demo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class FuckTheService {
    private final String USER_AGENT = "Mozilla/5.0";

    public static void main(String[] args) throws Exception {

        FuckTheService http = new FuckTheService();

        System.out.println("Testing 1 - Send Http GET request");


        Runnable task = () -> {
            String threadName = Thread.currentThread().getName();
            try {
                System.out.println("threadName :"+threadName);
                http.sendGet();
            } catch (Exception e) {
                System.out.println("Something b ad happened");
            }
        };

        task.run();
        for (int i = 0; i < 20; i++) {
            Thread thread = new Thread(task);
            thread.start();
        }


        System.out.println("Done!");
    }

    // HTTP GET request
    private void sendGet() throws Exception {

        String url = "http://springbootapp-test-ravi-baka.b542.starter-us-east-2a.openshiftapps.com/getAllCustomers";
        //String url = "http://alt-win-172.corp.telenor.no:7020/bedrift/minbedrift/api/config/chatopeninghours";

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();

        // optional default is GET
        con.setRequestMethod("GET");

        //add request header
        con.setRequestProperty("User-Agent", USER_AGENT);

        int responseCode = con.getResponseCode();
        /*System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);*/

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        //print result
        System.out.println("Response Code : " + responseCode + " >> " +response.toString());

    }
}
