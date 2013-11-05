package uy.edu.um.musica;

import java.net.URL;

import javazoom.jl.player.*;

public class PlayerThread extends Thread {

	private jlp mReproductor = null;
	private String hola = "/Users/facundoliston/Documents/FACULTAD/UM/Informatica2/info2_clientview/src/uy/edu/um/musica/Cocina.mp3";

	public PlayerThread(String file) {

		try {

			String[] args = new String[1];

			args[0] = file;
			System.out.println(file);
			mReproductor = jlp.createInstance(args);

		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
		}

	}

	public void run() {

		try {

			while (true) {

				mReproductor.play();

				Thread.sleep(1000); // esperar un segundo y volver a reproducir

			}

		} catch (Exception e) {
			// TODO: Add catch code
			e.printStackTrace();
		}
	}
}
