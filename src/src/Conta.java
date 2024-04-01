import java.util.Objects;

public class Conta {
    private float saldo;
    private String estado;
    private Cliente cliente;

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Conta() {
        this.saldo = 0;
        this.estado = "PRATA";
        this.cliente = new Cliente();
    }

    public void depositar(float quantia) {
        if(Objects.equals(getEstado(), "OURO")){
            setSaldo((float) (getSaldo() + quantia*1.05));
        }
        else{
            setSaldo((getSaldo() + quantia));
        }
        this.atualizarEstado();
    }

    public boolean sacar(float quantia) {
        if(Objects.equals(getEstado(), "VERMELHO")){
            return false;
        }
        else if(Objects.equals(getEstado(), "PRATA")){
            setSaldo((float) (getSaldo() - quantia*1.05));
        }
        else{
            setSaldo((float) (getSaldo() - quantia));
        }
        this.atualizarEstado();
        return true;
    }

    public void atualizarEstado() {
        if(getSaldo() > 1000){
            setEstado("OURO");
        }
        else if(getSaldo() < 0){
            setEstado("VERMELHO");
        }
        else{
            setEstado("PRATA");
        }
    }

    public class Cliente {
        String nome;
    }
}