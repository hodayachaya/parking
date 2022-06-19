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
import java.util.Scanner;

/**
 *
 * @author student
 */
public class ClientParking {

    /**
     * @param args the command line arguments
     */    // TODO code application logic here
    private DataOutputStream toServer;
    private DataInputStream fromServer;


    private Socket socket;

    public ClientParking() {
        try {
            //יצירת קשר עם השרת
            Scanner me= new Scanner(System.in);
            socket = new Socket("localhost", 1728);
            toServer = new DataOutputStream(socket.getOutputStream());
            fromServer = new DataInputStream(socket.getInputStream());
            //System.out.println(fromServer.readUTF());
        } catch (IOException e) {
            System.out.println("Attempt to create connection failed with error: " + e);
        }
    }


    private ClientParking(String string, int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void ToServer(String c) {
        try {
            toServer.writeUTF(c);
            toServer.flush();
        } catch (IOException e) {
        }
    }

    public String readFromServer() {
        try {
            return  fromServer.readUTF();
        } catch (IOException e) {
        }
        return null;
    }
    public static void main(String[] args) {
        // TODO code application logic here
        new ClientParking();
    }
    
}
