package br.com.designpatterns;

import java.math.BigDecimal;

/**
 * Created by ramon on 09/08/16.
 */

public interface Imposto {
    BigDecimal calcula(Orcamento orcamento);
}
