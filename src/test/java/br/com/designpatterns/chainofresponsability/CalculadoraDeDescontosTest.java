package br.com.designpatterns.chainofresponsability;

import br.com.designpatterns.dominio.Item;
import br.com.designpatterns.dominio.Orcamento;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * Created by ramon on 18/08/16.
 */
public class CalculadoraDeDescontosTest {

    @Test
    public void testaCalculadoraDeDescontosComMaisDeCincoItens() {
        CalculadoraDeDescontos calculadoraDeDescontos = new CalculadoraDeDescontos();
        Orcamento orcamento = new Orcamento(1500.0);
        orcamento.adicionaItem(new Item("CANETA", 250.00));
        orcamento.adicionaItem(new Item("LAPIS", 250.00));
        orcamento.adicionaItem(new Item("PAPEL", 250.00));
        orcamento.adicionaItem(new Item("BORRACHA", 250.00));
        orcamento.adicionaItem(new Item("CADERNO", 250.00));
        orcamento.adicionaItem(new Item("RÉGUA", 250.00));

        BigDecimal desconto = calculadoraDeDescontos.calcula(orcamento);
        assertEquals(new BigDecimal("150.00"), desconto);
    }

    @Test
    public void testaCalculadoraDeDescontosComMaisDeQuinhentosReais() {
        CalculadoraDeDescontos calculadoraDeDescontos = new CalculadoraDeDescontos();
        Orcamento orcamento = new Orcamento(750.00);
        orcamento.adicionaItem(new Item("CANETA", 250.00));
        orcamento.adicionaItem(new Item("LAPIS", 250.00));
        orcamento.adicionaItem(new Item("PAPEL", 250.00));

        BigDecimal desconto = calculadoraDeDescontos.calcula(orcamento);
        assertEquals(new BigDecimal("52.50"), desconto);
    }

    @Test
    public void testaCalculadorDeDescontosComMaisDeDezItens() {
        CalculadoraDeDescontos calculadoraDeDescontos = new CalculadoraDeDescontos();
        Orcamento orcamento = new Orcamento(2750.0);
        orcamento.adicionaItem(new Item("CANETA", 250.00));
        orcamento.adicionaItem(new Item("LAPIS", 250.00));
        orcamento.adicionaItem(new Item("PAPEL", 250.00));
        orcamento.adicionaItem(new Item("BORRACHA", 250.00));
        orcamento.adicionaItem(new Item("CADERNO", 250.00));
        orcamento.adicionaItem(new Item("RÉGUA", 250.00));
        orcamento.adicionaItem(new Item("CANETA", 250.00));
        orcamento.adicionaItem(new Item("LAPIS", 250.00));
        orcamento.adicionaItem(new Item("PAPEL", 250.00));
        orcamento.adicionaItem(new Item("BORRACHA", 250.00));
        orcamento.adicionaItem(new Item("BORRACHA", 250.00));

        BigDecimal desconto = calculadoraDeDescontos.calcula(orcamento);
        assertEquals(new BigDecimal("550.00"), desconto);

    }

}