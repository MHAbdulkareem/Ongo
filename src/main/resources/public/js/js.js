window.addEventListener('load', function() {
  $("#registerNow").on("click", function() {
  hideElement("loginform");
  showElement("registerform");
  });


  $("#BtnsignInInstead").on("click", function() {
  hideElement("registerform");
  showElement("loginform");
  });



  function hideElement(element) {

    let x = document.getElementById(element);
    x.style.display = "none";
  };

  function showElement(element) {
    let x = document.getElementById(element);
    x.style.display = "block";
  };



  $( function() {
    $( "#dob" ).datepicker({
      changeMonth: true,
      changeYear: true,
      yearRange: '1910:2018'
    });
    $( "#anim" ).on( "change", function() {
      $( "#dob" ).datepicker( "option", "showAnim", "slide" );
      $( "#datepicker" ).datepicker( "option", "dateFormat", "d M, y");
    });
  } );
});
