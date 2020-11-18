package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;


public class ServerThread extends Thread{


    private Socket client;
    private  int clientID;
    private boolean running = true;

    public ServerThread(Socket client, int clientID) {
        this.client = client;
        this.clientID = clientID;
    }

    @Override
    public void run() {
        System.out.println("დაკაკშირებული კლიენტის: ID - " + clientID + " : მისამართი - " + client.getInetAddress().getHostName());

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(Socket.getOutputStream());

        try {

            System.out.println("მიმდინარეობს მონაცემების წაკითხვა ...");
            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());
            String str = (String) objectInputStream.readObject();
            if (str == "მითხარი ეროვნული ვალუტის კურსი") {
                objectOutputStream.writeObject(3.12);
            }
            else if ( str == "მაჩვენე ფილიალები") {
                try {
                    objectOutputStream.writeObject("ი.ჭავჭავაძის გამზ., ვაჟა ფშაველას გამზ., გურამიშვილის გამზ");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else if ( str == "ნახვამდის") {

            }




        }