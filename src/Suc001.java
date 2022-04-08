import java.net.*;
import java.io.*;
public class Suc001 {
   static int NoClients=0;
   public static void main (String[] argumentos)throws IOException{
	ServerSocket socketServidor = null;
	Socket socketCliente = null;
	String json="src/SUC001.json";
	String sucursal="suc001";

	try{
	   socketServidor = new ServerSocket (13777);
	}catch (Exception e){
	   System.out.println ("Error : "+ e.toString());
	   System.exit (0);
	}

	System.out.println ("Server started... (Socket TCP)");
	int enproceso=1;
	while(enproceso==1){
		try{
	   		socketCliente = socketServidor.accept();
			MultiServerThread controlThread=new MultiServerThread(socketCliente,json,sucursal);
			controlThread.start();
	   	}catch (Exception e){
	    	System.out.println ("Error : " + e.toString());
			socketServidor.close();
			System.exit (0);
	   	}
	}
	System.out.println("Finalizando Servidor...");

   }
}
