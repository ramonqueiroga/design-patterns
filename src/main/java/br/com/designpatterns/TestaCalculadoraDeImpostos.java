package br.com.designpatterns;

import java.math.BigDecimal;


/**
 * Created by ramon on 09/08/16.
 */
public class TestaCalculadoraDeImpostos {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(100.00);
        CalculadorDeImpostosStrategy calculadorDeImpostosStrategy = new CalculadorDeImpostosStrategy();
        BigDecimal impostoCalculado = calculadorDeImpostosStrategy.calculaImposto(orcamento, ImpostoFactory.getImposto(ImpostoEnum.ICMS));
        System.out.println(impostoCalculado);
    }

}
