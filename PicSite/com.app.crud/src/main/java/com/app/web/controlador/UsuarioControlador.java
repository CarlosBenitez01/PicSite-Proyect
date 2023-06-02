package com.app.web.controlador;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.web.entidad.Comentarios;
import com.app.web.entidad.Donaciones;
import com.app.web.entidad.Filtros;
import com.app.web.entidad.Imagenes;
import com.app.web.entidad.Respuestas;
import com.app.web.entidad.Usuario;
import com.app.web.servicio.ComentarioServicio;
import com.app.web.servicio.DonacionServicio;
import com.app.web.servicio.FiltroServicio;
import com.app.web.servicio.ImagenServicio;
import com.app.web.servicio.RespuestaServicio;
import com.app.web.servicio.UsuarioServicio;

import finalc.UsuarioConst;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class UsuarioControlador {

	public UsuarioControlador() {
		super();
	}

	@Autowired
	private UsuarioServicio servicio;

	@Autowired
	private ImagenServicio servicioImg;

	@Autowired
	private FiltroServicio servicioFiltro;
	
	@Autowired
	private ComentarioServicio servicioComentario;
	
	@Autowired
	private RespuestaServicio servicioRespuesta;
	
	@Autowired
	private DonacionServicio donacionRespuesta;


	@GetMapping({ "/registrousu" })
	public String registroUsuarios(Model model) {
		filtros.clear();
		Usuario usuario = new Usuario();

		model.addAttribute("usuario", usuario);

		return "registro";
	}

	@PostMapping({ "/registro" })
	public String guardarUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindresult,
			Model model) {
		String email = usuario.getEmail();
		usuario.setEmail(usuario.getEmail() + "@gmail.com");
		
		if (bindresult.hasErrors()) {
			List<Usuario> listUsu = servicio.listarUsuarios();
			for(Usuario usu : listUsu) {
				if (usu.getNombre().toLowerCase().equals(usuario.getNombre().toLowerCase())) {
		            bindresult.rejectValue("nombre", null, "El nombre de usuario ya existe");
		        }

		        if (usu.getEmail().toLowerCase().equals(usuario.getEmail().toLowerCase())) {
		            bindresult.rejectValue("email", null, "El correo electrónico ya está registrado");
		        }
			}
			usuario.setEmail(email);
			model.addAttribute("usuario", usuario);

			return "registro";
			
		}else {
			boolean validation = false;
			List<Usuario> listUsu = servicio.listarUsuarios();
			for(Usuario usu : listUsu) {
				if (usu.getNombre().toLowerCase().equals(usuario.getNombre().toLowerCase())) {
		            bindresult.rejectValue("nombre", null, "El nombre de usuario ya existe");
		            validation = true;
		        }

		        if (usu.getEmail().toLowerCase().equals(usuario.getEmail().toLowerCase())) {
		            bindresult.rejectValue("email", null, "El correo electrónico ya está registrado");
		            validation = true;
		        }
			}
			if(validation) {
				bindresult.rejectValue("password", null, "Intente usar otra contraseña");
				usuario.setEmail(email);
				return "registro";
			}else {
				usuario.setFoto("iconousuDegre.png");
				servicio.guardarUsuario(usuario);

				return "redirect:/loginusu";
			}
		}
	}

	@GetMapping({ "/loginusu" })
	public String loginUsuarios(Model model) {
		filtros.clear();
		Usuario usuario = new Usuario();

		model.addAttribute("desdeBlog", false);
		model.addAttribute("usuario", usuario);

		return "login";
	}

	public Usuario usuarioActual = new Usuario();

	// Resivimos por Post los datos en un objeto de estudiantes y los guardamos con
	// el servicio de JpaRepository
	@PostMapping({ "/login" })
	public String compararUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindresult,
			Model model) {
		boolean usuarioEncontrado = false;
		List<Usuario> usuList = servicio.listarUsuarios();

		for (Usuario usu : usuList) {
			if (usuario.getNombre().equals(usu.getNombre()) && usuario.getPassword().equals(usu.getPassword())) {
				usuarioEncontrado = true;
			}
			if (usuarioEncontrado) {
				UsuarioConst.id = usu.getId();
				UsuarioConst.nombre = usu.getNombre();
				UsuarioConst.email = usu.getEmail();
				UsuarioConst.hayusu = true;
				usuarioActual.setNombre(usu.getNombre());
				usuarioActual.setEmail(usu.getEmail());
				break;
			}
		}
		if (usuarioEncontrado) {
			return "redirect:/homeredirect";

		}

		if (bindresult.hasErrors()) {
			bindresult.rejectValue("password", "error.usuarioNoExiste", "Usuario o contraseña incorrectos");
			model.addAttribute("usuario", usuario);
			model.addAttribute("desdeBlog", false);

			return "login";
		}

		return "redirect:/loginusu";
	}
	
	@GetMapping({ "/loginusudesdeblog" })
	public String loginUsuariosDesdeBlog(Model model) {
		filtros.clear();
		Usuario usuario = new Usuario();
		
		model.addAttribute("desdeBlog", true);
		model.addAttribute("usuario", usuario);

		return "login";
	}
	
	@PostMapping({ "/logindesdeblog" })
	public String compararUsuarioDesdeBlog(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindresult,
			Model model) {
		boolean usuarioEncontrado = false;
		List<Usuario> usuList = servicio.listarUsuarios();

		for (Usuario usu : usuList) {
			if (usuario.getNombre().equals(usu.getNombre()) && usuario.getPassword().equals(usu.getPassword())) {
				usuarioEncontrado = true;
			}
			if (usuarioEncontrado) {
				UsuarioConst.id = usu.getId();
				UsuarioConst.nombre = usu.getNombre();
				UsuarioConst.email = usu.getEmail();
				UsuarioConst.hayusu = true;
				usuarioActual.setNombre(usu.getNombre());
				usuarioActual.setEmail(usu.getEmail());
				break;
			}
		}
		if (usuarioEncontrado) {
			seHaComentado = 1;
			return "redirect:/comunidad/blog";

		}

		if (bindresult.hasErrors()) {
			bindresult.rejectValue("password", "error.usuarioNoExiste", "Usuario o contraseña incorrectos");
			model.addAttribute("usuario", usuario);
			model.addAttribute("desdeBlog", true);
			return "login";
		}

		return "redirect:/loginusudesdeblog";
	}


	public void clearArrays() {
		imgListCol1.clear();
		imgListCol2.clear();
		imgListCol3.clear();
		imgListCol4.clear();
	}

	/*
	 * ArrayList<Imagenes> imgListCol1 = new ArrayList<>(); ArrayList<Imagenes>
	 * imgListCol2 = new ArrayList<>(); ArrayList<Imagenes> imgListCol3 = new
	 * ArrayList<>(); ArrayList<Imagenes> imgListCol4 = new ArrayList<>(); public
	 * void galeriaHome() {
	 * 
	 * List<Imagenes> todasImg = servicioImg.listarImagenes();
	 * 
	 * if(todasImg.size() == 1) { for(Imagenes img : todasImg) {
	 * imgListCol1.add(img); }
	 * 
	 * }else if(todasImg.size() == 2) {
	 * 
	 * for(int i = 0; i < todasImg.size(); i++) { if(i%2 == 0) {
	 * imgListCol1.add(todasImg.get(i));
	 * 
	 * }else { imgListCol2.add(todasImg.get(i)); } } }else if(todasImg.size() == 3)
	 * { int size = todasImg.size(); int partes = size / 3;
	 * 
	 * imgListCol1.addAll(todasImg.subList(0, partes));
	 * imgListCol2.addAll(todasImg.subList(partes, 2 * partes));
	 * imgListCol3.addAll(todasImg.subList(2 * partes, size));
	 * 
	 * }else if(todasImg.size() >= 4) { //int size = todasImg.size(); //int sobrante
	 * = size % 4; //int partesEnteras = (int) Math.ceil((double) imgTodas.size() /
	 * 4); double partes = todasImg.size() / 4; if(partes % 1 == 0) { int
	 * partesIguales = (int)partes; imgListCol1.addAll(todasImg.subList(0,
	 * partesIguales)); imgListCol2.addAll(todasImg.subList(partesIguales, 2 *
	 * partesIguales)); imgListCol3.addAll(todasImg.subList(2 * partesIguales, 3 *
	 * partesIguales)); imgListCol4.addAll(todasImg.subList(3 * partesIguales, 4 *
	 * partesIguales));
	 * 
	 * }else if(partes == (int) Math.floor(partes) + 0.25) { int partesplus1 = (int)
	 * Math.floor(partes) + 1; imgListCol1.addAll(todasImg.subList(0, partesplus1));
	 * imgListCol2.addAll(todasImg.subList(partesplus1, 2 * partesplus1-1));
	 * imgListCol3.addAll(todasImg.subList(2 * partesplus1-1, 3 * partesplus1-2));
	 * imgListCol4.addAll(todasImg.subList(3 * partesplus1-2, 4 * partesplus1-3));
	 * 
	 * }else if(partes == (int) Math.floor(partes) + 0.50) { int partesplus1 = (int)
	 * Math.floor(partes) + 1; imgListCol1.addAll(todasImg.subList(0, partesplus1));
	 * imgListCol2.addAll(todasImg.subList(partesplus1, 2 * partesplus1));
	 * imgListCol3.addAll(todasImg.subList(2 * partesplus1, 3 * partesplus1-1));
	 * imgListCol4.addAll(todasImg.subList(3 * partesplus1-1, 4 * partesplus1-2)); }
	 * 
	 * else if(partes == (int) Math.floor(partes) + 0.75) { int partesplus1 = (int)
	 * Math.floor(partes) + 1; imgListCol1.addAll(todasImg.subList(0, partesplus1));
	 * imgListCol2.addAll(todasImg.subList(partesplus1, 2 * partesplus1));
	 * imgListCol3.addAll(todasImg.subList(2 * partesplus1, 3 * partesplus1));
	 * imgListCol4.addAll(todasImg.subList(3 * partesplus1, 4 * partesplus1-1)); } }
	 * }
	 */
	ArrayList<Imagenes> imgListCol1 = new ArrayList<>();
	ArrayList<Imagenes> imgListCol2 = new ArrayList<>();
	ArrayList<Imagenes> imgListCol3 = new ArrayList<>();
	ArrayList<Imagenes> imgListCol4 = new ArrayList<>();

	public void galeriaHome() {

		// List<Imagenes> todasImg = servicioImg.listarImagenes();
		List<Imagenes> todasImg = servicioImg.listarImagenes();

		List<Imagenes> imagenes50 = new ArrayList<Imagenes>();
		int contadorDeImagenes = 1;
		for (Imagenes img : todasImg) {
			if (contadorDeImagenes <= 50) {
				imagenes50.add(img);
				contadorDeImagenes++;
			}
		}

		int size = imagenes50.size();
		int chunkSize = (int) Math.ceil((double) size / 4);

		List<List<Imagenes>> particiones = new ArrayList<>();
		for (int i = 0; i < size; i += chunkSize) {
			particiones.add(imagenes50.subList(i, Math.min(size, i + chunkSize)));
		}

		imgListCol1 = new ArrayList<>(particiones.get(0));
		imgListCol2 = new ArrayList<>(particiones.get(1));
		imgListCol3 = new ArrayList<>(particiones.get(2));
		imgListCol4 = new ArrayList<>(particiones.get(3));

	}

	public Usuario usuImgParaIcono() {
		if (UsuarioConst.hayusu) {
			Usuario imgUsu = servicio.obtenerUsuarioPorId(UsuarioConst.id);
			return imgUsu;

		} else {
			return null;
		}

	}

	@GetMapping({ "/homeredirect", "/" })
	public String homeRedirect(Model model) {
		filtros.clear();
		clearArrays();
		galeriaHome();

		boolean mostrar = false;
		boolean noMostrarLoginYRegistro = false;
		if (UsuarioConst.hayusu) {
			mostrar = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		} else {
			noMostrarLoginYRegistro = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		}

		if (mostrar) {
			model.addAttribute("mostrarElemento", mostrar);
			model.addAttribute("imgusu", usuImgParaIcono());
			model.addAttribute("objusu", servicio.obtenerUsuarioPorId(UsuarioConst.id));
		}

		model.addAttribute("galeriaList1", imgListCol1);
		model.addAttribute("galeriaList2", imgListCol2);
		model.addAttribute("galeriaList3", imgListCol3);
		model.addAttribute("galeriaList4", imgListCol4);
		return "/home";
	}

	@GetMapping({ "/home" })
	public String home() {

		return "home";
	}

	@GetMapping("/cerrarsesion")
	public String cerrarSesion() {
		UsuarioConst.id = null;
		UsuarioConst.nombre = null;
		UsuarioConst.email = null;
		UsuarioConst.hayusu = false;
		return "redirect:/";
	}

	@PostMapping("/galeria/eliminar-filtro")
	public String galeriaObtenFiltro(HttpServletRequest request) {
		String filtroABorrar = request.getParameter("filtro");
		if (!(filtros.size() == 1)) {
			filtros.remove(filtroABorrar);
		}

		return "redirect:/galeriaredirect";
	}

	@GetMapping("/g")
	public String galeriaObtenFiltro(@RequestParam("opcion") String opcion) {
		boolean existe = false;
		for (String filtro : filtros) {
			if (opcion.equals(filtro)) {
				existe = true;
				break; // Salir del bucle si encuentra una coincidencia
			}

		}

		if (!existe) {
			filtros.add(opcion);
		}
		System.out.println(opcion);
		for (String filtro : filtros) {
			if (filtro.equals(null)) {
				filtros.remove(filtro);
				break;
			}

		}

		return "redirect:/galeriaredirect";
	}

	public void objFiltroActivados() {
		String n = "";
		Filtros fTemporal = new Filtros(n);

		for (String filtro : filtros) {

			if (filtro.equals("ilustracion")) {
				fTemporal.setIlustracion(true);

			} else if (filtro.equals("wallpaper")) {
				fTemporal.setWallpaper(true);

			} else if (filtro.equals("foto")) {
				fTemporal.setFoto(true);

			} else if (filtro.equals("vector")) {
				fTemporal.setVector(true);

			} else if (filtro.equals("gif")) {
				fTemporal.setGif(true);

			} else if (filtro.equals("rojo")) {
				fTemporal.setRojo(true);

			} else if (filtro.equals("naranja")) {
				fTemporal.setNaranja(true);

			} else if (filtro.equals("amarillo")) {
				fTemporal.setAmarillo(true);

			} else if (filtro.equals("verde")) {
				fTemporal.setVerde(true);

			} else if (filtro.equals("blanco")) {
				fTemporal.setBlanco(true);

			} else if (filtro.equals("azul")) {
				fTemporal.setAzul(true);

			} else if (filtro.equals("morado")) {
				fTemporal.setMorado(true);

			} else if (filtro.equals("rosado")) {
				fTemporal.setRosado(true);

			} else if (filtro.equals("marron")) {
				fTemporal.setMarron(true);

			} else if (filtro.equals("negro")) {
				fTemporal.setNegro(true);

			} else if (filtro.equals("personas")) {
				fTemporal.setPersonas(true);

			} else if (filtro.equals("animales")) {
				fTemporal.setAnimales(true);

			} else if (filtro.equals("cocina")) {
				fTemporal.setCocina(true);

			} else if (filtro.equals("videojuegos")) {
				fTemporal.setVideojuegos(true);

			} else if (filtro.equals("paisajes")) {
				fTemporal.setPaisajes(true);

			} else if (filtro.equals("edificios")) {
				fTemporal.setEdificios(true);

			} else if (filtro.equals("transporte")) {
				fTemporal.setTransporte(true);

			} else if (filtro.equals("educacion")) {
				fTemporal.setEducacion(true);

			} else if (filtro.equals("tecnologia")) {
				fTemporal.setTecnologia(true);

			} else if (filtro.equals("gatos")) {
				fTemporal.setGatos(true);

			} else if (filtro.equals("perros")) {
				fTemporal.setPerros(true);

			} else if (filtro.equals("naturaleza")) {
				fTemporal.setNaturaleza(true);

			} else if (filtro.equals("comida")) {
				fTemporal.setComida(true);

			} else if (filtro.equals("negocio")) {
				fTemporal.setNegocio(true);

			} else if (filtro.equals("logo")) {
				fTemporal.setLogo(true);

			} else if (filtro.equals("hogar")) {
				fTemporal.setHogar(true);

			} else if (filtro.equals("playa")) {
				fTemporal.setPlaya(true);

			} else if (filtro.equals("oceano")) {
				fTemporal.setOceano(true);

			} else if (filtro.equals("viaje")) {
				fTemporal.setViaje(true);

			} else if (filtro.equals("espacio")) {
				fTemporal.setEspacio(true);

			} else if (filtro.equals("coche")) {
				fTemporal.setCoche(true);

			} else if (filtro.equals("motocicleta")) {
				fTemporal.setMotocicleta(true);

			} else if (filtro.equals("cielo")) {
				fTemporal.setCielo(true);

			} else if (filtro.equals("dinero")) {
				fTemporal.setDinero(true);

			} else if (filtro.equals("festividad")) {
				fTemporal.setFestividad(true);

			} else if (filtro.equals("cultura")) {
				fTemporal.setCultura(true);

			} else if (filtro.equals("mapa")) {
				fTemporal.setMapa(true);

			} else if (filtro.equals("deportes")) {
				fTemporal.setDeportes(true);

			} else if (filtro.equals("boda")) {
				fTemporal.setBoda(true);

			} else if (filtro.equals("luces")) {
				fTemporal.setLuces(true);

			} else if (filtro.equals("arte")) {
				fTemporal.setArte(true);

			} else if (filtro.equals("grafiti")) {
				fTemporal.setGrafiti(true);

			} else if (filtro.equals("relajante")) {
				fTemporal.setRelajante(true);

			} else if (filtro.equals("moderno")) {
				fTemporal.setModerno(true);

			} else if (filtro.equals("muebles")) {
				fTemporal.setMuebles(true);

			} else if (filtro.equals("fantasia")) {
				fTemporal.setFantasia(true);

			} else if (filtro.equals("danza")) {
				fTemporal.setDanza(true);

			} else if (filtro.equals("gimnasio")) {
				fTemporal.setGimnasio(true);

			} else if (filtro.equals("lluvia")) {
				fTemporal.setLluvia(true);

			} else if (filtro.equals("libro")) {
				fTemporal.setLibro(true);

			} else if (filtro.equals("oscuro")) {
				fTemporal.setOscuro(true);

			} else if (filtro.equals("cine")) {
				fTemporal.setCine(true);

			}
		}
		filtroTemporal = fTemporal;
	}

	ArrayList<Imagenes> imgListColGal1 = new ArrayList<>();
	ArrayList<Imagenes> imgListColGal2 = new ArrayList<>();
	ArrayList<Imagenes> imgListColGal3 = new ArrayList<>();
	ArrayList<Imagenes> imgListColGal4 = new ArrayList<>();

	Filtros filtroTemporal;

	public void galeriaDistribucion() {
		// Creando la lista filtrada
		// Esta variable del controlador es solo para poder tener 2 controladores que
		// pongan todo en false sin necesidad de agregar el id de imagen foranea
		//String n = "";
		objFiltroActivados();
		//List<Imagenes> todasImg = servicioImg.listarImagenes();
		List<Filtros> todosFiltros = servicioFiltro.listarRegistrosDeFiltros();
		List<Imagenes> listaFiltrada = new ArrayList<Imagenes>();

		for (Filtros fdb : todosFiltros) {
			Imagenes img = servicioImg.obtenerImagenPorId(fdb.getImagen().getId_imagen());

			if (fdb.getIlustracion().equals(true) && filtroTemporal.getIlustracion().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getWallpaper().equals(true) && filtroTemporal.getWallpaper().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getFoto().equals(true) && filtroTemporal.getFoto().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getVector().equals(true) && filtroTemporal.getVector().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getGif().equals(true) && filtroTemporal.getGif().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getRojo().equals(true) && filtroTemporal.getRojo().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getNaranja().equals(true) && filtroTemporal.getNaranja().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getAmarillo().equals(true) && filtroTemporal.getAmarillo().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getVerde().equals(true) && filtroTemporal.getVerde().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getBlanco().equals(true) && filtroTemporal.getBlanco().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getAzul().equals(true) && filtroTemporal.getAzul().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getMorado().equals(true) && filtroTemporal.getMorado().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getRosado().equals(true) && filtroTemporal.getRosado().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getMarron().equals(true) && filtroTemporal.getMarron().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getNegro().equals(true) && filtroTemporal.getNegro().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getPersonas().equals(true) && filtroTemporal.getPersonas().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getAnimales().equals(true) && filtroTemporal.getAnimales().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getCocina().equals(true) && filtroTemporal.getCocina().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getVideojuegos().equals(true) && filtroTemporal.getVideojuegos().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getPaisajes().equals(true) && filtroTemporal.getPaisajes().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getEdificios().equals(true) && filtroTemporal.getEdificios().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getTransporte().equals(true) && filtroTemporal.getTransporte().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getEducacion().equals(true) && filtroTemporal.getEducacion().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getTecnologia().equals(true) && filtroTemporal.getTecnologia().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getGatos().equals(true) && filtroTemporal.getGatos().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getPerros().equals(true) && filtroTemporal.getPerros().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getNaturaleza().equals(true) && filtroTemporal.getNaturaleza().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}

			} else if (fdb.getComida().equals(true) && filtroTemporal.getComida().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getNegocio().equals(true) && filtroTemporal.getNegocio().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getLogo().equals(true) && filtroTemporal.getLogo().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getHogar().equals(true) && filtroTemporal.getHogar().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getPlaya().equals(true) && filtroTemporal.getPlaya().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getOceano().equals(true) && filtroTemporal.getOceano().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getViaje().equals(true) && filtroTemporal.getViaje().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getEspacio().equals(true) && filtroTemporal.getEspacio().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getCoche().equals(true) && filtroTemporal.getCoche().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getMotocicleta().equals(true) && filtroTemporal.getMotocicleta().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getCielo().equals(true) && filtroTemporal.getCielo().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getDinero().equals(true) && filtroTemporal.getDinero().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getFestividad().equals(true) && filtroTemporal.getFestividad().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getCultura().equals(true) && filtroTemporal.getCultura().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getMapa().equals(true) && filtroTemporal.getMapa().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getDeportes().equals(true) && filtroTemporal.getDeportes().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getBoda().equals(true) && filtroTemporal.getBoda().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getLuces().equals(true) && filtroTemporal.getLuces().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getArte().equals(true) && filtroTemporal.getArte().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getGrafiti().equals(true) && filtroTemporal.getGrafiti().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getRelajante().equals(true) && filtroTemporal.getRelajante().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getModerno().equals(true) && filtroTemporal.getModerno().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getMuebles().equals(true) && filtroTemporal.getMuebles().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getFantasia().equals(true) && filtroTemporal.getFantasia().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getDanza().equals(true) && filtroTemporal.getDanza().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getGimnasio().equals(true) && filtroTemporal.getGimnasio().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getLluvia().equals(true) && filtroTemporal.getLluvia().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getLibro().equals(true) && filtroTemporal.getLibro().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getOscuro().equals(true) && filtroTemporal.getOscuro().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			} else if (fdb.getCine().equals(true) && filtroTemporal.getCine().equals(true)) {
				if (!listaFiltrada.contains(img)) {
					listaFiltrada.add(img);

				}
			}
		}

		// Repartiendo los elementos de la lista filtrada a las 4 listas
		int tamano = listaFiltrada.size();
		int tamanoParte = tamano / 4;
		int tamanoParteAdicional = tamano % 4;

		for (int i = 0; i < tamano; i++) {
			Imagenes elementoActual = listaFiltrada.get(i);
			if (i < tamanoParte + tamanoParteAdicional) {
				imgListColGal1.add(elementoActual);
			} else if (i < (tamanoParte * 2) + tamanoParteAdicional) {
				imgListColGal2.add(elementoActual);
			} else if (i < (tamanoParte * 3) + tamanoParteAdicional) {
				imgListColGal3.add(elementoActual);
			} else {
				imgListColGal4.add(elementoActual);
			}
		}

	}

	public void limpiarListas() {
		imgListColGal1.clear();
		imgListColGal2.clear();
		imgListColGal3.clear();
		imgListColGal4.clear();
	}

	public static ArrayList<String> filtros = new ArrayList<>();
	
	boolean desdeDonacion;
	@GetMapping("/galeriaredirectdonacion")
	public String galeriaRedirectDonacion() {
		filtros.clear();
		desdeDonacion = true;
		return "redirect:/galeriaredirect";
	}
	
	// String filtroSeleccionado;
	@GetMapping("/galeriaredirect")
	public String galeriaRedirect(Model model) {
		model.addAttribute("desdeDonacion", desdeDonacion);
		desdeDonacion = false;
		
		limpiarListas();
		galeriaDistribucion();
		model.addAttribute("galeriaList1", imgListColGal1);
		model.addAttribute("galeriaList2", imgListColGal2);
		model.addAttribute("galeriaList3", imgListColGal3);
		model.addAttribute("galeriaList4", imgListColGal4);

		boolean mostrar = false;

		// Mostrar o no los botones de login y registro, depende de si hay una sesion
		// iniciada
		boolean noMostrarLoginYRegistro = false;
		if (UsuarioConst.hayusu) {
			mostrar = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		} else {
			noMostrarLoginYRegistro = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		}

		// Mostrar o no el icono de perfil de usuario, depende de si hay una sesion
		// iniciada
		if (mostrar) {
			model.addAttribute("mostrarElemento", mostrar);
			model.addAttribute("imgusu", usuImgParaIcono());
			model.addAttribute("objusu", servicio.obtenerUsuarioPorId(UsuarioConst.id));
		}

		model.addAttribute("filtros", filtros);

		// Filtrar la galeria

		return "/galeria";
	}

	@GetMapping("/galeria")
	public String galeria() {
		return "galeria";

	}
	
	@GetMapping("/conocenos/nosotros")
	public String nosotrosRedirect(Model model) {
		boolean mostrar = false;

		// Mostrar o no los botones de login y registro, depende de si hay una sesion
		// iniciada
		boolean noMostrarLoginYRegistro = false;
		if (UsuarioConst.hayusu) {
			mostrar = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		} else {
			noMostrarLoginYRegistro = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		}

		// Mostrar o no el icono de perfil de usuario, depende de si hay una sesion
		// iniciada
		if (mostrar) {
			model.addAttribute("mostrarElemento", mostrar);
			model.addAttribute("imgusu", usuImgParaIcono());
			model.addAttribute("objusu", servicio.obtenerUsuarioPorId(UsuarioConst.id));
		}

		return "/nosotros";
	}
	
	@GetMapping("/nosotros")
	public String nosotros() {
		return "nosotros";

	}
	
	@PostMapping( "/comentar" )
	public String comentar(@ModelAttribute("comentarioObj") Comentarios comentario, Model model) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime fechaHoraActual = LocalDateTime.now();
		
		String date = fechaHoraActual.format(formato).toString();
		Usuario usu = servicio.obtenerUsuarioPorId(UsuarioConst.id);
		Comentarios comentarioSave = new Comentarios(comentario.getComentario(), date, 0, 0, usu);
		servicioComentario.guardarRegistroDeComentario(comentarioSave);
		seHaComentado = 1;
		
		return "redirect:/comunidad/blog";
	}
	int seHaComentado = 0;
	@PostMapping( "/responder" )
	public String comentar(@ModelAttribute("respuestaObj") Respuestas respuesta, @RequestParam("idComentario") String idComentario, Model model) {
		DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		LocalDateTime fechaHoraActual = LocalDateTime.now();
		
		String date = fechaHoraActual.format(formato).toString();
		Usuario usu = servicio.obtenerUsuarioPorId(UsuarioConst.id);
		Comentarios comentario = servicioComentario.obtenerRegistroDeComentarioPorId(Long.parseLong(idComentario));
		Respuestas respuestaSave = new Respuestas(respuesta.getComentario(), date, comentario, usu);
		servicioRespuesta.guardarRegistroDeRespuesta(respuestaSave);
		seHaComentado = 1;
		
		return "redirect:/comunidad/blog";
	}
	 
	@GetMapping("/comunidad/blog")
	public String blogRedirect(Model model) {
		//Seguir intentando que al comentar la pagina cargue en el apartado de comentarios
		model.addAttribute("seComento", seHaComentado);
		seHaComentado = 0;
		
		filtros.clear();
		
		int hayUsuario = 0;
		if (UsuarioConst.id != null && UsuarioConst.id != 0) {
		    hayUsuario = 1;
		    Usuario usu = servicio.obtenerUsuarioPorId(UsuarioConst.id);
			model.addAttribute("usuarioActualInfo", usu);
		}
		
		
		model.addAttribute("idUsuExiste", hayUsuario);
		
		Comentarios comentarioObj = new Comentarios();
		model.addAttribute("comentarioObj", comentarioObj);
		
		Respuestas respuestaObj = new Respuestas();
		model.addAttribute("respuestaObj", respuestaObj);
		
		/*
		List<Comentarios> comentariosList = servicioComentario.listarRegistrosDeComentarios();
		Collections.reverse(comentariosList);
		model.addAttribute("listaDeComentarios", comentariosList);
		*/
		
			
		
		/*
		int contadorTemp = 0;
		List<Respuestas> todasRespuestas = servicioRespuesta.listarRegistrosDeRespuestas();
		ArrayList<String> numeroDeRespuestasPorComentario = new ArrayList<>(); 
		
		for(Respuestas respuesta : todasRespuestas) {
			int numRes = 0;
			for(Comentarios comentario : comentariosList) {
				if(comentario.getId_comentario().equals(respuesta.comentarioFk.getId_comentario())) {
					numRes += 1;
				}
			}
			numeroDeRespuestasPorComentario.add(String.valueOf(numRes));
			contadorTemp += 1;
		}
		model.addAttribute("numResPorComent", numeroDeRespuestasPorComentario);
		*/		
		List<Respuestas> respuestasList = servicioRespuesta.listarRegistrosDeRespuestas();
		model.addAttribute("respuestasList", respuestasList);
		
		List<Comentarios> comentariosList = servicioComentario.listarRegistrosDeComentarios();
		Collections.reverse(comentariosList);
		Map<Integer, Comentarios> mapaComentarios = new HashMap<>();
		
		int par = 2;
		int inpar = 3;
		for(Comentarios comentario : comentariosList) {
			if(!(respuestasList.size() == 0)) {
				for(Respuestas respuesta : respuestasList) {
					if(comentario.getId_comentario().equals(respuesta.getComentarioFk().getId_comentario())) {
						
						mapaComentarios.put(par, comentario);
						par += 2;
						
					}else {
						mapaComentarios.put(inpar, comentario);
						inpar += 2;
					}	
					
					
				}
			}else {
				inpar += 2;
				mapaComentarios.put(inpar, comentario);
			}
		}
		
		/*for (Map.Entry<Integer, Comentarios> i : mapaComentarios.entrySet()) {
			System.out.println("clave: " + i.getKey()+" -> valor: " + i.getValue());
		}*/
		
		Map<Integer, Comentarios> mapaComentariosSinCoincidencias = new HashMap<>();
		for(Entry<Integer, Comentarios> iterador : mapaComentarios.entrySet()) {
			if(!mapaComentariosSinCoincidencias.containsValue(iterador.getValue())) {
				mapaComentariosSinCoincidencias.put(iterador.getKey(), iterador.getValue());
			}
		}
		model.addAttribute("mapaDeComentarios", mapaComentariosSinCoincidencias);
/*
 * para quitar duplicados
		Map<Integer, Comentarios> mapaComentariosSinDuplicados = new HashMap<>();
		Set<Comentarios> valoresUnicos = new HashSet();

		for (Map.Entry<Integer, Comentarios> entry : mapaComentarios.entrySet()) {
		    Comentarios comentario = entry.getValue();
		    if (valoresUnicos.add(comentario)) {
		        mapaComentariosSinDuplicados.put(entry.getKey(), comentario);
		    }
		}

		mapaComentarios = mapaComentariosSinDuplicados;
*/
		
		int cantidadComentarios = comentariosList.size();
		model.addAttribute("cantidadComents", cantidadComentarios);
		
		boolean mostrar = false;

		// Mostrar o no los botones de login y registro, depende de si hay una sesion
		// iniciada
		boolean noMostrarLoginYRegistro = false;
		if (UsuarioConst.hayusu) {
			mostrar = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		} else {
			noMostrarLoginYRegistro = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		}

		// Mostrar o no el icono de perfil de usuario, depende de si hay una sesion
		// iniciada
		if (mostrar) {
			model.addAttribute("mostrarElemento", mostrar);
			model.addAttribute("imgusu", usuImgParaIcono());
			model.addAttribute("objusu", servicio.obtenerUsuarioPorId(UsuarioConst.id));
		}

		return "/blog";
	}
	
	@GetMapping("/blog")
	public String blog() {
		return "blog";

	}
	
	@GetMapping("/comunidad/creadores")
	public String creadoresRedirect(Model model) {
		List<Usuario> listaTemporal = servicio.listarUsuarios();
		int listaTamano = listaTemporal.size(); 
		Collections.reverse(listaTemporal);
		
		List<Usuario> CreadoresList = new ArrayList<>();
		for(Usuario item : listaTemporal) {
			if (CreadoresList.size() < 51) {
			    CreadoresList.add(item);
			    
			}else {
				break;
			}
		}
		
		model.addAttribute("CreadoresList", CreadoresList);
		model.addAttribute("numerodecreadores", listaTamano);
		
		boolean mostrar = false;

		// Mostrar o no los botones de login y registro, depende de si hay una sesion
		// iniciada
		boolean noMostrarLoginYRegistro = false;
		if (UsuarioConst.hayusu) {
			mostrar = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		} else {
			noMostrarLoginYRegistro = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		}

		// Mostrar o no el icono de perfil de usuario, depende de si hay una sesion
		// iniciada
		if (mostrar) {
			model.addAttribute("mostrarElemento", mostrar);
			model.addAttribute("imgusu", usuImgParaIcono());
			model.addAttribute("objusu", servicio.obtenerUsuarioPorId(UsuarioConst.id));
		}

		return "/creadores";
	}
	
	@GetMapping("/creadores")
	public String creadores() {
		return "creadores";

	}
	
	@GetMapping("/donacionesredirect")
	public String donacionesRedirect(Model model) {
		Donaciones donaciones = new Donaciones();
		model.addAttribute("donaciones", donaciones);
		
		boolean mostrar = false;

		boolean noMostrarLoginYRegistro = false;
		if (UsuarioConst.hayusu) {
			mostrar = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		} else {
			noMostrarLoginYRegistro = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		}

		// Mostrar o no el icono de perfil de usuario, depende de si hay una sesion
		// iniciada
		if (mostrar) {
			model.addAttribute("mostrarElemento", mostrar);
			model.addAttribute("imgusu", usuImgParaIcono());
			model.addAttribute("objusu", servicio.obtenerUsuarioPorId(UsuarioConst.id));
		}

		return "/donaciones";
	}
	
	@GetMapping("/donaciones")
	public String donaciones() {
		return "donaciones";
	}
	
	@PostMapping("/registroDonacion")
	public String registroDonacion(@Valid @ModelAttribute("donaciones") Donaciones donaciones, BindingResult bindresult, Model model) {
		if (bindresult.hasErrors()) {
			boolean mostrar = false;

			boolean noMostrarLoginYRegistro = false;
			if (UsuarioConst.hayusu) {
				mostrar = true;
				model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
			} else {
				noMostrarLoginYRegistro = true;
				model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
			}

			// Mostrar o no el icono de perfil de usuario, depende de si hay una sesion
			// iniciada
			if (mostrar) {
				model.addAttribute("mostrarElemento", mostrar);
				model.addAttribute("imgusu", usuImgParaIcono());
				model.addAttribute("objusu", servicio.obtenerUsuarioPorId(UsuarioConst.id));
			}
			model.addAttribute("donaciones", donaciones);
			return "/donaciones";
			
		}else {
			Usuario usu = servicio.obtenerUsuarioPorId(UsuarioConst.id);
			donaciones.setUsuario(usu);
			donacionRespuesta.guardarRegistroDeDonacione(donaciones);
			return "redirect:/agradecimientoredirect";
		}
	}
	
	@GetMapping("/agradecimientoredirect")
	public String agradecimientoRedirect(Model model) {
		boolean mostrar = false;

		boolean noMostrarLoginYRegistro = false;
		if (UsuarioConst.hayusu) {
			mostrar = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		} else {
			noMostrarLoginYRegistro = true;
			model.addAttribute("sinLogYRy", noMostrarLoginYRegistro);
		}

		// Mostrar o no el icono de perfil de usuario, depende de si hay una sesion
		// iniciada
		if (mostrar) {
			model.addAttribute("mostrarElemento", mostrar);
			model.addAttribute("imgusu", usuImgParaIcono());
			model.addAttribute("objusu", servicio.obtenerUsuarioPorId(UsuarioConst.id));
		}

		return "/agradecimiento";
	}
	
	@GetMapping("/agradecimiento")
	public String agradecimiento() {
		return "agradecimiento";

	}
}
