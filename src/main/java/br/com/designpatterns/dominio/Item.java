package br.com.designpatterns.dominio;

import java.math.BigDecimal;

/**
 * Created by ramon on 18/08/16.
 */
public class Item {

    private String nome;
    private BigDecimal valor;

    public Item(String nome, BigDecimal valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Item(String nome, Double valor) {
        this.nome = nome;
        this.valor = new BigDecimal(valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

}
