package logico;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Servidor extends Thread {
	public static Vector usuarios = new Vector();

	public static void main(String[] args) {
		ServerSocket sfd = null;
	    try
	    {
	      sfd = new ServerSocket(7000);
	    }
	    catch (IOException ioe)
	    {
	      System.out.println("Comunicación rechazada."+ioe);
	      System.exit(1);
	    }

	    while (true)
	    {
	      try
	      {
	        Socket nsfd = sfd.accept();
	      }
	      catch(IOException ioe)
	      {
	        System.out.println("Error: "+ioe);
	      }
	    }
	  }
}
