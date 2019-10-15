package com.sia.java.homework.java_2019_03_26.javaday35homework_company;

public class Run {

    public static void main(String[] args) {
        ManageDeparment md = new ManageDeparment();

        // 添加部门
        md.addDepart("001","财务部");
        md.addDepart("002","设计部");
        md.addDepart("003","销售部");
        for ( Department d: Department.departments ) System.out.println(d.getDepartmentName());

        ManageEmployee me = new ManageEmployee();

        // 每个部门添加两个员工
        me.add(1001,"虎子","1990-09-19","男",10000F,"设计部");
        me.add(1002,"小虎","1990-09-19","男",10000F,"设计部");
        me.add(2001,"小敏","1990-09-19","女",10000F,"财务部");
        me.add(2002,"小绿","1990-09-19","女",10000F,"财务部");
        me.add(3001,"小张","1990-09-19","男",10000F,"销售部");
        me.add(3002,"小李","1990-09-19","男",10000F,"销售部");

        // 计算设计部所有员工的薪资总和
        Employee[] emp = md.checkDepart("设计部");
        int sum = 0;
        for ( int i=0; i<emp.length; i++) {
            sum += emp[i].geteSalary();
        }
        System.out.println( "设计部的全部员工的薪资为：" + sum );

        // 撤销“设计部”
        md.delDepart("财务部");
        for ( Department d: Department.departments ) System.out.println(d.getDepartmentName());
        me.leaveCompany(1001);
        for ( Employee e: Employee.employees ) System.out.println(e.geteName());

        // 所有姓张员工的信息
        for ( int i=0; i<Employee.employees.length; i++ ) {
            if ( "张".equals(Employee.employees[i].geteName().charAt(0))) {
                Employee e = Employee.employees[i];
                System.out.printf("姓名：%s, 员工ID：%d, 性别：%s, 生日：%s, 部门%s, 薪资：%f",e.geteName(),e.geteID(),
                        e.geteSex(),e.geteBirth(),e.geteDepartment(),e.geteSalary());
            }
        }
        int countM =0,countF = 0;
        for ( int i=0; i<Employee.employees.length; i++ ) {
            if ( "女".equals(Employee.employees[i].geteSex()) ) {
                countF++;
            }
            else countM++;
        }
        System.out.println("公司有男性人数为：" + countM + "人。  女性人数为：" + countF + "人。");


        // 销售部的人数
        for ( int i=0; i<Department.departments.length; i++ ) {
            if ( "销售部".equals(Department.departments[i].getDepartmentName())) {
                System.out.println(Department.departments[i].getDepartmentCount());
                break;
            }
        }

        // 给所有工资在12000元以下的员工涨薪1000元
        for ( int i=0; i<Employee.employees.length; i++ ) {
            if ( Employee.employees[i].geteSalary()<12000 )
                Employee.employees[i].seteSalary( Employee.employees[i].geteSalary() + 1000);
        }
        for ( Employee e:Employee.employees ) System.out.println(e.geteSalary());
    }
}
