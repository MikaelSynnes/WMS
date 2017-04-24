package wms;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.Buffer;
import java.util.ArrayList;
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
    public getJSON(){
             mapper = new ObjectMapper();
            }

    private static ObjectMapper mapper;

  //  public static void main(String[] args) throws Exception {
     
/*
        ArrayList<OrderLine> line = new ArrayList<>();
        line.add(new OrderLine(1, 1, 1, 1));
        Order order = new Order();
        order.setCustomerID(1);
        order.setEmployeeID(1);
        order.setOrderID(1);
        order.setInvoiceDate("invoiceDate");
        order.setPlacedDate("placedDate");
        order.setOrderLines(line);

        try {
            System.out.println(mapper.writeValueAsString(order));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

       ArrayList<Order> or= getAllOrders();
       for(Order y:or){
           System.out.println(y.getOrderID());
       }
*/

  //  }

    public static ArrayList<Order> getAllOrders() throws Exception {
        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 1; i < 100; i++) {
            Order o = getOrder(i);
            if (o != null) {

                orders.add(o);
            }
            else if(i == 3 || i ==4){

            }
            else{
                return orders;
            }
 
        }
        return orders;
    }

    public static Order getOrder(int i) throws Exception {
        try {
        String fetchString = httpGet("http://kaysl-logix.uials.no:8080/orders/" + i);


            Order ordre = mapper.readValue(fetchString, Order.class);
          
            return ordre;

        }
        catch (IOException ex) {
             System.out.println(ex.getMessage());
            System.out.println("ERROR");
        } 
        return null;
    }

    public void addOrder() throws Exception {
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
