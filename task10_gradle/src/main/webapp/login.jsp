<%@include file="/WEB-INF/jspf/directives/page.jspf"%>
<%@ taglib uri="/WEB-INF/tld/login.tld" prefix="log"%>
<!DOCTYPE HTML>
<html>
<%@include file="WEB-INF/jspf/head.jspf"%>
<body class="homepage">
    <div class="wrapper style1">
     <%@include file="/WEB-INF/jspf/header.jspf"%>
        <!-- Field login -->
        <div class="wrapper style2"> 
            <section class="container">
                <div class="row double">
                    <div class="6u">
        <log:Login/>
                    </div>
                </div>
            </section>
        </div>
        <script src="js/login.js"></script>
</body> 
</html> 