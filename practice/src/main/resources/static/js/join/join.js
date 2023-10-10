const nameErrorMsg = "이름을 입력해주세요";
const idErrorMsg = ["아이디를 입력해주세요.", "2-10자의 영문과 숫자만 입력가능합니다.","중복된 아이디입니다."];
const passwordErrorMsg = ["비밀번호를 입력해주세요", "영문과 숫자 조합의 8-20자의 비밀번호를 입력해주세요."];

let userName = $("#userName");
let	id = $("#identification");
let password = $("#password");
let passwordShowBtn = $(".password-show");
let passwordShowCheck = true;
let check = [false, false, false, false];

// 아이디 정규식 (2-10자의 영문과 숫자와 일부 특수문자(._-)만 입력 가능)
const regId = /^(?=.*[a-zA-Z])[-a-zA-Z0-9]{2,10}$/;

// 비밀번호 정규식(영문과 숫자 조합의 8-20자의 비밀번호)
const regPassword = /^(?=.*\d)(?=.*[a-zA-Z])[0-9a-zA-Z]{8,20}$/;


// 이름 검사
userName.blur(() => {
    if(userName.val()){
        $(".name-check").text("");
        check[0] = true;
    }else {
        $(".name-check").text(nameErrorMsg);
        check[0] = false;
    }
    inputCheck(check);
});

// 아이디 검사
id.blur(() => {
    if(!id.val()){
        $(".identification-check").text(idErrorMsg[0]);
        check[1] = false;
    }else if (!regId.test(id.val())){
        $(".identification-check").text(idErrorMsg[1]);
        check[1] = false;
    }else {
        $(".identification-check").text("");
        check[1] = true;
    }
    inputCheck(check);
});

// 비밀번호 검사
password.blur(() => {
    if(!password.val()){
        $(".pw-check").text(passwordErrorMsg[0]);
        check[2] = false;
    }else if(!regPassword.test(password.val())){
        $(".pw-check").text(passwordErrorMsg[1]);
        check[2] = false;
    }else {
        $(".pw-check").text("");
        check[2] = true;
    }
    inputCheck(check);
});

// 비밀번호 표시
passwordShowBtn.click(() => {
    if(passwordShowCheck){
        password.prop("type", "text");
        passwordShowBtn.text("숨김");
        passwordShowCheck = false;
    }else {
        password.prop("type", "password");
        passwordShowBtn.text("표시");
        passwordShowCheck = true;
    }
});

// 선택상자 ( 전체 동의 )
$("#allSelect").click(function() {
    if($("#allSelect").is(":checked")) {
        $("input[name=check]").prop("checked", true);
        check[3] = true;
    }else {
        $("input[name=check]").prop("checked", false);
        check[3] = false;
    }
    inputCheck(check);
});

// 각각 동의
$("input[name=check]").click(function() {
    var total = $("input[name=check]").length;
    var checked = $("input[name=check]:checked").length;
    if(total != checked) {
        $("#allSelect").prop("checked", false);
        check[3] = false;
    }else {
        $("#allSelect").prop("checked", true);
        check[3] = true;
    } 
    inputCheck(check);
});

function inputCheck(check){
    if(check.length == check.filter(e => true === e).length) {
        $(".btn-signup").css("background-color", "#cfbaf0");
    }else {
        $(".btn-signup").css("background-color", "#8eecf5");
    }
}
