const mostrarRespuestasBtns = document.querySelectorAll('.respuestas');
const respuestasList = document.querySelectorAll('.respuestas-list');

for (let i = 0; i < mostrarRespuestasBtns.length; i++) {
  mostrarRespuestasBtns[i].addEventListener('click', function() {
    if (respuestasList[i].classList.contains('novisible')) {
        respuestasList[i].classList.replace('novisible', 'visible');
    } else {
        respuestasList[i].classList.replace('visible', 'novisible');
    }
  });
}

/*-----------------Mostrar el formulario de respuesta----------------------*/ 

const responderBotones = document.querySelectorAll('.footer__coment-responder');

responderBotones.forEach(function(boton) {
  boton.addEventListener('click', function() {
    const comentario = this.closest('.footer__coment');
    const contenedor = comentario.nextElementSibling;
    contenedor.classList.toggle('novisible');
  });
});

/*-----------------Like y dislike----------------------*/

const buttonsContainers = document.querySelectorAll('.footer__coment');

for (let i = 0; i < buttonsContainers.length; i++) {
  const container = buttonsContainers[i];
  const likeBtn = container.querySelector('.like-btn');
  const dislikeBtn = container.querySelector('.dislike-btn');

  if (likeBtn && dislikeBtn) {
    let likeActive = false;
    let dislikeActive = false;

    likeBtn.addEventListener('click', () => {
      if (!likeActive && !dislikeActive) {
        likeBtn.src = '../multimedia/icons/like-solid-24.png';
        likeActive = true;
      } else if (likeActive) {
        likeBtn.src = '../multimedia/icons/like-regular-24.png';
        likeActive = false;
      } else if (dislikeActive) {
        likeBtn.src = '../multimedia/icons/like-solid-24.png';
        dislikeBtn.src = '../multimedia/icons/dislike-regular-24.png';
        likeActive = true;
        dislikeActive = false;
      }
    });

    dislikeBtn.addEventListener('click', () => {
      if (!dislikeActive && !likeActive) {
        dislikeBtn.src = '../multimedia/icons/dislike-solid-24.png';
        dislikeActive = true;
      } else if (dislikeActive) {
        dislikeBtn.src = '../multimedia/icons/dislike-regular-24.png';
        dislikeActive = false;
      } else if (likeActive) {
        likeBtn.src = '../multimedia/icons/like-regular-24.png';
        dislikeBtn.src = '../multimedia/icons/dislike-solid-24.png';
        likeActive = false;
        dislikeActive = true;
      }
    });
  }
}


/*------------------------------------Funcion para mostrar u ocultar respuestas------------------------------------*/ 
/*
const respuestasList = document.querySelector('.respuestas-list');
const arrow = document.querySelector('.arrow');
const agregarRespuesta = document.querySelector('.respuestas');

for (let i = 0; i < respuestasList.length; i++) {
  agregarRespuesta[i].addEventListener('click', function() {
  
    if (respuestasList[i].classList.contains('novisible')) {
        respuestasList[i].classList.replace('novisible', 'visible');
        arrow.style.transform = 'rotate(180deg)';
    } else {
        respuestasList[i].classList.replace('visible', 'novisible');
        arrow.style.transform = '';
    }
});
}
*/


/*------------------------------------Funcion para ocultar div de respuestas------------------------------------*/

document.addEventListener("DOMContentLoaded", function() {
	var desdeElBlog = document.getElementById("seComento").value; // Obtén el valor de la variable desdeElBlog desde el controlador
    var seccionComentarios = document.getElementById("seccionComentarios");
    
    if (desdeElBlog == 1) {
    	seccionComentarios.scrollIntoView({ behavior: 'instant' });
        
    }
});
        
    