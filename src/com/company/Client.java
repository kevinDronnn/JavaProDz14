package com.company;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        scanner.useDelimiter("\n");

        Socket clientSocket = new Socket("localhost", 8081);
        OutputStream outputStream = clientSocket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(outputStream, true);
        String message = scanner.next();

        while (!message.equals("exit")) {
            message = scanner.next();
            printWriter.println(message);
        }
        scanner.close();
        clientSocket.close();
        outputStream.close();
        printWriter.close();

    }
}
