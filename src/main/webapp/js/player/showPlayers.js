$(document).ready(function()
{
      $.get("/league/rest/player/getAllPlayers", function(data, textStatus)
      {
              var table = document.getElementById('presentationTable');

              for(var i in data) {
                    var row = document.createElement("tr");

                    var cID = document.createElement("td");
                    var cIDContent = document.createTextNode(data[i].idPlayer);
                
                    var cFirstName = document.createElement("td");
                    var cFirstNameContent = document.createTextNode(data[i].firstName);
                
                    var cLastName = document.createElement("td");
                    var cLastNameContent = document.createTextNode(data[i].lastName);
                
                    var cShirtNumber = document.createElement("td");
                    var cShirtNumberContent = document.createTextNode(data[i].shirtNumber);
                
                    var cPosition = document.createElement("td");
                    var cPositionContent = document.createTextNode(data[i].position);
                
                    var cBornDate = document.createElement("td");
                    var cBornDateContent = document.createTextNode(data[i].bornDate);
                
                    var cClub = document.createElement("td");
                    var cClubContent = document.createTextNode(data[i].club.name + " ");

                    cID.appendChild(cIDContent);
                    cFirstName.appendChild(cFirstNameContent);
                    cLastName.appendChild(cLastNameContent);
                    cShirtNumber.appendChild(cShirtNumberContent);
                    cPosition.appendChild(cPositionContent);
                    cBornDate.appendChild(cBornDateContent);
                    cClub.appendChild(cClubContent);


                    //Read:
                    var cRead = document.createElement("td");
                    var cReadLink = document.createElement("a");

                    var cReadPicture = document.createElement("img");
                    cReadPicture.setAttribute('src', '/league/img/preview.png');
                    cReadLink.appendChild(cReadPicture);
                
                    cReadLink.href = "../../tables/Player/readPlayer.html?id=" + data[i].idPlayer;
                    cRead.appendChild(cReadLink);

                    //Update:
                    var cUpdate = document.createElement("td");
                    var cUpdateLink = document.createElement("a");

                    var cUpdatePicture = document.createElement("img");
                    cUpdatePicture.setAttribute('src', '/league/img/edit.png');

                    cUpdateLink.appendChild(cUpdatePicture);
                    cUpdateLink.href = "../../tables/Player/updatePlayer.html?id=" + data[i].idPlayer;
                    cUpdate.appendChild(cUpdateLink);

                    //Delete:
                    var cDelete = document.createElement("td");
                    var cDeleteLink = document.createElement("a");

                    var cDeletePicture = document.createElement("img");
                    cDeletePicture.setAttribute('src', '/league/img/delete.png');

                    cDeleteLink.appendChild(cDeletePicture);
                    cDeleteLink.href = "../../tables/Player/deletePlayer.html?id=" + data[i].idPlayer;
                    cDelete.appendChild(cDeleteLink);

                    row.appendChild(cID);
                    row.appendChild(cFirstName);
                    row.appendChild(cLastName);
                    row.appendChild(cShirtNumber);
                    row.appendChild(cPosition);
                    row.appendChild(cBornDate);
                    row.appendChild(cClub);
                    row.appendChild(cRead);
                    row.appendChild(cUpdate);
                    row.appendChild(cDelete);

                    table.appendChild(row);
              }
      });
});