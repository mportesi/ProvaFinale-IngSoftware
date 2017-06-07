package it.polimi.ingsw.serverSocket;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.AlreadyBoundException;
import java.rmi.RemoteException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import it.polimi.ingsw.serverSocketTest.ServerView;

public class ServerSocketConnection {

	private final static int PORT = 29999;
	// private Partita partita;
	// private Controller controller;

	public ServerSocketConnection() throws RemoteException {
		// partita=new Partita();
		// controller=new Controller(partita);
	}

	public void start() throws AlreadyBoundException, IOException {
		this.startSocket();
	}

	private void startSocket() throws IOException {
		ExecutorService executor = Executors.newCachedThreadPool();
		ServerSocket serverSocket = new ServerSocket(PORT);
		System.out.println("Server socket ready on port: " + PORT);
		System.out.println("Server ready");
		while (true) {
			try {
				Socket socket = serverSocket.accept();
				ServerSocketConnectionView view = new ServerSocketConnectionView(socket);
				this.addClient(view);
				executor.submit(view);
			} catch (IOException e) {
				break;
			}
		}
		// shutdown the executor
		executor.shutdown();
		// closes the ServerSocket
		serverSocket.close();
	}

	public void addClient(ServerView view) {
		// view.addObserver(controller);
		// partita.addObserver(view);
		// Submits a Runnable task for execution
		// partita.setGameState(partita.getGameState().nextState());
		// if (partita.getGameState().equals(GameState.RUNNING)) {
		System.out.println("creo una nuova partita");
		// partita = new Partita();
		// System.out.println(partita.getGameState());
		// controller = new Controller(partita);
		// }
	}

	public static void main(String[] args) throws AlreadyBoundException, RemoteException {
		ServerSocketConnection server = new ServerSocketConnection();
		// starts the server
		try {
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
