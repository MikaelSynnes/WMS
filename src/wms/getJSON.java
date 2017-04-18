package wms;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.HashMap;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mikael
 */
public class getJSON {

    private static ObjectMapper mapper;

    public getJSON() {
        mapper = new ObjectMapper();
    }

    public static void main(String[] args) throws Exception {
        mapper = new ObjectMapper();
        Order order = new Order();
        order.setCustomerID(1);
        order.setEmployeeID(1);
        order.setOrderID(1);
        order.setInvoiceDate("invoiceDate");
        order.setPlacedDate("placedDate");

        try {
            System.out.println(mapper.writeValueAsString(order));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        getOrder();
        //addOrder();

    }

    public static void getOrder() throws Exception {
        String fetchString = httpGet("http://kaysl-logix.uials.no:8080/orders/10");
        try {
            Order ordre = mapper.readValue(fetchString, Order.class);
            System.out.println(ordre.getOrderID());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
       public static void addOrder() throws Exception {
        Order order = new Order();
        order.setOrderID(1234);
       
        HashMap<String, String> paramMap = new HashMap<String, String>();
        try {
            System.out.println(mapper.writeValueAsString(order));
            String body = mapper.writeValueAsString(order);
            httpPost("http://localhost:8080/orders", body);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static String httpGet(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("GET");

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String input;
        StringBuffer response = new StringBuffer();

        while ((input = in.readLine()) != null) {
            response.append(input);
        }
        in.close();
        System.out.println(response.toString());
        return response.toString();
    }

    private static void httpPost(String urlString, String body) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(body);
        out.flush();
        out.close();

        int responseCode = con.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String input;
        StringBuffer response = new StringBuffer();

        while ((input = in.readLine()) != null) {
            response.append(input);
        }
        in.close();

        System.out.println(response.toString());
    }

}
