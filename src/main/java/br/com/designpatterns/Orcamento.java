package br.com.designpatterns;

import java.math.BigDecimal;

/**
 * Created by ramon on 09/08/16.
 */
public class Orcamento {

    private BigDecimal valor;

    public Orcamento(BigDecimal valor) {
        this.valor = valor;
    }

    public Orcamento(Integer valor) {
        this.valor = new BigDecimal(valor);
    }

    public Orcamento(Double valor) {
        this.valor = new BigDecimal(valor);
    }

    public BigDecimal getValor() {
        return valor;
    }

}
