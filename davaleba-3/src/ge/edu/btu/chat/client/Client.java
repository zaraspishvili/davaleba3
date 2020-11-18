package ge.edu.btu.chat.client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        String data;
        Socket socket;
        ObjectOutputStream objectOutputStream = null;
        boolean isStart = true;
        try {

            socket = new Socket("localhost", 9011);
            System.out.println("მიმდინარეობს კავშირის დამყარება ...");

            while (isStart) {
                Scanner scanner = new Scanner(System.in);
                data = scanner.nextLine();
                objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(data);

            }

            objectOutputStream.close();
            socket.close();
            System.out.println("კავშირი დასრულებულია!!!");

        } catch (Exception e) {
            System.out.println("შეცდომა : " + e);
        }
    }
}