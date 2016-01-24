function doAjax(url, type, dataType, data){
  return $.ajax({
                url: url,
                type: type,
                dataType: dataType,
                data: data,
                error: function (errorThrown)
            {
                console.log(errorThrown);
                if(errorThrown.status == 400)
                    showIfError({status: errorThrown.status, message: errorThrown.responseText });
                else
                    showIfError({status: errorThrown.status, message: errorThrown.statusText });
            }
        });
        }

$(document).ready(function(){
    var id = window.location.search.replace("?id=", "");
    document.getElementById('idPlayerID').value = id;

    $.get("/league/rest/player/getPlayer/" + id, function(data, textStatus){
       document.getElementById('id').innerHTML = data.idPlayer;
       document.getElementById('firstName').innerHTML = data.firstName;
       document.getElementById('lastName').innerHTML = data.lastName;
       document.getElementById('shirtNumber').innerHTML = data.shirtNumber;
       document.getElementById('position').innerHTML = data.position;
       document.getElementById('bornDate').innerHTML = data.bornDate;
       document.getElementById('club').innerHTML = data.club.name;
    });
  
    $('.addSuccesC').click(function(){     
        var idPlayer = window.location.search.replace("?id=", "");
      
        doAjax('../../rest/player/deletePlayer','POST', '', {
           idPlayer: idPlayer
        }).success(function(response){ location.reload(true); });
 
        window.location.replace("Player.html");
    });
});