package br.com.vraptor.horas.seguranca;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) //para métodos
@Retention(RetentionPolicy.RUNTIME)//não ser descartada pela compilacao
public @interface Open {

}
