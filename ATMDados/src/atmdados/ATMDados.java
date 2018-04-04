package atmdados;

public class ATMDados {

    public static void main(String[] args) {

        BancoProxy bp = new BancoProxy();
        
        String server_address = args[0];
        String server_port = args[1];
        String operacao = args[2];
        
        System.out.println(operacao);
        
        if(operacao.equals("transferencia")) {
            bp.transferencia(args[3], args[4], args[5]);
        }
        
        if(operacao.equals("saldo")) {
            System.out.println("caiu aqui");
            bp.saldo(args[3]);
        }
        
        if(operacao.equals("saque")) {
            bp.saque(args[3], args[4]);
        }
        
        if(operacao.equals("deposito")) {
            bp.deposito(args[3], args[4]);
        }

    }
    
}
