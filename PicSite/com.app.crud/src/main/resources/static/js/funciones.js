/*
function enviarOpcionSeleccionada(event) {
  event.preventDefault();
  var opcionSeleccionada = event.target.getAttribute("data-opcion");
  var url = "/g?opcion=" + opcionSeleccionada;

  var xhr = new XMLHttpRequest();
  xhr.open("GET", url);
  xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
  xhr.send();
  }
}*/

function enviarOpcionSeleccionada(event) {
  event.preventDefault();
  var opcionSeleccionada = event.target.getAttribute("data-opcion");
  var url = "/g?opcion=" + opcionSeleccionada;

  var xhr = new XMLHttpRequest();
  xhr.open("GET", url);
  xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

  xhr.onreadystatechange = function() {
    if (xhr.readyState === 4 && xhr.status === 200) {
      window.location.href = "/galeriaredirect";
    }
  };

  xhr.send();
}


function cambiarEstiloBuscador() {
  var buscador = document.getElementById("buscador");
  buscador.style.border = "1px solid rgba(132, 132, 132, 0.418)";
  buscador.style.borderRadius = "0"
}

function regresarEstiloBuscador() {
  var buscador = document.getElementById("buscador");
  buscador.style.border = "none";
  buscador.style.borderColor = "rgb(98, 98, 98)";
  buscador.style.borderRadius = "15px"
}
/*
document.addEventListener("keyup", e=>{
  if(e.target.matches("#buscador")){
    if(e.key === "Escape")e.target.value = "";
    document.querySelectorAll(".filtro-a").forEach(filtro=>{
      filtro.textContent.toLowerCase().includes(e.target.value.toLowerCase())
        ?filtro.classList.remove("filtro-inactivo")
        :filtro.classList.add("filtro-inactivo")
    })
  }
});
*/
function mostrarCoincidencias() {
  // Obtener el valor del buscador
  var valorBuscador = document.getElementById("buscador").value.toLowerCase();

  // Obtener todas las opciones de búsqueda
  var opcionesBusqueda = document.querySelectorAll(".filtro-a");

  // Recorrer todas las opciones de búsqueda
  opcionesBusqueda.forEach(function(opcion) {
    var valorOpcion = opcion.innerHTML.toLowerCase();
    var liOpcion = opcion.parentElement;

    // Comprobar si la opción coincide con el texto del buscador
    if (valorOpcion.includes(valorBuscador)) {
      liOpcion.style.display = "block";
    } else {
      liOpcion.style.display = "none";
    }
  });
  
}

// Escuchar el evento de cambio en el buscador
document.getElementById("buscador").addEventListener("input", mostrarCoincidencias);

/*
function enviarOpcionSeleccionada(event) {
  event.preventDefault();
  var opcionSeleccionada = event.target.getAttribute("data-opcion");
  var url = "/g?opcion=" + opcionSeleccionada;

  $.ajax({
    url: url,
    type: "GET",
    dataType: "json",
    success: function(data) {
      console.log(data);
      window.location.href = "/galeria";
    },
    error: function(xhr, status, error) {
      console.log(error);
    }
  });
}
*/

function validarFormulario() {
        var fileInput = document.querySelector('input[type=file]');
        var error = /*[[${error}]]*/ null;
        
        if (fileInput.files.length === 0) {
            if (error) {
                mostrarMensajeError(error);
            } else {
                mostrarMensajeError("No se seleccionó una imagen.");
            }
            return false;
        }
        return true;
    }
    
    function mostrarMensajeError(mensaje) {
        alert(mensaje);
    }
  
  
