import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Final{
	public static void main(String[] agrs) throws IOException{

		StringBuffer str = new StringBuffer("192.168.X.X");
		str.delete(0, str.indexOf("/", 0) + 1);
		boolean check = false;

		for(int i = 0; i < 256; i++){
			str.delete(str.lastIndexOf("."), str.length());

			str.delete(str.lastIndexOf(".")+1, str.length());

			str.append(i + ".");

			for(int j = 0; j < 256; j++){
				str.append(j);
				InetAddress add;
				try {
					add = InetAddress.getByName(str.toString());
					check = add.isReachable(1000);

					if(check == true)
						System.out.println("The address " + str + " is in use");
					//else System.out.println("Address"  + str+ " is not in use");
					str.delete(str.lastIndexOf(".")+1, str.length());
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
			}str.append(i);
		}
	}
}
