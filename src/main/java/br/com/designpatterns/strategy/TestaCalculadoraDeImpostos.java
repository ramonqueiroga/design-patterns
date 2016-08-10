package br.com.designpatterns.strategy;

import java.math.BigDecimal;


/**
 * Created by ramon on 09/08/16.
 */
public class TestaCalculadoraDeImpostos {

    public static void main(String[] args) {
        Orcamento orcamento = new Orcamento(100.00);
        CalculadorDeImpostosStrategy calculadorDeImpostosStrategy = new CalculadorDeImpostosStrategy();
        BigDecimal icmsCalculado = calculadorDeImpostosStrategy.calculaImposto(orcamento, ImpostoFactory.getImposto(ImpostoEnum.ICMS));
        BigDecimal issCalculado = calculadorDeImpostosStrategy.calculaImposto(orcamento, ImpostoFactory.getImposto(ImpostoEnum.ISS));
        System.out.println(issCalculado);
        System.out.println(icmsCalculado);
    }

}
