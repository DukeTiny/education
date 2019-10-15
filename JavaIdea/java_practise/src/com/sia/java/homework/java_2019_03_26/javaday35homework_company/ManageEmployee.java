package com.sia.java.homework.java_2019_03_26.javaday35homework_company;

public class ManageEmployee {

    public void add(int eID,String eName,String eBirth,String eSex,float eSalary,String eDepartment){

        boolean findDepart = false;

        for (int i=0; i<Department.departments.length; i++)
            if ( eDepartment.equals( Department.departments[i].getDepartmentName() ) )
                findDepart = true;

        if ( findDepart ) {
            Employee addEmployee = new Employee( eID,eName,eBirth,eSex,eSalary,eDepartment);
            Employee[] tempEmployee = new Employee[Employee.employees.length+1];
            for ( int i=0; i<Employee.employees.length; i++)
                tempEmployee[i] = Employee.employees[i];
            tempEmployee[tempEmployee.length-1] = addEmployee;
            Employee.employees = tempEmployee;

            // 部门员工人数增加
            for ( int i=0; i<Department.departments.length; i++ )
                if ( Department.departments[i].getDepartmentName().equals(eDepartment) ){
                    Department.departments[i].setDepartmentCount( Department.departments[i].getDepartmentCount() + 1 );
                    break;
                }
        }
        else System.out.println("部门不存在");
    }

    public void leaveCompany ( int eID ) {
        int index = -1;
        String tempDepart = "";
        for ( int i=0; i<Employee.employees.length; i++ )
            if ( eID == Employee.employees[i].geteID()){
                index = i;
                tempDepart = Employee.employees[i].geteDepartment();
            }

        if ( index !=-1 ){
            Employee[] tempEmployee = new Employee[Employee.employees.length-1];
            for ( int i=0; i<Employee.employees.length; i++) {
                if ( i<index ) tempEmployee[i] = Employee.employees[i];
                if ( i>index ) tempEmployee[i-1] = Employee.employees[i];
            }
            Employee.employees = tempEmployee;
            System.out.println("员工删除成功");
            for ( int i=0; i<Department.departments.length; i++ )
                if ( Department.departments[i].getDepartmentName().equals(tempDepart) ){
                    Department.departments[i].setDepartmentCount( Department.departments[i].getDepartmentCount() - 1 );
                    break;
                }
        }
        else System.out.println("员工ID不存在");
    }

    public void updateSalary(int eId,float salary){
        for ( int i=0; i<Employee.employees.length; i++ ) {
            if ( eId==Employee.employees[i].geteID()){
                Employee.employees[i].seteSalary( Employee.employees[i].geteSalary() + salary);
                System.out.println("更改成功。");
                break;
            }
        }
    }

    public void checkEmp( int eId ) {
        int index = -1;
        for ( int i=0; i<Employee.employees.length; i++) {
            if ( eId == Employee.employees[i].geteID() )
                index = i;
        }
        if ( index!=-1 ) {
            Employee e = Employee.employees[index];
            System.out.printf("姓名：%s, 员工ID：%d, 性别：%s, 生日：%s, 部门%s, 薪资：%f",e.geteName(),e.geteID(),
                             e.geteSex(),e.geteBirth(),e.geteDepartment(),e.geteSalary());
        }
        else System.out.println("员工信息不存在,可能是员工ID输入错误");
    }

    public void checkDepart( String department ) {
        checkDepart( department );
    }

    public void checkAll () {
        for ( int j=0; j<Department.departments.length; j++)
            System.out.println("以下是" + Department.departments[j].getDepartmentName() + "部门");
            for ( int i=0; i<Employee.employees.length; i++ )
                if ( Department.departments[i].getDepartmentName().equals(Employee.employees[i].geteDepartment())){
                    Employee e = Employee.employees[i];
                    System.out.printf("姓名：%s, 员工ID：%d, 性别：%s, 生日：%s, 部门%s, 薪资：%f \n",e.geteName(),e.geteID(),
                            e.geteSex(),e.geteBirth(),e.geteDepartment(),e.geteSalary());
                }
    }


}
