package com.pl.game.model.client;

import java.io.IOException;
import java.io.ObjectOutputStream;

import com.pl.game.model.data.DataToSendToServer;
import com.pl.game.view.controller.BoardController;

public class Send implements Runnable {
	private ObjectOutputStream objectOutputStream;
	private BoardController boardController;

	public Send(ObjectOutputStream objectOutputStream, BoardController boardController) {
		this.objectOutputStream = objectOutputStream;
		this.boardController = boardController;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		while (true) {
			/*try {
				Thread.sleep(300);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}*/
			DataToSendToServer dataFromClient = boardController.getData();
			try {
				objectOutputStream.reset();
				objectOutputStream.writeObject(dataFromClient);

			} catch (IOException e) {
				break;

			}
		}
	}

}
