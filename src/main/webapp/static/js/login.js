$(document).ready(function () {
    $(".login").on("click", function(e){
        e.preventDefault();
        console.log("click on login");
        $('#login-modal').fadeIn()
        $('.modal').modal('hide');
        $('#login-modal').modal('show');
    });
    
    $('#loginForm').on("submit", function (e) {
        e.preventDefault();
        let login = $('#login').val();
        let password = $('#password').val();

        $.ajax({
            type: "POST",
            url: "login",
            data: {"login": login, "password": password},
            success: function (data) {
                console.log(data);
                if (data.success) {
                    $(location).attr('href', data.url)
                } else {
                    let textNode = document.createTextNode(data.message);
                    $('.login.message').append(textNode);
                }

            }
        })
    })
})