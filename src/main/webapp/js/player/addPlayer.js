$(function() {
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
    $.get("/league/rest/club/getAllClubs", function(data, textStatus) {
       var clubSelect = document.getElementById('clubID');

       for(var i in data) {
            var opt = document.createElement('option');
            var clubInfo = data[i].idClub + ". " + data[i].name + " " + data[i].owner;
            opt.value = clubInfo;
            opt.innerHTML = clubInfo;
            clubSelect.appendChild(opt);
       }
    });
    
    $('#addSucces').click(function(){
          var club = $("#clubID").val();
          var firstName = $("#firstNameID").val();
          var lastName = $("#lastNameID").val();
          var shirtNumber = $("#shirtNumberID").val();
          var position = $("#positionID").val();
          var bornDate = $("#bornDateID").val();
          
          doAjax('../../rest/player/addPlayer','POST', '', {
           club: club,
           firstName: firstName,
           lastName: lastName,
           shirtNumber: shirtNumber,
           position: position,
           bornDate: bornDate
          }).success(function(response){ location.reload(true); });
           alert("dodano: " + firstName);
    });

});