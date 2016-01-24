$(document).ready(function(){
    var id = window.location.search.replace("?id=", "");
    $.get("/league/rest/player/getPlayer/" + id, function(data, textStatus){
       document.getElementById('id').innerHTML = data.idPlayer;
       document.getElementById('firstName').innerHTML = data.firstName;
       document.getElementById('lastName').innerHTML = data.lastName;
       document.getElementById('shirtNumber').innerHTML = data.shirtNumber;
       document.getElementById('position').innerHTML = data.position;
       document.getElementById('bornDate').innerHTML = data.bornDate;
       document.getElementById('club').innerHTML = data.club.name;
    });
});