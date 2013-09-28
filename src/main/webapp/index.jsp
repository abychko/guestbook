<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<div style="text-align: center;">

    <h2><a href="/guestbook">My Guestbook</a></h2>

</div>
<div style="text-align: center;">
    <form action="/post" method="POST">
        Leave your message here: <input type="text" name="message">
        <input type="submit" value="Отправить"/>
    </form>
</body>
</html>
