package com.zq.socket;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA
 * Date: 2016/3/26
 * Time: 10:36
 * User: ThinerZQ
 * GitHub: <a>https://github.com/ThinerZQ</a>
 * Blog: <a>http://www.thinerzq.me</a>
 * Email: 601097836@qq.com
 */
public class URLConnectionTest {
    public static void main(String[] args) throws IOException {
        String urlName ="http://www.thinerzq.me";
        URL url = new URL(urlName);
        URLConnection connection = url.openConnection();

        connection.connect();
        Map<String,List<String>> headers = connection.getHeaderFields();
        for (Map.Entry<String,List<String>> entry : headers.entrySet()){
            String key = entry.getKey();
            for (String value : entry.getValue()){
                System.out.println(key+" : "+value);
            }
        }
        //some convenience functions
        System.out.println("--------------------");
        System.out.println("getContentType : "+connection.getContentType());
        System.out.println("getContentLength : "+connection.getContentLength());
        System.out.println("getContentEncoding : "+connection.getContentEncoding());
        System.out.println("getData : "+connection.getDate());
        System.out.println("getExpiration : "+connection.getExpiration());
        System.out.println("getLastModifed : "+connection.getLastModified());
        System.out.println("--------------------");

        Scanner in = new Scanner(connection.getInputStream());

        while (in.hasNextLine()){
            System.out.println(in.nextLine());
        }
    }
}
