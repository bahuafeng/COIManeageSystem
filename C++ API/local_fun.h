/**
*   +------------------------------+
*   |˵��:ǰ�˽��������API �汾  |
*   |�����Ҫ������������, ����
*   |�Լ��ں������湹��һ��������
*   |ǰ�˴���.
*   +------------------------------+
*   |ʹ��Ҫ��:������ڰ��������
*   |ǰ����� <vector>    ��ʹ��
*   |�����ռ�   STD
*   +------------------------------+
*   |����: �ܽ���
*   |zhoujinyu0713@gmail.com       |
*   +------------------------------+
******************/


#ifndef LOCAL_FUN_H_INCLUDED
#define LOCAL_FUN_H_INCLUDED

struct Person_info
{
	int id;
    char* name;
    char sex;
    int age;
    char* id_card_num;
    char* mar_stu;
    char* edu_stu;
    char* photo_addr;
    //�����ù��캯��
    Person_info()
    {
        id= 12;
        name = (char*)"nihao";
        sex = 'D';
        age = 34;
    }
    void print()
    {
        cout<<id<<" "<<name<<" "<<sex<<" "<<age<<endl;
    }
};
struct Medical_info
{
	int person_id;
    int medical_num;
    char dignose;
    char* place;
    int danger_level;
    char* danger_desc;
    char cure_meth;
    double in_panss;
    double out_panss;
    char* wtgo;
    Medical_info()
    {
        person_id = 12;
        medical_num = 2;
        dignose = 'S';
        place = (char*)"zhoujinyu";
    }
    void print()
    {
        cout<<person_id<<" "<<medical_num<<" "<<dignose<<" "<<place<<endl;
    }
 };

/**
�����ú���
*/
Person_info get_p()
{
    Person_info p ;
    return p;
}
Medical_info get_m()
{
    Medical_info m ;
    return m;
}

/**
������Ϣ������غ���
*/
int create_person_info(Person_info person)
{
    return 1;
}
bool update_person_info(int person_id,Person_info info)
{
    return false;
}
Person_info get_person_by_id(int person_id)
{
    Person_info p ;
    return p;
}
vector<Person_info> get_person_by_stu()
{
    vector<Person_info> pl ;
    return pl;
}

/**
����סԺ��Ϣ��غ���
*/
bool create_medical_info(int person_id,Medical_info info)
{
    return false;
}
bool update_medical_info(int person_id,Medical_info info)
{
    return false;
}
Medical_info get_medical_info(int person_id)
{
    Medical_info m;
    return m;
}
vector<Medical_info> get_history_medical_info(int person_id)
{
    vector<Medical_info> m;
    return m;
}
vector<Medical_info> get_period_medical_info(int person_id,char* start_date,char* end_date)
{
    return get_history_medical_info(12);
}



#endif // LOCAL_FUN_H_INCLUDED
