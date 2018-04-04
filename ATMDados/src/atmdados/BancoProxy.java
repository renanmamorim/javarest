package atmdados;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

public class BancoProxy {
    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/ServidorDados/webresources";

    public BancoProxy() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("operacoes");
    }

    public String saldo(String conta) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("/saldo/" + conta);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }
    
    public String deposito(String conta, String valor) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("deposito/" + conta + "/" + valor);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public String saque(String conta, String valor) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("saque/" + conta + "/" + valor);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }
    
    public String transferencia(String contaorig, String contadest, String valor) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("transferencia/" + contaorig + "/" + contadest + "/" + valor);
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }
    
    public void close() {
        client.close();
    }
    
}
