
/**
 * ����ౣ��һЩ����
 * ����˵ÿ�ű�ı���
 * @author Zhou
 *
 */
public class Const {
	
	//���Properties �ļ�·��
	public static final String Properties_file_Path = "Properties.Properties";
	
	//��properties �õ� port �� ��ֵ
	public static final String PORT = "port";
	
	//�����Ĭ�ϼ����˿�
	public static final String DEFAULT_PORT = "7933";
	
	//�������
	public static void opArray(Object[] arr)
	{
		op("the array is "+arr.getClass());
		for(int i=0;i<arr.length;i++)
		{
			op(""+arr[i]);
		}
	}
	
	//����ִ�гɹ��������ַ���
	public static final String success = "success";
	
	public static void op(String info)
	{
		System.out.println(info);
	}
	
	//�����ļ���
	public static final String CONFIG_FILE_NAME = "config.properties";
	
	//���ݿ����
	public static final String JDBC_DRIVER_STRING = "com.mysql.jdbc.Driver";
	public static final String JDBC_URL_STRING = "jdbc:mysql://localhost/xamindhospital";
	public static final String DEFAULT_DB_USER_STRING = "root";
	public static final String DEFAULT_DB_PWD_STRING = "admin";
	public static final String PERSON_TABLE = "person_info";
	
	//������Ϣ����������
		public static final String[] PERSON_INFO_COLUMNS_NAME_STRINGS=new String[]{
			"p_id","p_name","p_sex" ,"p_age","p_id_card_num", 
			"p_finger_id","p_fpp_person_id","p_mar_stu",
			"p_edu_stu","p_deleted","p_photo_addr"
		};
	
	
}
