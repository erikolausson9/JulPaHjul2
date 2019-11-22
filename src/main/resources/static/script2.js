
var map;

function myMap() {

var mapProp= {center:new google.maps.LatLng(51.508742,-0.120850), zoom:15,};
map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

var initialLocation = new google.maps.LatLng(55.605132, 13.003091);
map.setCenter(initialLocation);
map.setZoom(13);

getDat();

}

async function getDat() {
    const response = await fetch('/resturantData');
    mydataresponse = await response.json();


    var rName = document.getElementById("restName").textContent;
    console.log(rName);

    for (var i = 0; i < mydataresponse.length; i++) {
    if (rName == mydataresponse[i].name) {
       var resloc = new google.maps.LatLng(mydataresponse[i].lat, mydataresponse[i].lng);
       var name = mydataresponse[i].name;
       var id = mydataresponse[i].id;

       resturantMarkers(resloc, name, id);
       }
    }
}

function resturantMarkers(resloc, name, id) {

  var icon = iconOne();

    var marker = new google.maps.Marker({
      position: resloc,
      map: map,
      icon: icon
    });

    //"Tomte box"
    var infowindow = new google.maps.InfoWindow({
      content: '<b>' + name + '</b><br><a id="links" href="http://127.0.0.1:8080/view?id=' + id + '">Details</a>'
    });

    marker.addListener('click', function() {
      infowindow.open(map, marker);
    });
}

function iconOne(){

var icon = {
         url: "tomte2.png", // url
         scaledSize: new google.maps.Size(50, 50), // size
     };

     return icon;

}