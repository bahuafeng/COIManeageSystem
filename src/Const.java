
/**
 * ����ౣ��һЩ����
 * ����˵ÿ�ű�ı���
 * @author Zhou
 *
 */
public class Const {
	
	//���߸�����Ϣ����
	public static final String PERSONTABLE = "personInfo";
	
	//���Properties �ļ�·��
	public static final String Properties_file_Path = "Properties.Properties";
	
	//��properties �õ� port �� ��ֵ
	public static final String PORT = "port";
	
	//�����Ĭ�ϼ����˿�
	public static final String DEFAULT_PORT = "7954";
	
	//�������
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
