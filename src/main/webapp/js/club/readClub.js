$(document).ready(function(){
    var id = window.location.search.replace("?id=", "");
  
    $.get("/league/rest/club/getClub/" + id, function(data, textStatus){
       document.getElementById('id').innerHTML = data.idClub;
       document.getElementById('name').innerHTML = data.name;
       document.getElementById('owner').innerHTML = data.owner;
       document.getElementById('city').innerHTML = data.city;
       document.getElementById('capacity').innerHTML = data.capacity;
    });
});