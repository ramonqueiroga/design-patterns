package br.com.designpatterns.strategy;

import br.com.designpatterns.dominio.Orcamento;

import java.math.BigDecimal;

/**
 * Created by ramon on 09/08/16.
 */

public interface Imposto {
    BigDecimal calcula(Orcamento orcamento);
}
