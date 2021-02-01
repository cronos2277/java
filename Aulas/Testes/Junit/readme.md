# JUnit
Documentação: [Classe Assert](http://junit.sourceforge.net/javadoc/org/junit/Assert.html), [JUnit 5 documentação](https://junit.org/junit5/docs/current/user-guide/)

1.[Básico](#básico)

2.[Arrumando](#arrumando)

## Básico
[Calculadora](Calculadora.java)

[Test](Test.java)

Inicialmente temos a classe 

    public class Calculadora {
	    public int somar(int a, int b) {
		    return (a+b);
	    }
    }

O teste unitário tem uma característica, que é justamente a característica de executar em unidades, nesse caso em um método, que seguindo a analogia seria a unidade. Nesse caso será usado o **JUnit**, para tal você precisa criar uma classe `class Test {}` e dentro dela assinalar com a anotation `@Test` todos os métodos que irão executar os testes, essa anotação vem de `@org.junit.jupiter.api.Test`. Lembrando que esse método deve ser sempre público e deve retornar *void*, ou seja não pode conter retorno. Qualquer método sem a anotação `@Test` serão sumariamente ignorados, exemplo:

    @org.junit.jupiter.api.Test
	public void soma1() {
		Calculadora cal = new Calculadora();		
		org.junit.Assert.assertTrue(10 == cal.somar(5, 5));
	}

### Primeiro exemplo
Nesse exemplo mais básico é usado o package.classe para ficar explícito da onde cada método, anotação ou atributo vem. No caso é instanciado o objeto a ser testado `Calculadora cal = new Calculadora();` e então é feito um teste `org.junit.Assert.assertTrue(10 == cal.somar(5, 5));`, sendo o primeiro argumento o valor que deveria ser do output e o segundo o método a ser testado, sempre lembrando que testes unitátios tem foco nos métodos. O método `assertTrue` da classe `Assert` valida o teste se o argumento recebido for true, nesse caso esse teste é bom para valores booleanos.

### Segundo exemplo
    @org.junit.jupiter.api.Test
	public void soma2() {
		org.junit.Assert.assertEquals(10, new Calculadora().somar(5, 5));
	}

Aqui já é usado um outro método de *Assert* que é o *assertEquals* que verifica se existe igualdade se comparado os dois agumentos do método.


## Arrumando

### Maven

    <!-- https://mvnrepository.com/artifact/junit/junit -->
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.1</version>
        <scope>test</scope>
    </dependency>

[Repositório no Maven](https://mvnrepository.com/artifact/junit/junit)

[JUnit no Eclipse](https://nglauber.medium.com/junit-no-eclipse-ebd134fcf6d4)

[the import org.junit cannot be resolved in Eclipse](https://www.toddlahman.com/import-org-junit-cannot-resolved-eclipse/#:~:text=The%20error%20occurs%20because%20the,Build%20Path%20%3E%20Configure%20Build%20Path.&text=Now%20select%20the%20latest%20version,JUnit%20library%2C%20then%20click%20Finish.)