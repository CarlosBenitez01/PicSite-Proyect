package finalc;

public class UsuarioObject {
	private Long id;

	private String nombre;
	
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UsuarioObject(Long id, String nombre, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.email = email;
	}
	
	public UsuarioObject(String nombre, String email) {
		super();
		this.nombre = nombre;
		this.email = email;
	}
	
	public UsuarioObject() {
	}
}
