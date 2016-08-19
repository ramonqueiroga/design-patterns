package br.com.designpatterns.chainofresponsability;

import br.com.designpatterns.dominio.Orcamento;

import java.math.BigDecimal;

/**
 * Created by ramon on 18/08/16.
 */
@PrioridadeDesconto(value = "2")
public class DescontoPorMaisDeQuinhentosReais implements Desconto {

    private Desconto proximaOpcaoDesconto;

    public BigDecimal calcula(Orcamento orcamento) {
        if (orcamento.getValor().compareTo(new BigDecimal("500.00")) > 0) {
            return orcamento.getValor().multiply(new BigDecimal(0.07)).setScale(2, BigDecimal.ROUND_HALF_EVEN);
        } else {
            return proximaOpcaoDesconto.calcula(orcamento);
        }
    }

    @Override
    public void proximaOpcaoDesconto(Desconto desconto) {
        this.proximaOpcaoDesconto = desconto;
    }
}
