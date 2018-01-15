$(document).ready(function () {
    var validation = {

        phone: function () {
            var phoneRegExp = /^\+\d{9,12}$/;
            if (!phoneRegExp.test($("input[name='phone']").val())) {
                // $("input[name='phone']").addClass('invalid');
                return false;
            } else {
                // $("input[name='phone']").removeClass('invalid');
                return true;
            }
        },
        password: function () {
            var passwordRegExp = /^.{8,}$/;
            if (!passwordRegExp.test($("input[name='password']").val())) {
                // $("input[name='password']").addClass('invalid');
                // $('#password_')[0].innerHTML = check($("input[name='password_confirm']").val());
                return false;
            } else {
                // $("input[name='password']").removeClass('invalid');
                return true;
            }
        },
    };

    $('#phone').blur(validation.phone);

    $('#password').blur(validation.password);

    $("#submit").click(function (event) {
        if ( validation.phone()  === true
            && validation.password()  === true) {
            return true;
        }
        alert("fields are incorrect");
        event.preventDefault();
    });
});