import java.io.FileOutputStream;
import java.net.URL;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class KeyGenerator {
	public static void main(String[] args){
		
		int c = 0;
		String q = "";
		byte[] b;
		String fileName ="";
		
		//Gets numbers of characters needed
		boolean dataGood = false;
		while(!dataGood){
			String s = JOptionPane.showInputDialog("How many characters [1,10000] would you like the users to be able to encrypt?");
			try{
				c = Integer.parseInt(s);
				if(c >= 1 && c <= 10000)
					dataGood = true;
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null, "Please enter a number [1,10000]!");
			}
		}
		b = new byte[c];
		
		//Builds query string
		q = "https://www.random.org/integers/?num=" + c + "&min=0&max=255&col=1&base=8&format=plain&rnd=new";
		
		//Fill the array with random bytes
		try{
			URL u = new URL(q);
			Scanner s = new Scanner(u.openStream());
			for(int i = 0; i < c; i++){
				byte t = (byte) s.nextInt();
				b[i] = t;
			}
			s.close();
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "We are having issues with random.org, please try again later (Have you exceeded your random number cap for the day?).");
		}
		
		for(int i = 0; i < b.length; i++){
			System.out.println(b[i]);
		}		
		
		//Write the data to the file
		boolean goodFile = false;
		
		while(!goodFile){
			try{	
				fileName = JOptionPane.showInputDialog("Please enter a full name (C:\\Users\\Alice\\keyfile) for the keyfile");
				FileOutputStream f = new FileOutputStream(fileName);
				f.write(b);
				f.close();
				goodFile = true;
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(null, "We could not write the file, please try to write to another location.");
			}
		}
	}
}