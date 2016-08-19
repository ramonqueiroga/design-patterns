package br.com.designpatterns.chainofresponsability;

import br.com.designpatterns.dominio.Orcamento;

import java.math.BigDecimal;

/**
 * Created by ramon on 18/08/16.
 */
public class CalculadoraDeDescontos {

   public BigDecimal calcula(Orcamento orcamento) {
       //TODO: CRIAR UMA CLASSE QUE REGISTRA AS PRIORIDADES DE DESCONTO PELA ORDEM DEFINIDA
       Desconto descontoPrincipal = new DescontoPorCincoItens();
       Desconto desconto2 = new DescontoPorMaisDeQuinhentosReais();
       Desconto semDesconto = new SemDesconto();

       descontoPrincipal.proximaOpcaoDesconto(desconto2);
       desconto2.proximaOpcaoDesconto(semDesconto);

       return descontoPrincipal.calcula(orcamento);
   }

}
