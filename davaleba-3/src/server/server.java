package server;


import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

class Server extends Thread{

    public static void main(String[] args) {

        ServerSocket serverSocket;
        Socket socket = null;
        ObjectInputStream objectInputStream;
        String str;
        int clientId = 0;
        ServerThread serverThread;


        try {
            serverSocket = new ServerSocket(9011);
            System.out.println("სერვერი ჩაირთო !!! ");

            while (true) {
                socket = serverSocket.accept();
                serverThread = new ServerThread(socket, clientId);
                serverThread.start();
                System.out.println("კავშირი დამყარებულია !");
                clientId++;
            }

        } catch (Exception e) {
            System.out.println("შეცდომა :  " + e);
        }

    }
}