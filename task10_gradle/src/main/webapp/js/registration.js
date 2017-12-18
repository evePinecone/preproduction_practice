window.onload = (function() {
    var form = $("#form1");
    form.submit(function(event) {
    var string = document.getElementsByClassName("form__item");
    var regexp = [/^\w{3,}$/, /^[A-z0-9._-]+@[A-z0-9.-]+\.[A-z]{2,4}$/, /^\+\d{9,12}$/, /(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/g, /^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.{8,})/g];
    var flag = true;

    for (let i = 0; i < string.length; i++) {
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
});
    });

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


// file:///C:/Users/Roman_Lutsenko/preproduction_practice/preproduction_practice/task10_gradle/src/main/webapp/registration.html