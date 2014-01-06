import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;

import com.sun.corba.se.spi.orb.StringPair;
import com.sun.org.apache.bcel.internal.generic.RETURN;



/**
 * 这个类用来向数据库中插入一条新病人记录
 * 通过SOCKET 得到客户端传输回来的数据并检查合法性后插入到数据库中返回插入结果
 */
public class CreatePersonServer {

	//不接受无参数实例化
	private CreatePersonServer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreatePersonServer(Socket returnSockets ,String[] dates)
	{
		this.dates = dates;
		this.return_socket = returnSockets;
	}
	
	//将数据插入数据库
	public void startWork()
	{
		Statement sta = init_db();
		Const.op("start data aly");
		String[] kSet = new String[100];
		String[] vSet = new String[100];
		String[] temp = null;
		for(int i=1;i<dates.length;i++)
		{
			temp = dates[i].split(":");
			if(temp.length!=2||(!p_coloumnsSet.contains(temp[0])))
			{
				String errorString = "第"+i+"行参数错误，在CreatePersonServer";
				Const.op(errorString+"\n"+temp[0]+"P_name:周金宇");
				finisWork(errorString);
				return;
			}
			kSet[i] = temp[0];
			vSet[i] = temp[1];
		}
		StringBuffer sb = new StringBuffer();
		sb.append( "insert into "+Const.PERSON_TABLE+"(");
		//拼接列表名
		for(int i=1;i<dates.length;i++)
		{
			sb.append(kSet[i]);
			sb.append(i==dates.length-1?")":",");
		}
		sb.append("  values(");
		//拼接需要插入的值
		for(int i=1;i<dates.length;i++)
		{
			String tv = isQuete.get(kSet[i])?"\'"+vSet[i]+"\'":vSet[i];
			sb.append(tv);
			sb.append(i==dates.length-1?")":",");
		}
		sql = sb.toString();
		Const.op("insert sql is "+sql);
		try {
			sta.execute(sql);
		} catch (SQLException e) {
			// TODO: handle exception 
			e.printStackTrace();
			finisWork("数据库错误");
		}
		finisWork(Const.success);
	}
	
	//初始化数据库
	private Statement init_db()
	{
		Connection con = null;
		System.setProperty("jdbc.drivers", Const.JDBC_DRIVER_STRING);
		try {
			con = DriverManager.getConnection(Const.JDBC_URL_STRING, Const.DEFAULT_DB_USER_STRING, Const.DEFAULT_DB_PWD_STRING);
			Statement STA = con.createStatement();
			STA.execute(getCreateTableSQl());
			return STA;
		} catch (SQLException e){
			// TODO: handle exception
			e.printStackTrace();
			Const.op("数据库错误");
			System.exit(0);
		}
		return null;
	}
	
	private void finisWork(String info)
	{
		try {
			return_socket.getOutputStream().write(info.getBytes());
			return_socket.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	

	private String getCreateTableSQl()
	{
		//构造创建表语句
		sql = "create table if not exists "+Const.PERSON_TABLE;
		sql += "(p_id int auto_increment primary key,p_name varchar(10),p_sex char(1),p_age int,p_id_card_num char(18)," +
				"p_finger_id varchar(50),p_fpp_person_id varchar (100),p_mar_stu varchar(10),"+
				"p_edu_stu varchar(10),p_deleted int default 0,p_photo_addr varchar(100)"+
				")";
		return sql ;
	}
	
	private String sql = null;
	private Socket return_socket = null;
	
	//保存从客户端接受到的数据（键值对），解析前
	private String[] dates = null;
	
	//保存从dates 解析完成后的键值对，在构造函数中实例化
	private HashMap<String, String> values = null;
	
	//保存个人信息表的中所有列名集合，在静态代码中实例化
	public static HashSet<String> p_coloumnsSet =null;
	
	//保存个人信息表中的每一列的对应类型在拼接SQL的时候是否需要加引号
	//在静态代码中初始化
	public static HashMap<String, Boolean> isQuete = null;
	
	static
	{
		p_coloumnsSet = new HashSet<String>();
		for(int i=0;i<Const.PERSON_INFO_COLUMNS_NAME_STRINGS.length;i++)
		{
			p_coloumnsSet.add(Const.PERSON_INFO_COLUMNS_NAME_STRINGS[i]);
		}
		
		isQuete = new HashMap<String,Boolean>();
		for(String t:p_coloumnsSet)
		{
			isQuete.put(t, true);
		}
		isQuete.put("p_age", false);
		isQuete.put("p_deleted", false);
	}
}
