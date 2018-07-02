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


//removes browser native datepicker
$('input[type="date"]').attr('type','text');
//initialize datepicker
  $(function() {
    let dt = new Date();
    let year = dt.getYear();
    let allowedYears
    $("#dob").datepicker({
      minDate: new Date(1900,1-1,1), maxDate: '-18Y',
      dateFormat: 'dd/mm/yy',
      defaultDate: new Date(1970,1-1,1),
      changeMonth: true,
      changeYear: true,
      yearRange: '-110:-18'
    });
    $("#anim").on("change", function() {
      $("#dob").datepicker("option", "showAnim", "slide");
    });
  });

}); //onLoad
