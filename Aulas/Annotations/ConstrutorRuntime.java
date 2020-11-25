package annotations;

import static java.lang.annotation.ElementType.CONSTRUCTOR;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME) //Que tipo de anotacao?
@Target(CONSTRUCTOR) //Alvo
public @interface ConstrutorRuntime {
	String valor() default "valor";
}
