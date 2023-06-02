package com.app.web.entidad;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "filtros")
public class Filtros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_filtro;

	@Column(name = "ilustracion", columnDefinition = "BOOLEAN")
	private Boolean ilustracion;

	@Column(name = "wallpaper", columnDefinition = "BOOLEAN")
	private Boolean wallpaper;

	@Column(name = "foto", columnDefinition = "BOOLEAN")
	private Boolean foto;

	@Column(name = "vector", columnDefinition = "BOOLEAN")
	private Boolean vector;

	@Column(name = "gif", columnDefinition = "BOOLEAN")
	private Boolean gif;

	@Column(name = "rojo", columnDefinition = "BOOLEAN")
	private Boolean rojo;

	@Column(name = "naranja", columnDefinition = "BOOLEAN")
	private Boolean naranja;

	@Column(name = "amarillo", columnDefinition = "BOOLEAN")
	private Boolean amarillo;

	@Column(name = "verde", columnDefinition = "BOOLEAN")
	private Boolean verde;

	@Column(name = "blanco", columnDefinition = "BOOLEAN")
	private Boolean blanco;

	@Column(name = "azul", columnDefinition = "BOOLEAN")
	private Boolean azul;

	@Column(name = "morado", columnDefinition = "BOOLEAN")
	private Boolean morado;

	@Column(name = "rosado", columnDefinition = "BOOLEAN")
	private Boolean rosado;

	@Column(name = "marron", columnDefinition = "BOOLEAN")
	private Boolean marron;

	@Column(name = "negro", columnDefinition = "BOOLEAN")
	private Boolean negro;

	@Column(name = "personas", columnDefinition = "BOOLEAN")
	private Boolean personas;

	@Column(name = "animales", columnDefinition = "BOOLEAN")
	private Boolean animales;

	@Column(name = "cocina", columnDefinition = "BOOLEAN")
	private Boolean cocina;

	@Column(name = "videojuegos", columnDefinition = "BOOLEAN")
	private Boolean videojuegos;

	@Column(name = "paisajes", columnDefinition = "BOOLEAN")
	private Boolean paisajes;

	@Column(name = "edificios", columnDefinition = "BOOLEAN")
	private Boolean edificios;

	@Column(name = "transporte", columnDefinition = "BOOLEAN")
	private Boolean transporte;

	@Column(name = "educacion", columnDefinition = "BOOLEAN")
	private Boolean educacion;

	@Column(name = "tecnologia", columnDefinition = "BOOLEAN")
	private Boolean tecnologia;

	@Column(name = "gatos", columnDefinition = "BOOLEAN")
	private Boolean gatos;

	@Column(name = "perros", columnDefinition = "BOOLEAN")
	private Boolean perros;

	@Column(name = "naturaleza", columnDefinition = "BOOLEAN")
	private Boolean naturaleza;

	@Column(name = "comida", columnDefinition = "BOOLEAN")
	private Boolean comida;

	@Column(name = "negocio", columnDefinition = "BOOLEAN")
	private Boolean negocio;
	
	@Column(name = "logo", columnDefinition = "BOOLEAN")
	private Boolean logo;

	@Column(name = "hogar", columnDefinition = "BOOLEAN")
	private Boolean hogar;

	@Column(name = "playa", columnDefinition = "BOOLEAN")
	private Boolean playa;

	@Column(name = "oceano", columnDefinition = "BOOLEAN")
	private Boolean oceano;

	@Column(name = "viaje", columnDefinition = "BOOLEAN")
	private Boolean viaje;

	@Column(name = "espacio", columnDefinition = "BOOLEAN")
	private Boolean espacio;

	@Column(name = "coche", columnDefinition = "BOOLEAN")
	private Boolean coche;

	@Column(name = "motocicleta", columnDefinition = "BOOLEAN")
	private Boolean motocicleta;

	@Column(name = "cielo", columnDefinition = "BOOLEAN")
	private Boolean cielo;

	@Column(name = "dinero", columnDefinition = "BOOLEAN")
	private Boolean dinero;

	@Column(name = "festividad", columnDefinition = "BOOLEAN")
	private Boolean festividad;

	@Column(name = "cultura", columnDefinition = "BOOLEAN")
	private Boolean cultura;

	@Column(name = "mapa", columnDefinition = "BOOLEAN")
	private Boolean mapa;
	
	@Column(name = "libro", columnDefinition = "BOOLEAN")
	private Boolean libro;

	@Column(name = "cine", columnDefinition = "BOOLEAN")
	private Boolean cine;
	
	@Column(name = "oscuro", columnDefinition = "BOOLEAN")
	private Boolean oscuro;
	
	@Column(name = "lluvia", columnDefinition = "BOOLEAN")
	private Boolean lluvia;
	
	@Column(name = "gimnasio", columnDefinition = "BOOLEAN")
	private Boolean gimnasio;
	
	@Column(name = "danza", columnDefinition = "BOOLEAN")
	private Boolean danza;
	
	@Column(name = "fantasia", columnDefinition = "BOOLEAN")
	private Boolean fantasia;
	
	@Column(name = "muebles", columnDefinition = "BOOLEAN")
	private Boolean muebles;
	
	@Column(name = "relajante", columnDefinition = "BOOLEAN")
	private Boolean relajante;
	
	@Column(name = "moderno", columnDefinition = "BOOLEAN")
	private Boolean moderno;
	
	@Column(name = "grafiti", columnDefinition = "BOOLEAN")
	private Boolean grafiti;
	
	@Column(name = "arte", columnDefinition = "BOOLEAN")
	private Boolean arte;
	
	@Column(name = "luces", columnDefinition = "BOOLEAN")
	private Boolean luces;
	
	@Column(name = "boda", columnDefinition = "BOOLEAN")
	private Boolean boda;
	
	@Column(name = "deportes", columnDefinition = "BOOLEAN")
	private Boolean deportes;
	
	@ManyToOne
	@JoinColumn(name = "id_imagenFK")
	private Imagenes imagen;

	public Filtros() {
		super();
	}
	
	public Filtros(Long id_filtro, Boolean ilustracion, Boolean wallpaper, Boolean foto, Boolean vector, Boolean gif,
			Boolean rojo, Boolean naranja, Boolean amarillo, Boolean verde, Boolean blanco, Boolean azul,
			Boolean morado, Boolean rosado, Boolean marron, Boolean negro, Boolean personas, Boolean animales,
			Boolean cocina, Boolean videojuegos, Boolean paisajes, Boolean edificios, Boolean transporte,
			Boolean educacion, Boolean tecnologia, Boolean gatos, Boolean perros, Boolean naturaleza, Boolean comida,
			Boolean negocio, Boolean logo, Boolean hogar, Boolean libro, Boolean playa, Boolean oceano, Boolean viaje, Boolean espacio,
			Boolean coche, Boolean motocicleta, Boolean cielo, Boolean dinero, Boolean festividad, Boolean cultura,
			Boolean mapa, Boolean cine, Boolean oscuro, Boolean lluvia, Boolean gimnasio, Boolean danza,
			Boolean fantasia, Boolean muebles, Boolean relajante, Boolean moderno, Boolean grafiti, Boolean arte,
			Boolean luces, Boolean boda, Boolean deportes, Imagenes imagen) {
		super();
		this.id_filtro = id_filtro;
		this.ilustracion = ilustracion;
		this.wallpaper = wallpaper;
		this.foto = foto;
		this.vector = vector;
		this.gif = gif;
		this.rojo = rojo;
		this.naranja = naranja;
		this.amarillo = amarillo;
		this.verde = verde;
		this.blanco = blanco;
		this.azul = azul;
		this.morado = morado;
		this.rosado = rosado;
		this.marron = marron;
		this.negro = negro;
		this.personas = personas;
		this.animales = animales;
		this.cocina = cocina;
		this.videojuegos = videojuegos;
		this.paisajes = paisajes;
		this.edificios = edificios;
		this.transporte = transporte;
		this.educacion = educacion;
		this.tecnologia = tecnologia;
		this.gatos = gatos;
		this.perros = perros;
		this.naturaleza = naturaleza;
		this.comida = comida;
		this.negocio = negocio;
		this.logo = logo;
		this.hogar = hogar;
		this.playa = playa;
		this.oceano = oceano;
		this.viaje = viaje;
		this.espacio = espacio;
		this.coche = coche;
		this.motocicleta = motocicleta;
		this.cielo = cielo;
		this.dinero = dinero;
		this.festividad = festividad;
		this.cultura = cultura;
		this.mapa = mapa;
		this.cine = cine;
		this.libro = libro;
		this.oscuro = oscuro;
		this.lluvia = lluvia;
		this.gimnasio = gimnasio;
		this.danza = danza;
		this.fantasia = fantasia;
		this.muebles = muebles;
		this.relajante = relajante;
		this.moderno = moderno;
		this.grafiti = grafiti;
		this.arte = arte;
		this.luces = luces;
		this.boda = boda;
		this.deportes = deportes;
		this.imagen = imagen;
	}

	public Filtros(Boolean ilustracion, Boolean wallpaper, Boolean foto, Boolean vector, Boolean gif,
			Boolean rojo, Boolean naranja, Boolean amarillo, Boolean verde, Boolean blanco, Boolean azul,
			Boolean morado, Boolean rosado, Boolean marron, Boolean negro, Boolean personas, Boolean animales,
			Boolean cocina, Boolean videojuegos, Boolean paisajes, Boolean edificios, Boolean transporte,
			Boolean educacion, Boolean tecnologia, Boolean gatos, Boolean perros, Boolean naturaleza, Boolean comida,
			Boolean negocio, Boolean logo, Boolean libro,  Boolean hogar, Boolean playa, Boolean oceano, Boolean viaje, Boolean espacio,
			Boolean coche, Boolean motocicleta, Boolean cielo, Boolean dinero, Boolean festividad, Boolean cultura,
			Boolean mapa, Boolean cine, Boolean oscuro, Boolean lluvia, Boolean gimnasio, Boolean danza,
			Boolean fantasia, Boolean muebles, Boolean relajante, Boolean moderno, Boolean grafiti, Boolean arte,
			Boolean luces, Boolean boda, Boolean deportes, Imagenes imagen) {
		super();
		this.ilustracion = ilustracion;
		this.wallpaper = wallpaper;
		this.foto = foto;
		this.vector = vector;
		this.gif = gif;
		this.rojo = rojo;
		this.naranja = naranja;
		this.amarillo = amarillo;
		this.verde = verde;
		this.blanco = blanco;
		this.azul = azul;
		this.morado = morado;
		this.rosado = rosado;
		this.marron = marron;
		this.negro = negro;
		this.personas = personas;
		this.libro =libro;
		this.animales = animales;
		this.cocina = cocina;
		this.videojuegos = videojuegos;
		this.paisajes = paisajes;
		this.edificios = edificios;
		this.transporte = transporte;
		this.educacion = educacion;
		this.tecnologia = tecnologia;
		this.gatos = gatos;
		this.perros = perros;
		this.naturaleza = naturaleza;
		this.comida = comida;
		this.negocio = negocio;
		this.logo = logo;
		this.hogar = hogar;
		this.playa = playa;
		this.oceano = oceano;
		this.viaje = viaje;
		this.espacio = espacio;
		this.coche = coche;
		this.motocicleta = motocicleta;
		this.cielo = cielo;
		this.dinero = dinero;
		this.festividad = festividad;
		this.cultura = cultura;
		this.mapa = mapa;
		this.cine = cine;
		this.oscuro = oscuro;
		this.lluvia = lluvia;
		this.gimnasio = gimnasio;
		this.danza = danza;
		this.fantasia = fantasia;
		this.muebles = muebles;
		this.relajante = relajante;
		this.moderno = moderno;
		this.grafiti = grafiti;
		this.arte = arte;
		this.luces = luces;
		this.boda = boda;
		this.deportes = deportes;
		this.imagen = imagen;
	}
	
	public Filtros(Imagenes imagen) {
		super();
		this.ilustracion = false;
		this.wallpaper = false;
		this.foto = false;
		this.vector = false;
		this.gif = false;
		this.rojo = false;
		this.naranja = false;
		this.amarillo = false;
		this.verde = false;
		this.blanco = false;
		this.azul = false;
		this.morado = false;
		this.rosado = false;
		this.marron = false;
		this.negro = false;
		this.personas = false;
		this.animales = false;
		this.cocina = false;
		this.videojuegos = false;
		this.paisajes = false;
		this.edificios = false;
		this.libro = false;
		this.transporte = false;
		this.educacion = false;
		this.tecnologia = false;
		this.gatos = false;
		this.perros = false;
		this.naturaleza = false;
		this.comida = false;
		this.negocio = false;
		this.logo = false;
		this.hogar = false;
		this.playa = false;
		this.oceano = false;
		this.viaje = false;
		this.espacio = false;
		this.coche = false;
		this.motocicleta = false;
		this.cielo = false;
		this.dinero = false;
		this.festividad = false;
		this.cultura = false;
		this.mapa = false;
		this.deportes = false;
		this.boda = false;
		this.luces = false;
		this.arte = false;
		this.grafiti = false;
		this.relajante = false;
		this.moderno = false;
		this.muebles = false;
		this.fantasia = false;
		this.danza = false;
		this.gimnasio = false;
		this.lluvia = false;
		this.oscuro = false;
		this.cine = false;
		this.imagen = imagen;
	}

	public Filtros(String n) {
		super();
		this.ilustracion = false;
		this.wallpaper = false;
		this.foto = false;
		this.vector = false;
		this.gif = false;
		this.rojo = false;
		this.naranja = false;
		this.amarillo = false;
		this.verde = false;
		this.blanco = false;
		this.azul = false;
		this.morado = false;
		this.rosado = false;
		this.marron = false;
		this.negro = false;
		this.personas = false;
		this.animales = false;
		this.cocina = false;
		this.videojuegos = false;
		this.paisajes = false;
		this.libro = false;
		this.edificios = false;
		this.transporte = false;
		this.educacion = false;
		this.tecnologia = false;
		this.gatos = false;
		this.perros = false;
		this.naturaleza = false;
		this.comida = false;
		this.negocio = false;
		this.logo = false;
		this.hogar = false;
		this.playa = false;
		this.oceano = false;
		this.viaje = false;
		this.espacio = false;
		this.coche = false;
		this.motocicleta = false;
		this.cielo = false;
		this.dinero = false;
		this.festividad = false;
		this.cultura = false;
		this.mapa = false;
		this.deportes = false;
		this.boda = false;
		this.luces = false;
		this.arte = false;
		this.grafiti = false;
		this.relajante = false;
		this.moderno = false;
		this.muebles = false;
		this.fantasia = false;
		this.danza = false;
		this.gimnasio = false;
		this.lluvia = false;
		this.oscuro = false;
		this.cine = false;
	}
	public Long getId_filtro() {
		return id_filtro;
	}

	public Boolean getIlustracion() {
		return ilustracion;
	}

	public void setIlustracion(Boolean ilustracion) {
		this.ilustracion = ilustracion;
	}

	public Boolean getWallpaper() {
		return wallpaper;
	}

	public void setWallpaper(Boolean wallpaper) {
		this.wallpaper = wallpaper;
	}

	public Boolean getFoto() {
		return foto;
	}

	public void setFoto(Boolean foto) {
		this.foto = foto;
	}

	public Boolean getVector() {
		return vector;
	}

	public Boolean getLibro() {
		return libro;
	}

	public void setLibro(Boolean libro) {
		this.libro = libro;
	}

	public void setVector(Boolean vector) {
		this.vector = vector;
	}

	public Boolean getGif() {
		return gif;
	}

	public void setGif(Boolean gif) {
		this.gif = gif;
	}

	public Boolean getRojo() {
		return rojo;
	}

	public void setRojo(Boolean rojo) {
		this.rojo = rojo;
	}

	public Boolean getNaranja() {
		return naranja;
	}

	public void setNaranja(Boolean naranja) {
		this.naranja = naranja;
	}

	public Boolean getAmarillo() {
		return amarillo;
	}

	public void setAmarillo(Boolean amarillo) {
		this.amarillo = amarillo;
	}

	public Boolean getVerde() {
		return verde;
	}

	public void setVerde(Boolean verde) {
		this.verde = verde;
	}

	public Boolean getBlanco() {
		return blanco;
	}

	public void setBlanco(Boolean blanco) {
		this.blanco = blanco;
	}

	public Boolean getAzul() {
		return azul;
	}

	public void setAzul(Boolean azul) {
		this.azul = azul;
	}

	public Boolean getMorado() {
		return morado;
	}

	public void setMorado(Boolean morado) {
		this.morado = morado;
	}

	public Boolean getRosado() {
		return rosado;
	}

	public void setRosado(Boolean rosado) {
		this.rosado = rosado;
	}

	public Boolean getMarron() {
		return marron;
	}

	public void setMarron(Boolean marron) {
		this.marron = marron;
	}

	public Boolean getNegro() {
		return negro;
	}

	public void setNegro(Boolean negro) {
		this.negro = negro;
	}

	public Boolean getPersonas() {
		return personas;
	}

	public void setPersonas(Boolean personas) {
		this.personas = personas;
	}

	public Boolean getAnimales() {
		return animales;
	}

	public void setAnimales(Boolean animales) {
		this.animales = animales;
	}

	public Boolean getCocina() {
		return cocina;
	}

	public void setCocina(Boolean cocina) {
		this.cocina = cocina;
	}

	public Boolean getVideojuegos() {
		return videojuegos;
	}

	public void setVideojuegos(Boolean videojuegos) {
		this.videojuegos = videojuegos;
	}

	public Boolean getPaisajes() {
		return paisajes;
	}

	public void setPaisajes(Boolean paisajes) {
		this.paisajes = paisajes;
	}

	public Boolean getEdificios() {
		return edificios;
	}

	public void setEdificios(Boolean edificios) {
		this.edificios = edificios;
	}

	public Boolean getTransporte() {
		return transporte;
	}

	public void setTransporte(Boolean transporte) {
		this.transporte = transporte;
	}

	public Boolean getEducacion() {
		return educacion;
	}

	public void setEducacion(Boolean educacion) {
		this.educacion = educacion;
	}

	public Boolean getTecnologia() {
		return tecnologia;
	}

	public void setTecnologia(Boolean tecnologia) {
		this.tecnologia = tecnologia;
	}

	public Boolean getGatos() {
		return gatos;
	}

	public void setGatos(Boolean gatos) {
		this.gatos = gatos;
	}

	public Boolean getPerros() {
		return perros;
	}

	public void setPerros(Boolean perros) {
		this.perros = perros;
	}

	public Boolean getNaturaleza() {
		return naturaleza;
	}

	public void setNaturaleza(Boolean naturaleza) {
		this.naturaleza = naturaleza;
	}

	public Boolean getComida() {
		return comida;
	}

	public void setComida(Boolean comida) {
		this.comida = comida;
	}

	public Boolean getNegocio() {
		return negocio;
	}

	public void setNegocio(Boolean negocio) {
		this.negocio = negocio;
	}
	
	public Boolean getLogo() {
		return logo;
	}

	public void setLogo(Boolean logo) {
		this.logo = logo;
	}

	public Boolean getHogar() {
		return hogar;
	}

	public void setHogar(Boolean hogar) {
		this.hogar = hogar;
	}

	public Boolean getPlaya() {
		return playa;
	}

	public void setPlaya(Boolean playa) {
		this.playa = playa;
	}

	public Boolean getOceano() {
		return oceano;
	}

	public void setOceano(Boolean oceano) {
		this.oceano = oceano;
	}

	public Boolean getViaje() {
		return viaje;
	}

	public void setViaje(Boolean viaje) {
		this.viaje = viaje;
	}

	public Boolean getEspacio() {
		return espacio;
	}

	public void setEspacio(Boolean espacio) {
		this.espacio = espacio;
	}

	public Boolean getCoche() {
		return coche;
	}

	public void setCoche(Boolean coche) {
		this.coche = coche;
	}

	public Boolean getMotocicleta() {
		return motocicleta;
	}

	public void setMotocicleta(Boolean motocicleta) {
		this.motocicleta = motocicleta;
	}

	public Boolean getCielo() {
		return cielo;
	}

	public void setCielo(Boolean cielo) {
		this.cielo = cielo;
	}

	public Boolean getDinero() {
		return dinero;
	}

	public void setDinero(Boolean dinero) {
		this.dinero = dinero;
	}

	public Boolean getFestividad() {
		return festividad;
	}

	public void setFestividad(Boolean festividad) {
		this.festividad = festividad;
	}

	public Boolean getCultura() {
		return cultura;
	}

	public void setCultura(Boolean cultura) {
		this.cultura = cultura;
	}

	public Boolean getMapa() {
		return mapa;
	}

	public void setMapa(Boolean mapa) {
		this.mapa = mapa;
	}

	public Imagenes getImagen() {
		return imagen;
	}

	public void setImagen(Imagenes imagen) {
		this.imagen = imagen;
	}

	public Boolean getCine() {
		return cine;
	}

	public void setCine(Boolean cine) {
		this.cine = cine;
	}

	public Boolean getOscuro() {
		return oscuro;
	}

	public void setOscuro(Boolean oscuro) {
		this.oscuro = oscuro;
	}

	public Boolean getLluvia() {
		return lluvia;
	}

	public void setLluvia(Boolean lluvia) {
		this.lluvia = lluvia;
	}

	public Boolean getGimnasio() {
		return gimnasio;
	}

	public void setGimnasio(Boolean gimnasio) {
		this.gimnasio = gimnasio;
	}

	public Boolean getDanza() {
		return danza;
	}

	public void setDanza(Boolean danza) {
		this.danza = danza;
	}

	public Boolean getFantasia() {
		return fantasia;
	}

	public void setFantasia(Boolean fantasia) {
		this.fantasia = fantasia;
	}

	public Boolean getMuebles() {
		return muebles;
	}

	public void setMuebles(Boolean muebles) {
		this.muebles = muebles;
	}

	public Boolean getRelajante() {
		return relajante;
	}

	public void setRelajante(Boolean relajante) {
		this.relajante = relajante;
	}

	public Boolean getModerno() {
		return moderno;
	}

	public void setModerno(Boolean moderno) {
		this.moderno = moderno;
	}

	public Boolean getGrafiti() {
		return grafiti;
	}

	public void setGrafiti(Boolean grafiti) {
		this.grafiti = grafiti;
	}

	public Boolean getArte() {
		return arte;
	}

	public void setArte(Boolean arte) {
		this.arte = arte;
	}

	public Boolean getLuces() {
		return luces;
	}

	public void setLuces(Boolean luces) {
		this.luces = luces;
	}

	public Boolean getBoda() {
		return boda;
	}

	public void setBoda(Boolean boda) {
		this.boda = boda;
	}

	public Boolean getDeportes() {
		return deportes;
	}

	public void setDeportes(Boolean deportes) {
		this.deportes = deportes;
	}
}
