<%@include file="/WEB-INF/jspf/directives/page.jspf"%>
<html>
    <form action="login" method="POST">
        <input type="text" id="login" name="login" placeholder="Login" />
        <input type="text" id="password" name="password" placeholder="Password" />
        <input id="submit" type="submit" class="special" value="Submit" />
        <div class="err_mess">
            ${sessionScope.err_mess}
        </div>
    </form>
</html> 