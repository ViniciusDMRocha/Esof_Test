import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    @org.junit.jupiter.api.Test
    void depositar() {
        Conta conta = new Conta();
        conta.depositar(5000);
        Float saldo = conta.getSaldo();
        assertEquals(5000, saldo, 0.0f);
    }

    @org.junit.jupiter.api.Test
    void depositarCaseOuro() {
        Conta conta = new Conta();
        conta.depositar(5000);
        conta.depositar(1000);
        Float saldo = conta.getSaldo();
        assertEquals(6050, saldo, 0.0f);
    }


    @org.junit.jupiter.api.Test
    void sacarCaseOuro() {
        Conta conta = new Conta();
        conta.depositar(5000);
        conta.sacar(1000);
        Float saldo = conta.getSaldo();
        assertEquals(4000, saldo, 0.0f);
    }

    @org.junit.jupiter.api.Test
    void sacarCasePrata() {
        Conta conta = new Conta();
        conta.depositar(1000);
        conta.sacar(100);
        Float saldo = conta.getSaldo();
        assertEquals(895, saldo, 0.0f);
    }

    @org.junit.jupiter.api.Test
    void sacarCaseVermelho() {
        Conta conta = new Conta();
        conta.sacar(100);
        boolean legit = conta.sacar(100);
        assertFalse(legit);
    }

    @org.junit.jupiter.api.Test
    void atualizarEstadoCaseOuro() {
        Conta conta = new Conta();
        conta.depositar(5000);
        String estado = conta.getEstado();
        assertEquals("OURO", estado);
    }

    @org.junit.jupiter.api.Test
    void atualizarEstadoCaseVermelho() {
        Conta conta = new Conta();
        conta.sacar(100);
        String estado = conta.getEstado();
        assertEquals("VERMELHO", estado);
    }

    @org.junit.jupiter.api.Test
    void atualizarEstadoCasePrata() {
        Conta conta = new Conta();
        conta.depositar(500);
        String estado = conta.getEstado();
        assertEquals("PRATA", estado);
    }
}
