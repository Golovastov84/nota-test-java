$(function(){
    block = document.getElementById("calculationResultId");

    $('#enterId').click(function(){
               var incomingText = $('#originalText form').serialize();
               var inText = document.getElementById('incomingTextId').value;
               if(inText == ""){
                            alert("Введите текст");
                        } else {
                           $.ajax({
                                method: "POST",
                                url: '/inTexts/',
                                data: incomingText,
                                success: function(response){
                                    document.getElementById('calculationResultId').value = response.secondText;
                                        $('#originalText').css({display: 'none'});
                                        $('#calculationResult').css({display: 'flex'});
    // автоматическое расширение блока input
                                        var textLength = ((response.secondText.length + 1) * 8);
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
        $('#calculationResult').css({display: 'none'});
        $('#originalText').css({display: 'flex'});
        return false;
    });
});



