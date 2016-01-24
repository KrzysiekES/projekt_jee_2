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
        $('#addSucces').click(function(){
          var name = $("#nameID").val();
          var owner = $("#ownerID").val();
          var city = $("#cityID").val();
          var capacity = $("#capacityID").val();
          
          doAjax('../../rest/club/addClub','POST', '', {
           name: name,
           owner: owner,
           city: city,
           capacity: capacity
          }).success(function(response){ location.reload(true); });
           alert("dodano: " + name);
        });
      });