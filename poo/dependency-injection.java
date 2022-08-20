// https://www.codejava.net/coding/what-is-dependency-injection-with-java-code-example

public interface Client {
    void doSomething();
}
 
public interface Service {
    String getInfo();
}

public class ServiceB implements Service {
 
    @Override
    public String getInfo() {
        return "ServiceB's Info";
    }
}
	
public class ServiceC implements Service {
 
    @Override
    public String getInfo() {
        return "ServiceC's Info";
    }
}
 

public class ClientA implements Client {
     
    Service service;
     
    public ClientA(Service service) {
        this.service = service;
    }

    public void setService(Service service) {
        this.service = service;
    }
 
    @Override
    public void doSomething() {
         
        String info = service.getInfo();
         
    }
}

Service service = new ServiceB();
Client client = new ClientA(service);
client.doSomething();
