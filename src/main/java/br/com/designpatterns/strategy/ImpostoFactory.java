package br.com.designpatterns.strategy;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by ramon on 09/08/16.
 */
public class ImpostoFactory {

    private static Map<ImpostoEnum, Imposto> factory = new HashMap<>();

    static {
        Reflections reflections = new Reflections("br.com.designpatterns");
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(ImpostoImpl.class);
        for (Class<?> aClass : typesAnnotatedWith) {
            ImpostoEnum impostoEnum = aClass.getAnnotation(ImpostoImpl.class).tipoImposto();
            try {
                factory.put(impostoEnum, (Imposto) aClass.newInstance());
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static Imposto getImposto(ImpostoEnum impostoEnum) {
        return factory.get(impostoEnum);
    }

}
