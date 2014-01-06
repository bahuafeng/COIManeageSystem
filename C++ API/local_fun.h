/**
*   +------------------------------+
*   |说明:前端界面测试用API 版本  |
*   |如果需要更多样化数据, 可以
*   |自己在函数里面构造一下来测试
*   |前端代码.
*   +------------------------------+
*   |使用要求:请务必在包含本库的
*   |前面包含 <vector>    和使用
*   |命名空间   STD
*   +------------------------------+
*   |作者: 周金宇
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
    //测试用构造函数
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
测试用函数
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
个人信息管理相关函数
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
个人住院信息相关函数
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
