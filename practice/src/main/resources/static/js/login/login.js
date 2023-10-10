let id = $("#identification"); // input id 변수
let idErrorMsg = $(".id-error"); // error msg 변수
let password = $("#password"); // input password 변수
let passwordErrorMsg = $(".password-error"); // error msg 변수
let check = [false, false]; // 전부 입력했는지 검사 위함

// 아이디 입력했는지 검사
id.blur(() => {
    if(id.val()){
        idErrorMsg.css("display", "none");
        check[0] = true;
    }else {
        check[0] = false;
        idErrorMsg.css("display", "block");
    }
    inputCheck(check);
});

// 비밀번호 입력했는지 검사
password.blur(() => {
    if(password.val()){
        passwordErrorMsg.css("display", "none");
        check[1] = true;
    }else {
        check[1] = false;
        passwordErrorMsg.css("display", "block");
    }
    inputCheck(check);
});


// 아이디, 비밀번호 전부 입력했는지 검사
function inputCheck(check){
    check[0]  && check[1] ? $(".login-button").css("background-color", "#cfbaf0") : $(".login-button").css("background-color", "#8eecf5");
}