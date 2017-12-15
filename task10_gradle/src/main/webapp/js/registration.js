
function validateName() {
    var qwe = document.getElementById("1");
    var string = document.getElementsByName("name").item(1);
    var regexp = /\w+/
    if(regexp.test(string)) {
        alert("Чемпион да? а если проверю!?");
        return false;
    }
    alert("qweqwe")
}

function validateNumber() {
    var string = document.getElementsByName("phone");
    var regexp = /\D/
    if(string.equals(regexp)) {
        alert("");
        return false;
    }
    return string.replace(regexp);
}