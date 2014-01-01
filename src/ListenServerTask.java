import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程的实例，用来监听特定的端口
 * @author Zhou
 *
 */
public class ListenServerTask implements Runnable{
	
	private int port = 0;
	//拒绝无参数实例化
	private ListenServerTask(){}
	public ListenServerTask(int port)
	{
		this.port  = port;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		ServerSocket serverSocket = null;
		Socket socket = null;
		try {
			serverSocket = new ServerSocket(port);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			Const.op("创建套接字错误");
			System.exit(0);
			
		}
		while(true)
		{
			Const.op("Start Accept...");
			try {
				/*
				 * 得到SOCKET 启动新线程处理，方便多客户端连接
				 */			
				socket =  serverSocket.accept();
				new Thread(new DeliverServerTask(socket)).start();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("网络错误");
			}
			Const.op("Accepted");
		}
		
	}
}
