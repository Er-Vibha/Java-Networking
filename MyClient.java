import java.io.*;    // Importing classes for input/output operations
import java.net.*;   // Importing classes for networking

public class MyClient {
    public static void main(String[] args) {
        try {
            // Step 1: Create a Socket object to connect to the server.
            // The server is running on 'localhost' (same machine) and listening on port 6666.
            // This socket initiates the connection with the server.
            Socket s = new Socket("localhost", 6666);
            
            // Step 2: Create a DataOutputStream to send data through the socket.
            // The 'getOutputStream()' method retrieves the output stream from the socket,
            // allowing us to send data to the server. DataOutputStream wraps it to enable easier writing of data types.
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            
            // Step 3: Use the 'writeUTF()' method to send a string in UTF-8 encoding to the server.
            // The message "Hello Server" will be sent across the network to the server.
            dout.writeUTF("Hello Server");
            
            // Step 4: Flush the DataOutputStream to ensure that any buffered data is sent immediately.
            // This is important because data may be buffered before being sent over the network.
            dout.flush();
            
            // Step 5: Close the DataOutputStream after sending the data.
            // This step ensures that the output stream is properly closed and releases any resources associated with it.
            dout.close();
            
            // Step 6: Close the socket after the communication is complete.
            // Closing the socket releases the connection between the client and server.
            s.close();
            
        } catch (Exception e) {
            // Catch and handle any exceptions that might occur during the process, such as:
            // - UnknownHostException: If the specified host could not be resolved.
            // - IOException: If there is a problem in input/output (e.g., connection failure).
            // Any caught exception will be printed to the console.
            System.out.println(e);
        }
    }
}
