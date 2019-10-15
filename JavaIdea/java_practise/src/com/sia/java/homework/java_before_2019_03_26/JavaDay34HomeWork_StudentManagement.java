package com.sia.java.homework.java_before_2019_03_26;


public class JavaDay34HomeWork_StudentManagement {


        JavaDay34HomeWork_StudentInfo stuInfo = new JavaDay34HomeWork_StudentInfo();

    public static void main(String[] args) {
        JavaDay34HomeWork_StudentManagement manage = new JavaDay34HomeWork_StudentManagement();
        manage.enterASchool("王虎","27","男","5班");
        manage.enterASchool("马丁","22","男","3班");
        JavaDay34HomeWork_StudentInfo a = manage.stuInfo.stuInfos[0];
        System.out.println( a.getStuName() + a.getStuAge() + a.getSex() + a.getStuID() + a.getStuClass());
        manage.transfericlass(10000,"7班");
        System.out.println( a.getStuName() + a.getStuAge() + a.getSex() + a.getStuID() + a.getStuClass());
        manage.fireStu(10000);
        a = manage.stuInfo.stuInfos[0];
        System.out.println( a.getStuName() + a.getStuAge() + a.getSex() + a.getStuID() + a.getStuClass());

    }

    public void enterASchool(String stuName,String stuAge,String stuSex,String stuClass) {

        JavaDay34HomeWork_StudentInfo newStuInfo = new JavaDay34HomeWork_StudentInfo();
        newStuInfo.setStuName(stuName);
        newStuInfo.setStuAge(stuAge);
        newStuInfo.setSex(stuSex);
        newStuInfo.setStuClass(stuClass);
        newStuInfo.setStuID((10000+stuInfo.stuInfos.length));

        JavaDay34HomeWork_StudentInfo[] tempStu = new JavaDay34HomeWork_StudentInfo[stuInfo.stuInfos.length+1];

        for ( int i=0; i<stuInfo.stuInfos.length; i++ ) {
            tempStu[i] = stuInfo.stuInfos[i];
        }
        tempStu[stuInfo.stuInfos.length] = newStuInfo;
        stuInfo.stuInfos = tempStu;
    }
    public void transfericlass( int stuID,String className) {
        int index = findStu( stuID );
        stuInfo.stuInfos[index].setStuClass( className );
    }

    public void fireStu( int stuID ){
        int index = findStu( stuID );
        JavaDay34HomeWork_StudentInfo[] tempStu = new JavaDay34HomeWork_StudentInfo[stuInfo.stuInfos.length-1];
        for ( int i=0; i<stuInfo.stuInfos.length; i++ ) {
            if ( i<index) tempStu[i] = stuInfo.stuInfos[i];
            if ( i>index ) tempStu[i-1] = stuInfo.stuInfos[i];
        }
        stuInfo.stuInfos = tempStu;
    }
    public int findStu ( int stuID ) {
        int index = -1;
        for ( int i=0; i<stuInfo.stuInfos.length; i++ ) {
            if ( stuInfo.stuInfos[i].getStuID()==(stuID)){
                index = i;
                break;
            }
        }
        return index;
    }
}
