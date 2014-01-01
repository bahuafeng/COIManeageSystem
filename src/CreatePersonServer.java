import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

import com.sun.corba.se.spi.orb.StringPair;



/**
 * ��������������ݿ��в���һ���²��˼�¼
 * ͨ��SOCKET �õ��ͻ��˴�����������ݲ����Ϸ��Ժ���뵽���ݿ��з��ز�����
 */
public class CreatePersonServer {

	//�������޲���ʵ����
	private CreatePersonServer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CreatePersonServer(Socket returnSockets ,String[] dates)
	{
		Const.op("cp ger");
		this.dates = dates;
		this.return_socket = returnSockets;
	}
	
	public void startWork()
	{
		Const.op("start data aly");
		for(int i=0;i<dates.length;i++)
		{
			Const.op(dates[i]);
		}
	}

	private String getCreateTableSQl()
	{
		//���촴�������
		sql = "create table if not exists "+Const.PERSONTABLE;
		sql += "(p_id int auto_increment primary key,p_name varchar(10),p_sex char(1),p_age int,p_id_card_num char(18)," +
				"p_finger_id varchar(50),p_fpp_person_id varchar (100),p_mar_stu varchar(10),"+
				"p_edu_stu varchar(10),p_deleted int default 0,p_photo_addr varchar(100)"+
				")";
		return sql ;
	}
	
	private String name = null,sex = null,id_card_num=null,finger_id = null,fpp_person_id=null;
	private String mar_stu = null,edu_stu = null,photo_addr=null;
	private int age = 0;
	private String sql = null;
	private Socket return_socket = null;
	private String[] dates = null;
}
