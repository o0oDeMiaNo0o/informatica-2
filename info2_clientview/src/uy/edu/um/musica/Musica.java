package uy.edu.um.musica;

public class Musica {

	private PlayerThread elReproductor = null;
	private String file = DirLocalMusica.class.getResource("Cocina.mp3")
			.toString().substring(5);

	public Musica() {
		try {
			jbInit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void jbInit() throws Exception {
		String sSistemaOperativo = System.getProperty("os.name");
		if (!sSistemaOperativo.equals("Mac OS X")) {
			file.substring(1);
		}

		elReproductor = new PlayerThread(file);

		elReproductor.start();

	}
}