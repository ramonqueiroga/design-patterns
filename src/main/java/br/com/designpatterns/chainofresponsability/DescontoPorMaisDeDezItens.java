package br.com.designpatterns.chainofresponsability;

import br.com.designpatterns.dominio.Orcamento;

import java.math.BigDecimal;

/**
 * Created by ramon on 20/08/16.
 */
@PrioridadeDesconto(value = "1")
public class DescontoPorMaisDeDezItens implements Desconto {

    private Desconto proximaOpcaoDesconto;

    @Override
    public BigDecimal calcula(Orcamento orcamento) {
        if(orcamento.getItens().size() > 10) {
            return orcamento.getValor().multiply(new BigDecimal(0.2)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        } else {
            return proximaOpcaoDesconto.calcula(orcamento);
        }
    }

    @Override
    public void proximaOpcaoDesconto(Desconto desconto) {
        this.proximaOpcaoDesconto = desconto;
    }
}
