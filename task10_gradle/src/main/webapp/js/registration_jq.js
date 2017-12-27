window.onload = function() {
    var form = $("#registration_form");
    form.submit(function(event) {
        var error = false;
        var emailRegExp = /^[A-z0-9._-]+@[A-z0-9.-]+\.[A-z]{2,4}$/;
        var nameRegExp = /\w{3,}/;
        var phoneRegExp = /\+\d{9,12}/;
        var passwordRegExp = /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/;

        if (!nameRegExp.test($("input[name='name']").val())) {
            $("input[name='name']").addClass('invalid');
            error = true;
        } else {
            $("input[name='name']").removeClass('invalid');
        }
        if (!phoneRegExp.test($("input[name='phone']").val())) {
            $("input[name='phone']").addClass('invalid');
            error = true;
        } else {
            $("input[name='phone']").removeClass('invalid');
        }
        if (!emailRegExp.test($("input[name='email']").val())) {
            $("input[name='email']").addClass('invalid');
            error = true;
        } else {
            $("input[name='email']").removeClass('invalid');
        }

        if (!passwordRegExp.test($("input[name='password']").val())) {
            $("input[name='password']").addClass('invalid');
            error = true;
        } else {
            $("input[name='password']").removeClass('invalid');
        }
        if (!passwordRegExp.test($("input[name='password_confirm']").val())) {
            $("input[name='password_confirm']").addClass('invalid');
            error = true;
        } else {
            $("input[name='password_confirm']").removeClass('invalid');
        }
        if ($("input[name='password']").val() !== $("input[name='password_confirm']").val()) {
            $("input[name='password_confirm']").addClass('invalid');
            error = true;
        }

        if (!error) {
            return;
        }
        event.preventDefault();
    });
};