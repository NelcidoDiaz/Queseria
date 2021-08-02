package logico;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor extends Thread {

	public static void main(String[] args) {
		ServerSocket sfd = null;
	    try
	    {
	      sfd = new ServerSocket(7000);
	    }
	    catch (IOException ioe)
	    {
	      System.out.println("Error al abrir el socket"+ioe);
	      System.exit(-1);
	    }

	    while (true)
	    {
	      try
	      {
	        Socket socket = sfd.accept();
	        DataInputStream disco = new DataInputStream(socket.getInputStream());
	        String str = disco.readUTF();
	        
	        try {
	        	File outFile = new File("git\\Queseria\\factura\\factura.txt");
	        	FileWriter outputStream = new FileWriter(outFile);
	        	outputStream.write(str);
	        	outputStream.close();
	        } catch(IOException ioe) {
	        	ioe.printStackTrace();
	        }
	        System.out.print("Factura Recibida");
	        disco.close();
	        socket.close();
	      }
	      catch(IOException ioe)
	      {
	        System.out.println("Error: "+ioe);
	      }
	    }
	  }
}
