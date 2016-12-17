package com.pl.game.model.server;

public class ClientsNumber {
	private int clients = 0;
	private boolean connected = false;

	public void increment() {
		clients++;
	}

	public int getClients() {
		return clients;
	}

	public void setClients(int clients) {
		this.clients = clients;
	}

	public boolean isConnected() {
		return connected;
	}

	public void setConnected(boolean connected) {
		this.connected = connected;
	}

}
