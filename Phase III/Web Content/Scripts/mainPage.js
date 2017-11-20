function expand() {
  toggleSubmitDisplay ();
  $(".search").toggleClass("close");
  $(".input").toggleClass("square");
  if ($('.search').hasClass('close')) {
    $('input').focus();
  } else {
    $('input').blur();
  }
}
//$('button').on('click', expand);
//$('.search').on('click', submitDisplay);

//copyright('');

function toggleSubmitDisplay () {
    var x = document.getElementById("submit");
    if (x.style.display === "none") {
        x.style.display = "inline-block";
    } else if (x.style.display === "inline-block") {
        x.style.display = "none";
    }
}