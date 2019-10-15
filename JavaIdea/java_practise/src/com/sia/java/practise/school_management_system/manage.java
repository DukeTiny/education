package com.sia.java.practise.school_management_system;


public class manage {
    public static void main(String[] args) {
    StudentInformation stuInfo = new StudentInformation();
    stuInfo.userInfo.add(new StudentInformation("John","男",20,12));
    for ( int i=0; i<stuInfo.userInfo.size(); i++ ){
        System.out.print(stuInfo.userInfo.get(i).getId()+"  ");
        System.out.print(stuInfo.userInfo.get(i).getName()+"  ");
        System.out.print(stuInfo.userInfo.get(i).getAge()+"  ");
        System.out.print(stuInfo.userInfo.get(i).getSex()+"  ");
        System.out.print(stuInfo.userInfo.get(i).getClassId()+"  ###  ");
    }
    System.out.println();

    stuInfo.userInfo.get(1).setClassId(9);
    for ( int i=0; i<stuInfo.userInfo.size(); i++ ){
        System.out.print(stuInfo.userInfo.get(i).getId()+"  ");
        System.out.print(stuInfo.userInfo.get(i).getName()+"  ");
        System.out.print(stuInfo.userInfo.get(i).getAge()+"  ");
        System.out.print(stuInfo.userInfo.get(i).getSex()+"  ");
        System.out.print(stuInfo.userInfo.get(i).getClassId()+"  ###  ");
    }
    System.out.println();
    stuInfo.userInfo.remove(stuInfo.userInfo.get(2));
    for ( int i=0; i<stuInfo.userInfo.size(); i++ ){
        System.out.print(stuInfo.userInfo.get(i).getId()+"  ");
        System.out.print(stuInfo.userInfo.get(i).getName()+"  ");
        System.out.print(stuInfo.userInfo.get(i).getAge()+"  ");
        System.out.print(stuInfo.userInfo.get(i).getSex()+"  ");
        System.out.print(stuInfo.userInfo.get(i).getClassId()+"  ###  ");
    }



    }
}
