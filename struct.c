#include<iostream>
#include<cstdio>
#include<cstring>
#include<vector>
#include<algorithm>
#include<map>
#include<cstdlib>
using namespace std;


struct person_info
{
    char* name;
    char sex;
    int age;
    char* id_card_num;
    char* mar_stu;
    char* edu_stu;
    char* photo_addr;
}

struct Medical_info
{
    int medical_num;
    char* in_date;
    char dignose;
    char* place;
    int danger_level;
    char* danger_desc;
    char cure_meth;
    double in_panss;
    char* out_date;
    double out_panss;
    char* wtgo;
    int med_stu;
}
