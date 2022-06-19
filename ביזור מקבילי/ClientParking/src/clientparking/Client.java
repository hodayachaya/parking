/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientparking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class Client {

    private DataOutputStream toServer;
    private DataInputStream fromeServer;
    private Socket socket;

    public Client() {
        try {
            socket = new Socket("localhost", 1728);
            toServer = new DataOutputStream(socket.getOutputStream());
            fromeServer = new DataInputStream(socket.getInputStream());
//            String s =fromeServer.readUTF();
//            System.out.println(s);

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public String ReadFromeServer() {
        try {
            return fromeServer.readUTF();
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } 
        


            return null;

        }
    }
