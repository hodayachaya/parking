/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverparking;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
//import .client.ThreadConnection;

/**
 *
 * @author student
 */
public class ServerParking {

  

    /**
     * @param args the command line arguments
     */
    ServerSocket main;//אובייקט שאחראי על התקשורת
    Socket socket;//שקע. אובייקט שבתוכו המידע על התקשורת עצמה
    int port;
    static Place[][] placeStatus = new Place[11][9];
    //מטריצה סטטיתמסוג בוליאני של המקומות - 
//    DataInputStream din;
//    DataOutputStream dout;

    public ServerParking(int port) {
        char c = 'A';
        for (int i = 1; i <= 10; i++) {

            for (int j = 1; j <= 8; j++) {
                placeStatus[i][j] = new Place(i, c++, true);
//                placeStatus[i][j].setRow(i);
//                placeStatus[i][j].setCol(c++);
//                placeStatus[i][j].setIsCatch(true);
            }
            c = 'A';
        }

 
        this.port = port;
        try {
            main = new ServerSocket(port);
            while (true) {
                socket = main.accept();//האזנה של השרת על הפורט שלו עד שלקוח יצור קשר
                ClientHandler ch = new ClientHandler(socket);
//            din=new DataInputStream(socket.getInputStream());
//            dout=new DataOutputStream(socket.getOutputStream());
//            String read = din.readUTF();
//            System.out.println(read);
//            dout.writeUTF("i connect with you "+read);

            }
        } catch (IOException ex) {

        }
    }
      



    public static void main(String[] args) {
        // TODO code application logic here
        new ServerParking(1728);

    }

}
