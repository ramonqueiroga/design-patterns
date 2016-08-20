package br.com.designpatterns.chainofresponsability;

import br.com.designpatterns.dominio.Orcamento;

import java.math.BigDecimal;

import static br.com.designpatterns.chainofresponsability.RegistraCadeiaDeDescontos.getCadeiaDeDescontos;

/**
 * Created by ramon on 18/08/16.
 */
public class CalculadoraDeDescontos {

   public BigDecimal calcula(Orcamento orcamento) {
       return getCadeiaDeDescontos().calcula(orcamento);
   }

}
