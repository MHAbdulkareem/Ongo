window.addEventListener('load', function() {

  'use strict';
  getLocation();
  var mapProp = {
    center: new google.maps.LatLng(54.9783, -1.617780),
    zoom: 12,
    streetViewControl: false,
    styles: [{
        "featureType": "water",
        "elementType": "geometry",
        "stylers": [{
            "color": "#e9e9e9"
          },
          {
            "lightness": 17
          }
        ]
      },
      {
        "featureType": "landscape",
        "elementType": "geometry",
        "stylers": [{
            "color": "#f5f5f5"
          },
          {
            "lightness": 20
          }
        ]
      },
      {
        "featureType": "road.highway",
        "elementType": "geometry.fill",
        "stylers": [{
            "color": "#ffffff"
          },
          {
            "lightness": 17
          }
        ]
      },
      {
        "featureType": "road.highway",
        "elementType": "geometry.stroke",
        "stylers": [{
            "color": "#ffffff"
          },
          {
            "lightness": 29
          },
          {
            "weight": 0.2
          }
        ]
      },
      {
        "featureType": "road.arterial",
        "elementType": "geometry",
        "stylers": [{
            "color": "#ffffff"
          },
          {
            "lightness": 18
          }
        ]
      },
      {
        "featureType": "road.local",
        "elementType": "geometry",
        "stylers": [{
            "color": "#ffffff"
          },
          {
            "lightness": 16
          }
        ]
      },
      {
        "featureType": "poi",
        "elementType": "geometry",
        "stylers": [{
            "color": "#f5f5f5"
          },
          {
            "lightness": 21
          }
        ]
      },
      {
        "featureType": "poi.park",
        "elementType": "geometry",
        "stylers": [{
            "color": "#dedede"
          },
          {
            "lightness": 21
          }
        ]
      },
      {
        "elementType": "labels.text.stroke",
        "stylers": [{
            "visibility": "on"
          },
          {
            "color": "#ffffff"
          },
          {
            "lightness": 16
          }
        ]
      },
      {
        "elementType": "labels.text.fill",
        "stylers": [{
            "saturation": 36
          },
          {
            "color": "#333333"
          },
          {
            "lightness": 40
          }
        ]
      },
      {
        "elementType": "labels.icon",
        "stylers": [{
          "visibility": "off"
        }]
      },
      {
        "featureType": "transit",
        "elementType": "geometry",
        "stylers": [{
            "color": "#f2f2f2"
          },
          {
            "lightness": 19
          }
        ]
      },
      {
        "featureType": "administrative",
        "elementType": "geometry.fill",
        "stylers": [{
            "color": "#fefefe"
          },
          {
            "lightness": 20
          }
        ]
      },
      {
        "featureType": "administrative",
        "elementType": "geometry.stroke",
        "stylers": [{
            "color": "#fefefe"
          },
          {
            "lightness": 17
          },
          {
            "weight": 1.2
          }
        ]
      }
    ]

  };
  var map = new google.maps.Map(document.getElementById("googleMap"), mapProp);





  function getLocation() {
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(showPosition);
    } else {
      alert('Sorry your browser doesn\'t support the Geolocation API');
    }
  };

  function showPosition(position) {
    var latlng = new google.maps.LatLng(position.coords.latitude, position.coords.longitude);
    let currentUserPositionMarker = new google.maps.Marker({
      position: latlng,
      title: "Me!"
    });
    currentUserPositionMarker.setMap(map);
    console.log(position);
  };

  function ongoMenu(element) {
    switch (element) {
      case "ongo-map":
        hideElement("ongo-nearby");
        hideElement("ongo-chat");
        showElement(element);
        ongoIcons(element);
        break;
      case "ongo-nearby":
        hideElement("ongo-map");
        hideElement("ongo-chat");
        loadNearby();
        showElement(element);
        ongoIcons(element);
        break;
      case "ongo-chat":
        hideElement("ongo-nearby");
        hideElement("ongo-map");
        loadChat();
        showElement(element);
        ongoIcons(element);
        break;
      default:

    }
  };

  function ongoIcons(element) {

    switch (element) {
      case "ongo-map":
        $('#nearbyIcon').attr("src", "img/nearby.svg");
        $('#messageIcon').attr("src", "img/message.svg");
        $('#mapIcon').attr("src", "img/compassB.svg");
        $('#nav-icons-row').removeClass("bg-white");
        break;
      case "ongo-nearby":
        $('#nearbyIcon').attr("src", "img/nearbyB.svg");
        $('#messageIcon').attr("src", "img/message.svg");
        $('#mapIcon').attr("src", "img/compass.svg");
        $('#nav-icons-row').addClass("bg-white");
        break;
      case "ongo-chat":
        $('#nearbyIcon').attr("src", "img/nearby.svg");
        $('#messageIcon').attr("src", "img/messageB.svg");
        $('#mapIcon').attr("src", "img/compass.svg");
        $('#nav-icons-row').addClass("bg-white");
        break;
      default:
    }

  };

  function hideElement(element) {
    $(".ongo-nearby-person").remove();
    let x = document.getElementById(element);
    x.style.display = "none";
  };

  function showElement(element) {
    let x = document.getElementById(element);
    x.style.display = "block";
  };
  $("#ongo-nearby-icon").on("click", function() {
    ongoMenu("ongo-nearby");
  });
  $("#ongo-map-icon").on("click", function() {
    ongoMenu("ongo-map");
  });
  $("#ongo-chat-icon").on("click", function() {
    ongoMenu("ongo-chat");
  });
  $("#closeSettings").on("click", function() {
    hideElement("ongo-settings");
    $("#navContainer").addClass("fixed-top");
    $("#navContainer").addClass("d-block");
    $("#navContainer").removeClass("d-none");
  });
  $("#settingsLink").on("click", function() {
    ongoMenu("ongo-map");
    showElement("ongo-settings");
    $("#navContainer").removeClass("fixed-top");
    $("#navContainer").removeClass("d-block");
    $("#navContainer").addClass("d-none");
  });
  $("html").on("click", function() {
    screenfull.request($('#html')[0]);
  });
  $("#ongoBrandLogo").on("click", function() {
    screenfull.toggle($('#html')[0]);
  });



  function loadNearby() {
    for (var i = 1; i <= 10; i++) {
      $('#ongo-nearby').append('<div class="ongo-nearby-person row no-gutters">' +
        '<div class="col-2">' +
        '<img class="nearby-img" src="img/account-test.jpg" alt="nearby person">' +
        '</div>' +
        '<div class="col-8">' +
        '<p>George</p>' +
        '</div>' +
        '<div class="col-2">' +
        '<p class="nearby-text">1km</p>' +
        '</div>')
    }
  };

  function loadChat() {
    for (var i = 1; i <= 10; i++) {
      $('#chat-container').append('<div class="ongo-nearby-person row no-gutters">' +
        '<div class="col-2">' +
        '<img class="nearby-img" src="img/account-test.jpg" alt="nearby person">' +
        '</div>' +
        '<div class="col-8">' +
        '<p>George</p>' +
        '<p>preview of last message received</p>' +
        '</div>' +
        '<div class="col-2">' +
        '<p class="nearby-text">1h</p>' +
        '</div>')
    }
    for (var i = 1; i <= 2; i++) {
      $('#chat-events-container').append('<div class="ongo-nearby-person row no-gutters">' +
        '<div class="col-2">' +
        '<img class="nearby-img" src="img/account-test.jpg" alt="nearby person">' +
        '</div>' +
        '<div class="col-8">' +
        '<p>George</p>' +
        '<p>preview of last message received</p>' +
        '</div>' +
        '<div class="col-2">' +
        '<p class="nearby-text">1h</p>' +
        '</div>')
    }
    for (var i = 1; i <= 2; i++) {
      $('#chat-requests-container').append('<div class="ongo-nearby-person row no-gutters">' +
        '<div class="col-2">' +
        '<img class="nearby-img" src="img/account-test.jpg" alt="nearby person">' +
        '</div>' +
        '<div class="col-2">' +
        '<p>Luke</p>' +
        '</div>' +
        '<div class="col-7 text-right ml-1">' +
        '<a href="#" onclick="acceptChat()"><img img class="icon-width ml-1" src="img/check-mark.svg" alt="chat"></a>' +
        '<a href="#" onclick="declineChat()"><img img class="icon-width ml-1" src="img/x-mark.svg" alt="chat"></a>' +
        '</div>' +
        '</div>')
    }
  };

  function acceptChat() {
    alert("accepted");

  };

  function declineChat() {
    alert("declined");
  };
});
