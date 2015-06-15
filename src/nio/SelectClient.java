package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * Created by Mryang on 15-4-13.
 */
public class SelectClient {

    private Selector selector;

    private String ip = "localhost";
    private int port = 8082;

    public SelectClient() throws IOException {
        SocketChannel cl = SocketChannel.open();
        cl.configureBlocking(false);
        selector = Selector.open();
        cl.connect(new InetSocketAddress(ip,port));
        cl.register(selector, SelectionKey.OP_CONNECT);
    }

    public void conn() throws IOException {
        while (true){
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            for(SelectionKey key:keys){
                SocketChannel channel = (SocketChannel) key.channel();

                keys.remove(key);

                if(key.isConnectable()){

                    // 如果正在连接，则完成连接
                    if(channel.isConnectionPending()){
                        channel.finishConnect();
                    }
                    System.out.println("server connected...");
                    // 设置成非阻塞
                    channel.configureBlocking(false);
                    //在这里可以给服务端发送信息哦
                    channel.write(ByteBuffer.wrap(new String("向服务端发送了一条信息").getBytes()));
                    //在和服务端连接成功之后，为了可以接收到服务端的信息，需要给通道设置读的权限。
                    channel.register(this.selector, SelectionKey.OP_READ);

                    continue;
                }

                if(key.isReadable()){
                    ByteBuffer bb = ByteBuffer.allocate(1024);
                    int count  =0;
                    while ((count = channel.read(bb)) >0){
                        bb.flip();
                        while (bb.hasRemaining()) {
                            System.out.println("111");
                        }
                        bb.clear();
                    }


                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new SelectClient().conn();
    }
}
