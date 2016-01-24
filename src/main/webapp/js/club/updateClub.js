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
    $('.addSuccesC').click(function(){
          var idClub = $(".idClubC").val();
          var name = $(".nameC").val();
          var owner = $(".ownerC").val();
          var city = $(".cityC").val();
          var capacity = $(".capacityC").val();
          
      doAjax('../../rest/club/updateClub','POST', '', {
           idClub: idClub,
           name: name,
           owner: owner,
           city: city,
           capacity: capacity
      }).success(function(response){ location.reload(true); });
          alert("Zmiany zostały zastosowane");
    });
});
