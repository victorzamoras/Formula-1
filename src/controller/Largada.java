package controller;

import java.util.Arrays;
import java.util.concurrent.Semaphore;

import model.Carro;

public class Largada extends Thread {
	private int id = 1;
	private Semaphore semaforo;
	private Carro carro;
	static String saida = "";
	private int tempo;
	static int[] vetor = new int[15];
	static int te = 14;

	public Largada(int id, Semaphore semaforo, Carro carro) {
		this.id = id;
		this.carro = carro;
		this.semaforo = semaforo;

	}

	@Override
	public void run() {
		try {
			carros();
			sleep(1500);
			semaforo.acquire();
			pista();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		try {
			sleep(5000);
			volta();
			podium();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void carros() {
		if (id % 7 == 6) {
			System.out.println("Carro " + id + " é da equipe 1");
			carro.setEquipe("1");
			carro.setId(id);
		} else if (id % 7 == 5) {
			System.out.println("Carro " + id + " é da equipe 2");
			carro.setEquipe("2");
			carro.setId(id);
		} else if (id % 7 == 4) {
			System.out.println("Carro " + id + " é da equipe 3");
			carro.setEquipe("3");
			carro.setId(id);
		} else if (id % 7 == 3) {
			System.out.println("Carro " + id + " é da equipe 4");
			carro.setEquipe("4");
			carro.setId(id);
		} else if (id % 7 == 2) {
			System.out.println("Carro " + id + " é da equipe 5");
			carro.setEquipe("5");
			carro.setId(id);
		} else if (id % 7 == 1) {
			System.out.println("Carro " + id + " é da equipe 6");
			carro.setEquipe("6");
			carro.setId(id);
		} else if (id % 7 == 0) {
			System.out.println("Carro " + id + " é da equipe 7");
			carro.setEquipe("7");
			carro.setId(id);
		}
	}

	public void pista() {
		try {
			if (!saida.contains(carro.getEquipe())) {
				saida += carro.getEquipe() + " ";
				System.out.println("Carro " + carro.getId() + " da equipe " + carro.getEquipe() + " está na pista");
				sleep(1500);
				System.out.println(" ");
			} else if (saida.contains(carro.getEquipe())) {
				sleep(3000);
				saida = "";
				System.out.println("Carro " + carro.getId() + " da equipe " + carro.getEquipe() + " está na pista");
				System.out.println(" ");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void volta() {
		for (int j = 0; j < 3; j++) {
			tempo = (int) (Math.random() * 501) + 150;
			if (carro.getMtempo() > tempo) {
				carro.setMtempo(tempo);
				vetor[carro.getId()] = carro.getMtempo();
				System.out.println("Carro " + id + " fez uma volta de " + tempo + "segundos");
			} else {
				System.out.println("Carro " + id + " fez uma volta de " + tempo + "segundos");

			}
		}
	}

	public void podium() {
		te--;
		if (te == 0) {
			Arrays.sort(vetor);
			for (int k = 1; k < vetor.length; k++) {
				System.out.println("A " + k + "ª melhor volta foi de " + vetor[k] + " segundos");
			}
		}
	}
}
