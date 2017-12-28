<%@include file="/WEB-INF/jspf/directives/page.jspf"%>

<!DOCTYPE HTML>
<html>
<%-- <%@include file="/WEB-INF/jspf/head.jspf"%> --%>

 <head>
    <title>PineconeEve shop</title>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <meta name="description" content="" />
    <meta name="keywords" content="" />
    <script src="js/jquery.min.js"></script>
    <script src="js/jquery.dropotron.min.js"></script>
    <script src="js/skel.min.js"></script>
    <script src="js/skel-layers.min.js"></script>
    <script src="js/init.js"></script>
    <noscript>
			<link rel="stylesheet" href="css/skel.css" />
			<link rel="stylesheet" href="css/style.css" />
		</noscript>
    <!--[if lte IE 8]><link rel="stylesheet" href="css/ie/v8.css" /><![endif]-->
</head>

<body class="homepage">
    <div class="wrapper style1">

        <%@include file="/WEB-INF/jspf/header.jspf"%>
     
        <!-- Field registration -->
        <div class="wrapper style2"> 
            <section class="container">
                <div class="row double">
                    <div class="6u">
                         <form id="registration_form" action="controller" name="registrationForm" method="POST">
                            <header class="major">
                                <h2 class="">Registration</h2>
                                <span class="byline"></span>
                            </header>
                            <div class="form__item">
                                <input id="name" name="name" placeholder="Name" type="text" title="Enter your name" />
                                <div class="invalid_input">Invalid name</div>
                            </div>
                            <div class="form__item">
                                <input id="email" name="email" placeholder="Email" type="email" />
                                <div class="invalid_input">Invalid email</div>
                            </div>
                            <div class="form__item">
                                <input id="phone" name="phone" placeholder="Phone number" type="text"></input>
                                <div class="invalid_input">Invalid phone simple "+3801112223"</div>
                            </div>
                            <div class="form__item">
                                <input id="password" name="password" placeholder="Password" type="password" />
                                <div id="password_" class="invalid_input">Invalid password</div>
                            </div>
                            <div class="form__item">
                                <input id="password_confirm" name="password_confirm" placeholder="Confirm password" type="password" />
                                <div id="password_confirm_" class="invalid_input">Invalid password</div>
                            </div>

                            <ul class="actions">
                                <li><input id="submit" type="submit" class="special" value="Submit" /></li>
                                <li><input href="#" type="reset" class="alt" value="Reset" /></li>
                            </ul>
                        </form>
                    </div>
                    <!-- </form> -->
                    <!-- <div class="6u">
                        <h2>SOME another information</h2>
                    </div> -->
                </div>
            </section>
        </div>

        <!-- Footer -->
        <%@include file="/WEB-INF/jspf/footer.jspf"%>
    </div>
    <script src="js/registration_jq.js"></script>
</body>
</html>
