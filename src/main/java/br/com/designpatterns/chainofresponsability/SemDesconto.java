package br.com.designpatterns.chainofresponsability;

import br.com.designpatterns.dominio.Orcamento;

import java.math.BigDecimal;

/**
 * Created by ramon on 18/08/16.
 */
@PrioridadeDesconto(value = "4")
public class SemDesconto implements Desconto {

    private Desconto proximaOpcaoDesconto;

    @Override
    public BigDecimal calcula(Orcamento orcamento) {
        return BigDecimal.ZERO;
    }

    @Override
    public void proximaOpcaoDesconto(Desconto desconto) {
        /** NÃO INFORMA NINGUÉM */
        this.proximaOpcaoDesconto = null;
    }
}
