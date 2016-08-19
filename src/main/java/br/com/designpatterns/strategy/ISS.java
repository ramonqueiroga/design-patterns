package br.com.designpatterns.strategy;

import br.com.designpatterns.dominio.Orcamento;

import java.math.BigDecimal;

/**
 * Created by ramon on 09/08/16.
 */
@ImpostoImpl(tipoImposto = ImpostoEnum.ISS)
public class ISS implements Imposto {

    public BigDecimal calcula(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal(0.06));
    }

}
