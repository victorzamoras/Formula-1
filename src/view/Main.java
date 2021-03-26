package view;

import java.util.concurrent.Semaphore;

import controller.Largada;
import model.Carro;

public class Main {
	public static void main(String[] args) {
		Semaphore semaforo = new Semaphore(5);
		for (int id = 1; id <= 14; id++) {
			Thread t = new Largada(id, semaforo,new Carro());
			t.start();
			
		}
	}
}