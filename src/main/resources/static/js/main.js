$(function(){
//  var incomingText = "qwerty";
    block = document.getElementById("calculationResultId");

    $('#enterId').click(function(){
               var incomingText = $('#choiceLogin form').serialize();
               var inText = document.getElementById('incomingTextId').value;
               if(inText == ""){
                            alert("Введите текст");
                        } else {
                           $.ajax({
                                method: "POST",
                                url: '/inTexts/',
                                data: incomingText,
                                success: function(response){
                                    document.getElementById('calculationResultId').value = response;
                                        $('#choiceLogin').css({display: 'none'});
                                        $('#registrationWindow').css({display: 'flex'});
    // автоматическое расширение блока input
                                        var textLength = ((response.length + 1) * 8);
                                        if(textLength < 1000){
                                        block.style.width = textLength + "px";
                                        } else{
                                        block.style.width = 1000 + "px";
                                        }
                                }
                            });
                       }
        return false;
    });

    $('.goHome').click(function(){
        document.getElementById('incomingTextId').value = "";
        document.getElementById('calculationResultId').value = "";
        $('#registrationWindow').css({display: 'none'});
        $('#choiceLogin').css({display: 'flex'});
        return false;
    });
});



