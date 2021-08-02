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
	    	Fichero archLectura =  new Fichero("C:\\Users\\gesbi\\git\\Queseria\\factura\\factura.txt");
	        archLectura.crearArchivo();
	        Socket socket = sfd.accept();
	        String str = archLectura.leerArchivo();
	        
	        try {
	        	Fichero archEscribir = new Fichero("C:\\Users\\gesbi\\git\\Queseria\\factura\\factura.txt");
	        	FileWriter outStream = new FileWriter(archEscribir.crearArchivo());
	        	outStream.write(str);
	        	outStream.close();
	        } catch(IOException ioe) {
	        	ioe.printStackTrace();
	        }
	        System.out.print("Factura Recibida");
	        socket.close();
	      }
	      catch(IOException ioe)
	      {
	        System.out.println("Error: "+ioe);
	      }
	    }
	  }
}
