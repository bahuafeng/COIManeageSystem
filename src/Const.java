
/**
 * 这个类保存一些常量
 * 比如说每张表的表名
 * @author Zhou
 *
 */
public class Const {
	
	//存放Properties 文件路径
	public static final String Properties_file_Path = "Properties.Properties";
	
	//从properties 得到 port 的 键值
	public static final String PORT = "port";
	
	//服务端默认监听端口
	public static final String DEFAULT_PORT = "7933";
	
	//输出数组
	public static void opArray(Object[] arr)
	{
		op("the array is "+arr.getClass());
		for(int i=0;i<arr.length;i++)
		{
			op(""+arr[i]);
		}
	}
	
	//任务执行成功完成这个字符串
	public static final String success = "success";
	
	public static void op(String info)
	{
		System.out.println(info);
	}
	
	//配置文件名
	public static final String CONFIG_FILE_NAME = "config.properties";
	
	//数据库相关
	public static final String JDBC_DRIVER_STRING = "com.mysql.jdbc.Driver";
	public static final String JDBC_URL_STRING = "jdbc:mysql://localhost/xamindhospital";
	public static final String DEFAULT_DB_USER_STRING = "root";
	public static final String DEFAULT_DB_PWD_STRING = "admin";
	public static final String PERSON_TABLE = "person_info";
	
	//个人信息表所有列名
		public static final String[] PERSON_INFO_COLUMNS_NAME_STRINGS=new String[]{
			"p_id","p_name","p_sex" ,"p_age","p_id_card_num", 
			"p_finger_id","p_fpp_person_id","p_mar_stu",
			"p_edu_stu","p_deleted","p_photo_addr"
		};
	
	
}
