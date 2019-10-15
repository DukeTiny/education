<%--
  Created by IntelliJ IDEA.
  User: duke_tiny
  Date: 2019/5/10
  Time: 09:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <title>$Title$</title>
      <script src="https://cdn.bootcss.com/jquery/3.4.1/jquery.js"></script>
    <script>
        $(document).ready(function () {
            var year = $("#year");
            var month = $("#month");
            var d = $("#date");
            var yearnum = new Date().getFullYear();
            for ( var i=yearnum; i>=1980; i-- ){
                var opObj = $("<option></Option>");
                opObj.val(i);
                opObj.html(i);
                year.append(opObj);
            }
            for ( var j=1; j<=12; j++ ){
                var monthOpObj = $("<option></option>");
                monthOpObj.val(j);
                monthOpObj.html(j);
                month.append(monthOpObj);
            }
            for ( var k=1; k<=31; k++ ){
                var dateOpObj = $("<option></Option>");
                dateOpObj.val(k);
                dateOpObj.html(k);
                d.append(dateOpObj);
            }
            function changeEvent() {
                var selectYear = year.val();
                var selectDate = month.val();
                var calDate = new Date(selectYear,selectDate,0).getDate();
                d.empty();
                for( var l=1; l<=calDate; l++ ){
                    var dayOpObj = $("<option></option>");
                    dayOpObj.val(l);
                    dayOpObj.html(l);
                    d.append(dayOpObj);
                }
            }
            month.change(function () {
                changeEvent();
            });
            year.change(function () {
                changeEvent();
            });
            // check input id number;
            var empNo = /^\d{1,4}$/;
            function checkID(){
                var idRight = empNo.test($("[name=empno]").val());
                var idContent = (idRight?"<font color='green'>Right</font>":"<font color='red'>WRONG<font>");
                $("[name=empno]").parent().next().html(idContent);
                return idRight;
            }
            $("[name=empno]").bind('input propertychange',function () {checkID()});
            // check input employee name
            var eName = /^\w{8,16}$/;
            function checkName(){
                var nameRight = eName.test($("[name=ename]").val());
                var nameContent = (nameRight?"<font color='green'>Right</font>":"<font color='red'>WRONG<font>");
                $("[name=ename]").parent().next().html(nameContent);
                return nameRight;
            }
            $("[name=ename]").bind('input propertychange',function () {checkName();});
            // check employee job
            var job =/^[a-zA-z1-9]{4,20}$/;
            function checkJob() {
                var jobRight = job.test($("[name=job]").val());
                var jobContent = (jobRight?"<font color='green'>Right</font>":"<font color='red'>WRONG<font>");
                $("[name=job]").parent().next().html(jobContent);
                return jobRight;
            }
            $("[name=job]").bind('input propertychange',function () {checkJob();});
            // check salary right or not
            var sal = /^[123]\d{3,4}$/;
            function checkSal() {
                var salRight = sal.test($("[name=sal]").val());
                var salContent = (salRight?"<font color='green'>Right</font>":"<font color='red'>WRONG<font>");
                $("[name=sal]").parent().next().html(salContent);
                return salRight;
            }
            $("[name=sal]").bind('input propertychange',function () {checkSal();});
            // check bonus right
            var comm = /^[123]\d{3,4}$/;
            function checkComm() {
                var commRight = sal.test($("[name=comm]").val());
                var commContent = (commRight?"<font color='green'>Right</font>":"<font color='red'>WRONG<font>");
                $("[name=comm]").parent().next().html(commContent);
                return commRight;
            }
            $("[name=comm]").bind('input propertychange',function () {checkComm();});

            $("#myForm").submit(function () {
                return checkComm()&&checkJob()&&checkName()&&checkID()&&checkSal();
            });


        });
    </script>
  </head>
  <body>
        <form action="/empServlet.do?method=confirmAddEmp" method="post" id="myForm">
        <table width="600" align="center" border="1" cellspacing="0" cellpadding="5" bordercolor="gray">
                <tr align="center">
                    <th width="80">员工ID</th>
                    <td width="300"><input type="text" name="empno" /></td>
                    <td></td>
                </tr>
                <tr align="center">
                    <th width="80">员工姓名</th>
                    <td><input type="text" name="ename"/></td>
                    <td></td>
                </tr>
                <tr align="center">
                    <th width="80">职位</th>
                    <td><input type="text" name="job"/></td>
                    <td></td>
                </tr>
                <tr align="center">
                    <th width="80">领导</th>
                    <td>
                        <select name="mgr">
                            <c:forEach var="emp" items="${requestScope.emps}" >
                                <c:forEach var="emp2" items="${requestScope.emps}">
                                 <c:if test="${emp2.empno==emp.mgr}">
                                      <option value="${emp2.empno}">${emp2.ename}</option>
                                 </c:if>
                                 </c:forEach>
                            </c:forEach>
                        </select>
                    </td>
                    <td></td>
                </tr>
                <tr align="center">
                    <th width="80">入职日期</th>
                    <td>
                        <select id="year" name="hiredate"></select> 年&nbsp;
                        <select id="month" name="hiredate"></select> 月&nbsp;
                        <select id="date" name="hiredate"></select> 日
                    </td>
                    <td></td>
                </tr>
                <tr align="center">
                    <th width="80">薪水</th>
                    <td><input type="text" name="sal"/></td>
                    <td></td>
                </tr>
                <tr align="center">
                    <th width="80">奖金</th>
                    <td><input type="text" name="comm"/></td>
                    <td></td>
                </tr>
                <tr align="center">
                    <th width="80">部门号</th>
                    <td>
                        <select id="deptno" name="deptno">
                            <c:forEach var="dept" items="${requestScope.depts}">
                                <option>${dept.deptno}</option>
                            </c:forEach>
                        </select>
                    </td>
                    <td></td>
                </tr>
                <tr align="center">
                    <th colspan="3">
                        <button>提交</button>
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <button type="reset">重置</button></th>
                </tr>
        </table>
        </form>
  </body>
</html>
