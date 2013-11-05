package uy.edu.um.musica;

import javazoom.jl.player.jlp;

public class PlayerThread extends Thread {

	private jlp mReproductor = null;

	public PlayerThread(String file) {

		try {

			String[] args = new String[1];

			args[0] = file;
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
