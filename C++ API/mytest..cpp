#include <iostream>
#include <cstdio>
#include <vector>

using namespace std;

#include "local_fun.h"

int main()
{
    Person_info p = get_p();
    p.print();
    Medical_info m = get_m();
    m.print();
    vector<Medical_info> ml = get_period_medical_info(12,(char*)"1956-65-85",NULL);
    cout<<ml.size()<<endl;
    vector<Person_info> pl = get_person_by_stu();
    cout<<pl.size()<<endl;
    return 0;
}
