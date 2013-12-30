import java.io.FileInputStream;
import java.net.ServerSocket;
import java.util.Properties;

import javax.naming.InitialContext;

import sun.print.resources.serviceui;


/**
 * 服务端的开始函数，进行一些初始化与端口的配置工作
 * @author Zhou
 *
 */
public class MainServer {	

	public static void main(String[] args)
	{
		init();
		new Thread(new ListenTaskServer(port)).start();
	}
	
	private static void init()
	{
		Properties pro = new Properties();
		Load_Por(pro);
		try {
			port = Integer.parseInt(pro.getProperty(Const.PORT,Const.DEFAULT_PORT));
		} catch (NumberFormatException exception) {
			// TODO: handle exception
			System.out.println("配置文件错误，请重新配置properties文件后重启程序");
			System.exit(0);
		}
		
	}
	private static void Load_Por(Properties pro)
	{
		try {
			FileInputStream fis = new FileInputStream(Const.Properties_file_Path);
			pro.load(fis);
		} catch (Exception e) {
			// TODO: handle exception
			//e.printStackTrace();
			System.out.println("找不到配置文件");
			System.exit(0);
		}
	}
	
	private static int port = 0;
	private static ServerSocket server = null;
	
}
