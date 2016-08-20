package br.com.designpatterns.chainofresponsability;

import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by ramon on 20/08/16.
 */
public class RegistraCadeiaDeDescontos {

    private static Desconto descontoPrincipal;

    static {
        Reflections reflections = new Reflections("br.com.designpatterns.chainofresponsability");
        List<Class<?>> classList = reflections.getTypesAnnotatedWith(PrioridadeDesconto.class).stream().collect(Collectors.toList());
        classList.sort((c1, c2) -> c1.getAnnotation(PrioridadeDesconto.class).value().compareTo(c2.getAnnotation(PrioridadeDesconto.class).value()));
        Map<Integer, Object> objects = new HashMap<>();
        for (int i = 0; i < classList.size(); i++) {
            boolean invocaProximoDesconto = i + 1 <= classList.size()-1;
            try {
                objects.put(i, classList.get(i).newInstance());
                invocaMetodoProximaOpcaoDesconto((invocaProximoDesconto ? classList.get(i + 1) : null), classList.get(i), objects.get(i), invocaProximoDesconto);
            } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
                e.printStackTrace();
            }
        }
        descontoPrincipal = (Desconto) objects.get(0);
    }

    private static void invocaMetodoProximaOpcaoDesconto(Class<?> nextInstance, Class<?> currentClass, Object currentInstance, Boolean invocaProximoDesconto)
            throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException {
        Method declaredMethod = currentClass.getDeclaredMethod("proximaOpcaoDesconto", Desconto.class);
        if (invocaProximoDesconto) {
            declaredMethod.invoke(currentInstance, nextInstance.newInstance());
        }
    }

    public static Desconto getCadeiaDeDescontos() {
        return descontoPrincipal;
    }

}
