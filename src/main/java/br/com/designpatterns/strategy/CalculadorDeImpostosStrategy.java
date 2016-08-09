package br.com.designpatterns.strategy;

import java.math.BigDecimal;

/**
 * Created by ramon on 09/08/16.
 */
public class CalculadorDeImpostosStrategy {

    public BigDecimal calculaImposto(Orcamento orcamento, Imposto imposto) {
        return imposto.calcula(orcamento).setScale(2, BigDecimal.ROUND_HALF_EVEN);
    }

}
