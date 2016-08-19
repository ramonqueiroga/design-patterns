package br.com.designpatterns.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by ramon on 09/08/16.
 */
public class Orcamento {

    private BigDecimal valor;
    private List<Item> itens;

    public Orcamento(BigDecimal valor) {
        this.valor = valor;
        this.itens = new ArrayList<>();
    }

    public Orcamento(Integer valor) {
        this.valor = new BigDecimal(valor);
        this.itens = new ArrayList<>();
    }

    public Orcamento(Double valor) {
        this.valor = new BigDecimal(valor);
        this.itens = new ArrayList<>();
    }

    public BigDecimal getValor() {
        return valor;
    }

    public List<Item> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public void adicionaItem(Item item) {
        itens.add(item);
    }

}
