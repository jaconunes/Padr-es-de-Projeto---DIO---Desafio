package io.jaconunes.walletcontrolapi.dto;

public class Transferencia {
    private Long idContaOrigem;
    private Long idContaDestino;
    private Double saldoATransferir;

    public Long getIdContaOrigem() {
        return idContaOrigem;
    }

    public void setIdContaOrigem(Long idContaOrigem) {
        this.idContaOrigem = idContaOrigem;
    }

    public Long getIdContaDestino() {
        return idContaDestino;
    }

    public void setIdContaDestino(Long idContaDestino) {
        this.idContaDestino = idContaDestino;
    }

    public Double getSaldoATransferir() {
        return saldoATransferir;
    }

    public void setSaldoATransferir(Double saldoATransferir) {
        this.saldoATransferir = saldoATransferir;
    }
}
