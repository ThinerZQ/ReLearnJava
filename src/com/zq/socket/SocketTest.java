package com.zq.socket;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Created by 60109 on 2016/3/25.
 */
public class SocketTest {
    public static void main(String[] args) {

        try(Socket s = new Socket("time-A.timefreq.bldrdoc.gov",13)){
            InputStream inputStream = s.getInputStream();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNext()){
                System.out.println(scanner.nextLine());
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
