package com.sia.java.homework.java_2019_03_26.javaday35homework_company;

public class ManageDeparment {

    private static final String companyName = "神奇广大";
    private static String president = "王虎";

    public void addDepart( String departmentID,String departmentName ){
        int len = Department.departments.length;
        Department[] tempDepart = new Department[len+1];
        for (int i=0; i<len; i++) {
            tempDepart[i] = Department.departments[i];
        }
        tempDepart[len] = new Department( departmentID,departmentName );
        Department.departments = tempDepart;
        System.out.println( departmentName + "部门建立成功。");
    }
    public void delDepart( String departmentName ){
        Department[] departments = Department.departments;
        Department[] tempDepart = new Department[departments.length-1];
        int index = -1;
        for ( int i=0; i<departments.length; i++)
            if ( departmentName.equals( departments[i].getDepartmentName() ) ){
                index = i;
                break;
            }
        if ( index!=-1 ) {
            for (int i = 0; i < departments.length; i++) {
                if ( i<index ) tempDepart[i] = departments[i];
                if ( i>index ) tempDepart[i-1] = departments[i];
            }
            Department.departments = tempDepart;
            System.out.println( departmentName + "部门撤销成功。");
        }
        else System.out.println("部门不存在");
    }
    public Employee[] checkDepart( String department ) {
        Employee[] temp1 = new Employee[0];
        for ( int i=0; i<Employee.employees.length; i++ ){
            Employee[] temp2 = new Employee[temp1.length+1];
            if ( department.equals( Employee.employees[i].geteDepartment()) ){
                System.out.println(temp2.length);
                for ( int j=0; j<temp1.length; j++ )
                    temp2[j] = temp1[j];
                temp2[temp2.length-1] = Employee.employees[i];
                temp1 = temp2;
                System.out.println(temp1.length);
            }
        }
        return temp1;
    }

}
