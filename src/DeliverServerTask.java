import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;


public class DeliverServerTask implements Runnable{

	private DeliverServerTask(){};
	public DeliverServerTask(Socket socket)
	{
		Const.op("deliver get...");
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Const.op("deliver thread start....");
		try {
			Scanner cin  = new Scanner(socket.getInputStream(),"GBK");
			String temp = null;
			int cmd = 0; 
			StringBuffer sBuffer = new StringBuffer();
			while(cin.hasNext())
			{
				sBuffer.append(cin.next());
			}
			cmds = sBuffer.toString().split("&");
			Const.opArray(cmds);
			
			try {
				cmd = Integer.parseInt(cmds[0]);
			} catch (NumberFormatException ex) {
				// TODO: handle exception
				socket.getOutputStream().write("���ݴ���".getBytes());
				Const.op("���ݴ���##"+cmds[0]);
				ex.printStackTrace();
				return;
			}
			//��ʼ��������ַ�����
			deliver(cmd);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.out.println("�������");
		}
		
	}
	
	private void deliver(int cmd)
	{
		switch (cmd) {
		case 1:
			CreatePersonServer cps = new CreatePersonServer(socket,cmds);
			cps.startWork();
			break;

		default:
			Const.op("cmd is "+cmd);
			break;
		}
	}
	String [] cmds = null;
	private Socket socket = null;
}
