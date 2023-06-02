package finalc;

import java.util.List;

import com.app.web.entidad.Imagenes;
import com.app.web.entidad.Usuario;

public class ObjetoYListas {
	
	private Usuario usu;
	
	private List<Imagenes> listImg1;
	private List<Imagenes> listImg2;
	private List<Imagenes> listImg3;
	private List<Imagenes> listImg4;
	
	public ObjetoYListas(Usuario usu, List<Imagenes> listImg1, List<Imagenes> listImg2, List<Imagenes> listImg3,
			List<Imagenes> listImg4) {
		super();
		this.usu = usu;
		this.listImg1 = listImg1;
		this.listImg2 = listImg2;
		this.listImg3 = listImg3;
		this.listImg4 = listImg4;
	}
	
	public ObjetoYListas(List<Imagenes> listImg1, List<Imagenes> listImg2, List<Imagenes> listImg3,
			List<Imagenes> listImg4) {
		super();
		this.listImg1 = listImg1;
		this.listImg2 = listImg2;
		this.listImg3 = listImg3;
		this.listImg4 = listImg4;
	}
}
