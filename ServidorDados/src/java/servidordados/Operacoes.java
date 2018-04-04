package servidordados;

import javax.ejb.Singleton;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.POST;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

@Singleton
@Path("operacoes")
public class Operacoes {

    @Context
    private UriInfo context;

    private double[] contas = new double[10]; 
    
    public Operacoes() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saldo/{conta}")
    public String saldo(@PathParam("conta") String conta_) {
        int conta = Integer.parseInt(conta_);
        System.out.println("O saldo atual do usuario " + conta + " e " + contas[conta]);
        return Double.toString(contas[conta]);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deposito/{conta}/{valor}")
    public void deposito(@PathParam("conta") String conta_, @PathParam("valor") String valor_) {
        System.out.println("Servidor Dados - deposito");
        int conta = Integer.parseInt(conta_);
        int valor = Integer.parseInt(valor_);
        contas[conta] += valor;
        System.out.println("Deposito bem sucedido de " + valor + " na conta " + conta);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/saque/{conta}/{valor}")
    public void saque(@PathParam("conta") String conta_, @PathParam("valor") String valor_) {
        System.out.println("Servidor Dados - saque");
        int conta = Integer.parseInt(conta_);
        int valor = Integer.parseInt(valor_);
        contas[conta] -= valor;
        System.out.println("Saque bem sucedido de " + valor + " na conta " + conta);
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/deposito/{contaorig}/{contadest}/{valor}")
    public void transferencia(@PathParam("contaorig") String contaorig_, @PathParam("contadest") String contadest_, @PathParam("valor") String valor_) {
        System.out.println("Servidor Dados - transferência");
        int contaorig = Integer.parseInt(contaorig_);
        int contadest = Integer.parseInt(contadest_);
        int valor = Integer.parseInt(valor_);
        contas[contaorig] -= valor;
        contas[contadest] += valor;
        System.out.println("Transferencia bem sucedida de " + valor + " da conta " + contaorig + " para a conta " + contadest);
    }
}
