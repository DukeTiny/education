<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8" />
</head>
<body>
    <fieldset>
        <legend>普通数据类型</legend>
        <form action="user/f1.do" method="post">
            byte:<input name="b"/><br />
            short:<input name="s"/><br />
            int:<input name="i"/><br />
            long:<input name="l"/><br />
            float:<input name="f"/><br />
            double:<input name="d"/><br />
            boolean:<input name="bb"/><br />
            char:<input name="c"/><br />
            <button>Go</button>
        </form>
    </fieldset>

    <fieldset>
        <legend>String数据类型</legend>
        <form action="user/f2.do" method="post">
            username:<input name="username"/><br />
            password:<input name="password"/><br />
            <button>Go</button>
        </form>
    </fieldset>

    <fieldset>
        <legend>引用数据类型</legend>
        <form action="user/f3.do" method="post">
            id:<input name="id"/><br />
            name:<input name="name"/><br />
            birthday:<input name="birthday"/><br />
            money:<input name="money"/><br />
            <button>Go</button>
        </form>
    </fieldset>

    <fieldset>
        <legend>数组类型</legend>
        <form action="user/f4.do" method="get">
            hobby:
            <input type="checkbox" name="hobby" value="球1"/>球1
            <input type="checkbox" name="hobby" value="球2"/>球2
            <input type="checkbox" name="hobby" value="球3"/>球3
            <button>Go</button>
        </form>
    </fieldset>

    <fieldset>
        <legend>List类型</legend>
        <form action="user/f5.do" method="get">
            hobby:
            <input type="checkbox" name="hobby" value="球1"/>球1
            <input type="checkbox" name="hobby" value="球2"/>球2
            <input type="checkbox" name="hobby" value="球3"/>球3
            <button>Go</button>
        </form>
    </fieldset>

    <fieldset>
        <legend>Set类型</legend>
        <form action="user/f6.do" method="get">
            hobby:
            <input type="checkbox" name="hobby" value="1"/>球1
            <input type="checkbox" name="hobby" value="2"/>球2
            <input type="checkbox" name="hobby" value="3"/>球3
            <button>Go</button>
        </form>
    </fieldset>


    <fieldset>
        <legend>Map类型</legend>
        <form action="user/f7.do" method="get">
            hobby:
            <input type="checkbox" name="hobby" value="1+"/>球1
            <input type="checkbox" name="hobby" value="2+"/>球2
            <input type="checkbox" name="hobby" value="3+"/>球3
            <button>Go</button>
        </form>
    </fieldset>

</body>
</html>
