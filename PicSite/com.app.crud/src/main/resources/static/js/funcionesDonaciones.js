var inputFechaNacimiento = document.getElementById('fechaNacimiento');
var fechaMinima = new Date('2005-01-01'); // Establece la fecha mínima (2005-01-01)

inputFechaNacimiento.addEventListener('input', function() {
  var fechaSeleccionada = new Date(this.value);

  if (fechaSeleccionada > fechaMinima) {
    this.setCustomValidity('Debes seleccionar una fecha anterior a 2005');
  } else {
    this.setCustomValidity('');
  }
});

