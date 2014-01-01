import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���̵߳�ʵ�������������ض��Ķ˿�
 * @author Zhou
 *
 */
public class ListenServerTask implements Runnable{
	
	private int port = 0;
	//�ܾ��޲���ʵ����
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
			Const.op("�����׽��ִ���");
			System.exit(0);
			
		}
		while(true)
		{
			Const.op("Start Accept...");
			try {
				/*
				 * �õ�SOCKET �������̴߳��������ͻ�������
				 */			
				socket =  serverSocket.accept();
				new Thread(new DeliverServerTask(socket)).start();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				System.out.println("�������");
			}
			Const.op("Accepted");
		}
		
	}
}
