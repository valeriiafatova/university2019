$(document).ready(function () {
    $(".login").on("click", function(e){
        e.preventDefault();
        console.log("click on login");
        $('#login-modal').fadeIn()
        $('.modal').modal('hide');
        $('#login-modal').modal('show');
    });
})