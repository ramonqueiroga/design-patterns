package br.com.designpatterns.strategy;

import br.com.designpatterns.dominio.Orcamento;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by ramon on 18/08/16.
 */
public class CalculadorDeImpostosTest {

    @Test
    public void testaCalculadoraDeImpostos() {
        Orcamento orcamento = new Orcamento(100.00);
        CalculadorDeImpostosStrategy calculadorDeImpostos = new CalculadorDeImpostosStrategy();
        BigDecimal icms = calculadorDeImpostos.calculaImposto(orcamento, ImpostoFactory.getImposto(ImpostoEnum.ICMS));
        BigDecimal iss = calculadorDeImpostos.calculaImposto(orcamento, ImpostoFactory.getImposto(ImpostoEnum.ISS));
        assertEquals(new BigDecimal("55.00"), icms);
        assertEquals(new BigDecimal("6.00"), iss);
    }


}