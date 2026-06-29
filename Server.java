import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {

        try {

            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("Server started...");
            System.out.println("Waiting for client...");

            Socket socket = serverSocket.accept();

            System.out.println("Client connected!");

            BufferedReader input =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));

            String encrypted;

            while ((encrypted = input.readLine()) != null) {

                System.out.println("\nEncrypted : " + encrypted);

                String decrypted = AESUtil.decrypt(encrypted);

                System.out.println("Decrypted : " + decrypted);
            }

            input.close();
            socket.close();
            serverSocket.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}