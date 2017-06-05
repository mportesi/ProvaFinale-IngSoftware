package it.polimi.ingsw.serverRMI;

public class ServerRMIConnectionView
	extends View implements ServerRMIConnectionViewRemote {

		private Set<ClientViewRemote> clients;



		public RMIView() {
			this.clients = new HashSet<>();
		}

		@Override
		public void registerClient(ClientViewRemote clientStub) throws RemoteException {
			System.out.println("CLIENT REGISTRATO");
			this.clients.add(clientStub);
		}

		@Override
		public void update(Change o) {
			System.out.println("SENDING THE CHANGE TO THE CLIENT");
			try {
				for (ClientViewRemote clientstub : this.clients) {
					
					clientstub.updateClient(o);
				}
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		@Override
		public void update() {
			// TODO Auto-generated method stub

		}

		public void turnOn() throws RemoteException{
			this.notifyObserver(new TurnOn());
		}

		public void turnOff() throws RemoteException{
			this.notifyObserver(new TurnOff());

		}

		public void scommetti() throws RemoteException{
			this.notifyObserver(new Scommetti());
		}

		public void printModel() throws RemoteException{
			this.notifyObserver(new PrintModel());
		}

	}



