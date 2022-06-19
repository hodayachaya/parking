/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverparking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.net.Socket;

/**
 *
 * @author student
 */
public class ClientHandler extends Thread {

    Socket socket;
    DataInputStream din;
    DataOutputStream dout;

    public ClientHandler(Socket socket) {

        this.socket = socket;

        try {
            din = new DataInputStream(socket.getInputStream());
            dout = new DataOutputStream(socket.getOutputStream());
            start();
        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized String iscatch() {

        for (int i = 1; i <= 10; i++) {

            for (int j = 1; j <= 8; j++) {
                if (ServerParking.placeStatus[i][j].isCatch == true) {

                    ServerParking.placeStatus[i][j].setIsCatch(false);
                    return  String.valueOf(ServerParking.placeStatus[i][j].getCol())+" " + String.valueOf(ServerParking.placeStatus[i][j].getRow());

                }
            }

        }
        return "No parking available";

    }

    @Override
    public void run() {

        Place pRead;

        try {
            String str=iscatch();
            dout.writeUTF(str);
            dout.flush();
            System.out.println(Thread.currentThread());
            // dout.writeUTF("i connect with you " );

        } catch (IOException ex) {
            Logger.getLogger(ClientHandler.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }
}
