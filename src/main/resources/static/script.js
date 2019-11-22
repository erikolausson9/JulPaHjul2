
var mydataresponse;

var map;

async function getDat() {
    const response = await fetch('/resturantData');
    mydataresponse = await response.json();
    console.log(mydataresponse);

    for (var i = 0; i < mydataresponse.length; i++) {
       var resloc = new google.maps.LatLng(mydataresponse[i].lat, mydataresponse[i].lng);
       var name = mydataresponse[i].name;
       var id = mydataresponse[i].id;
       console.log(name);
       resturantMarkers(resloc, name, id);
    }
}


//Map init.. 
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

function GetSelectedValue(){

var e = document.getElementById("showMapFocus");
var strUser = e.options[e.selectedIndex].value;
console.log(strUser);

switch(strUser) {
      case "gamlaVaster":
         var loc = new google.maps.LatLng(55.604640, 12.996836);
         map.setCenter(loc);
         map.setZoom(15);
         break;
      case "Carolikvarteren":
      var loc = new google.maps.LatLng(55.606245, 13.009344);
               map.setCenter(loc);
               map.setZoom(15);
               break;

      case "Davidshall":
      var loc = new google.maps.LatLng(55.598955, 12.998516);
               map.setCenter(loc);
               map.setZoom(15);
               break;

      case "Slottsstaden":
      var loc = new google.maps.LatLng(55.597246, 12.976060);
               map.setCenter(loc);
               map.setZoom(15);
               break;

      case "Mollevangen":
      var loc = new google.maps.LatLng(55.591482, 13.008791);
               map.setCenter(loc);
               map.setZoom(15);
               break;

      case "Radmansvangen":
      var loc = new google.maps.LatLng(55.593009, 13.001743);
               map.setCenter(loc);
               map.setZoom(15);
               break;

      case "Slussen":
      var loc = new google.maps.LatLng(55.607810, 13.016972);
               map.setCenter(loc);
               map.setZoom(15);
               break;

      case "Varnhem":
      var loc = new google.maps.LatLng(55.605576, 13.022763);
               map.setCenter(loc);
               map.setZoom(15);
               break;

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
      content: '<b>' + name + '</b><br><a href="http://127.0.0.1:8080/veiw?id=' + id + '">Details</a>'
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
