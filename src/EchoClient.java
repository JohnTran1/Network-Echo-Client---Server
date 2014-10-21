import java.util.*;
import java.io.*;
import java.net.*;

/* @Author John Tran
 * CS380 - Project 1
 * Due: October 8th, 2014
 */

public class EchoClient {

	public static void main(String[] args) throws Exception {

		int port = 5050; // set port
		String host = "localhost"; // set host

		try (Socket client = new Socket(host, port)) {
			System.out.println("You are now connected to "
					+ client.getInetAddress());
			System.out.println("Type to chat or 'exit' to quit:");
			PrintStream out = new PrintStream(client.getOutputStream());
			Scanner keyboard = new Scanner(System.in);
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(
						client.getInputStream()));
				System.out.print("Client> ");
				String input = keyboard.nextLine();

				// Type "exit" to exit client
				out.println(input);
				if (input.equalsIgnoreCase("exit")) {
					System.exit(0);
				}
				System.out.println("Server> " + br.readLine());
			}
			// unable to connect message
		} catch (Exception e) {
			System.out
					.println("Error, was unable to connect.  Check the server and port configuration.  Now Exiting.");
		}
	}

}
