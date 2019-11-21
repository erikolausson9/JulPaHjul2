
var mydataresponse;

var map;

async function getDat() {
    const response = await fetch('/resturantData');
    mydataresponse = await response.json();
    console.log(mydataresponse);

    for (var i = 0; i < mydataresponse.length; i++) {
       var resloc = new google.maps.LatLng(mydataresponse[i].lat, mydataresponse[i].lng);
       var name = mydataresponse[i].name;
       console.log(name);
       resturantMarkers(resloc, name);
    }
}

function myMap() {

var mapProp= {center:new google.maps.LatLng(51.508742,-0.120850), zoom:15,};
map = new google.maps.Map(document.getElementById("googleMap"),mapProp);

var initialLocation = new google.maps.LatLng(55.605132, 13.003091);
map.setCenter(initialLocation);
map.setZoom(13);

getDat();

//google.maps.event.addListener(map, 'click', function(event) {
//  placeMarker(map, event.latLng);
}



function resturantMarkers(resloc, name) {

  var icon = iconOne();

    var marker = new google.maps.Marker({
      position: resloc,
      map: map,
      icon: icon
    });

    var infowindow = new google.maps.InfoWindow({
      content: 'Latitude: ' + name
    });

    marker.addListener('click', function() {
      infowindow.open(map, marker);
    });
}

 /*function initMap() {
  navigator.geolocation.getCurrentPosition(function(position) {
    var initialLocation = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
    map.setCenter(initialLocation);
    map.setZoom(12);

    var icon = {
         url: "tomte2.png", // url
         scaledSize: new google.maps.Size(50, 50), // size
     };

    var marker = new google.maps.Marker({
        position: initialLocation,
        map: map,
        icon: icon,
        title: 'Hello World!'
      });
    });

}*/

function iconOne(){

var icon = {
         url: "tomte2.png", // url
         scaledSize: new google.maps.Size(50, 50), // size
     };

     return icon;

}
