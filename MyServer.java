import java.io.*;    // Importing classes for input/output operations
import java.net.*;   // Importing classes for networking

public class MyServer {
    public static void main(String[] args) {
        try {
            // Step 1: Create a ServerSocket that listens for incoming client connections on port 6666.
            // A ServerSocket object is used by a server to wait for clients to connect on a specific port.
            ServerSocket ss = new ServerSocket(6666);
            
            // Step 2: The server waits for a client to connect.
            // The 'accept()' method blocks (waits) until a client connects to the server, returning a Socket object.
            // This Socket object is used to communicate with the client.
            Socket s = ss.accept();  // Server accepts the client connection
            
            // Step 3: Create a DataInputStream to receive data sent by the client through the socket.
            // The 'getInputStream()' method of the socket provides an InputStream, which is wrapped in a DataInputStream.
            // This allows us to easily read data from the client.
            DataInputStream dis = new DataInputStream(s.getInputStream());
            
            // Step 4: Read the string message sent by the client.
            // The 'readUTF()' method reads the data sent in UTF-8 format from the client and stores it in the variable 'str'.
            String str = dis.readUTF();  // Read the message from the client
            
            // Step 5: Print the received message to the console.
            // The server outputs the message sent by the client to its console, showing successful communication.
            System.out.println("Message = " + str);
            
            // Step 6: Close the ServerSocket after communication is done.
            // Closing the ServerSocket releases the port and other resources associated with the server.
            // This step is crucial to prevent resource leaks and ensure proper network behavior.
            ss.close();
            
        } catch (Exception e) {
            // Catch and handle any exceptions that might occur during the process.
            // - IOException: If there is a problem with input/output or network communication.
            // - Other general exceptions: Caught and printed to the console to help diagnose errors.
            System.out.println(e);
        }
    }
}
