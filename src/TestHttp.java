import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestHttp {
	
	/**
	 * @param args
	 * @throws IOException 
	 * @throws UnknownHostException 
	 * @throws IOException
	 * @throws UnknownHostException
	 */
	
	public static void Translate() throws IOException {
	  
      Socket s=new Socket("www.163.com",80);
      BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
      bw.write("OPTIONS /HTTP/1.1");
      bw.newLine();
      bw.write("Host:www.163.com£º80");
      bw.newLine();
      bw.write("Content-type:text/html");
      bw.newLine();
      bw.newLine();
      bw.flush();
      
      BufferedReader br=new BufferedReader(new InputStreamReader(s.getInputStream()));
      String str=null;
      while((str=br.readLine())!= null){
    	System.out.println(str);
      }
      
      bw.close();
      br.close();
      s.close();
	  
	}
    
	
	public static void main(String[] args) throws Exception {
		
	  /*
	  Socket s = new Socket("www.163.com", 80);
	  BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
	  */
		Translate();
    }

}
