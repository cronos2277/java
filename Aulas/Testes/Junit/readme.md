# JUnit
Documentação: [Classe Assert](http://junit.sourceforge.net/javadoc/org/junit/Assert.html), [JUnit 5 documentação](https://junit.org/junit5/docs/current/user-guide/)

1.[Básico](#básico)

2.[Arrumando](#arrumando)

3.[TDD](#tdd)

4.[BDD](#bdd)

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

## AssertJ
### No Maven
    <!-- https://mvnrepository.com/artifact/org.assertj/assertj-core -->
    <dependency>
        <groupId>org.assertj</groupId>
        <artifactId>assertj-core</artifactId>
        <version>3.19.0</version>
        <scope>test</scope>
    </dependency>

### Exemplo
[Exemplo](Exemplo.java)

    public class Exemplo {
        private int id;
        private String value;
        
        public int getId() {
            return this.id;
        }
        
        public void setId(int id) {		
            if(id < 1) throw new RuntimeException();
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            if(value == null) throw new NullPointerException();
            if(value == "" || value.trim().length() == 0) throw new NullPointerException();
            if(value.matches("\\d+")) throw new RuntimeException();
            this.value = value;
        }
    }


### Teste
[ExemploTeste](ExemploTeste.java)

    import org.junit.Before;
    import org.junit.Test;

    //Novidade
    import org.assertj.core.api.Assertions;

    public class ExemploTeste {
        
        private Exemplo exemplo;
        @Before
        public void init() {
            this.exemplo = new Exemplo();
        }
        
        @Test
        public void validId() {
            this.exemplo.setId(1);
            Assertions.assertThat(this.exemplo.getId())
            .isGreaterThan(0)
            .isNotNull();
        }
        
        @Test(expected = RuntimeException.class)
        public void notNegativeId() {
            this.exemplo.setId(-1);		
        }
        
        @Test(expected = RuntimeException.class)
        public void notZeroId() {
            this.exemplo.setId(0);
        }
        
        @Test
        public void validValue() {
            this.exemplo.setValue("abcd");
            Assertions.assertThat(this.exemplo.getValue())
            .hasSizeGreaterThan(3)
            .isNotNull()
            .isNotEmpty();		
        }
        
        @Test(expected = NullPointerException.class)
        public void notNullValue() {
            this.exemplo.setValue(null);
        }
        
        @Test(expected = NullPointerException.class)
        public void notEmptyValue() {
            this.exemplo.setValue("");
        }
        
        @Test(expected = RuntimeException.class)
        public void notDigitsValue() {
            this.exemplo.setValue("12345");		
        }
    }

Existe também o `Assertions` que permite fazer testes mais avançados, no caso o método `assertThat` permitem encadear métodos, segue a [Documentação](https://joel-costigliola.github.io/assertj/), para usar-lo, depois de implementado no arquivo *pom.xml* importa-se essa biblioteca `import org.assertj.core.api.Assertions;`.

Testando com um valor válido

     @Test
        public void validId() {
            this.exemplo.setId(1);
            Assertions.assertThat(this.exemplo.getId())
            .isGreaterThan(0)
            .isNotNull();
        }

Se não der nenhum problema em inserir 1 como ID, o teste continua, com essa biblioteca você pode fazer testes mais avançados.

## BDD

    <!-- https://mvnrepository.com/artifact/org.mockito/mockito-core -->
    <dependency>
        <groupId>org.mockito</groupId>
        <artifactId>mockito-core</artifactId>
        <version>3.7.7</version>
        <scope>test</scope>
    </dependency>		

Se faz necessário colocar essa dependencia no *Maven*. O BDD é um teste de comportamento, no caso é verifica se determinado método foi executado, quantas vezes, o que esse método retorna e etc... Mas diferente do *TDD* o foco aqui é o comportamento do método e das classes e não a construção.

### Mock básico
[Classe Modelo](Modelo.java)
[Modelo Teste](ModeloTeste.java)

    package Jotape.test;
    import Jotape.test.Modelo;

    import org.assertj.core.api.Assertions;
    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.mockito.Mockito;
    import org.mockito.junit.MockitoJUnitRunner;

    @RunWith(MockitoJUnitRunner.class)
    public class ModeloTeste {        
        @Test
        public void basicoTeste() {
            Modelo modelo = Mockito.mock(Modelo.class);
            Mockito.when(modelo.getId()).thenReturn(1);
            int scene1 = modelo.getId();
            Assertions.assertThat(scene1).isEqualTo(1);            
        }
    }

Esse é o modelo mais básico de *BDD*, inicialmente é sinalizado que essa classe deve ser processada pelo mockito `@RunWith(MockitoJUnitRunner.class)`, e no método tem que ter a marcação com o `@Test`. A classe passada como argumento de `@RunWith` vem de `import org.mockito.junit.MockitoJUnitRunner;`.

#### Instanciando com o Mock
    Modelo modelo = Mockito.mock(Modelo.class);

Aqui é instanciado o objeto para teste, repare que o objeto não é instanciado de maneira direta e sim é instanciado dentro de um objeto *mock* conforme demonstrado aqui `Mockito.mock(Modelo.class);`. Aqui estamos impondo um comportamento ao método `Mockito.when(modelo.getId()).thenReturn(1);`, dizendo que ele deve retornar *1*, ou seja nessa expressão `int scene1 = modelo.getId();` vai retornar para a variável *scene* o valor *1*, nesse caso estamos impondo um retorno ao método para ver como ele se comporta dentro do teste, no caso esse valor deve ser compatível com o seu retorno. O objeto singleton Mockito vem de `import org.mockito.Mockito;`, aqui fazemos a verificação para ver se o retorno bate com o esperado `Assertions.assertThat(scene1).isEqualTo(1);`, no caso se esse `int scene1 = modelo.getId();` é igual ao valor passado aqui `.isEqualTo(1);`.

### Um exemplo um pouco mais avançado
[MockTesteModelo](MockTesteModelo.java)

    import org.junit.Test;
    import org.junit.runner.RunWith;
    import org.mockito.InOrder;
    import org.mockito.Mock;
    import org.mockito.Mockito;
    import org.mockito.junit.MockitoJUnitRunner;

    @RunWith(MockitoJUnitRunner.class)
    public class MockTesteModelo {
    
    	@Mock
    	private Modelo modelo;
    
    	@Test
    	public void callingNumber() {		
    		this.modelo.setNumero(1000);
    		this.modelo.getNumero();
    
    		//Verifica se foi chamado independente da ordem
    		Mockito.verify(this.modelo).getNumero();
    		Mockito.verify(this.modelo).setNumero(1000);				
    	}
    
    	@Test
    	public void workingId() {
    		InOrder order1 = Mockito.inOrder(this.modelo);
    		this.modelo.setId(1);
    		this.modelo.getId();		
    
    		//Verifica se os metodos foram chamados seguindo a ordem abaixo.		
    		order1.verify(this.modelo).setId(1);
    		order1.verify(this.modelo).getId();
    	}	
    
    	@Test
    	public void workingValue() {
    		this.modelo.setValue("Exemplo");
    		Mockito.verify(this.modelo,Mockito.times(1)).setValue("Exemplo");
    		Mockito.verify(this.modelo,Mockito.never()).getValue();
    	}
    }

### Substituindo a instanciação.
Uma outra forma de instanciação  a esse trecho `Modelo modelo = Mockito.mock(Modelo.class);` seria:

    @RunWith(MockitoJUnitRunner.class)
    public class MockTesteModelo {
    
    	@Mock
    	private Modelo modelo;

Você precisará de duas anotações, essa para indicar essa classe do Mockito `@RunWith(MockitoJUnitRunner.class)` que vem de `import org.mockito.junit.MockitoJUnitRunner;`, assim como `@Mock` vem de `import org.mockito.Mock;`, dessa forma a classe de teste instancia de maneira automática o objeto.

### Método Verify
    @Test
    public void callingNumber() {		
        this.modelo.setNumero(1000);
        this.modelo.getNumero();

        //Verifica se foi chamado independente da ordem
        Mockito.verify(this.modelo).getNumero();
        Mockito.verify(this.modelo).setNumero(1000);				
    }

Com o método verifu do objeto *Mockito* oriundo de `import org.mockito.Mockito;`, analisa se o método foi executado apenas uma vez, esse método verifica, quando omitido o segundo parametro se o método foi executado, passando determinado padrão independente da ordem, isso é importante ressaltar, aqui a ordem não importa, no caso aqui `Mockito.verify(this.modelo).setNumero(1000);` estamos verificando se o método `setNumero` com o argumento de *100*, foi executado ao menos uma vez, e como no método acima temos isso `this.modelo.setNumero(1000);`, logo tende a ter aprovação, além disso é verificado se também foi executado o método `getNumero()` ao menos uma vez, veja que a ordem aqui foi ignorado. No caso o método *setter* foi executado e após isso foi executado o *getter*, porém a ordem não importa, independente de qual se executa primeiro, o importante é que ambos sejam executados, antes de executar a verificação para que haja a aprovação. Você passa um objeto do tipo Mock para o método verify `Mockito.verify(this.modelo)` e após isso você executa o método que você quer analizar, com o parametro a ser analizado `.setNumero(1000);` ou `.getNumero();`.

### InOrder

    @Test
    public void workingId() {
        InOrder order1 = Mockito.inOrder(this.modelo);
        this.modelo.setId(1);
        this.modelo.getId();		

        //Verifica se os metodos foram chamados seguindo a ordem abaixo.		
        order1.verify(this.modelo).setId(1);
        order1.verify(this.modelo).getId();
    }	

O verify do objeto inOrder leva a ordem com que o método foi executado em consideração, a classe *InOrder* vem de `import org.mockito.InOrder;` e esse objeto é criado com base no *Mockito* e não na instanciação `InOrder order1 = Mockito.inOrder(this.modelo);`, e no caso esse é o trecho de avaliação `order1.verify(this.modelo)` e aqui analizado o método com os argumentos `.setId(1);`, `.getId();`. Logo:

    order1.verify(this.modelo).setId(1);
    order1.verify(this.modelo).getId();

Nesse exemplo é verificado se foi executado nessa ordem o `setId` com o argumento *1*, e após isso o *getId* exatamente nessa ordem, se o parametro for diferente, tanto o *verify* básico, como o do *order* reprovam, agora se a ordem não for respeitado, o *verify* básico aprova e o do *order* não.

### Passando o segundo argumento ao verify

    @Test
    public void workingValue() {
        this.modelo.setValue("Exemplo");
        Mockito.verify(this.modelo,Mockito.times(1)).setValue("Exemplo");
        Mockito.verify(this.modelo,Mockito.never()).getValue();
    }

`Mockito.times(N)` => Verifica se foi executado *N* vezes determindo método, nesse exemplo o `setValue` com o argumento sendo `"Exemplo"`. Se a quantidade de vezes for menor ou mais ao *N*, o teste reprova.

`Mockito.never()` => Verifica se não foi executado, reprova caso seja executado o método uma ou mais vezes.