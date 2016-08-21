package br.com.designpatterns.chainofresponsability;

import org.reflections.Reflections;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ramon on 20/08/16.
 */
public class RegistraCadeiaDeDescontos {

    private static Desconto desconto;

    static {
        Reflections reflections = new Reflections("br.com.designpatterns.chainofresponsability");
        List<Class<?>> classList = reflections.getTypesAnnotatedWith(PrioridadeDesconto.class).stream().collect(Collectors.toList());
        classList.sort((c1, c2) -> c1.getAnnotation(PrioridadeDesconto.class).value().compareTo(c2.getAnnotation(PrioridadeDesconto.class).value()));
        Object descontoPrincipal = null;
        Object cadeiaDeDescontos = null;
        for (int i = 0; i < classList.size(); i++) {
            boolean invocaProximoDesconto = i + 1 <= classList.size()-1;
            try {
                if(cadeiaDeDescontos == null) {
                    cadeiaDeDescontos = classList.get(i).newInstance();
                    descontoPrincipal = cadeiaDeDescontos;
                }

                Object o = (invocaProximoDesconto ? classList.get(i + 1).newInstance() : null);
                invocaMetodoProximaOpcaoDesconto(o, cadeiaDeDescontos, invocaProximoDesconto);
                cadeiaDeDescontos = o;
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException | NoSuchFieldException e) {
                e.printStackTrace();
            }
        }
        desconto = (Desconto) descontoPrincipal;
    }

    private static void invocaMetodoProximaOpcaoDesconto(Object nextInstance, Object currentInstance, Boolean invocaProximoDesconto)
            throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        Method declaredMethod = currentInstance.getClass().getDeclaredMethod("proximaOpcaoDesconto", Desconto.class);
        if (invocaProximoDesconto) {
            declaredMethod.invoke(currentInstance, nextInstance);
        }
    }

    public static Desconto getCadeiaDeDescontos() {
        return desconto;
    }

}
