
function loginCheck() {
    $('#error-info').text('');
    var username = $('#username').val();
    var password = $('#password').val();
    var passwordReg = /^\w{6,20}$/;
    if(!username||username==""){
        $('#error-info').text('用户名不能为空');
        return false;
    }
    if(!password||password==""){
        $('#error-info').text('密码不能为空');
        return false;
    }
    if(username.length<3||username.length>10){
        $('#error-info').text('用户名格式错误');
        return false;
    }
    if(!passwordReg.test(password)){
        $('#error-info').text('用户名格式错误');
        return false;
    }
}