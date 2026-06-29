import java.io.*;
import java.net.*;

public class Client {

    public static void main(String[] args) {

        try {

            Socket socket = new Socket("localhost",5000);

            PrintWriter output =
                    new PrintWriter(socket.getOutputStream(), true);

            output.println(AESUtil.encrypt("Hello from Client"));
            output.println(AESUtil.encrypt("This message is encrypted"));
            output.println(AESUtil.encrypt("Goodbye"));

            output.close();

            socket.close();

            System.out.println("Encrypted messages sent.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}