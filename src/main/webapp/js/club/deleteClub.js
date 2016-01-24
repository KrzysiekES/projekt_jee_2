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
    document.getElementById('idClubID').value = id;

    $.get("/league/rest/club/getClub/" + id, function(data, textStatus){
       document.getElementById('id').innerHTML = data.idClub;
       document.getElementById('name').innerHTML = data.name;
       document.getElementById('owner').innerHTML = data.owner;
       document.getElementById('city').innerHTML = data.city;
       document.getElementById('capacity').innerHTML = data.capacity;
    });
  
    $('.addSuccesC').click(function(){       
        var idClub = window.location.search.replace("?id=", "");
        doAjax('../../rest/club/deleteClub','POST', '', {
           idClub: idClub
        }).success(function(response){ location.reload(true); });
            window.location.replace("Club.html");
    });
});