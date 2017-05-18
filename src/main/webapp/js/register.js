/**
 * Created by tian on 2017/5/17.
 */

function registerCheck() {
    var username=$("#username").val();
    var email=$("#email").val();
    var password=$("#password").val();
    var password2=$("#password2").val();
    var error=$("#error-info");
    if(username==null||username==""){
        error.html("用户名不能为空！");
        return false;
    }
    if(username.length<3||username.length>10){
        error.html("用户名必须为3-10位");
        return false;
    }
    if(email==null||email==""){
        error.html("邮箱不能为空");
        return false;
    }
    var emailRegex = /^\w{5,15}@\w{1,10}.\w{1,5}$/;
    if(!emailRegex.test(email)){
        error.html("邮箱格式错误");
        return false;
    }
    if(password==null||password==""){
        error.html("密码不能为空！");
        return false;
    }
    console.log(password);
    console.log(password2);
    if(password2!=password){
        error.html("两次密码不一致！");
        return false;
    }
    var passwordRegex=/^[\w_]{6,20}$/;
    if(!passwordRegex.test(password)){
        error.html("密码格式错误");
        return false;
    }
    error.html("");
    return true;



}