package nio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * Created by Mryang on 15-4-13.
 */
public class Client implements Runnable {


    public static void main(String[] args) {
        Client c = new Client();
        for(int i=0;i<1;i++){
            new Thread(c).start();
        }
    }

    public void run() {
        try {
            Socket socket = new Socket("localhost", 8082);
            OutputStream outputStream = socket.getOutputStream();
//            System.out.println(socket);
            InputStream is = socket.getInputStream();

            byte[] bytes = new byte[1024];

            int n = is.read(bytes);
            System.out.println(new String(bytes, 0, n));

            outputStream.write(("connect to the server at time ").getBytes());
            outputStream.flush();
            is.close();
            socket.close();
        } catch (Exception e) {

        }
    }
}
