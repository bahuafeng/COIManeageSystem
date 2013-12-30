import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;


public class TaskDeliverServer implements Runnable{

	private TaskDeliverServer(){};
	public TaskDeliverServer(Socket socket)
	{
		Const.op("deliver get...");
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		Const.op("deliver thread start....");
		try {
			InputStreamReader reader = new InputStreamReader(socket.getInputStream());
			BufferedReader bigreader = new BufferedReader(reader);
			int cmd = 0;
			String cmdStrin = bigreader.readLine();
			try {
				cmd = Integer.parseInt(cmdStrin);
			} catch (NumberFormatException ex) {
				// TODO: handle exception
				socket.getOutputStream().write("���ݴ���".getBytes());
				Const.op("���ݴ���"+cmdStrin);
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
			CreatePersonServer cps = new CreatePersonServer(socket);
			cps.startWork();
			break;

		default:
			Const.op("cmd is "+cmd);
			break;
		}
	}
	
	private Socket socket = null;
}
