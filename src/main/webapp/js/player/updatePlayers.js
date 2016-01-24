(function() {
  $( "#bornDateID" ).datepicker();
});

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

    $.get("/league/rest/club/getAllClubs", function(data, textStatus){
      
       var clubSelect = document.getElementById('clubID');
       for(var i in data) {
            var opt = document.createElement('option');
            var clubInfo = data[i].idClub + ". " + data[i].name + " " + data[i].owner;
            opt.value = clubInfo;
            opt.innerHTML = clubInfo;
            clubSelect.appendChild(opt);
       }
    });

    $.get("/league/rest/player/getPlayer/" + id, function(data, textStatus)
    {
       document.getElementById('id').innerHTML = data.idShopOrder;
       document.getElementById('firstName').innerHTML = data.firstName;
       document.getElementById('lastName').innerHTML = data.lastName;
       document.getElementById('shirtNumber').value = data.shirtNumber;
       document.getElementById('position').value = data.position;
       document.getElementById('bornDate').value = data.bornDate;
       document.getElementById('clubID').value = data.club.idClub + ". " + data.club.name + " " + data.club.owner;
    });
  
   $('#addSucces').click(function(){
          var idPlayer = $("#playerID").val();
          var club = $("#clubID").val();
          var firstName = $("#firstNameID").val();
          var lastName = $("#lastNameID").val();
          var shirtNumber = $("#shirtNumberID").val();
          var position = $("#positionID").val();
          var bornDate = $("#bornDateID").val();
          
          doAjax('../../rest/player/updatePlayer','POST', '', {
           idPlayer: idPlayer,
           firstName: firstName,
           lastName: lastName,
           shirtNumber: shirtNumber,
           position: position,
           bornDate: bornDate,
           club: club
          }).success(function(response){ location.reload(true); });
           alert("Zmiany zostały zastosowane");
    });
});