<%@include file="WEB-INF/jspf/directives/page.jspf"%>
<html>
<%@include file="WEB-INF/jspf/head.jspf"%>

<body class="homepage">
    <div class="wrapper style1">

         <%@include file="/WEB-INF/jspf/header.jspf"%>
         
        <div class="wrapper style2"> 
            <section class="container">
                <div class="row err_mess">
                    ${requestScope.message}
                </div>
            </section>
        </div>
     <%@include file="/WEB-INF/jspf/footer.jspf"%>
    </div>
</body>
</html>



