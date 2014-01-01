
/**
 * 这个类保存一些常量
 * 比如说每张表的表名
 * @author Zhou
 *
 */
public class Const {
	
	//患者个人信息表名
	public static final String PERSONTABLE = "personInfo";
	
	//存放Properties 文件路径
	public static final String Properties_file_Path = "Properties.Properties";
	
	//从properties 得到 port 的 键值
	public static final String PORT = "port";
	
	//服务端默认监听端口
	public static final String DEFAULT_PORT = "7954";
	
	//输出数组
	public static void opArray(Object[] arr)
	{
		op("the array is "+arr.getClass());
		for(int i=0;i<arr.length;i++)
		{
			op(""+arr[i]);
		}
	}
	
	public static void op(String info)
	{
		System.out.println(info);
	}
	
	
}
