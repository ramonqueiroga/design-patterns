package br.com.designpatterns.chainofresponsability;

import br.com.designpatterns.dominio.Orcamento;

import java.math.BigDecimal;

/**
 * Created by ramon on 18/08/16.
 */
public interface Desconto {
    public BigDecimal calcula(Orcamento orcamento);
    void proximaOpcaoDesconto(Desconto desconto);
}
