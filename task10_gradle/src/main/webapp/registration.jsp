<%@include file="/WEB-INF/jspf/directives/page.jspf"%>

<!DOCTYPE HTML>
<html>
<%@include file="WEB-INF/jspf/head.jspf"%>

<body class="homepage">
    <div class="wrapper style1">

        <%@include file="/WEB-INF/jspf/header.jspf"%>
     
        <!-- Field registration -->
        <div class="wrapper style2"> 
            <section class="container">
                <div class="row double">
                    <div class="6u">
                         <form id="registration_form" action="registration" name="registrationForm" method="POST" enctype="multipart/form-data">
                            <header class="major">
                                <h2 class="">Registration</h2>
                                <span class="byline"></span>
                            </header>
                            <div class="form__item">
                                <input id="name" name="name" placeholder="Name" type="text" title="Enter your name" value="${sessionScope.name}"/>
                                <div class="invalid_input">Invalid name</div>
                            </div>
                            <div class="form__item">
                                <input id="email" name="email" placeholder="Email" type="email" value="${sessionScope.email}"/>
                                <div class="invalid_input">Invalid email</div>
                            </div>
                            <div class="form__item">
                                <input id="phone" name="phone" placeholder="Phone number" type="text" value="${sessionScope.phone}"></input>
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
                            <div class="form__item">
                                <input id="avatar" name="avatar" placeholder="image" type="file" accept="image/jpeg,image/png"/>
                            </div>
                            <div class="form__item">
                                <cpt:Captcha />
                            </div>
                            <ul class="actions">
                                <li><input id="submit" type="submit" class="special" value="Submit" /></li>
                                <li><input href="#" type="reset" class="alt" value="Reset" /></li>
                            </ul>
                            <div class="invalid_input">
                             ${sessionScope.err_mess}
                            </div>
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
