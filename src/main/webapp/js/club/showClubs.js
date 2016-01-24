$(document).ready(function()
{
      $.get("/league/rest/club/getAllClubs", function(data, textStatus){
              var table = document.getElementById('presentationTable');

              for(var i in data) {
                    var row = document.createElement("tr");
                
                    var cID = document.createElement("td");
                    var cIDContent = document.createTextNode(data[i].idClub);
                
                    var cName = document.createElement("td");
                    var cNameContent = document.createTextNode(data[i].name);
                
                    var cOwner = document.createElement("td");
                    var cOwnerContent = document.createTextNode(data[i].owner);
                
                    var cCity = document.createElement("td");
                    var cCityContent = document.createTextNode(data[i].city);
                
                    var cCapacity = document.createElement("td");
                    var cCapacityContent = document.createTextNode(data[i].capacity);

                    cID.appendChild(cIDContent);
                    cName.appendChild(cNameContent);
                    cOwner.appendChild(cOwnerContent);
                    cCity.appendChild(cCityContent);
                    cCapacity.appendChild(cCapacityContent);
                
                    //Wyswietlanie pojedynczego
                    var cRead = document.createElement("td");
                    var cReadLink = document.createElement("a");
                    var cReadPicture = document.createElement("img");
                
                    cReadPicture.setAttribute('src', '/league/img/preview.png');
                    cReadLink.appendChild(cReadPicture);
                    cReadLink.href = "../../tables/Club/readClub.html?id=" + data[i].idClub;
                    cRead.appendChild(cReadLink);

                    //Update klubu
                    var cUpdate = document.createElement("td");
                    var cUpdateLink = document.createElement("a");
                    var cUpdatePicture = document.createElement("img");
                
                    cUpdatePicture.setAttribute('src', '/league/img/edit.png');
                    cUpdateLink.appendChild(cUpdatePicture);
                    cUpdateLink.href = "../../tables/Club/updateClub.html?id=" + data[i].idClub;
                    cUpdate.appendChild(cUpdateLink);

                    //Usuwanie
                    var cDelete = document.createElement("td");
                    var cDeleteLink = document.createElement("a");
                    var cDeletePicture = document.createElement("img");
                
                    cDeletePicture.setAttribute('src', '/league/img/delete.png');
                    cDeleteLink.appendChild(cDeletePicture);
                    cDeleteLink.href = "../../tables/Club/deleteClub.html?id=" + data[i].idClub;
                    cDelete.appendChild(cDeleteLink);
                     
                    row.appendChild(cID);
                    row.appendChild(cName);
                    row.appendChild(cOwner);
                    row.appendChild(cCity);
                    row.appendChild(cCapacity);
                    row.appendChild(cRead);
                    row.appendChild(cUpdate);
                    row.appendChild(cDelete);
                            
                    table.appendChild(row);
              }
      });
});