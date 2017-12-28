$(document).ready(function () {
    var validation = {

        name: function () {
            var nameRegExp = /^\w{3,}$/;
            if (!nameRegExp.test($("input[name='name']").val())) {
                $("input[name='name']").addClass('invalid');
                return false;
            } else {
                $("input[name='name']").removeClass('invalid');
                return true;
            }
        },
        email: function () {
            var emailRegExp = /^[A-z0-9._-]+@[A-z0-9.-]+\.[A-z]{2,4}$/;
            if (!emailRegExp.test($("input[name='email']").val())) {
                $("input[name='email']").addClass('invalid');
                return false;
            } else {
                $("input[name='email']").removeClass('invalid');
                return true;
            }
        },
        phone: function () {
            var phoneRegExp = /^\+\d{9,12}$/;
            if (!phoneRegExp.test($("input[name='phone']").val())) {
                $("input[name='phone']").addClass('invalid');
                return false;
            } else {
                $("input[name='phone']").removeClass('invalid');
                return true;
            }
        },
        password: function () {
            var passwordRegExp = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/;
            if (!passwordRegExp.test($("input[name='password']").val())) {
                $("input[name='password']").addClass('invalid');
                $('#password_')[0].innerHTML = check($("input[name='password_confirm']").val());
                return false;
            } else {
                $("input[name='password']").removeClass('invalid');
                return true;
            }
        },
        password_confirm: function () {
            var passwordRegExp = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/;
            if ($("input[name='password_confirm']").val() !== $("input[name='password']").val()) {
                $("input[name='password_confirm']").addClass('invalid');
                $("#password_confirm_")[0].innerHTML = "Different passwords";
                return false;
            } else if (!passwordRegExp.test($("input[name='password_confirm']").val())) {
                $("input[name='password_confirm']").addClass('invalid');
                $('#password_confirm_')[0].innerHTML = check($("input[name='password_confirm']").val());
                return false;
            } else {
                $("input[name='password_confirm']").removeClass('invalid');
                return true;
            }
        }
    };

    $('#name').blur(validation.name);

    $('#email').blur(validation.email);

    $('#phone').blur(validation.phone);

    $('#password').blur(validation.password);

    $('#password_confirm').blur(validation.password_confirm);

    $("#submit").click(function (event) {
        if (validation.name() === true 
            && validation.email()  === true
            && validation.phone()  === true
            && validation.password()  === true
            && validation.password_confirm()  === true) {
            return true;
        }
        alert("fields are incorrect");
        event.preventDefault();
    });
});

var check = (function (str) {
    if (str.length < 9) {
        return ("It's too short");
    } else if (str.length > 50) {
        return ("It's too long");
    } else if (!/(?=.*[a-z])/.test(str)) {
        return ('The string must contain at least 1 lowercase alphabetical character');
    } else if (!/(?=.*[A-Z])/.test(str)) {
        return ('The string must contain at least 1 uppercase alphabetical character');
    } else if (!/(?=.*[0-9])/.test(str)) {
        return ('he string must contain at least 1 numeric character');
    } else if (str.search(/[^a-zA-Z0-9\!\@\#\$\%\^\&\*\(\)\_\+]/) != -1) {
        return ('Bad chars in.');
    }
    return ('');
});