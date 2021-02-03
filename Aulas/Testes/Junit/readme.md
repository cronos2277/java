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

## TDD
No caso o TDD consiste em programar o teste antes do código, de modo que o teste molde o código resultante. Desse modo temos a classe **Bean**:
### Bean.java
    public class Bean {

        private int id;
        private String nome;
        
        public void setNome(String nome) {	
            if(
                    nome.isEmpty() || 
                    nome.matches("\\d+") ||
                    nome.trim().length() < 4
            ) {
                throw new RuntimeException();
            }
            this.nome = nome;
        }
        
        public String getNome() {		
            return this.nome;
        }
        
        public void setId(int id) {	
            if(id < 1) throw new RuntimeException();
            this.id = id;
        }

    }

### BeanTeste.java

    import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

public class BeanTeste {

	private Bean bean;
	
        @Before
        public void setUp() {
            this.bean = new Bean();
        }
        
        @Test
        public void nomeIsNotNull() {
            this.bean.setNome("Nome");
            Assert.assertNotNull(this.bean.getNome());
        }
        
        @Test(expected = RuntimeException.class)
        public void nomeIsNotDigit() {
            this.bean.setNome("123");		
        }
        
        @Test(expected = RuntimeException.class)
        public void idIsNotNegative() {
            this.bean.setId(-1);
        }
        
        @Test(expected = RuntimeException.class)
        public void idIsNotZero() {
            this.bean.setId(0);
        }
        
        @Test(expected = RuntimeException.class)
        public void nomeIsNotEmpty() {
            this.bean.setNome("");            
        }
        
        @Test(expected = RuntimeException.class)
        public void tooShortName() {
            this.bean.setNome("abc");            
        }
    }

Os métodos com a anotação `@Before`, são executado antes dos testes, nesse caso o objeto a ser testado é inicializado antes de ser executado a bateria de testes. Além disso é possível passar argumentos a `@Test`, como nesse exemplo `@Test(expected = RuntimeException.class)`, ou seja nesse caso só é aprovado no teste, caso essa exception aconteça, por exemplo aqui:

     @Test(expected = RuntimeException.class)
        public void idIsNotNegative() {
            this.bean.setId(-1);
        }

O teste vai tentar colocar o valor de menos um no ID, e com isso o teste espera que seja disparado o erro **RuntimeException**, caso não seja o ID aceita valor nulo e isso é entendido como bug e devido a isso o teste falha.

### Verificando se na String está nula ou vazia

Nesse teste abaixo é verificado se o nome possui algum valor e conforme explicado acima, nesse teste é passado valor pelo *setter* e depois o valor é resgatado pelo *getter*, a idéia ai é ver se o setter está passando valores ao atributo e se o getter está conseguindo pegar o valor passado pelo setter.

     @Test
        public void nomeIsNotNull() {
            this.bean.setNome("Nome");
            Assert.assertNotNull(this.bean.getNome());
        }

Já aqui é passado um valor vazio como nome, no caso o teste espera que esse trecho de código de uma exception, devido a `@Test(expected = RuntimeException.class)`.

     @Test(expected = RuntimeException.class)
        public void nomeIsNotEmpty() {
            this.bean.setNome("");            
        }

### Verificando se a String de nome contém valores válidos

Abaixo é testado para ver se a String aceita dígitos, no caso o teste vai tentar colocar dígito como parametro de nome e isso deve dar uma exception, se der uma exceção, o teste irá aprovar:

    @Test(expected = RuntimeException.class)
        public void nomeIsNotDigit() {
            this.bean.setNome("123");		
        }

Nesses dois testes abaixo é verificado respectivamente se o ID aceita número negativos ou o número zero, em ambos os casos o setter deve lançar uma exceção para ser aprovado nessa etapa.

    @Test(expected = RuntimeException.class)
        public void idIsNotNegative() {
            this.bean.setId(-1);
        }
        
        @Test(expected = RuntimeException.class)
        public void idIsNotZero() {
            this.bean.setId(0);
        }

Verifica se o nome é muito curto, ou seja se o setter aceita menos de 4 caracteres para nome.

    @Test(expected = RuntimeException.class)
        public void tooShortName() {
            this.bean.setNome("abc");            
        }

Ou seja com o TDD você cria o teste e com base nesse teste você vai criando a classe, sempre sendo moldado pelo teste.