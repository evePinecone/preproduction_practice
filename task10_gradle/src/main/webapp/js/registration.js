function validateFields() {
    var string = document.getElementsByClassName("form__item");
    var regexp = [/^\w{3,}$/, /^[A-z0-9._-]+@[A-z0-9.-]+\.[A-z]{2,4}$/, /^\+\d{9,12}$/, /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/g, /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/g];
    var flag = true;

    for (let i = 1; i < string.length; i++) {
        stringChildren = string[i].firstElementChild;
        if (!regexp[i].test(stringChildren.value)) {
            if (stringChildren.className !== 'invalid') {
                stringChildren.classList.add('invalid');
            }
            if (stringChildren.name === "password")
                string[i].children[1].innerHTML = "Invalid password. " + checkPwd(stringChildren.value);
            flag = false;
        } else {
            stringChildren.classList.remove('invalid');
        }
    }
    return flag;
}

function checkPwd(str) {
    if (str.length < 9) {
        return ("It's too short");
    } else if (str.length > 50) {
        return ("It's too long");
    } else if (!/(?=.*[a-z])/.test(str)) {
        return ("The string must contain at least 1 lowercase alphabetical character");
    } else if (!/(?=.*[A-Z])/.test(str)) {
        return ("The string must contain at least 1 uppercase alphabetical character");
    } else if (!/(?=.*[0-9])/.test(str)) {
        return ("he string must contain at least 1 numeric character");
    } else if (str.search(/[^a-zA-Z0-9\!\@\#\$\%\^\&\*\(\)\_\+]/) != -1) {
        return ("Bad chars in.");
    }
    return ("");
}

window.onload = function() {
    var form = $("#form1");
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