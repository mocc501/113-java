import java.util.ArrayList;

public class ClientQueue {
    private ArrayList<Client> clients = new ArrayList();
    private ClientListener listener = new ClientListener(){
        @Override
        public void clientAdded(ClientEvent event) {
            System.out.printf("%s 從 %s 連線%n",
                    event.getName(), event.getIp());
        }

        @Override
        public void clientPayed(ClientEvent event) {
            System.out.printf("%s 從 %s 付款%n",
                    event.getName(), event.getIp());
        }

        @Override
        public void clientRemoved(ClientEvent event) {
            System.out.printf("%s 從 %s 離線%n",
                    event.getName(), event.getIp());
        }
    };

    public ArrayList<Client> getClient() {
        return clients;
    }

    //public void addClientListener(ClientListener listener) {
    //     listeners.add(listener);
    //}
    
    public void enqueue(Client client) {
        clients.add(client);
        var event = new ClientEvent(client);
        listener.clientAdded(event);
    }

    
    public void dequeue(Client client) {
        clients.remove(client);
        var event = new ClientEvent(client);
        listener.clientRemoved(event);

    }

    public void pay(Client client) {
        var event = new ClientEvent(client);
        listener.clientPayed(event);
    }
}