import java.util.*;
import java.io.*;
import java.net.*;

/* @Author John Tran
 * CS380 - Project 1
 * Due: October 8th, 2014
 */

public class EchoServer {

	public static void main(String[] args) throws Exception {

		// port number to listen on
		int port = 5050;
		
		ServerSocket server = new ServerSocket(port);
		System.out.println("Server running.  Now listening on port " + port);
		while (true) {
			try (Socket incoming = server.accept()) {

				System.out.println("Client connected: "
						+ incoming.getInetAddress());
				PrintStream out = new PrintStream(incoming.getOutputStream());
				BufferedReader br = new BufferedReader(new InputStreamReader(
						incoming.getInputStream()));
				while (true) {

					String output = br.readLine();
					out.println(output);
				}
			}
			catch (Exception e) {
				System.out.println("Client disconnected.  Server shutting down.");

			}
		}

	}
}
