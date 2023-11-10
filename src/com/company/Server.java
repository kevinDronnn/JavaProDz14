package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8081);
        Socket accept = serverSocket.accept();
        InputStream inputStream = accept.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line1;
        System.out.println("hello");
        while (!(line1 = bufferedReader.readLine()).equals("exit")) {
            System.out.println(line1);
            if (line1.contains("ъ") || line1.contains("ы") || line1.contains("э") || line1.contains("ё")) {
                System.out.println("Що таке паляниця?");
                continue;
            }
            if (!line1.equals("хліб")) {
                break;
            } else {
                Date date = new Date();
                System.out.println(date);
                System.out.println("Бувай!");
                break;
            }
        }
        serverSocket.close();
        accept.close();
        inputStream.close();
        bufferedReader.close();
    }
}
