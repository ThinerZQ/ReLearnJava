package com.zq.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/3/26
 * Time: 10:56
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class PostTest {
    public static void main(String[] args) throws IOException {

        System.out.println(doPost("http://www.thinerzq.me",new HashMap<Object,Object>()));
    }
    public static String doPost(String urlString, Map<Object,Object> nameValuePairs) throws IOException {
        URLConnection connection = new URL(urlString).openConnection();
        connection.setDoOutput(true);
        try(PrintWriter out = new PrintWriter(connection.getOutputStream())){
            boolean first = true;
            for (Map.Entry<Object, Object> pair:
            nameValuePairs.entrySet()){
                if (first)first = false;
                else out.print('&');

                String name = pair.getKey().toString();
                String value = pair.getValue().toString();
                out.print(name);
                out.print("=");
                out.print(URLEncoder.encode(value,"UTF-8"));
            }
        }
        StringBuilder sb = new StringBuilder();
        try(Scanner in = new Scanner(connection.getInputStream())){
            while (in.hasNextLine()){
                sb.append(in.nextLine());
                sb.append("\n");
            }
        }catch (IOException e){
            if (!(connection instanceof HttpURLConnection))
                throw e;
            InputStream err = ((HttpURLConnection) connection).getErrorStream();
            if (err == null){
                throw  e;
            }
            Scanner in = new Scanner(err);
            while (in.hasNextLine()) {
                sb.append(in.nextLine());
                sb.append("\n");
            }
        }
        return sb.toString();
    }
}
