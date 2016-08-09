package br.com.designpatterns;

import java.math.BigDecimal;

/**
 * Created by ramon on 09/08/16.
 */
@ImpostoImpl(tipoImposto = ImpostoEnum.ICMS)
public class ICMS implements Imposto {

    public BigDecimal calcula(Orcamento orcamento) {
        return orcamento.getValor().multiply(new BigDecimal(0.05)).add(new BigDecimal(50.00));
    }

}
