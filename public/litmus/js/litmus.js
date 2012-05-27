$(function(){
    
    $('#loading').ajaxStart(function () {
        $(this).show();
    }).ajaxStop(function () {
        $(this).hide();
    });

  
    var testError = function (msg) {
        window.location = bookmark();
        stop();
        updateSelected();
    }



});