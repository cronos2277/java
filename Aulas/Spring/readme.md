# Java Spring
## XML
## Instalando
Esse é o arquivo pom.xml que foi usado. Você pode encontra-lo aqui:[pom.xml](pom.xml)

    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>Spring</groupId>
    <artifactId>home</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>home</name>
    <url>http://maven.apache.org</url>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>   
    </properties>

    <dependencies>		
        <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>3.8.1</version>
        <scope>test</scope>
        </dependency>
        
        <!-- DEPENDÊNCIAS DO SPRING -->
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
        <dependency>
        <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>5.2.8.RELEASE</version>
        </dependency>	
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-beans -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>5.2.8.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-aop -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>5.2.8.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-expression -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-expression</artifactId>
            <version>5.2.8.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.2.8.RELEASE</version>
        </dependency>
    </dependencies>	
    </project>

## Arquivo Básico
### Um Exemplo com comentários explicando.
    <?xml version="1.0" encoding="UTF-8"?>
        <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN"
        "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
        <beans> <!-- Aqui dentro voce coloca todos os Beans -->
            <!-- Aqui dentro voce informa a classe, o nome eh a referencia a ser usada e o class eh o path e a classe da mesma sem o .JAVA-->
	        <bean name="bean1" class="Spring.home.Bean1" > 
		    <!-- Aqui voce informa os atributos do objeto, no caso o Spring vai procurar por um setValor quando for escrever e getValor na leitura -->
		    <!-- No value temos o valor padrao. -->
		    <property name="valor" value="valor Padrao1"/>
	    </bean>
	    <!-- 
		    Cuidado do o DOCTYPE, recomenda-se copiar e colar da internet para nao errar na digitacao. No caso o Spring vai instanciar essa classe 
		    e injeta-la quando voce precisar, evitando assim acoplamento e um excesso de objeto instanciado.
	    -->
        </beans>

### Um exemplo de um arquivo sem comentários
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN"
            "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="bean1" class="Spring.home.Bean1" >		
            <property name="valor" value="valor Padrao"/>
        </bean>	
    </beans>

## Explicando
### Arquivo XML.
Você o encontra aqui esse arquivo básico: [ApplicationContext](ApplicationContext.xml)

### Sobre o XML Acima.

`<?xml version="1.0" encoding="UTF-8"?>` => Codificação do XML, recomenda-se o uso do UTF-8 para evitar problemas com caractéres latinos.

`<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">` => Arquivo de validacao do XML, jogue essa url na web para ver isso ainda está validando. Essa url precisa funcionar para esse ser um arquivo de validação, o java requer um doctype válido para funcionar, ai está uma cópia se quiser dar uma olhada [spring-beans-2.0.dtd](spring-beans-2.0.dtd).

`<beans>` **O BEAN AQUI** `</beans>` => Um container de beans o seu bean deve estar dentro dessas tags.

`<bean name="bean1" class="Spring.home.Bean1" >` **property** `</bean>` => Aqui fica a definição da sua classe, ao qual o Spring deve fazer a injeção de dependência. O **name** é como ele será referenciado e o **class** é path mais o nome da classe. XML e Java são sensetive case.

`<property name="valor" value="valor Padrao"/>` => Nesse contexto o name se refere ao atributo e o value, o valor inícial que esse atributo deve ter, você deve usar apenas se voce quiser que esse atributo inicie com algum valor. Lembrando que essa estratégia ela é apenas para valores do tipo primitivo, como String, Integer e etc... Se for um objeto a estratégia é outra, além disso o Spring vai procurar pelo Getter e o setter dele, ambos devem existir, no caso como o **name="valor"** deve existir na classe um setValor e um getValor. Com relação ao tipo voce pode especificar colocando um **type** no property, argumento que foi omitido nesse exemplo, ou apenas colocar o dado e no caso o Spring analisa o tipo pelo contexto.

## Como acessar esses valores do XML?
Nesse exemplo acima se quiser acessar esses valores você vai precisar fazer dois imports:

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

para conseguir fazer esses dois imports acima, você precisará dessa parte do código no seu arquivo pom.xml, Aqui estamos usando a versão 5.2.8

    <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.2.8.RELEASE</version>
        </dependency>
    </dependencies>	

No código, para acessar o Bean instanciado em tempo de execução:

`ApplicationContext app = new ClassPathXmlApplicationContext("/Spring/home/ApplicationContext.xml");` => No construtor você passa o Path mais o arquivo XML em questão.

`Bean1 bean = (Bean1) app.getBean("bean1");` => Essa parte seria o equivalente ao `Bean bean = new Bean` e `bean.setValor("valor Padrao");` uma vez que existe uma property no arquivo xml acima definido um valor padrão para esse bean. No caso é exatamente isso que o Spring faz, instanciar classes automaticamente e controla-las dando assim mais desempenho e maior escalabilidade, uma vez que isso pode ser tudo resolvido por anotations ou por XML. Não esqueça de dar um cast, uma vez que o método getBean retorna um **Object**, penso que seria uma boa tratar isso com **try** e **catch** também. Esse bean1 passado como parametro no método, faz referência a esse campo aqui: `<bean name="bean1" class="Spring.home.Bean1" >`. Lembrando que essa estratégia é para dados primitivos.

`bean.getValor()` => Pronto agora você pode acessar normalmente o seu Bean, com a instanciação sendo gerenciada pelo Spring.

#### Evitando os cast...
##### Método Main
    public class App 
    {
        public static void main( String[] args )
        {
            ApplicationContext app1 = new ClassPathXmlApplicationContext("/Spring/init/xml/init.xml");
            InitBean1 bean1 = app1.getBean(InitBean1.class);	
            InitBean2 bean2 = (InitBean2) app1.getBean("init2");
            System.out.println(bean1);
            System.out.println(bean2);
        }
    }

Forma sem cast `InitBean1 bean1 = app1.getBean(InitBean1.class);`, forma com cast ` InitBean2 bean2 = (InitBean2) app1.getBean("init2");`, desde a terceira versão do Spring, foi implementado o suporte a genérico e devido a isso, você pode passar como parametro a classe ao invés de passar a string contendo o nome do bean e evitando assim um problema em tempo de execução.

### Mapeando dados não primitivos.
#### Essa é a classe **Bean2**, ao qual está contido dentro de **Bean1**.

    import javax.swing.JOptionPane;
    public class Bean2 {
	    public void mensagem(String ...parametro){
		    for(String mensagem:parametro) {
			    JOptionPane.showMessageDialog(null, mensagem);
		    }
		
	    }
    }

#### Aqui esta a classe **Bean1**.
    public class Bean1 {
	private int id;
	private String valor;
	private Bean2 bean;	
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getValor() {
            return valor;
        }
        public void setValor(String valor) {
            this.valor = valor;
        }
        public Bean2 getBean() {
            return bean;
        }
        public void setBean(Bean2 bean) {
            this.bean = bean;
        }
    }

No caso para fazer referência ao **Bean2** a estratégia é diferente, no caso o seu property vai ter a seguinte estrutura:

#### No caso o XML ficaria assim:
    
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
	    <bean name="bean1" class="Spring.home.Bean1" >		
		    <property name="valor" value="valor Padrao"/>
		    <!-- Aqui fazemos a ligacao com o Bean2 como um atributo do Bean1 -->
		    <property name="bean" ref="beanId" />
	    </bean>	
	    <!-- Aqui temos o Bean2 -->
	    <bean id="beanId" name="bean2" class="Spring.home.Bean2" ></bean>	
    </beans>


`<bean id="beanId" name="bean2" class="Spring.home.Bean2" ></bean>` => O bean a ser referenciado precisa ter um ID.

`<property name="bean" ref="beanId" />` => Esse property vai dentro do elemento que contem, repare que temos um **ref** ali, esse ref, faz referência a um ID, por isso que o bean2 precisou ter um ID,
 justamente para que o mesmo pudesse ser referenciado.

### Injetando via construtor
#### XML contendo o Bean3
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="bean1" class="Spring.home.Bean1" >		
            <property name="valor" value="valor Padrao"/>		
            <property name="bean" ref="beanId" />
        </bean>	
        <bean id="beanId" name="bean2" class="Spring.home.Bean2" ></bean>	
        <bean name="bean3" class="Spring.home.Bean3">

            <!-- Aqui estamos injetando valores no construtor a forma eh essa, repare que o Spring descobre o tipo sozinho -->
            <constructor-arg value="Valor"/>
            <constructor-arg value="1"/>
            <constructor-arg value="true"/>
        </bean>
    </beans>

#### A Classe do Bean3.

    public class Bean3 {
        private String valor1;
        private int valor2;
        private boolean valor3;
        
        //Repare que temos um tipo String, um integer e um boolean e isso nao eh dito no XML acima
        public Bean3(String valor1, int valor2, boolean valor3) {
            this.valor1 = valor1;
            this.valor2 = valor2;
            this.valor3 = valor3;
        }	
        
        @Override
        public String toString() {
            return "Valor 1: "+this.valor1+", Valor2: "+this.valor2+", Valor3: "+this.valor3;
        }
    }

A forma básica é essa, dentro do seu bean: `<bean name="bean3" class="Spring.home.Bean3"></bean>` você coloca os **constructor-arg** `<constructor-arg value="Valor"/>`, um para cada parametro do seu bean, no caso a nossa classe Bean3 tem um construtor que recebe 3 argumentos, um de cada tipo, como visto nessa parte: `public Bean3(String valor1, int valor2, boolean valor3)`, logo no XML que é usado para configurar o Bean se faz necessário informar isso lá, como informado nesse trecho, repare que no XML não é informado os tipos, o Spring descobre isso sozinho:

    <bean name="bean3" class="Spring.home.Bean3">		
		<constructor-arg value="Valor"/>
		<constructor-arg value="1"/>
		<constructor-arg value="true"/>
	</bean>

### ApplicationContext ou BeanFactory
No caso sempre que possível use o **ApplicationContext**, uma vez que este é mais completo.

#### Exemplo de uso do **ApplicationContext**, usando os beans acima.
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    ApplicationContext app1 = new ClassPathXmlApplicationContext("/Spring/home/ApplicationContext.xml");
    System.out.println(app1.getBean("bean3"));

#### Exemplo de uso do **BeanFactory**, usando os beans acima.
    import org.springframework.context.ApplicationContext;
    import org.springframework.beans.factory.BeanFactory;
    BeanFactory app2 = new ClassPathXmlApplicationContext("/Spring/home/ApplicationContext.xml");
    System.out.println(app2.getBean("bean3"));

repare que os dois instanciam de `new ClassPathXmlApplicationContext("/Spring/home/ApplicationContext.xml");`. A String informada ali corresponde ao nome do XML aonde tem essas configurações e o Path para esse arquivo, instanciando a classe `ApplicationContext app = new ClassPathXmlApplicationContext` você inicia os Beans mapeados e para acessar os beans `app.getBean("bean3")`, com esse método você acessa o bean, uma vez acessado o bean você ja pode usar os setters e getters desse bean sem se preocupar com erros do tipo **NullPointerException**, uma vez que os mesmos serão inicializados com um valor padrão.

### ClassPathXmlApplicationContext
Você também pode usa-lo caso queira controlar o fluxo do Bean:

        ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/annotations/ApplicationContext.xml");
    	ApplicationContext app = classPath;
    	Bean1 bean = (Bean1) app.getBean("bean1");    

Dessa forma você consegue trabalhar o ciclo do bean se for o caso, o `ClassPathXmlApplicationContext` te da opções que vão além do `ApplicationContext` e você pode manter uma instância do `ClassPathXmlApplicationContext` se for o caso, com ele você pode por exemplo destruit um beam com o método `close()`, por exemplo : `classPath.close()`, para um gerenciamento de bean mais minuncioso pode ser interessante manter a instancia de `ClassPathXmlApplicationContext`, podendo ser moldado para um `ApplicationContext` se for o caso, como feito nessa linha: `ApplicationContext app = classPath`
### Collections SET e LIST
Aqui nós temos alguns exemplos de collections, no caso do **SET** e do **MAP**, você precisa informar um property que tenha o nome do atributo e dentro do property iniciar o **SET** ou o **LIST** com os valores que você deseja que seja inicializados.

#### Exemplos com o LIST
    <property name="lista">
			<list>
				<value>Item 1</value>
				<value>Item 2</value>
				<value>Item 3</value>
			</list>						
	</property>

#### Exemplos com o SET
    <property name="numeros">
			<set>
				<value>1</value>
				<value>2</value>
				<value>3</value>
			</set>
		</property>

Repare que a estrutura para os dois é a mesma, você deve criar uma tag **SET** ou **List** que sirva de container para os seus valores, uma vez feito isso, basta coloca-los dentro de um property, cujo o name é o atributo em questão.

### Collections com o MAP e Properties

O **MAP** já é um pouco diferente, no caso ao invés do **value**, você deve criar uma **entry** que contém como atributo uma **key** e um atributo **value** ou o **value** deve ser uma tag filho de **entry**, o **property** deve conter o nome do atributo da classe em questão.

#### MAP XML
		<property name="eventos">
			<map>
				<entry key="evento1" value="true"/>
				<entry key="evento2" value="false"/>
			</map>			
		</property>

**Properties** a estrutura é semelhante, porém ao invés de um **MAP**, você tem o **props** no *plural* e dentro do **props** no *plural* você tem os **prop** no *singular* que tem a chave com o valor dentro das tags a ser inicializado.

#### Properties XML
    <property name="propriedades">
			<props>
				<prop key="atributo1">valor1</prop>
				<prop key="atributo2">valor2</prop>				
			</props>
	</property>

### A classe Bean 4 que contém os atributos collections
Aqui nós temos uma classe que tem coleções, no caso a classe usada nas coleções acima, reparem que eles tem getters e setters como os atributos normais, no caso a estratégia de inicialização foi por setter, mas poderia ser por construtor também.

#### Bean4.java
    public class Bean4 {
        private List<String> lista;
        private Map<String,Boolean> eventos;
        private Set<Integer> numeros;
        private Properties propriedades;
        
        public Properties getPropriedades() {
            return propriedades;
        }
        public void setPropriedades(Properties propriedades) {
            this.propriedades = propriedades;
        }
        public List<String> getLista() {
            return lista;
        }
        public void setLista(List<String> lista) {
            this.lista = lista;
        }
        public Map<String, Boolean> getEventos() {
            return eventos;
        }
        public void setEventos(Map<String, Boolean> eventos) {
            this.eventos = eventos;
        }
        public Set<Integer> getNumeros() {
            return numeros;
        }
        public void setNumeros(Set<Integer> numeros) {
            this.numeros = numeros;
        }
            
        @Override
        public String toString() {
            return "Lista: "+this.lista
                    +"\nEventos: "+this.eventos
                    +"\nNumeros: "+this.numeros
                    +"\nPropriedades: "+this.propriedades;
        }
    }   

#### O XML contendo o Bean4

    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="bean1" class="Spring.home.Bean1" >		
            <property name="valor" value="valor Padrao"/>		
            <property name="bean" ref="beanId" />
        </bean>	
        <bean id="beanId" name="bean2" class="Spring.home.Bean2" ></bean>	
        <bean name="bean3" class="Spring.home.Bean3">		
            <constructor-arg value="Valor"/>
            <constructor-arg value="1"/>
            <constructor-arg value="true"/>
        </bean>
        <bean name="bean4" class="Spring.home.Bean4">
            <property name="lista">
                <list>
                <!-- Uma lista -->
                    <value>Item 1</value>
                    <value>Item 2</value>
                    <value>Item 3</value>
                </list>						
            </property>
            <property name="eventos">
                <map>
                    <entry key="evento1" value="true"/>
                    <entry key="evento2" value="false"/>
                    <!-- Essa eh uma outra forma -->
                    <entry key="evento3"><value>true</value></entry>
                </map>			
            </property>
            <property name="numeros">
                <set>
                <!-- uma lista que nao se repete -->
                    <value>1</value>
                    <value>2</value>
                    <value>3</value>
                </set>
            </property>
            <property name="propriedades">		
                <props>
                <!-- Properties -->
                    <prop key="atributo1">valor1</prop>
                    <prop key="atributo2">valor2</prop>				
                </props>
            </property>
        </bean>
    </beans>
### Bean aninhado
É possível inicializar um beam dentro do outro, ou seja caso um bean tenha como atributo, um outro bean, voce pode inicializa-lo, aqui inicializamos tanto por setter como por construtor. Abaixo o trecho de XML exemplo:

#### XML
    <bean name="bean5" class="Spring.home.Bean5">
		<!-- referenciando pelo id, injetando via construtor -->
		<constructor-arg  ref="idInterno1"/>
		<!-- referenciando pelo name, injetando via setter -->
		<property name="basico2" ref="interno2"/>
	</bean>
	<bean id="idInterno1" name="interno1" class="Spring.home.interno.Basico1">
		<property name="id" value="1"/>
		<property name="valor" value="valor padrao"/>
	</bean>
	<bean name="interno2" class="Spring.home.interno.Basico2">
		<property name="id" value="2"/>
		<property name="valores">
			<list>
				<value>Valor 1</value>
				<value>Valor 2</value>
				<value>Valor 3</value>
			</list>
		</property>
	</bean>

#### Bean 5    

    public class Bean5 {
	    private  Basico1 basico1;
	    private  Basico2 basico2;
	
        public Bean5(Basico1 basico1) {
            this.basico1 = basico1;
        }	

        public Basico2 getBasico2() {
            return basico2;
        }

        public void setBasico2(Basico2 basico2) {
            this.basico2 = basico2;
        }

        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "Basico1: "+this.basico1
                    +"\nBasico2: "+this.basico2;
        }	
    }

#### Basico1.java
    public class Basico1 {
        private String valor;
        public String getValor() {
            return valor;
        }
        public void setValor(String valor) {
            this.valor = valor;
        }
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        private int id;
        
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "ID: "+this.id+", Valor: "+this.valor;
        }
    }

#### Basico2.java
    public class Basico2 {
        private int id;
        private List<String> valores;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public List<String> getValores() {
            return valores;
        }
        public void setValores(List<String> valores) {
            this.valores = valores;
        }
        
        @Override
        public String toString() {
            // TODO Auto-generated method stub
            return "ID: "+this.id+", Valores: "+this.valores;
        }
    }

As 3 classes são informadas como qualquer bean, mas no Bean5 existe algo novo, no caso aqui `<constructor-arg  ref="idInterno1"/>` temos o construtor referenciando o **id**, esse id faz referência a anotação mais abaixo do primeiro bean interno como podemos ver aqui `<bean id="idInterno1" name="interno1" class="Spring.home.interno.Basico1">`. Além disso esse mesmo **ref** ele pode referenciar também um **name**, no segundo objeto interno fizemos a injeção por setter e o **ref** faz referência a um **name**, o Spring se vira tanto com **id** como com **name**.
Aqui temos o Bean5 referenciando um name `<property name="basico2" ref="interno2"/>`, no caso o interno2 que é esse beam aqui `<bean name="interno2" class="Spring.home.interno.Basico2">`. 

### lazy-init e default-lazy-init

#### Lazy-init
Com o Lazy init você pode fazer com que o Bean seja inicializado apenas quando a aplicação precisar dele, por padrão o valor dele é **falso**, mas se sinalizado como **true**, o carregamento do bean apenas será feito quando for necessitado o acesso a ele, exemplo: `<bean name="bean5" class="Spring.home.Bean5" lazy-init="true">`, aqui nós aplicamos no **Bean5**, com esse valor setado agora ele tem o carregamento no modo lazy, existe um terceiro valor que seria o **default**, esse terceiro padrão ele fica dependente do valor do **default-lazy-init** da tag `<beans>`, ao qual o bean está inserido dentro. Lembrando sempre que o `lazy-init` vai sempre no bean.

#### default-lazy-init
Aqui definimos o padrão de carregamento para todos os beans dentro da nossa tag `<beans>`, como nesse exemplo a seguir: `<beans default-lazy-init="true">` o padrão é false, e o funcionamento é igual ao **lazy-init**, mas diferentente dele, esse vai na tag que engloba todos os beans e define o comportamento padrão de todos os beans, caso o **lazy-init** não seja especificado, ou caso o **lazy-init** do bean em questão esteja definido como *default*.

### Instancias no Spring
#### N beans para a mesma classe
    <bean name="bean0" class="Spring.home.Bean1">		
		<property name="valor" value="valor Padrao"/>		
		<property name="bean" ref="beanId" />
	</bean>	
	
	<bean name="bean1" class="Spring.home.Bean1">		
		<property name="valor" value="valor Padrao"/>		
		<property name="bean" ref="beanId" />
	</bean>	

Aqui nesse exemplo acima, temos que tanto o **Bean0** como o **Bean1** apontam para a mesma classe, você pode acessar os dados tanto por `.getBean("bean0")` como por `.getBean("bean1")`, ou seja você pode acessar. Essa estratégia seria interessante por exemplo caso você tivesse uma classe DAO e quisesse que houvesse a conexão com dois ou mais bancos de dados diferentes, por exemplo uma classe inicializada com valores para acessar no mysql e você pode mudar os parametros para que possa ser feito o acesso com essa mesma classe no postgres por exemplo, tudo mudando o valor de uma String por exemplo.

#### Parametro scope
    <bean name="bean0" class="Spring.home.Bean1" scope="prototype">		
		<property name="valor" value="valor Padrao"/>		
		<property name="bean" ref="beanId" />
	</bean>	
	
	<bean name="bean1" class="Spring.home.Bean1" scope="singleton">		
		<property name="valor" value="valor Padrao"/>		
		<property name="bean" ref="beanId" />
	</bean>	

Aqui temos a mesma classe, porém com um atributo diferente, o atributo **scope**, aqui temos um exemplo de como funciona isso. Por padrão o spring trabalha com o Singleton, ou seja toda a chamada do método `.getBean("bean")` terá a instancia compartilhada, por exemplo: 

        ApplicationContext app1 = new ClassPathXmlApplicationContext("/Spring/home/ApplicationContext.xml");    
    	Bean1 bean1 = (Bean1) app1.getBean("bean0");
    	Bean1 bean2 = (Bean1) app1.getBean("bean0");

Se estiver configurado no modo padrão, ou se o **scope="singleton"**, nesse caso tanto o bean1 assim como o bean2 irão apontar para a mesma instancia, o objeto será inicializado na hora que for requisitado o acesso ao primeiro objeto, se o modo *lazy-init* estiver habilitado, seria executado ao inicialiazar a aplicação, caso o *lazy-init* fosse falso ou padrão, e o segundo objeto irá pegar uma cópia do primeiro. Agora se tivermos isso: `<bean name="bean0" class="Spring.home.Bean1" scope="prototype">`, ai muda, quando especificado como prototype, ai cada objeto terá acesso a uma instancia independente, nesse caso com o prototype o objeto bean1 e bean2 não apontariam ao mesmo objeto e sim a objetos diferentes. Em resumo, apenas use o prototype se você precisar de instancias independentes e não tem interesse de fazer isso dando um **new** em alguma classe, caso o contrário use o singleton, que é o padrão.

## Lendo dados de arquivo externo
#### Arquivo XML
[ArquivosExternos.xml](ArquivosExternos.xml)

    <?xml version="1.0" encoding="UTF-8" ?>
    <!-- Repare que eh colocado um xmlns no beans e o doctype foi tirado -->
    <beans xmlns="http://www.springframework.org/schema/beans"       
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xmlns:context="http://www.springframework.org/schema/context" 
        xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context 
        http://www.springframework.org/schema/context/spring-context.xsd"> 
        
        <!-- Aqui estamos importando o arquivo, ao qual contem os dados. -->   
        <context:property-placeholder location="classpath:Spring/home/arquivo.extensao"/>
        
        <!-- no valor nos interpolamos o valor pego no arquivo, aqui estamos injetando por setter -->
        <bean name="bean1" class="Spring.home.Bean1">
            <property name="id" value="${chave.prop2}" />
            <property name="valor" value="${chave.prop1}" />		
        </bean>	
        
        <!-- injetando por constructor, use o ${chave.prop} la no arquivo externo -->
        <bean name="bean3" class="Spring.home.Bean3">		
            <constructor-arg value="${chave.prop1}"/>
            <constructor-arg value="${chave.prop2}"/>
            <constructor-arg value="${chave.prop3}"/>
        </bean>
    </beans>

Repare que removemos do XML acima a linha `<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">` e no lugar colocamos, dentro da própria tag beans:

    <beans xmlns="http://www.springframework.org/schema/beans"       
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context" 
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context 
       http://www.springframework.org/schema/context/spring-context.xsd"> 

#### Como funciona essa estratégia?
No caso nos tags `<bean>` mantivemos os mesmos beans que usamos nos outros XML, usamos o Bean3 e o Bean1, no caso do Bean1 foi omitido a referência ao Bean2. Aqui temos a seguinte propriedade `<context:property-placeholder location="classpath:Spring/home/arquivo.extensao"/>` essa parte carrega o arquivo, que no caso é usado pelos dois beans. Dessa forma `${chave.prop1}` nos acessamos uma propriedade de dentro do arquivo, no caso essa linha é preenchida pelo atributo **prop1** dentro do objeto **chave**, segue o arquivo [arquivo.extensao](arquivo.extensao) abaixo:

    chave.prop1 = valor1
    chave.prop2 = 1
    chave.prop3 = true

Lembre-se do seguinte, aqui é definido o namespace *context*: `xmlns:context="http://www.springframework.org/schema/context"`, ao qual tem o seu *xsi*:

    xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context 
       http://www.springframework.org/schema/context/spring-context.xsd"

E aqui temos o uso: `context:property-placeholder` dentro da tag `<context:property-placeholder location="classpath:Spring/home/arquivo.extensao"/>`, no *location* você define o path da seguinte forma **classpath:**path/arquivo.extensao. 

#### Uma outra estratégia

Isso no arquivo de XML acima: [ApplicationContext.xml](ApplicationContext.xml)

    <bean name="propertiesConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
		<property name="locations">
			<value>
				classpath:Spring/home/arquivo.extensao
			</value>
		</property>
	</bean>
	<bean name="arquivo" class="Spring.home.Bean1" scope="prototype">		
		<property name="valor" value="${chave.prop1}"/>		
		<property name="bean" ref="beanId" />
	</bean>	

Nessa estratégia nós configuramos um Bean com esse parametro: `<bean name="propertiesConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">`, ali dentro colocamos uma uma propriedade `<property name="locations">` e ali dentro colocamos o path para o arquivo no seguinte padrão: `<value>` **classpath:path/arquivo.extensao** `</value>`, esse nós colocamos dentro do XML que tem o doctype `<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">` dentro do arquivo em questão, abaixo o XML com o *propertiesConfigurer*

    <?xml version="1.0" encoding="UTF-8" ?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans default-lazy-init="false">
        <!-- Essa aqui eh um bean clone e versao prototype do bean1 abaixo -->
        <bean name="bean0" class="Spring.home.Bean1" scope="prototype">		
            <property name="valor" value="valor Padrao"/>		
            <property name="bean" ref="beanId" />
        </bean>	
        
        <bean name="bean1" class="Spring.home.Bean1" scope="singleton">		
            <property name="valor" value="valor Padrao"/>		
            <property name="bean" ref="beanId" />
        </bean>	
        <bean id="beanId" name="bean2" class="Spring.home.Bean2" ></bean>	
        <bean name="bean3" class="Spring.home.Bean3">		
            <constructor-arg value="Valor"/>
            <constructor-arg value="1"/>
            <constructor-arg value="true"/>
        </bean>
        <bean name="bean4" class="Spring.home.Bean4">
            <property name="lista">
                <list>
                <!-- Uma lista -->
                    <value>Item 1</value>
                    <value>Item 2</value>
                    <value>Item 3</value>
                </list>						
            </property>
            <property name="eventos">
                <map>
                    <entry key="evento1" value="true"/>
                    <entry key="evento2" value="false"/>
                    <!-- Essa eh uma outra forma -->
                    <entry key="evento3"><value>true</value></entry>
                </map>			
            </property>
            <property name="numeros">
                <set>
                <!-- uma lista que nao se repete -->
                    <value>1</value>
                    <value>2</value>
                    <value>3</value>
                </set>
            </property>
            <property name="propriedades">		
                <props>
                <!-- Properties -->
                    <prop key="atributo1">valor1</prop>
                    <prop key="atributo2">valor2</prop>				
                </props>
            </property>
        </bean>
        <bean name="bean5" class="Spring.home.Bean5" lazy-init="true">
            <!-- referenciando pelo id, injetando via construtor -->
            <constructor-arg  ref="idInterno1"/>
            <!-- referenciando pelo name, injetando via setter -->
            <property name="basico2" ref="interno2"/>
        </bean>
        <bean id="idInterno1" name="interno1" class="Spring.home.interno.Basico1">
            <property name="id" value="1"/>
            <property name="valor" value="valor padrao"/>
        </bean>
        <bean name="interno2" class="Spring.home.interno.Basico2">
            <property name="id" value="2"/>
            <property name="valores">
                <list>
                    <value>Valor 1</value>
                    <value>Valor 2</value>
                    <value>Valor 3</value>
                </list>
            </property>
        </bean>
        <bean name="propertiesConfigurer" class="org.springframework.beans.factory.config.PropertyPlaceholderConfigurer">
            <property name="locations">
                <value>
                    classpath:Spring/home/arquivo.extensao
                </value>
            </property>
        </bean>
        <bean name="arquivo" class="Spring.home.Bean1" scope="prototype">		
            <property name="valor" value="${chave.prop1}"/>		
            <property name="bean" ref="beanId" />
        </bean>	
    </beans>
## Internacionalização - I18N
### Básico

[Arquivo XML](i18n.xml)

    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>

    <!-- A classe precisa ser exatamente a abaixo para que tudo funcione. -->
        <bean name="i18nBasico" class="org.springframework.context.support.ResourceBundleMessageSource">

            <!-- no caso como temos a propriedade basename, sera procurado por setBasename e getBasename, na escrita ou leitura respectivamente. -->
            <!-- O arquivo em questao eh o traducao.properties. -->
            <property name="basename" value="Spring/home/i18n/traducao"/>
        </bean>
    </beans>

Seja lá o que você for fazer, você precisa ter um doctype válido: `<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">`, após isso informe dentro de uma estrutura do **bean** a classe para tradução `<bean name="i18nBasico" class="org.springframework.context.support.ResourceBundleMessageSource">`, no caso a classe é essa `org.springframework.context.support.ResourceBundleMessageSource`, não esqueça que a classe deve ser informada direito, para evitar problemas. Nesse exemplo básico temos um único property, que seria esse: `<property name="basename" value="Spring/home/i18n/traducao"/>`, nessa propriedade temos o arquivo **traducao.properties**, lembrando que *properties* é a extensão do arquivo. No caso aqui o Spring vai acessar a classe *ResourceBundleMessageSource* e procurar pelo método *setbasename* quando for fazer a injeção de valor e *getbasename*, quando for recuperar algum valor, se você for ver a classe em questão você perceberá a existência dessas classes, no caso a injeção será feito com base em um arquivo *.properties* em questão.

#### Recuperando valores.

        ApplicationContext app = new ClassPathXmlApplicationContext("/Spring/home/i18n/i18n.xml"); 
    	MessageSource source = (MessageSource) app.getBean("i18nBasico");
    	String message = source.getMessage("mensage.content", null, null);
    	System.out.println(message);

Como sempre usamos o `ClassPathXmlApplicationContext`, e depois acessamos o **MessageSource** como se fosse um Bean qualquer, uma vez que o mesmo está em uma estrutura de Bean `MessageSource source = (MessageSource) app.getBean("i18nBasico");`, a grande diferença vem aqui: `String message = source.getMessage("mensage.content", null, null);` o método getMessage retorna uma string, porém se faz necessário informar 3 parametros, podendo ser os dois ultimos nulos se for o caso. O primeiro seria a propriedade de dentro do arquivo *.properties*, o segundo parametro são um conjunto de argumentos para customização, e por fim o idioma em questão, como esse exemplo é básico então por hora pulamos os dois ultimos, clique aqui para acessar o arquivo [traducao.properties](traducao.properties)

#### Arquivos de idiomas separados
    <bean name="i18nArquivos" class="org.springframework.context.support.ResourceBundleMessageSource">
		<!-- Sera procurado pelo arquivo msgs_pt_BR se o sistema operacional estiver em portugues, en_US em ingles, etc... -->		
		<property name="basename" value="Spring/home/i18n/msgs"/>
	</bean>

Aqui temos um exemplo de como funciona com arquivos externos, você também pode especificar um arquivo de mensagem de acordo com idioma do sistema operacional. Repare que no XML o bean é o mesmo que o Bean do exemplo anterior, caso não exista o arquivo para o idioma especifico ele pega o mais generico, que no caso seria esse *"Spring/home/i18n/msgs"*, o idioma escolhido é com base no sistema operacional, exceto se você deixar isso explícito com essa função aqui: `Locale.setDefault(new Locale("es","MX"));`, no caso essa linha define o espanho mexicano como idioma padrão da aplicação. Para que você tenha um arquivo específico para cada idioma, basta você adicionar no arquivo o *_idioma_PAISABREVIADO*, ou seja no exemplo acima ficaria: **msgs_pt_BR** para o arquivo de tradução do português do Brasil, **msgs_en_US** para o inglês americano, **msgs_es_MX** para espanhol mexicano por exemplo, siga sempre esse padrao para nomear o arquivo *_idioma_PAISABREVIADO*.

#### Arquivo java
    ApplicationContext app = new ClassPathXmlApplicationContext("/Spring/home/i18n/i18n.xml"); 
    MessageSource source = (MessageSource) app.getBean("i18nArquivos");
    String message1 = source.getMessage("mensage", null, null); //Exibindo mensagem com o idioma padrao do sistema, do arquivo msgs_pt_br
    System.out.println(message1);
    
    Locale local = Locale.US; //Voce pode pegar idiomas predefinidos.
    //Nesse exemplo passamos esse local como parametro no getMessage
    String message2 = source.getMessage("mensage", null, local); //Exibindo mensagem commo idioma ingles, do arquivo msgs_en_US.    	
    System.out.println(message2);
    
    //Aqui temos um outro exemplo, alterando o idioma de todo o sistema:
    Locale.setDefault(new Locale("es","MX"));
    
    //Apartir daqui o idioma padrao eh espanhol, no caso o message1 continua sendo o padrao, uma vez que esse veio antes dessa linha.
    String message3 = source.getMessage("mensage", null, null);
    System.out.println(message3);

`.getMessage("mensage", null, null);` => procura pelo atributo mensage dentro do arquivo de idioma escolhido, seja o *_pt_BR*, *es_MX*, ou *en_US*. Lembrando que deve existir um atributo **mensage** la dentro.

`.getMessage("mensage", null, Locale.US)` => Nesse ultimo estamos explicitando que queremos a mensagem do arquivo terminado em *en_US*.

Lembre-se que o acesso a esses arquivos de tradução é igual a um Bean, uma vez que o mesmo estra estruturado em bean `(MessageSource) app.getBean("i18nArquivos");`.

### Locale
Você pode criar um arquivo locale para definir o idioma da aplicação `Locale locale = new Locale("es","MX")`, lembrando que se você for criar um arquivo locale customizável no primeiro parametro você passa o idioma e no segundo o pais abreviado, esse arquivo locale pode ser usado como parametro no *getMessage* `.getMessage("mensage", null, locale)`, ou você pode usar isso para mudar o idioma padrão de toda a aplicação `Locale.setDefault(new Locale("es","MX"));`, Dentro da classe *Locale* você tem alguns padrões de países, que você pode usar ao invés de criar um novo, como por exemplo: `Locale local = Locale.US;`. Arquivos de idiomas: [msgs_pt_BR.properties](msgs_pt_BR.properties), [msgs_en_US.properties](msgs_en_US.properties), [msgs_es_MX.properties](msgs_es_MX.properties)

## Factory
[Arquivo XML](factory.xml)
### Criando um Bean com base em método construtor
#### BeanF1
    public class BeanF1 {
        private String valor;

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }
        
        //O metodo factory em questao
        public static BeanF1 metodoCriador() {
            return new BeanF1();
        }

        @Override
        public String toString() {		
            return this.valor;
        }  
	
    }


#### XML
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="factory" class="Spring.factory.BeanF1" factory-method="metodoCriador">
            <property name="valor" value="valorExemplo"/>
        </bean>
    </beans>

#### Explicando o factory-method
Aqui no caso, usamos a estratégia factory para a criação e instanciação de objetos, nessa linha é possível ver isso ` <bean name="factory" class="Spring.factory.BeanF1" factory-method="metodoCriador">`, no caso para isso usamos o atributo **factory-method** e passamos como um atributo o nome do método dentro da classe que fará esse trabalho `metodoCriador`. No caso o método criador está aqui, o método criador deve ser um método de classe, ou seja um método estático:

    //O metodo factory em questao
        public static BeanF1 metodoCriador() {
            return new BeanF1();
        }

### Método criador com parametros
#### O mesmo BeanF1
    public class BeanF1 {
        private String valor;

        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }
        
        public static BeanF1 metodoCriador() {
            return new BeanF1();
        }
        
        //A novidade esta nessa sobrecarga aqui
        public static BeanF1 metodoCriador(String parametro) {
            BeanF1 bean = new BeanF1();
            bean.setValor(parametro);
            return bean;
        }

        @Override
        public String toString() {		
            return this.valor;
        }		
    }

#### XML
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="factory" class="Spring.factory.BeanF1" factory-method="metodoCriador">
            <property name="valor" value="valorExemplo"/>
        </bean>
        <bean name="parametros" class="Spring.factory.BeanF1" factory-method="metodoCriador">
            <constructor-arg value="Parametro passado como exemplo"/>
        </bean>
    </beans>

#### Método criador com parametros.
 A grande diferença está aqui: `<constructor-arg value="Parametro passado como exemplo"/>`, ao invés de usar propriedades você usa um **constructor-arg** desse para cada argumento que o método exigir. Se houver dois parametros no métodos, você precisará informar duas propriedades dessa, no caso o método exige apenas um único argumento do tipo *String* e com nome de *paramtro* para o parametro, segue abaixo o método construtor:

    public static BeanF1 metodoCriador(String parametro) {
            BeanF1 bean = new BeanF1();
            bean.setValor(parametro);
            return bean;
        }

### Factory usando uma classe construtora como base.
#### XML
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="factory" class="Spring.factory.BeanF1" factory-method="metodoCriador">
            <property name="valor" value="valorExemplo"/>
        </bean>
        <bean name="parametros" class="Spring.factory.BeanF1" factory-method="metodoCriador">
            <constructor-arg value="Parametro passado como exemplo"/>
        </bean>
        
        <!-- Factory usando classe construtora, apenas deve ter uma property com o valor a ser preenchido -->
        <bean name="beanPronto" class="Spring.factory.BeanF1" factory-bean="nome-construtor">
            <property name="valor" value="Bean Criado com a classe construtora"/>		
        </bean>
        
        <!-- Repare que aqui voce passa apenas a classe construtora e mais nada, inclusive o metodo o Spring adivinha -->
        <bean name="nome-construtor" class="Spring.factory.BeanF2" />	
    </beans>

#### Bean F1
    public class BeanF1 {
        private String valor;
        
        public BeanF1() {
            System.out.println("BEAN F1");
        }
        
        public String getValor() {
            return valor;
        }

        public void setValor(String valor) {
            this.valor = valor;
        }
        
        public static BeanF1 metodoCriador() {
            return new BeanF1();
        }        
        
        public static BeanF1 metodoCriador(String parametro) {
            BeanF1 bean = new BeanF1();
            bean.setValor(parametro);
            return bean;
        }

        @Override
        public String toString() {		
            return this.valor;
        }       
	
    }

#### Bean F2

    public class BeanF2 {	
	    public BeanF2() {
		    System.out.println("BEAN F2");
	    }	
    }

#### Como funciona:
Aqui abaixo temos a parte do xml que irá conter o bean com o seu valor inicializado, repare que a única coisa que tem de diferente é o atributo `factory-bean`, esse atributo deve conter o bean que terá a classe que ira construir-lo, no caso seria o bean *nome-construtor*.

##### Bean com o atributo factory-bean
    <bean name="beanPronto" class="Spring.factory.BeanF1" factory-bean="nome-construtor">
            <property name="valor" value="Bean Criado com a classe construtora"/>		
    </bean>

Uma vez definido, iremos definir o bean que tem a classe construtora: 

##### Bean Construtor
    <bean name="nome-construtor" class="Spring.factory.BeanF2" />

Repare que apenas é informado a classe e o nome do Bean, no bean que tem a classe construtora, no caso será instanciado essa segunda classe e executada as instruções no construtores, o conteúdo dessa segunda classe pouco importa, veja que a classe BeanF2 apenas tem o construtor que da log no console.

##### BeanF2
    public class BeanF2 {	
	    public BeanF2() {
		    System.out.println("BEAN F2");
	    }	
    }

##### Para concluir...
Quando esse beam for criado, será chamado o BeanF2 e esse Beam irá executar todas as instruções de seu construtor.

## Herança

#### XML
[Arquivo XML](heranca.xml)

    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="pai" class="Spring.heranca.Pai" abstract="true">
            <property name="sobrenome" value="Sobrenome Pai"/>
        </bean>
        <bean name="filho" class="Spring.heranca.Filho" parent="pai" abstract="false">
            <property name="nome" value="Nome filho"/>
        </bean>
    </beans>

#### Classe Pai
    public abstract class Pai {
        private String sobrenome;

        public String getSobrenome() {
            return sobrenome;
        }

        public void setSobrenome(String sobrenome) {
            this.sobrenome = sobrenome;
        }

        @Override
        public String toString() {
            return "Pai [sobrenome=" + sobrenome + "]";
        }	
    }

#### Classe Filho
    public class Filho extends Pai{
        private String nome;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        @Override
        public String toString() {
            return "Filho [nome=" + nome + ", sobrenome="+this.getSobrenome()+"]";
        }
    }

### Explicando
Aqui temos um caso de herança, repare que no xml existe apenas dois atributos diferentes para o bean: `parent` e `abstract`.

### Abstract

    <bean name="pai" class="Spring.heranca.Pai" abstract="true">
            <property name="sobrenome" value="Sobrenome Pai"/>
    </bean>

Aqui estamos indicando que pai é uma classe abstrata, quando você tiver uma classe abstrada e for fazer a notação dela como bean, como nesse caso: `public abstract class Pai {`, você deve informar o Spring de essa classe é abstrata, assim o Spring sabe que não pode instanciar ela. Além disso quando a classe é abstrata você não pode acessar ela de maneira alguma, logo tenha cuidado para não colocar classes desse tipo no método **.getBean** ,Aqui estamos referenciando o filho, pois o Pai é abstrato e não pode ser instanciado: 

##### No método Main...
    ApplicationContext app1 = new ClassPathXmlApplicationContext("/Spring/heranca/heranca.xml");
    Pai bean = (Pai) app1.getBean("filho"); 

### Parent

    <bean name="filho" class="Spring.heranca.Filho" parent="pai" abstract="false">
            <property name="nome" value="Nome filho"/>
    </bean>

Através do atributo **parent** indicamos qual é a classe pai, caso o seu Bean tenha alguma herança você deve usar o parent para que o Spring possa inicializar corretamente o seu Bean, além disso como essa classe é concreta essa indicação `abstract="false"` é desnecessária, o padrão desse atributo é false, logo ele poderia ser perfeitamente omitido, uma vez que a classe é concreta.

### Trabalhando com listas na Herança
##### XML Completo
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="pai" class="Spring.heranca.Pai" abstract="true">
            <property name="sobrenome" value="Sobrenome Pai"/>
        </bean>
        <bean name="filho" class="Spring.heranca.Filho" parent="pai" abstract="false">
            <property name="nome" value="Nome filho"/>
        </bean>
        
        <bean class="Spring.heranca.AutoRelacionamento" name="abstrato" abstract="true">
            <property name="lista">
                <list>
                    <value>1</value>
                    <value>2</value>
                    <value>3</value>
                </list>
            </property>
        </bean>
        
        <!-- Repare que o list na classe concreta tem um atributo merge, diferente da abstrata -->
        <bean  name="concreto" abstract="false" parent="abstrato">
            <property name="lista">
            <!-- A ausencia do merge faz com que a lista seja sobscrita ao inves de mesclada -->
                <list  merge="true">
                    <value>4</value>
                    <value>5</value>
                    <value>6</value>
                </list>
            </property>		
        </bean>
    </beans>

#### Classe AutoRelacionamento
    public class AutoRelacionamento {
        private List<Integer>lista;

        public List<Integer> getLista() {
            return lista;
        }

        public void setLista(List<Integer> lista) {
            this.lista = lista;
        }

        @Override
        public String toString() {
            return "AutoRelacionamento [lista=" + lista + "]";
        }
    }

Inicialmente repare que na classe concreta sequer foi definida uma classe: `<bean  name="concreto" abstract="false" parent="abstrato">`, nesse caso o Spring pega a classe do Bean informado no parent, porém isso só funciona, primeiro porque os dois Beans usam a mesma classe e segundo porque está implicito no **parent**, caso as classes sejam diferentes ou não esteja implicita a classe com o uso do **parent**, deve-se informar o bean, além disso é valido reforçar que o abstract continua sendo desnecessário para classe concreta, mas ajuda a destacar que essa classe é concreta. Repare que tanto o Bean Pai assim como o Bean filho, ambos oriundos da mesma classe preenche o array:
##### Classe abstrata
    <bean class="Spring.heranca.AutoRelacionamento" name="abstrato" abstract="true">
            <property name="lista">
                <list>
                    <value>1</value>
                    <value>2</value>
                    <value>3</value>
                </list>
            </property>
        </bean>

Por padrão essa lista acima será substituido, pela lista abaixo, esse é o comportamento padrão com o **Merge** ocultado.
##### Classe concreta
    <bean  name="concreto" abstract="false" parent="abstrato">
            <property name="lista">            
                <list  merge="true">
                    <value>4</value>
                    <value>5</value>
                    <value>6</value>
                </list>
            </property>		
        </bean>

Porém como aqui o **List** possuí o atributo `merge="true"`, logo ambos as listas serão mescladas, possuindo tanto o valor do Bean pai, como do Bean filho, output com **merge**: `lista=[1, 2, 3, 4, 5, 6]`, **sem merge**:`lista=[4, 5, 6]`, ou seja com o comportamento padrão a classe concreta, ou o escopo mais próximo reescreve a lista.

## Inicializando valores com Spring
### XML Completo
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="init1" class="Spring.init.InitBean1" init-method="metodoInicio">
            <property name="valor" value="Exemplo de valor 1"/>
        </bean>
        <bean name="init2" class="Spring.init.InitBean2">
            <property name="valor" value="Exemplo de valor 2"/>
        </bean>
    </beans>

### App.java
    public class App 
        {
            public static void main( String[] args )
            {
                ApplicationContext app1 = new ClassPathXmlApplicationContext("/Spring/init/init.xml");
                InitBean1 bean1 = (InitBean1) app1.getBean("init1");	
                InitBean2 bean2 = (InitBean2) app1.getBean("init2");
                System.out.println(bean1);
                System.out.println(bean2);
            }
        }

### init-method
    <bean name="init1" class="Spring.init.InitBean1" init-method="metodoInicio">
		<property name="valor" value="Exemplo de valor 1"/>
	</bean>

#### init-method
Aqui você informa o método que deve ser executado assim que o Spring inicializa, no caso depois de inicializado o Bean, esse método é executado, lembrando que esse método nesse exemplo não recebe parametros e não retorna valores.

##### Classe InitBean1
    public class InitBean1 {
        private double Id;
        private String valor;
        public double getId() {
            return Id;
        }
        public void setId(double id) {
            Id = id;
        }
        public String getValor() {
            return valor;
        }
        public void setValor(String valor) {
            this.valor = valor;
        }

        //Aqui esta o metodo em questao
        public void metodoInicio() { 
            System.out.println("Metodo de geracao de id executado ao iniciar o bean: InitBean1");
            this.Id = Math.random();
        }
        
        @Override
        public String toString() {
            return "InitBean1 [Id=" + Id + ", valor=" + valor + "]";
        }	
    }

 ### Implementando uma interface
 Ao invés de usar a propriedade `init-method` você também pode usar uma interface para isso como esse exemplo abaixo:
 #### Classe com a Interface implementada
    import org.springframework.beans.factory.InitializingBean;
    public class InitBean2 implements InitializingBean{
        private double Id;
        private String valor;
        public double getId() {
            return Id;
        }
        public void setId(double id) {
            Id = id;
        }
        public String getValor() {
            return valor;
        }
        public void setValor(String valor) {
            this.valor = valor;
        }	
        
        @Override
        public String toString() {
            return "InitBean2 [Id=" + Id + ", valor=" + valor + "]";
        }
        public void afterPropertiesSet() throws Exception {
            System.out.println("Metodo de geracao de id executado ao iniciar o bean: InitBean2");
            this.Id = Math.random();		
        }
    }

#### Interface: InitializingBean
Essa interface exige a implementação desse método: `public void afterPropertiesSet() throws Exception`, a interface em questão vem daqui `org.springframework.beans.factory.InitializingBean`, você deve importar essa interface se for usa-la, mas recomenda-se fazer por anotação em XML para reduzir o acoplamento.

## Validator
[Validator XML](./verification/verification.xml)
#### XML
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="check" class="Spring.verification.Check">
            <constructor-arg  value="0"/>
            <constructor-arg  value="asas"/>
        </bean>	
    </beans>
#### Observação:
Repare que nada é feito do XML.

[Check.java](verification/Check.java)
#### Bean.java
    import org.springframework.validation.Errors;
    import org.springframework.validation.ValidationUtils;
    import org.springframework.validation.Validator;

    public class Check implements Validator {
        private long id;
        private String value;
        public Check(long id, String value) {
            this.id = id;
            this.value = value;
        }
        
        public boolean supports(Class<?> clazz) {		
            return Check.class.equals(clazz);
        }

        public void validate(Object target, Errors errors) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors,"value", "erro.vazio");
            if(id < 1) {
                errors.rejectValue("id", "ID Invalido");
            }
        }

        @Override
        public String toString() {
            return "Bean [id=" + id + ", value=" + value + "]";
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }

### Como deve ser a classe?
Para você usar o sistema de validação do Spring, você deve inicialmente implementar essa classe `Validator` oriunda de `org.springframework.validation.Validator`, essa interface tem dois métodos:

#### public boolean supports(Class<?> clazz)
`public boolean supports(Class<?> clazz)` => Como você pode ter diferentes validadores, o Spring vai usar esse método pra saber se pode aplicar este validador ao objeto anotado com **@Valid**. Se forem compatíveis ele aplica sua validação, senão ele a ignora.

#### public void validate(Object target, Errors errors)
`public void validate(Object target, Errors errors)` => Aqui você coloca a sua regra para validação, nesse caso temos dois objetos, um deles é passado por parametro como objeto do tipo **Errors**, no caso o segundo. Além disso você também pode usar o **ValidationUtils**.

### Errors
Essa classe vem de `org.springframework.validation.Errors`, a partir dessa classe você pode lançar erros com o metodo `.rejectValue("nome_variavel", "Mensagem Erro")`, como por exemplo:

    if(id < 1) {
		errors.rejectValue("id", "ID Invalido");
	} 

Nesse caso se o id for menor que 1, logo é lançado esse erro.

### ValidationUtils
Esse objeto tem origem em `org.springframework.validation.ValidationUtils`, dentro desse objeto singleton existe diversos métodos uteis para validação, como esse `.rejectIfEmptyOrWhitespace(errors,"value", "erro.vazio");`, como por exemplo: `ValidationUtils.rejectIfEmptyOrWhitespace(errors,"value", "erro.vazio");`

##### ValidationUtils.rejectIfEmptyOrWhitespace
O primeiro parametro exige um objeto do tipo **Errors**, no segundo exige uma String contendo o nome da variavel a ser validade e no terceiro e ultimo parametro o código do erro, ou seja a mensagem a ser exibida.

[Classe com metodo Main](verification/Runner.java)
#### Classe com Método Main
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    import org.springframework.validation.BeanPropertyBindingResult;
    import org.springframework.validation.Errors;


    public class Runner {

        public static void main(String[] args) {		
                    ApplicationContext app1 = new ClassPathXmlApplicationContext("Spring/verification/verification.xml");
                    Check bean1 = (Check) app1.getBean("check");		    	
                    System.out.println(bean1);
                    Errors erros = new BeanPropertyBindingResult(bean1,"check");
                    bean1.validate(bean1, erros);
                    for(Object erro: erros.getAllErrors()) {
                        System.out.println(erro);
                    }
        }
    }

##### Errors erros = new BeanPropertyBindingResult(bean1,"check"); 
Você verifica erros de validação dessa forma, aonde esta o *bean1* é o local ao qual você deve informar a instancia do Bean a ser analizado, o segundo parametro, aonde esta **"check"** você deve informar o nome do Bean no XML, no caso `<bean name="check" class="Spring.verification.Check">`.

##### bean1.validate(bean1, erros);
No caso nós estamos executando nesse trecho esse código aqui: `public void validate(Object target, Errors errors)`.

##### Pegando todos os erros, após a instanciação e a execução do método validate.
    for(Object erro: erros.getAllErrors()) {
        System.out.println(erro);
    }

#### Exemplo de erro: Output
    Bean [id=0, value=]
    Field error in object 'check' on field 'value': rejected value []; codes [erro.vazio.check.value,erro.vazio.value,erro.vazio.java.lang.String,erro.vazio]; arguments []; default message [null]
    Field error in object 'check' on field 'id': rejected value [0]; codes [ID Invalido.check.id,ID Invalido.id,ID Invalido.long,ID Invalido]; arguments []; default message [null]

##### O Tipo do Erro.
Um erro lançado pelo Spring não é um erro do tipo **Exception**, logo se faz necessário você dar um *throw* caso você deseje isso.

## Persistencia
### Import
Inicialmente se formos trabalhar com o Maven precisamos importar, o módulo do Spring para acesso ao banco de dados:
#### Importando o módulo usando o Maven
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
	<dependency>	
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-jdbc</artifactId>
	    <version>5.2.8.RELEASE</version>
	</dependency>

#### Importando o driver do banco de dados
No caso esse driver é para o funcionamento do banco de dados PostGres, cada banco de dados tem um driver diferente
##### postgresql
    <!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
	<dependency>
	    <groupId>org.postgresql</groupId>
	    <artifactId>postgresql</artifactId>
	    <version>42.2.16</version>
	</dependency>	

##### Que deve ser incluído no XML:
    <project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>Spring</groupId>
    <artifactId>home</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <packaging>jar</packaging>

    <name>home</name>
    <url>http://maven.apache.org</url>

    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>   
    </properties>

    <dependencies>		
        <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>3.8.1</version>
        <scope>test</scope>
        </dependency>
        
        <!-- DEPENDÊNCIAS DO SPRING -->
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-core -->
        <dependency>
        <groupId>org.springframework</groupId>
            <artifactId>spring-core</artifactId>
            <version>5.2.8.RELEASE</version>
        </dependency>	
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-beans -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-beans</artifactId>
            <version>5.2.8.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-aop -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>5.2.8.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-expression -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-expression</artifactId>
            <version>5.2.8.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-context</artifactId>
            <version>5.2.8.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.springframework/spring-jdbc -->
        <dependency>	
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.2.8.RELEASE</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.postgresql/postgresql -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>42.2.16</version>
        </dependency>	
    </dependencies>	
    </project>

### Usando no XML
[Persistence XML](persistencia/persistence.xml)

[Arquivo com metodo main](persistencia/Main.java)
#### XML
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="conexao" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
            <property name="driverClassName" value="org.postgresql.Driver"/>
            <property name="url" value="jdbc:postgresql://localhost:5432/postgres"/>
            <property name="username" value="postgres"/>
            <property name="password" value="123456"/>
        </bean>
        <bean name="dao" class="org.springframework.jdbc.core.JdbcTemplate" lazy-init="false">
            <property name="dataSource" ref="conexao" />
            <property name="lazyInit" value="false" />
        </bean>
    </beans>

#### Explicando
Repare que ambos são definidos como bean.
##### org.springframework.jdbc.datasource.DriverManagerDataSource
    <bean name="conexao" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
            <property name="driverClassName" value="org.postgresql.Driver"/>
            <property name="url" value="jdbc:postgresql://localhost:5432/postgres"/>
            <property name="username" value="postgres"/>
            <property name="password" value="123456"/>
    </bean>

Aqui nós defimos as confugurações de acesso com o banco de dados, esse Bean fará a conexão com o banco de dados, repare que a estrutura é como um bean qualquer, porém a classe carregada é própria do Spring, que é a: `org.springframework.jdbc.datasource.DriverManagerDataSource`, não esqueça que você precisa fazer dois imports para que isso funcione, um para o driver do banco de dados e outro que é o package que contém essa classe **DriverManagerDataSource**.

`<property name="driverClassName" value="org.postgresql.Driver"/>` => Aqui é feito o carregamento do banco de dados, no caso o PostGres, repare que a string para carregamento é semelhante ao do JDBC.

`<property name="url" value="jdbc:postgresql://localhost:5432/postgres"/>` => Aqui temos um path até o banco de dados, no caso estamos acessando o banco de dados padrão do Postgres, na url *localhost* e na porta *5432*.

`<property name="username" value="postgres"/>` => Aqui temos a informação de username sendo passada para o bean.

`<property name="password" value="123456"/>` => Aqui é passado a senha.

##### org.springframework.jdbc.core.JdbcTemplate
    <bean name="dao" class="org.springframework.jdbc.core.JdbcTemplate" lazy-init="false">
		<property name="dataSource" ref="conexao" />
		<property name="lazyInit" value="false" />
	</bean>

Aqui seria o equivalente a classe que se conecta a classe *DAO*. Essa classe `org.springframework.jdbc.core.JdbcTemplate` será usada aqui e posteriomente na execução de operações de CRUD no banco de dado.

`<property name="dataSource" ref="conexao" />` => Aqui devemos informar um *datasource*, que no caso seria o bean de nome *conexao* acima. No caso devemos passar a referencia do bean para a propriedade *dataSource*.

`<property name="lazyInit" value="false" />` => Aqui fazemos um carregamento do tipo *Eager*.

#### Executando
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    import org.springframework.jdbc.core.JdbcTemplate;

    public class Main {
        public static void main(String[] args) {
            ApplicationContext app = new ClassPathXmlApplicationContext("/Spring/persistence/persistence.xml");
            JdbcTemplate jdbc = (JdbcTemplate) app.getBean("dao");	            
        }
    }

##### Explicando
Repare que é importado a mesma classe que no XML, como nesse exemplo `org.springframework.jdbc.core.JdbcTemplate`. Porém na execução como em qualquer beam você faz o cast nessa linha aqui:

     JdbcTemplate jdbc = (JdbcTemplate) app.getBean("dao");	

### Executando o código.
#### Código completo
    import java.util.List;
    import java.util.Map;

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    import org.springframework.jdbc.core.JdbcTemplate;

    public class Main {

        public static void main(String[] args) {
            ApplicationContext app = new ClassPathXmlApplicationContext("/Spring/persistence/persistence.xml");
            JdbcTemplate jdbc = (JdbcTemplate) app.getBean("dao");	
            jdbc.execute("create table if not exists valor (id serial primary key,numero decimal(10,2) not null)");
            
            int rowAffected = jdbc.update("insert into valor(numero) values (?)",Math.random());
            System.out.println(rowAffected);
            
            List<Map<String,Object>> listas = jdbc.queryForList("Select * from valor");
            System.out.println(listas);
            

        }

    }

### Metodos-JDBC
#### Método execute
Esse método pode ser encontrado aqui `jdbc.execute("create table if not exists valor (id serial primary key,numero decimal(10,2) not null)")`, repare que esse código não retorna nenhuma linha, uma vez que é um comando DDL. O método execute tem justamente essa finalidade de executar códigos que não retornem nada, uma vez que esse método tem um retorno void e aceita apenas um único parametro, não permitindo por exemplo tratamento de query, ou seja esse método é aconselhável para comandos que não tenham retornam e não exijam parametros.

#### Método update
Esse método pode ser encontrado aqui `int rowAffected = jdbc.update("insert into valor(numero) values (?)",Math.random())`, esse método é útil caso você queira saber quantas linhas foram afetadas, uma vez que o retorno desse método é um *Integer*, que é o número de linhas afetadas. Esse método aceita dois parametros, *primeiro*: a query a ser executada, *segundo*: um array de objetos que será usado para substituir cada **?** da query, sendo o primeiro elemento do array equivalente ao primeiro interrogação, o segundo ao segundo interrogação, etc... 

#### Método queryForList
Esse método pode ser encontrado aqui: `List<Map<String,Object>> listas = jdbc.queryForList("Select * from valor")`, com relação aos de entrada parametros ele, ele funciona como o método update, cada parametro informado ou cada parametro de um array objeto com correspondencia ao interrogação apartir do segundo argumento e sendo o primeiro a query a ser executada, porém a diferença está no retorno, no caso esse método retorna um `List<Map<String,Object>>` ao invés de um Inteiro como no método anterior. Dentro desse retorno você tem: Cada elemento do *List* equivale a uma tabela e dentro do *List* você *Map* que estão relacionados a cada coluna e valor na tabela do banco de dados. Por exemplo essa query: `create table if not exists valor (id serial primary key,numero decimal(10,2) not null)`

    List => contém dados da tabela valor;
    id => chave de maps interno do list e com valor correspondente um para ocorrência existente. Por exemplo: id=1, id=2, etc...
    numero => Mesma coisa no map teremos várias chaves numero, mas cada um com o valor equivalente a ocorrência no banco de dados, tudo dentro de uma List

##### Exemplo de output imprimindo o System.out.println o código acima
[{id=1, numero=0.71}, {id=2, numero=0.18}, {id=3, numero=0.37}, {id=4, numero=0.03}, {id=5, numero=0.48}, {id=6, numero=0.58}, {id=7, numero=0.56}]

## DAO
### Arquivos
[Actions.java](dao/Actions.java)

[Bean.java](dao/Bean.java)

[DAO.java](dao/DAO.java)

[Main.java](dao/Main.java)

[Arquivo XML](dao/persistence.xml)

### Arquivo XML
    <?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="conexao" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
            <property name="driverClassName" value="org.postgresql.Driver"/>
            <property name="url" value="jdbc:postgresql://localhost:5432/postgres"/>
            <property name="username" value="postgres"/>
            <property name="password" value="123456"/>
        </bean>
        <bean name="dao" class="org.springframework.jdbc.core.JdbcTemplate" lazy-init="false">
            <property name="dataSource" ref="conexao" />
            <property name="lazyInit" value="false" />
        </bean>
        <bean name="bean" class="Spring.dao.DAO">
            <property name="JdbcTemplate" ref="dao"/>
        </bean>
    </beans>

#### A diferenca esta aqui: 
    <bean name="bean" class="Spring.dao.DAO">
            <property name="JdbcTemplate" ref="dao"/>
    </bean>

##### Repare que esse XML acima faz referência a esse:
    <bean name="dao" class="org.springframework.jdbc.core.JdbcTemplate" lazy-init="false">
            <property name="dataSource" ref="conexao" />
            <property name="lazyInit" value="false" />
    </bean>

##### Que por fim o bean acima faz referência a esse:
    <bean name="conexao" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="org.postgresql.Driver"/>
        <property name="url" value="jdbc:postgresql://localhost:5432/postgres"/>
        <property name="username" value="postgres"/>
        <property name="password" value="123456"/>
    </bean>

##### XML
[Arquivo XML](dao/persistence.xml)

### Interface
#### Aqui criamos uma Interface com os métodos que será executado no método main:
    import java.util.List;
    public interface Actions<Model> {
        void saveOrUpdate(Model model);
        void delete(int id);
        List<Model> getOne(int id);
        List<Model> getAll();
    }
#### Arquivo
[Actions.java](dao/Actions.java)
### Bean
#### Classe
    public class Bean {
        private int id = 0;
        private String name;
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        @Override
        public String toString() {
            return "Bean [id=" + id + ", name=" + name + "]";
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + id;
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Bean other = (Bean) obj;
            if (id != other.id)
                return false;
            return true;
        }	
    }
#### Arquivo
[Bean.java](dao/Bean.java)
### Método Main
#### Arquivo Java    
    import javax.swing.JOptionPane;

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    import org.springframework.jdbc.core.JdbcTemplate;

    public class Main {
        public static void main(String[] args) {
            ApplicationContext app = new ClassPathXmlApplicationContext("/Spring/dao/persistence.xml");
            Actions jdbc = (Actions) app.getBean("bean");		
            Bean bean = new Bean();
            //bean.setName(JOptionPane.showInputDialog("Novo nome"));
            //jdbc.saveOrUpdate(bean);		
            System.out.println(jdbc.getOne(2));
        }
    }

#### Explicando o Main
No caso o método acima executa com base na interface `Actions jdbc = (Actions) app.getBean("bean");`, isso porque o DAO ele implementa a interface de Actions: `public class DAO extends JdbcDaoSupport implements Actions<Bean>{` abaixo

### Método DAO
#### Arquivo
[DAO](dao/DAO.java)
#### Código Java
    import java.util.List;
    import org.springframework.jdbc.core.support.JdbcDaoSupport;
    public class DAO extends JdbcDaoSupport implements Actions<Bean>{        
        public void saveOrUpdate(Bean model) {
            this.checkTable();
            if(model.getId() == 0) {
                this.getJdbcTemplate().update("insert into tabela(name) values (?)",model.getName());
                System.out.println("Adding...");
            }else {
                this.getJdbcTemplate().update("update tabela set name = ? where id = ?",model.getName(),model.getId());
                System.out.println("Updating...");
            }		
        }

        public void delete(int id) {
            this.checkTable();
            this.getJdbcTemplate().update("delete from tabela where id = ?",id);	
            System.out.println("Deleting...");
        }

        public List<Bean> getOne(int id) {
            this.checkTable();
            return (List) this.getJdbcTemplate().queryForList("select * from tabela where id = ?",id);
        }

        @SuppressWarnings("unchecked")
        public List<Bean> getAll() {
            this.checkTable();
            return (List) this.getJdbcTemplate().queryForList("select * from tabela");		
        }
        
        private void checkTable() {
            this.getJdbcTemplate().execute(""
                    + "create table if not exists tabela (id serial primary key, name varchar(50) not null)"
                    );
        }
    }

#### Explicando
No caso esse Dao é do tipo Action também, pois implementa a interface `public class DAO extends JdbcDaoSupport implements Actions<Bean>`, logo isso é possível: `Actions jdbc = (Actions) app.getBean("bean");`, no caso aqui é dado um cast de modo que o usuário usa os métodos, para conseguir as informações que desejam no banco de dados. Além disso essa classe extende de `JdbcDaoSupport`, que está localizado aqui `import org.springframework.jdbc.core.support.JdbcDaoSupport;`, e essa classe possuí esse método dentre outros `getJdbcTemplate()`

#### getJdbcTemplate
Esse método ele retorna um objeto que tem outros métodos e permite com que seja feito a interação de maneira simplificada com o banco de dados, mais informações sobre esse métodos aqui [Clique aqui para ver.](readme.md#Metodos-JDBC), porém o uso deve ser encadeado com o **getJdbcTemplate** como por exemplo: `getJdbcTemplate().execute()`.

## Annotations

### Adições no arquivo POM.XML
Inicialmente foram adicionado bibliotecas para que as anotações funcionem, essas anotações precisam desses novos imports para funcionar.

        <!-- Spring annotations -->
        <dependency>
            <groupId>javax.annotation</groupId>
            <artifactId>javax.annotation-api</artifactId>
            <version>1.3.2</version>
        </dependency>

### Exemplo básico
    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"       
        xmlns:context="http://www.springframework.org/schema/context"
        
        xsi:schemaLocation="http://www.springframework.org/schema/beans 
                        http://www.springframework.org/schema/beans/spring-beans.xsd
                        http://www.springframework.org/schema/context 
                        http://www.springframework.org/schema/context/spring-context.xsd">
        <context:annotation-config/>
        <bean name='bean1' class='Springann.annotations.Bean1'/>
        <bean name='bean2' class='Springann.annotations.Bean2'>
            <constructor-arg value="VALOR BEAN INTERNO"/>
        </bean>
    </beans>

Apesar de usar a anotação, aqui nesse exemplo isso é usado de maneira parcial ao menos, a relação entre o *bean1* e o *bean2* e o ciclo de vida dos beans será feito por anotação, ou seja, delegar um pouco as anotações algumas responsabilidades, aumentando um pouco o acoplamento do bean, mas simplificando ela. [Arquivo de exemplo](./basico-ann/spring-ann-basico.xml).

#### Como o XML com suporte a anotações funciona?
Para que as anotações funcionem, precisa que seja informado o context, isso é feito aqui `<context:annotation-config/>`, ou seja sem essa marcação dentro do `<beans>`, as anotações não funcionaram, ou seja, isso é obrigatório para o funcionamento das anotações, Porém ela não vem do nada, para isso você precisa, implementar `xmlns:context="http://www.springframework.org/schema/context"` e para essa emplementação funcione você precisa informar `xmlns="http://www.springframework.org/schema/beans"` e `xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"`,
o **xmlns** serve para informar o *namespace*, com base nisso também precisamos implementar a url dos arquivos *XSD* ,**xmlns:xsi** logo se faz necessário e por fim `xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"`, uma vez que esteja implementado ai deve-se implementar `xmlns:context="http://www.springframework.org/schema/context"`, para funcionar o `<context:annotation-config/>`. Aqui abaixo temos a importação dos arquivos *XSD*:

     xsi:schemaLocation="http://www.springframework.org/schema/beans 
                        http://www.springframework.org/schema/beans/spring-beans.xsd
                        http://www.springframework.org/schema/context 
                        http://www.springframework.org/schema/context/spring-context.xsd"

Dessa forma a tag beans deve ficar assim:

    <beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"       
       xmlns:context="http://www.springframework.org/schema/context"       
       xsi:schemaLocation="http://www.springframework.org/schema/beans 
                           http://www.springframework.org/schema/beans/spring-beans.xsd
                           http://www.springframework.org/schema/context 
                           http://www.springframework.org/schema/context/spring-context.xsd">
    </beans>

Repare que ainda assim precisa definir no *XML* as definições dos *Beans*:

    <bean name='bean1' class='Springann.annotations.Bean1'/>
	<bean name='bean2' class='Springann.annotations.Bean2'>
		<constructor-arg value="VALOR BEAN INTERNO"/>
	</bean>
#### Classe bean2    
    import javax.annotation.PostConstruct;
    import javax.annotation.PreDestroy;

    public class Bean2 {
        private String valor;
        public Bean2(String valor) {
            this.setValor(valor);
        }
        public String getValor() {
            return "Valor do bean interno é: " +valor;
        }
        public void setValor(String valor) {
            this.valor = valor;
        }
        
        @PostConstruct
        public void exibir() {
            System.out.println("Executando @PostConstruct do Bean Interno");
        }
        
        @PreDestroy
        public void destroir() {
            System.out.println("Executando @PreDestroy do Bean Interno");
        }
    }

#### Bean1
    import javax.annotation.PostConstruct;
    import javax.annotation.PreDestroy;
    import org.springframework.beans.factory.annotation.Autowired;
    import org.springframework.stereotype.Component;

    @Component
    public class Bean1 {
        private long id;
        private String value;
        
        @Autowired
        private Bean2 bean2;
        
        public long getId() {
            return id;
        }
        public void setId(long id) {
            this.id = id;
        }
        public String getValue() {
            return value;
        }
        public void setValue(String value) {
            this.value = value;
        }
        
        @PostConstruct
        public void exibir() {
            System.out.println("Executando @PostConstruct do Bean Externo");
        }
        
        @PreDestroy
        public void destroir() {
            System.out.println("Executando @PreDestroy do Bean Externo");
        }
        
        public Bean2 getBean() {
            return bean2;
        }
        public void setBean(Bean2 bean) {
            this.bean2 = bean;
        }
        
        @Override
        public String toString() {
            return this.bean2.getValor();
        }
        
    }

##### @Component
Aqui indica que se trata de um Bean, mas da maneira mais genérica possível, para esse exemplo básico não faz muita diferença [Documentação](https://docs.spring.io/spring-framework/docs/2.5.x/javadoc-api/org/springframework/stereotype/Component.html):

    De acordo com a própria definição dos criadores: Ela representa um componente (bean) que é detectado automaticamente quando trabalhamos com configurações baseadas em annotations e busca de caminhos de classes.

#### @Autowired
Essa anotação é usada quando você quer colocar um bean dentro do outro:
Isso dentro do **Bean1**:

     @Autowired
    private Bean2 bean2;

Significa isso:

    <bean name="bean2" class="package.Bean2" />			
    <bean name="bean1" class="package.Bean1">			
		<property name="bean2" ref="bean2" />
	</bean>	

Em casos mais simples é possível usar sem a anotação `@Qualifier`, mas caso haja mais de um *bean* com a mesma origem ou até mesmo de origem diferente dentro do bean, se faz necessário usar o `@Qualifier` para evitar ambiguidades. Nesse caso aonde o `@Autowired` está sem a anotação `@Qualifier` abaixo, ele procura no *XML* um bean que tem esse tipo e usa esse bean para iniciar esse valor interno. O `@Autowire` vem de `org.springframework.beans.factory.annotation.Autowired`, já o `@Component` vem de `import org.springframework.stereotype.Component`.

#### @PostConstruct e @PreDestroy

##### Classe com método Main
    public class App 
    {
        public static void main( String[] args )
        {
            ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/annotations/spring-ann-basico.xml");
            ApplicationContext app = classPath;
            Bean1 bean = (Bean1) app.getBean("bean1");    	
            System.out.println(bean);    	
            classPath.close();    	
        }
    }

Aqui é executado todo a aplicação, nesse caso o objeto instanciado será armazenado em *classPath*: `ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/annotations/spring-ann-basico.xml");` e depois criado um *AplicationContext* `ApplicationContext app = classPath;`, a grande diferença ocorre aqui: `classPath.close();`, quando o método é encerrado.

##### Explicando:
 As anotações **@PostConstruct** e **@PreDestroy**, vem respectivamente de: `javax.annotation.PostConstruct` e `javax.annotation.PreDestroy`, essas anotações estaram disponíveis após a implementação dos da biblioteca `javax.annotation-api`. Essas duas anotações estão relacionadas ao ciclo de vida de um bean, o **@PostConstruct** é executado após o construtor ao passo que o **@PreDestroy** é executado após a morte do bean. Output da aplicação:
    
    Executando @PostConstruct do Bean Interno
    Executando @PostConstruct do Bean Externo
    Valor do bean interno é: VALOR BEAN INTERNO
    Executando @PreDestroy do Bean Externo
    Executando @PreDestroy do Bean Interno

O **@PreDestroy** foi executado, quando foi executado esse método aqui: `classPath.close()`, repare que ele matou todos os beans, ou seja na prática, o método marcado com a anotação **@PreDestroy** seria um destrutor para o bean, ao passo que o **@PostConstruct** é executado já após o construtor, util para checar valores inicializados, por exemplo ou quando for necessário executar alguma coisa, depois que o *Bean* for inicializado.

## AOP 
Existe uma forma de programação que é a Orientação a aspectos, que incluem deteminadas vantagens, no caso você precisar ter uma classe *Advice*, que contém os métodos a ser executados em determinados eventos e a classe a ser assistida, segue a [pasta contendo os arquivos de exemplo](./aop_basico).

### Importando as Bibliotecas
Caso você use o Maven, você deve importar as dependencias abaixo, ou se for o caso importar as bibliotecas do **aspectj** no maven:

    <dependency>
	    <groupId>org.springframework</groupId>
	    <artifactId>spring-aspects</artifactId>
	    <version>5.2.8.RELEASE</version>
	</dependency>

Com isso o `import org.aspectj.lang.annotation.*;` fica disponível.

### No XML

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"       
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:aop="http://www.springframework.org/schema/aop"
        
        xsi:schemaLocation="http://www.springframework.org/schema/beans 
                            http://www.springframework.org/schema/beans/spring-beans.xsd
                            http://www.springframework.org/schema/context 
                            http://www.springframework.org/schema/context/spring-context.xsd
                            http://www.springframework.org/schema/aop
                            http://www.springframework.org/schema/aop/spring-aop.xsd">
                            
        <aop:aspectj-autoproxy/>	
        <bean name="aop" class="Springann.aop.Advice" />
        <bean name="concreta" class="Springann.aop.Concreta" />	
    </beans>

No caso deve ser adicionado essa linha `xmlns:aop="http://www.springframework.org/schema/aop"` para que essa expressão também funciona `<aop:aspectj-autoproxy/>`, além disso no `xsi:schemaLocation` deve ter essas linhas:

    http://www.springframework.org/schema/aop
    http://www.springframework.org/schema/aop/spring-aop.xsd"

#### <aop:aspectj-autoproxy/>
Essa é parte que habilita o aspectj e informa ao spring que a orientação a aspecto será usado, no entanto o bean de advice deve estar imediamente abaixo dele, caso o bean abaixo dele não seja um advice pode dar problemas:

    <aop:aspectj-autoproxy/>	
    <bean name="aop" class="Springann.aop.Advice" />
    <bean name="concreta" class="Springann.aop.Concreta" />	

O exemplo acima funciona o exemplo abaixo não:

    <aop:aspectj-autoproxy/>	
    <bean name="concreta" class="Springann.aop.Concreta" />	
    <bean name="aop" class="Springann.aop.Advice" />

[XML](aop_basico/config.xml)
#### Classe advice
 A classe [Advice](aop_basico/Advice.java) é aonde estará programado os gatilhos, no caso a classe [Advice](aop_basico/Advice.java) vai assistir uma classe e se os eventos programados do Pointcut for acionado, ai é executado o método anotato pelo Pointcut, nesse trecho abaixo é informado a classe de [Advice](aop_basico/Advice.java).

    <aop:aspectj-autoproxy/>	
    <bean name="aop" class="Springann.aop.Advice" />

##### Classe Advice
Que tem o conteúdo:

    import org.aspectj.lang.annotation.After;
    import org.aspectj.lang.annotation.AfterReturning;
    import org.aspectj.lang.annotation.AfterThrowing;
    import org.aspectj.lang.annotation.Aspect;
    import org.aspectj.lang.annotation.Before;

    @Aspect
    public class Advice {
        
        @Before("execution(public void antes())")
        public void before() {
            System.out.println("Executando o metodo referente ao @Before");
        }
        
        @After("execution(public * dep*())")
        public void after() {
            System.out.println("Executando o metodo referente ao @After");
        }
        
        @AfterReturning("execution(public void depois(boolean))")
        public void afterReturning() {
            System.out.println("Executando o metodo referente ao @AfterReturning");
        }
        
        @AfterThrowing("execution( * * (..))")
        public void afterErrors() {
            System.out.println("Executando o metodo referente ao @AfterThrowing");
        }	
        
    }
[Advice](aop_avancado/Advice.java)
#### Classe Concreta
Essa classe acima, assiste essa classe:

    public class Concreta implements Contrato{
	
        public Concreta() {
            System.out.println("Executando o construtor");
        }
        
        public void antes() {
            System.out.println("Executando o metodo antes");		
        }

        public void depois() {
            System.out.println("Executando o metodo depois");		
        }

        public void erro() {
            System.out.println("Executando o metodo de erro");		
            throw new java.lang.RuntimeException("Erro provocado pelo metodo de erro");
        }

        public void depois(boolean b) {
            System.out.println("Executando o metodo depois");		
        }	
    }  

[Concreta](aop_basico/Concreta.java)
#### Interface Contrato
Ao qual tem essa interface implementada, até agora:

    public interface Contrato {
        public void antes();
        public void depois();
        public void erro();
        public void depois(boolean b);	
    }

[Contrato](aop_basico/Contrato.java)
#### Classe com o Main

    public class App 
    {
        public static void main( String[] args )
        {
            ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/config.xml");
            ApplicationContext app = classPath;
            Contrato bean = (Contrato) app.getBean("concreta");   	            
            classPath.close();    	
        }
    }

[App.java](aop_avancado/App.java)
### Explicando as anotações básicas da classe Advice
#### @Aspect
Toda e qualquer classe Advice deve conter essa anotação, essa é a base, é o que indica a JVM que se trata de uma classe Advice, como no exemplo abaixo:

    @Aspect
    public class Advice {

Essa anotação indica que se trata de uma classe advice, visto nesse exemplo [aqui](#classe-advice).

#### Pointcut
Pointcut são expressões que permite executar ações, no caso se as condições impostas pelo Pointcut forem acionadas, o método ao qual contém a anotação é executado:

    @Before("execution(public void antes())")
    public void before() 
        
    @After("execution(public * dep*())")
    public void after()
        
    @AfterReturning("execution(public void depois(boolean))")
    public void afterReturning()
        
    @AfterThrowing("execution( * * (..))")
    public void afterErrors() 

##### execution
Aqui temos um exemplo de pointcut `execution` que faz com que o método seja executo, quando o método dentro dos parenteses forem executados, existem outros exemplos envolvendo o `target` ou o `@Target` que será explicado melhor a frente. O `execution` aceita como parametro a assinatura de métodos, por exemplo: `@AfterReturning("execution(public void depois(boolean))")`, nesse caso o `execution(public void depois(boolean))`, que significa que quando um método público e sem retorno com o nome de depois e que aceita um argumento booleano for executado, logo isso servirá de gatilho para que o método `public void afterReturning()` seja executado, porém é possível criar pointcuts mais genéricos, por exemplo esse `execution( * * (..))`, que significa que qualquer que seja o método executado, esse pointcut será ativado. você deve usar ` * * `, quando precisar executar qualquer método, no caso, isso `(..)` significa que um método que tenha pelo menos um argumento seja executada, se estiver no contexto dessa expressão `execution( * * (..))`, caso a função não deva ter parametros se usa `execution( * * ())` ou seja sem os ` .. `.

##### Expressões com * ? \ + .

` * ` => Significa zero ou mais caracter após a expressão, no caso serve como um coringa.

`+` => Significa que deva ter um ou mais caracter após a expressão.

`?` => Siginifica que deva ter zero ou no máximo 1 string após a expressão.

` . ` => significa o exato um caracter qualquer aonde está o ponto.

` \ ` => a expressão deve seguir a regex.

Exemplo `execution(public * dep*())` no caso entre o `public` e o `dep` deve ter zero ou mais caracteres entre eles, no caso ali caberia um `int` ou um `void` ou um `Object`, etc... ou seja com base no primeiro asterisco, isso indica que a assinatura do método deve-se começar por `public` e ser seguido por `dep`, avançando na expressão o `dep*` siginifica com base na posição, que o método deve ter em seu nome alguma relação com *dep* ao começo do nome, podendo ser: *dep1*, *dep_2* ou *dep* por exemplo devido ao asteriscos, podendo ter o comportamento modificado se mudar o metacaracter, porém esse exemplo não engloba: *_dep*, *a_dep*, ou qualquer nome que tenha um caracter antes de *dep* e não contenha *dep* no seu início.

#### @Before
Essa anotação, faz com que o método seja executado **ANTES** do pointcut assistido, no caso primeiro executa esse método e depois o método ao qual está sendo monitorado, funciona igual o *Trigger Before* de um banco de dados por exemplo, ao qual executa a lógica antes do evento e depois o evento.

##### Método de monitoramento 
    @Before("execution(public void antes())")
	public void before() {
		System.out.println("Executando o metodo referente ao @Before");
	}

##### Método da classe concreta
    public void antes() {
		System.out.println("Executando o metodo antes");		
	}


##### Método main
    ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/config.xml");
    ApplicationContext app = classPath;
    Contrato bean = (Contrato) app.getBean("concreta");   	
    bean.antes();	
    classPath.close();
##### Output
    Executando o construtor
    Executando o metodo referente ao @Before
    Executando o metodo antes

Repare na sequência do output e que ele executa esse método `before` antes desse `antes`

#### @After
O After é um pouco mais complexo, no caso pode-se usar o `@After` ou o `@AfterReturning` e o `@AfterThrowing`, no caso o `@After` é mais abrangente que os outros dois, pois incluem as duas situações, assim sendo:

`@AfterReturning` => Dispara apenas quando a execução do método ocorre de maneira normal.

`@AfterThrowing` => Dispara apenas quando a execução do método gera uma exceção.

`@After` => Executa quando o erro ocorre e quando o erro não ocorre, ou seja abrange os dois outros *afters*.

#### Chamando o @After
##### Método concreto
    public void depois() {
		System.out.println("Executando o metodo depois");		
	}

##### Método com a anotação @After
    @After("execution(public * dep*())")
	public void after() {
		System.out.println("Executando o metodo referente ao @After");
	}

##### Método Main
    ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/config.xml");
    ApplicationContext app = classPath;
    Contrato bean = (Contrato) app.getBean("concreta");   	
    bean.depois();
    classPath.close(); 

##### Output 
    Executando o construtor
    Executando o metodo depois
    Executando o metodo referente ao @After

##### Explicando:
Repare que diferente do `@Before` esse método executou depois do método assistido, pois como explicado tanto no erro ou no acerto esse método é executado, quando qualquer método tenha como nome os caracteres iniciados por *dep* conforme o pointcut `"execution(public * dep*())"`, porém atente-se ao detalhe de que esse método não deve ter parametros, pois se tiver um parametro que seja, o mesmo não será executado.

#### Chamando o @AfterReturning
Esse será executado após o método, apenas se tudo der certo.

##### Método Concreto
    public void depois(boolean b) {
		System.out.println("Executando o metodo depois");		
	}	

##### Método com a anotação @AfterReturning
    @AfterReturning("execution(public void depois(boolean))")
	public void afterReturning() {
		System.out.println("Executando o metodo referente ao @AfterReturning");
	}

##### Método Main
    ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/config.xml");
    ApplicationContext app = classPath;
    Contrato bean = (Contrato) app.getBean("concreta");   	
    bean.depois(true);
    classPath.close(); 

##### Output
    Executando o construtor
    Executando o metodo depois
    Executando o metodo referente ao @AfterReturning

##### Explicando
Repare que o método aqui tem assinatura diferente do `@After` acima, no caso o mesmo foi executado pois não houve exceções.

#### @After com exceções
##### Método Concreto, lançando erro
    public void erro() {
		System.out.println("Executando o metodo de erro");		
		throw new java.lang.RuntimeException("Erro provocado pelo metodo de erro");
	}

##### Método com a anotação @AfterThrowing
    @AfterThrowing("execution( * * (..))")
	public void afterErrors() {
		System.out.println("Executando o metodo referente ao @AfterThrowing");
	}	

##### Método Main
     public static void main( String[] args )
    {
    	ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/config.xml");
    	ApplicationContext app = classPath;
    	Contrato bean = (Contrato) app.getBean("concreta");   	
    	bean.erro();
    	classPath.close();    	
    }
##### Output
    Executando o construtor
    Executando o metodo de erro
    Executando o metodo referente ao @AfterThrowing
    Exception in thread "main" java.lang.RuntimeException: Erro provocado pelo metodo de erro
        at Springann.aop.Concreta.erro(Concreta.java:19)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
        at org.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:62)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:95)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212)
        at com.sun.proxy.$Proxy8.erro(Unknown Source)
        at Springann.aop.App.main(App.java:13)

##### Explicando
Repare que o método foi executado devido ao metodo [lançar um erro](#método-concreto-lançando-erro), existe forma do método não parar a execução e de tratar esse erro, mas isso é mais avançado.

### Exemplo mais avançados de AOP
Segue os [exemplos envolvendo AOP](./aop_avancado):

#### Advice
    import org.aspectj.lang.ProceedingJoinPoint;
    import org.aspectj.lang.annotation.After;
    import org.aspectj.lang.annotation.AfterReturning;
    import org.aspectj.lang.annotation.AfterThrowing;
    import org.aspectj.lang.annotation.Around;
    import org.aspectj.lang.annotation.Aspect;
    import org.aspectj.lang.annotation.Before;

    @Aspect
    public class Advice {
        
        @Around(value = "execution (public void durante())")
        public void during(ProceedingJoinPoint point){		
            double loteria = Math.random();
            System.out.println("Loteria: "+loteria);
            if(loteria < 0.5)
                System.out.println("Executando o @Around, o durante esta sem parametros: Travou aqui");
            else
                try {
                    System.out.println("Executando o @Around, o durante esta sem parametros: Avancando...");
                    point.proceed();
                } catch (Throwable e) {				
                    e.printStackTrace();
                }
        }
        
        @Around("execution(public void durante(boolean))")
        public void duringParam(ProceedingJoinPoint point) {
            Object[] args = point.getArgs();
            boolean advance = false;
            for(Object arg: args) {
                advance = (Boolean) arg;
            }
            if(advance) {
                try {
                    System.out.println("Executando o @Around, o durante esta com parametro verdadeiro: Avancando...");
                    point.proceed();
                } catch (Throwable e) {				
                    e.printStackTrace();
                }
            }else {
                System.out.println("Executando o @Around, o durante esta com parametro falso: Travou aqui");
            }
        }
        
        @Before(value = "@target(Springann.aop.avancado.Anotado)")
        public void annotation() {
            System.out.println("@Before: Executando o metodo com @target sem os argumentos.");
        }
        
        @After(value="target(Springann.aop.avancado.Classe)")
        public void target() {
            System.out.println("@After: Executando o método com 'target'");
        }
        
        @AfterReturning(pointcut = "args(param)",returning="java.lang.Double")
        public void returning(double param) {
            System.out.println("@AfterReturning, valor do parametro informado: "+param);
        }
        
        @AfterThrowing(pointcut="@target(Springann.aop.avancado.Anotado)", throwing="erro")
        public void throwing(Exception erro) {
            System.out.println("@AfterThrowing, Erro tratado: "+erro.getMessage());
        }
    }

[Advice](aop_avancado/Advice.java)

#### Interface Anotado

    import static java.lang.annotation.RetentionPolicy.RUNTIME;
    import java.lang.annotation.Retention;

    @Retention(RUNTIME)
    public @interface Anotado {}

[Anotado](aop_avancado/Anotado.java)
#### Classe concreta

    @Anotado
    public class Classe{
        
        public Classe() {
            System.out.println("Executando Construtor");		
        }
        
        public void erro(){
            System.out.println("Executando o metodo de erro");		
            throw new java.lang.RuntimeException("Erro provocado pelo metodo de erro");
        }	

        public void durante() {
            System.out.println("Executando o durante sem parametros");
        }	
        
        public void durante(boolean b) {
            System.out.println("Executando o durante com parametros");
        }
        
        public double retorno(double arg) {
            double random = Math.random() * arg;
            System.out.println("Metodo retorno: "+random);
            return random;
        }	
                
    }

[Classe Concreta](aop_avancado/Classe.java)
#### config.xml

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"       
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:aop="http://www.springframework.org/schema/aop"
        
        xsi:schemaLocation="http://www.springframework.org/schema/beans 
                            http://www.springframework.org/schema/beans/spring-beans.xsd
                            http://www.springframework.org/schema/context 
                            http://www.springframework.org/schema/context/spring-context.xsd
                            http://www.springframework.org/schema/aop
                            http://www.springframework.org/schema/aop/spring-aop.xsd">
                            
        <aop:aspectj-autoproxy/>	
        <bean name="aop" class="Springann.aop.avancado.Advice" />
        <bean name="classe" class="Springann.aop.avancado.Classe" />	
    </beans>

[XML](aop_avancado/config.xml)
#### App.java

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

    public class App 
    {
        public static void main( String[] args )
        {
            ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/avancado/config.xml");
            ApplicationContext app = classPath;
            Classe bean = (Classe) app.getBean("classe");  	
            bean.erro();
            classPath.close();    	
        }
    }

[Classe com Main](aop_avancado/App.java)
### Pointcuts @target, target, args

#### @Target
Esse pointcut faz refencia a uma anotação:

    @Before(value = "@target(Springann.aop.avancado.Anotado)")
        public void annotation() {
            System.out.println("@Before: Executando o metodo com @target sem os argumentos.");
        }

Basicamente você informa dentro do `@target` o path + a classe que contem a anotação e todo o método que possui essa anotação será monitorada, ao exemplo de:

    @Anotado
    public class Classe{

No caso como a classe está anotada, graças ao `@target`, qualquer método será monitorado, o `value=` é uma outra forma de passar o pointcut, caso você queira fazer mais ajustes, nesse caso tanto o `@Before(value = "@target(Springann.aop.avancado.Anotado)")` como o `@Before("@target(Springann.aop.avancado.Anotado)")` são válidos. [Ver classe de Anotação](#interface-anotado).

#### target
Nessa você informa a classe alvo, no caso a classe alvo desse target terão todos os seus métodos monitorados:

     @After(value="target(Springann.aop.avancado.Classe)")
        public void target() {
            System.out.println("@After: Executando o método com 'target'");
        }

A mesma lógica que o `@target`, se você quer monitorar apenas uma classe, usar o `target` é mais interessante, agora se você quer monitorar **N** classes, pode-se usar de composição ou da estratétia de do `@target`. Também estaria certo se fosse ` @After("target(Springann.aop.avancado.Classe)")`, porém dessa forma você não passa outros parametros a anotação, além do pointcut. Cuidado para não confundir, o `@Before`,`@Around` e o `@After` usam **value**, mas os métodos específicos do **After** usam `pointcut=` como propriedade.

#### args

    @AfterReturning(pointcut = "args(param)",returning="java.lang.Double")
    public void returning(double param) {
        System.out.println("@AfterReturning, valor do parametro informado: "+param);
    }

o `@AfterReturning` ao invés do `value=` temos o `pointcut=`, o args é uma outra forma de pointcut, assim como o `@target`, `target` e o `execution`, porém essa estratégia é para métodos que recebem argumentos e o mesmo precise ser tratado de alguma forma, nesse caso o valor passado para `args()` deve ter o mesmo nome do informado na assinatura do método abaixo, ou seja: Isso `args(param)` deve ser condizente com isso `public void returning(double param)`, repare que no args estamos dizendo ao Spring que o param é o parametro informado no método de dentro do método o mesmo será tratado como feito aqui `System.out.println("@AfterReturning, valor do parametro informado: "+param);`, exemplo:

##### Métod Main
    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

    public class App 
    {
        public static void main( String[] args )
        {
            ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/avancado/config.xml");
            ApplicationContext app = classPath;
            Classe bean = (Classe) app.getBean("classe");  	
            bean.retorno(1);
            classPath.close();    	
        }
    }

##### Output

    Executando Construtor
    @Before: Executando o metodo com @target sem os argumentos.
    Metodo retorno: 0.030492221825531463
    @AfterReturning, valor do parametro informado: 1.0
    @After: Executando o método com 'target'

##### Explicando @AfterReturning
No caso aqui foi pego o valor passado aqui `bean.retorno(1);` e processado aqui `System.out.println("@AfterReturning, valor do parametro informado: "+param);` e exibido aqui `@AfterReturning, valor do parametro informado: 1.0`, ou seja esse pointcut é interessante caso você queira fazer uma interceptação nos argumentos recebidos, além disso você pode usar esse atributo `returning="java.lang.Double"` para informar o valor que o método deve retornar, ou seja se o método não retornar o que está aqui `returning="java.lang.Double"`, esse método não será executado caso também não retorne o tipo informado no `returning=`, ou seja o método deve ter como retorno um *double* para funcionar. O `returning=` é um atributo exclusivo de `@AfterReturning`.

#### Tratando erros na classe Advice

    @AfterThrowing(pointcut="@target(Springann.aop.avancado.Anotado)", throwing="erro")
    public void throwing(Exception erro) {
        System.out.println("@AfterThrowing, Erro tratado: "+erro.getMessage());
    }

o `@AfterThrowing` também tem um argumento `pointcut`, porém temos isso `throwing="erro"`. Aqui em `throwing` você informa a variável que vai receber qualquer erro pego pelo método que está sendo observado, lembrando que isso `throwing="erro"` deve ser condizente com isso `public void throwing(Exception erro)`, da mesma forma que ocorre entre o `returning` e o `@AfterReturning`.

##### Método Main

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

    public class App 
    {
        public static void main( String[] args )
        {
            ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/avancado/config.xml");
            ApplicationContext app = classPath;
            Classe bean = (Classe) app.getBean("classe");  	
            bean.erro();
            classPath.close();    	
        }
    }

##### Output

    Executando Construtor
    @Before: Executando o metodo com @target sem os argumentos.
    Executando o metodo de erro
    @AfterThrowing, Erro tratado: Erro provocado pelo metodo de erro
    @After: Executando o método com 'target'
    Exception in thread "main" java.lang.RuntimeException: Erro provocado pelo metodo de erro
        at Springann.aop.avancado.Classe.erro(Classe.java:12)
        at Springann.aop.avancado.Classe$$FastClassBySpringCGLIB$$122d658a.invoke(<generated>)
        at org.springframework.cglib.proxy.MethodProxy.invoke(MethodProxy.java:218)
        at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.invokeJoinpoint(CglibAopProxy.java:771)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
        at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
        at org.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:62)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)
        at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
        at org.springframework.aop.aspectj.AspectJAfterAdvice.invoke(AspectJAfterAdvice.java:47)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)
        at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
        at org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor.invoke(MethodBeforeAdviceInterceptor.java:56)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)
        at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
        at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:95)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        at org.springframework.aop.framework.CglibAopProxy$CglibMethodInvocation.proceed(CglibAopProxy.java:749)
        at org.springframework.aop.framework.CglibAopProxy$DynamicAdvisedInterceptor.intercept(CglibAopProxy.java:691)
        at Springann.aop.avancado.Classe$$EnhancerBySpringCGLIB$$42d1b5e5.erro(<generated>)
        at Springann.aop.avancado.App.main(App.java:13)

##### Explicando
Esse método `bean.erro();` disparou este `public void throwing(Exception erro)` que foi executado aqui `@AfterThrowing, Erro tratado: Erro provocado pelo metodo de erro`, logo esse parametro erro dessa assinatura `public void throwing(Exception erro)` faz referencia ao erro lançado pela classe, uma vez que esse método está monitorando via anotação, como pode-se ver aqui: `pointcut="@target(Springann.aop.avancado.Anotado)"`, ou seja qualquer método dessa classe, se der uma exceção vai chamar o método `public void throwing(Exception erro)`.

#### @Around
##### Métodos de exemplo do @Around

    @Around(value = "execution (public void durante())")
	public void during(ProceedingJoinPoint point){		
		double loteria = Math.random();
		System.out.println("Loteria: "+loteria);
		if(loteria < 0.5)
			System.out.println("Executando o @Around, o durante esta sem parametros: Travou aqui");
		else
			try {
				System.out.println("Executando o @Around, o durante esta sem parametros: Avancando...");
				point.proceed();
			} catch (Throwable e) {				
				e.printStackTrace();
			}
	}
	
	@Around("execution(public void durante(boolean))")
	public void duringParam(ProceedingJoinPoint point) {
		Object[] args = point.getArgs();
		boolean advance = false;
		for(Object arg: args) {
			advance = (Boolean) arg;
		}
		if(advance) {
			try {
				System.out.println("Executando o @Around, o durante esta com parametro verdadeiro: Avancando...");
				point.proceed();
			} catch (Throwable e) {				
				e.printStackTrace();
			}
		}else {
			System.out.println("Executando o @Around, o durante esta com parametro falso: Travou aqui");
		}
	}

##### Explicando
O `@Around` é um pouco mais complexo que o `@After` e o `@Before`, uma vez que o `@Around` executa em paralelo ao método observado. No caso temos o objeto `ProceedingJoinPoint` que vem de `org.aspectj.lang.ProceedingJoinPoint`, esse objeto faz a interceptação dos valores recebidos pelo metodo observado, dentro dele, dois métodos se destacam: 

`.getArgs()` => Retorna um array de Objetos contendo todos os argumentos do método, através dele pode-se interceptar os argumentos recebidos no método observado, porém como se trata de um array, se faz necessário fazer uma varredura e como se trata de um Objeto se faz necessário fazer um cast, para ter acesso ao valor interceptado, como nesse caso abaixo:

    Object[] args = point.getArgs();
    boolean advance = false;
	for(Object arg: args) {
	    advance = (Boolean) arg;
    }

No caso o valor interceptado é notoriamente um booleano, além disso tem apenas um único argumento o método, ao qual faz a escrita da variável *advance*.

`.proceed()` => Informa que o método pode continuar a sua execução, no caso se esse método não for chamado o método executado tem a sua execuçao suspensa, pense nesse método como os next() dos chain of responsability. Esse método exige um tratamento com try-catch da exceção `Throwable`, como exemplificado abaixo:

    if(advance) {
        try {
            System.out.println("Executando o @Around, o durante esta com parametro verdadeiro: Avancando...");
            point.proceed();
        } catch (Throwable e) {				
            e.printStackTrace();
	}

##### Um exemplo mais didático:

    @Around(value = "execution (public void durante())")
	public void during(ProceedingJoinPoint point){		
		double loteria = Math.random();
		System.out.println("Loteria: "+loteria);
		if(loteria < 0.5)
			System.out.println("Executando o @Around, o durante esta sem parametros: Travou aqui");
		else
			try {
				System.out.println("Executando o @Around, o durante esta sem parametros: Avancando...");
				point.proceed();
			} catch (Throwable e) {				
				e.printStackTrace();
			}
	}

Repare que apesar desse método observar métodos se parametros, como visto aqui: `@Around(value = "execution (public void durante())")`, lembrando sempre que o exception funciona normalmente dentro de um atributo *value* assim como no atributo *pointcut* dos `@AfterReturning` e `@AfterThrowing`, também seria válido se fosse: `@Around("execution (public void durante())")`, porém o método relacionado a ele tem como assinatura um objeto do tipo `ProceedingJoinPoint` como visto abaixo:

    @Around(value = "execution (public void durante())")
	public void during(ProceedingJoinPoint point){	

Esse método ele executa aleatóriamente o `.proceed()` ou não de acordo com o número aleatório de `double loteria = Math.random();` sendo essa condição:

###### Caso seja menor que 0.5

    if(loteria < 0.5)
			System.out.println("Executando o @Around, o durante esta sem parametros: Travou aqui");

###### Output True

    Executando Construtor
    Loteria: 0.11948580659555863
    Executando o @Around, o durante esta sem parametros: Travou aqui

###### Caso maior que 0.5

    else
        try {
            System.out.println("Executando o @Around, o durante esta sem parametros: Avancando...");
            point.proceed();
        } catch (Throwable e) {				
            e.printStackTrace();
        }

###### Output False

    Executando Construtor
    Loteria: 0.8649151073830073
    Executando o @Around, o durante esta sem parametros: Avancando...
    @Before: Executando o metodo com @target sem os argumentos.
    Executando o durante sem parametros
    @After: Executando o método com 'target'

###### No main

    public class App 
    {
        public static void main( String[] args )
        {
            ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/avancado/config.xml");
            ApplicationContext app = classPath;
            Classe bean = (Classe) app.getBean("classe");  	
            bean.durante();
            classPath.close();    	
        }
    }

Usando o `@Around` pode se interceptar o método no ato da execução, assim como o seu `@Before` e `@After` associado a ele, bastando para isso criar uma lógica para a execução do `.proceed()`

### Pointcuts Avançado
[Pasta](./aop-composition/)

[Advice](./aop-composition/Advice.java)

    import org.aspectj.lang.annotation.AfterReturning;
    import org.aspectj.lang.annotation.AfterThrowing;
    import org.aspectj.lang.annotation.Aspect;
    import org.aspectj.lang.annotation.Before;
    import org.aspectj.lang.annotation.Pointcut;

    @Aspect
    public class Advice {

        @Pointcut(value="target(Springann.aop.composicao.Contrato)")
        public boolean contrato() {
            System.out.println("Esse metodo nao sera chamado");
            return false;
        }
        
        @Pointcut("@target(Springann.aop.composicao.Anotacao)")
        public boolean anotacao() {
            System.out.println("Esse metodo nao sera chamado");
            return true;
        }
        
        @Before("contrato()")
        public void before() {
            System.out.println("Executando o metodo com @Before");
        }
        
        @AfterReturning("anotacao() && contrato()")
        public void afterReturning() {
            System.out.println("Executando o metodo com @AfterReturning");
        }
        
        @AfterThrowing(pointcut="anotacao() || !anotacao()", throwing="erro")
        public void afterThrowing(Exception erro) {
            System.out.println("@AfterThrowing: Erro provocado com o:"+erro.getMessage());
        }
        
    }

[Classe Concreta vigiada pela classe Advice](aop-composition/Alvo.java)    

    @Anotacao
    public class Alvo implements Contrato{
        
        public void metodo() {		
            System.out.println("Executando Metodo sem parametros e sem retorno");
        }
        
        public void erro() {
            throw new RuntimeException("Erro provocado!");
        }

    }

[Anotacao](aop-composition/Anotacao.java)

    import static java.lang.annotation.RetentionPolicy.RUNTIME;
    import java.lang.annotation.Retention;

    @Retention(RUNTIME)
    public @interface Anotacao {

    }

[Interface Contrato](aop-composition/Contrato.java)

    public interface Contrato {
	    public void metodo();
	    public void erro();
    }

[Arquivo XML](aop-composition/spring.xml)

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"       
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:aop="http://www.springframework.org/schema/aop"
        
        xsi:schemaLocation="http://www.springframework.org/schema/beans 
                            http://www.springframework.org/schema/beans/spring-beans.xsd
                            http://www.springframework.org/schema/context 
                            http://www.springframework.org/schema/context/spring-context.xsd
                            http://www.springframework.org/schema/aop
                            http://www.springframework.org/schema/aop/spring-aop.xsd">
                            
        <aop:aspectj-autoproxy/>	
        <bean name="aop" class="Springann.aop.composicao.Advice" />	
        <bean name="alvo" class="Springann.aop.composicao.Alvo" />	
    </beans>

[Classe com método Main](aop-composition/App.java)

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;
    public class App 
    {
        public static void main( String[] args )
        {
            ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Springann/aop/composicao/spring.xml");
            ApplicationContext app = classPath;
            Contrato alvo = (Contrato) app.getBean("alvo");    	
            if(Math.random() < 0.5)
                alvo.erro();
            else
                alvo.metodo();
            classPath.close();    	
        }
    }

#### Exemplo básico envolvendo Pointcut

##### O método com Pointcut
    @Pointcut(value="target(Springann.aop.composicao.Contrato)")
    public boolean contrato() {
        System.out.println("Esse metodo nao sera chamado");
        return false;
    }

##### Método Executador
    @Before("contrato()")
    public void before() {
        System.out.println("Executando o metodo com @Before");
    }

##### Explicando
No caso quando esse gatilho for disparado `@Pointcut(value="target(Springann.aop.composicao.Contrato)")` o pointcut ligado a ele também será disparado `@Before("contrato()")`, ou seja esse método é uma forma de se criar **pointcuts** mais complexos, no caso um `@Pointcut` está ligado ao método e toda vez que você fizer referencia a esse pointcut, você informa o método para se referenciar a ele, porém o método ligado ao pointcut não é executado a não ser que haja uma outra anotação ligado a eles.

###### Output se (Math.random() < 0.5) true

    Executando o metodo com @Before
    Executando Metodo sem parametros e sem retorno
    Executando o metodo com @AfterReturning

###### Output se (Math.random() < 0.5) false

    Executando o metodo com @Before
    @AfterThrowing: Erro provocado com o:Erro provocado!
    Exception in thread "main" java.lang.RuntimeException: Erro provocado!
        at Springann.aop.composicao.Alvo.erro(Alvo.java:11)
        at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
        at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
        at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
        at java.lang.reflect.Method.invoke(Method.java:498)
        at org.springframework.aop.support.AopUtils.invokeJoinpointUsingReflection(AopUtils.java:344)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.invokeJoinpoint(ReflectiveMethodInvocation.java:198)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:163)
        at org.springframework.aop.aspectj.AspectJAfterThrowingAdvice.invoke(AspectJAfterThrowingAdvice.java:62)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)
        at org.springframework.aop.framework.adapter.AfterReturningAdviceInterceptor.invoke(AfterReturningAdviceInterceptor.java:55)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)
        at org.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor.invoke(MethodBeforeAdviceInterceptor.java:56)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:175)
        at org.springframework.aop.interceptor.ExposeInvocationInterceptor.invoke(ExposeInvocationInterceptor.java:95)
        at org.springframework.aop.framework.ReflectiveMethodInvocation.proceed(ReflectiveMethodInvocation.java:186)
        at org.springframework.aop.framework.JdkDynamicAopProxy.invoke(JdkDynamicAopProxy.java:212)
        at com.sun.proxy.$Proxy9.erro(Unknown Source)
        at Springann.aop.composicao.App.main(App.java:14)

Também é possível colocar os pointcuts dentro de uma expressão booleana.

###### Se tiver implementado a interface contrato, executa-se esse pointcut
    @Pointcut(value="target(Springann.aop.composicao.Contrato)")
	public boolean contrato() {
		System.out.println("Esse metodo nao sera chamado");
		return false;
	}

###### Se tiver a anotacao na classe alvo executa	
	@Pointcut("@target(Springann.aop.composicao.Anotacao)")
	public boolean anotacao() {
		System.out.println("Esse metodo nao sera chamado");
		return true;
	}

Como visto [aqui](#pointcuts-avançado) é possível combinar diferente pointcuts através de expressões booleanas, lembrando que a execução desse pointcut não significa a execução desse método, para chamar o pointcut você usa o método `@Before("contrato()")`, nesse caso será chamado os pointcuts associado ao método `contrato()` da própria classe, porém sem executar o método. 

#### Pointcut AND
Aqui nessa expressão temos o uso do **AND** `@AfterReturning("anotacao() && contrato()")` no caso se as condições para o pointcut associado a `anotacao` e `contrato`, ambas forem verdadeiras esse evento é executado.

#### Pointcut OR e Negação
Aqui nessa expressão temos o uso do **OR** em conjunto com a negação **!** ` @AfterThrowing(pointcut="anotacao() || !anotacao()", throwing="erro")`, no caso tendo `anotacao()` **ou** `||`, não `!anotacao()` tendo, esse método será executado, porém por ser o `@AfterThrowing` logo ele será executado quando der erro.

### AOP com XML
#### App.java
[App.java](aop_xml/App.java)

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

    public class App {
        public static void main(String[] args) {
            ClassPathXmlApplicationContext classPath = new ClassPathXmlApplicationContext("Spring/aop/spring.xml");
            ApplicationContext app = classPath;
            Clazz clazz = (Clazz) app.getBean("clazz");    
            clazz.metodo();
            classPath.close();    
        }
    }

#### Advice.java da AOP com XML
[Advice.java](aop_xml/Advice.java), repare que não tem nenhuma anotação na classe abaixo:

    import org.aspectj.lang.ProceedingJoinPoint;
    public class Advice {
        
        public void before() {
            System.out.println("Executando método BEFORE de Advice");
        }
        
        public void after() {
            System.out.println("Executando método AFTER de Advice");
        }
        
        public void around(ProceedingJoinPoint point) throws Throwable{
            System.out.println("Executando método AROUND de Advice");
            point.proceed();
        }
        
        public boolean after_returning() {
            System.out.println("Executando método AFTER_RETURNING de Advice");
            return true;
        }
        
        public void after_throwing(Exception erro) {
            System.out.println("Executando método AFTER_THROWING de Advice: "+erro.getMessage());
        }
    }

#### Classe Clazz.java
[Clazz.java](./aop_xml/Clazz.java)

    public class Clazz {
	    public void metodo() {
		    System.out.println("Executando o método() da classe");
	    }
    }

#### Arquivo XML com 
[Arquivo XML](./aop_xml/spring.xml), repare que toda a configuração está no XML e será melhor explicado.

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"       
        xmlns:context="http://www.springframework.org/schema/context"
        xmlns:aop="http://www.springframework.org/schema/aop"
        
        xsi:schemaLocation="http://www.springframework.org/schema/beans 
                            http://www.springframework.org/schema/beans/spring-beans.xsd
                            http://www.springframework.org/schema/context 
                            http://www.springframework.org/schema/context/spring-context.xsd
                            http://www.springframework.org/schema/aop
                            http://www.springframework.org/schema/aop/spring-aop.xsd">
                            
        <aop:config>
            <aop:aspect id="aspectidxml" ref="aop">
            
                <!-- Pointcuts -->
                <aop:pointcut expression="target(Spring.aop.Clazz)" id="antes" />
                <aop:pointcut expression="execution( * * ())" id="depois" />
                
                <!-- Eventos -->
                <aop:before method="before" pointcut-ref="antes"/>
                <aop:around method="around" pointcut="execution( * * ())"/>
                <aop:after-returning method="after_returning" pointcut="target(Spring.aop.Clazz)" returning="java.lang.Boolean"/>
                <aop:after-throwing method="after_throwing" pointcut="target(Spring.aop.Clazz)" throwing="erro"/>
                <aop:after method="after" pointcut-ref="depois"/>	

            </aop:aspect>
        </aop:config>
        <bean name="aop" class="Spring.aop.Advice" />	
        <bean name="clazz" class="Spring.aop.Clazz" />	
    </beans>

#### Explicando
No caso do XML você substitui o `<aop:aspectj-autoproxy/>` por `<aop:config>` e dentro dessa estrutura deve conter: 

##### aop:aspect
`<aop:aspect id="aspectidxml" ref="aop">` o *ref* faz referencia ao bean, que no caso é a classe advice `<bean name="aop" class="Spring.aop.Advice" />`, no caso do campo *ref* você deve informar o nome do Bean que corresponde a classe Advice, recomenda-se colocar um *id* no *aspect*.

##### Pointcut

     <!-- Pointcuts -->
    <aop:pointcut expression="target(Spring.aop.Clazz)" id="antes" />
    <aop:pointcut expression="execution( * * ())" id="depois" />

###### expression
Para criar um *pointcut* você precisa pelo menos de 2 parametros no `aop:pointcut`, o primeiro um que vai aceitar a expressão, que aceita expressões iguais ao `@Pointcut`, como a exemplo `expression="target(Spring.aop.Clazz)"` ou `expression="execution( * * ())"` além disso se faz necessário ter um id, que será usado para referenciar o pointcut, ao exemplo de:

    <aop:before method="before" pointcut-ref="antes"/>
     <aop:after method="after" pointcut-ref="depois"/>

###### pointcut como parametro
Você também pode colocar o pointcut direto no método advice a exemplo de `pointcut="execution( * * ())"` ou `pointcut="target(Spring.aop.Clazz)"`.

    <aop:around method="around" pointcut="execution( * * ())"/>
    <aop:after-returning method="after_returning" pointcut="target(Spring.aop.Clazz)" returning="java.lang.Boolean"/>
    <aop:after-throwing method="after_throwing" pointcut="target(Spring.aop.Clazz)" throwing="erro"/>

##### Colocando Before, After e Around no XML.

###### @Before
    <aop:before method="before" pointcut-ref="antes"/>

Esse XML substitui a anotação `@Before`.
###### @Around
    <aop:around method="around" pointcut="execution( * * ())"/>

Esse XML substitui a anotação `@Around`.

###### @AfterReturning    
    <aop:after-returning method="after_returning" pointcut="target(Spring.aop.Clazz)" returning="java.lang.Boolean"/>

Esse XML substitui a anotação `@AfterReturning`.

###### @AfterThrowing
    <aop:after-throwing method="after_throwing" pointcut="target(Spring.aop.Clazz)" throwing="erro"/>

Esse XML substitui a anotação `@AfterThrowing`.

###### @After
    <aop:after method="after" pointcut-ref="depois"/>	

Esse XML substitui a anotação `@After`.

###### Explicando
Repare que todas as propriedades têm o `method` no caso o método carregado vem da classe especificada aqui `<aop:aspect id="aspectidxml" ref="aop">`, que no caso se refere a esse bean `<bean name="aop" class="Spring.aop.Advice" />`, que cuja a classe pode ser avaliada [aqui](#advicejava-da-aop-com-xml).

## RMI
**RMI (Remote Method Invocation)** é uma forma de você acessar um objeto remotamente, ou seja o servidor fornece um objeto e você o pega do sistema servidor, ou seja você instancia através do Spring o objeto em uma máquina *(cliente)* e pode usar em outra *(servidor)* de maneira remota.

### Configurando servidor
[Arquivos](./rmi-server/)
#### Interface Contrato do RMI
[Contrato](rmi-server/Contrato.java)

    import java.util.Date;

    public interface Contrato {
        public Date getDate();
        public double aleatorio();
    }

Você vai precisar de uma interface, no caso essa interface será usada pelo **cliente** e pelo **servidor**, através dessa interface o servidor sabe o que será enviado e o cliente sabe o que será recebido.

#### Classe concreta RMI
[Classe concreta](rmi-server/Classe.java)

    import java.util.Date;
    public class Classe implements Contrato{
	
        private static double numero = Math.random();	
        private Date data = new Date();

        public double aleatorio() {		
            return Classe.numero;
        }
        
        public Date getDate() {		
            return this.data;
        }

    }

Essa classe vai implementar a interface e criar devidamente o objeto no servidor, uma vez que o objeto esteja criado, poderá então ser enviado ao sistema cliente.

#### Classe com o método main
[ServerInit](./rmi-server/ServerInit.java)

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

    public class ServerInit 
    {
        public static void main( String[] args )
        {
            ApplicationContext app1 = new ClassPathXmlApplicationContext("/Spring/rmi/server/server.xml");    
            Contrato bean = (Contrato) app1.getBean("identificador");	
            System.out.println("Data: "+bean.getDate());
            System.out.println("Aleatorio: " + bean.aleatorio());
            System.out.println("Servidor está ouvindo...");
        }
    }

Caso esteja tudo certo com o XML a aplicação vai ficar ouvindo na porta especificada no xml, que será melhor detalhado abaixo, na url também informada no xml e caso haja algum acesso o objeto será enviado, de todo esse procedimento o que você precisa fazer é até aqui:

    ApplicationContext app1 = new ClassPathXmlApplicationContext("/Spring/rmi/server/server.xml");        

De resto está tudo certinho, essa linha de código é o trecho que carrega o spring e ao menos essa linha precisa ser chamada para que o servidor funcione, uma vez carregado o spring ai é só esperar.

#### Finalmente o XML para configuração do RMI Server
[server.xml](./rmi-server/server.xml)

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"            
        xsi:schemaLocation="http://www.springframework.org/schema/beans 
                            http://www.springframework.org/schema/beans/spring-beans.xsd">
                            
            <!-- Bem que sera acessado pelo cliente -->                  
            <bean id="identificador" class="Spring.rmi.server.Classe" />
            
            <!-- Configuração do bean que sera passado ao cliente -->       
            <bean class="org.springframework.remoting.rmi.RmiServiceExporter">
                <property name="serviceName" value="Target-Contrato"/>
                <property name="service" ref="identificador"/>
                <property name="serviceInterface" value="Spring.rmi.server.Contrato"/>
                <property name="registryPort" value="1199" />
            </bean>            
    </beans>

Como pode-se ver o **RMI** funciona com o básico do Spring, o template básico é o suficiente, além do seu bean informado aqui `<bean id="identificador" class="Spring.rmi.server.Classe" />`, você também deve criar um beam com base na classe [RmiServiceExporter](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/remoting/rmi/RmiServiceExporter.html) no XML do servidor, que vem de `org.springframework.remoting.rmi`, como visto aqui `<bean class="org.springframework.remoting.rmi.RmiServiceExporter">`.

##### serviceName
`<property name="serviceName" value="Target-Contrato"/>`, aqui você informa a url que o seu cliente precisa informar para ter acesso ao seu objeto criado, no caso para que o cliente possa acessar esse bean `<bean id="identificador" class="Spring.rmi.server.Classe" />` ele precisará digitar `rmi://IP:PORTA/Target-Contrato`, quando for solicitado o acesso da aplicação cliente a esse path, esse bean será retornado, devidamente instanciado: `<bean id="identificador" class="Spring.rmi.server.Classe" />`, claro isso se aplica a esse exemplo expecífico, esse atributo é obrigatório e o valor `value="Target-Contrato"` corresponde a esse trecho `/Target-Contrato` do path que o usuário terá que informar `rmi://IP:PORTA/Target-Contrato`.

##### service
Aqui especificamos que bean deve ser exportado caso o path definido acima seja informado, no caso de `<property name="service" ref="identificador"/>` o `ref="identificador"` faz referencia a esse bean `<bean id="identificador" class="Spring.rmi.server.Classe" />`, devido ao ID que esse bean contém, também é obrigatório, uma vez que essa parte informa ao Spring que bean será servido.

##### serviceInterface
Aqui especificamos um interface, lembrando sempre que a interface é obrigado. Essa interface informa ao Spring que tipo de objeto será exportado, também é obrigatório, além disso essa mesma interface deve estar na aplicação,cliente ou a mesma deve ter acesso a essa interface `<property name="serviceInterface" value="Spring.rmi.server.Contrato"/>`.

##### registryPort
Aqui definimos a porta **TCP** que o servidor irá ouvir, uma vez inicializado o servidor, será respondida com o bean todas as requisições com o path correto informado nessa porta, também obrigatório.

### Configurando o Cliente
O cliente é mais simples que o servidor, apenas precisar ter a classe com o método Main, a interface e o XML de configuração e está pronto.

[Classe main do cliente](rmi-client/ClientInit.java)

    import org.springframework.context.ApplicationContext;
    import org.springframework.context.support.ClassPathXmlApplicationContext;

    //Importando a interface do pacote servidor
    import Spring.rmi.server.Contrato;

    public class ClientInit {

        public static void main(String args[]) {
            try {
                ApplicationContext app1 = new ClassPathXmlApplicationContext("/Spring/rmi/client/client.xml");    
                Contrato bean = (Contrato) app1.getBean("identificador");	
                System.out.println(bean.getDate());
                System.out.println("Cliente acessando:" +bean.getDate());
                System.out.println("Numero aleatorio: "+bean.aleatorio());
            }catch(org.springframework.beans.factory.BeanCreationException error) {
                System.out.printf("Ocorreu o seguinte erro: %s, certifique-se que o servidor esteja escutando no Target correto",error.getMessage());
            }
            
        }
    }

#### Atenção nesse ponto!
    //Importando a interface do pacote servidor
    import Spring.rmi.server.Contrato;

Repare que se faz necessário ter a interface, é com base nela que o cliente vai identificar o objeto, no caso é [essa interface criado no também no servidor](#interface-contrato-do-rmi).

#### XML do cliente RMI
[XML Cliente](./rmi-client/client.xml)

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns="http://www.springframework.org/schema/beans"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"            
        xsi:schemaLocation="http://www.springframework.org/schema/beans 
                            http://www.springframework.org/schema/beans/spring-beans.xsd"> 
            
            <!-- Configuração do bean que sera passado ao cliente -->       
            <bean id="identificador" class="org.springframework.remoting.rmi.RmiProxyFactoryBean">
                <property name="serviceUrl" value="rmi://localhost:1199/Target-Contrato"/>        	
                <property name="serviceInterface" value="Spring.rmi.server.Contrato" />
            </bean>            
    </beans>

Esse bean é ainda mais básico que o Bean do servidor, no caso precisa de apenas duas propriedades, o bean deve ter essa classe [RmiProxyFactoryBean](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/remoting/rmi/RmiProxyFactoryBean.html), que é oriundo de `org.springframework.remoting.rmi`, todo o bean que acessa um objeto remoto deve usar-se dessa classe, conforme ilustrado aqui `<bean id="identificador" class="org.springframework.remoting.rmi.RmiProxyFactoryBean">`.

##### serviceUrl
Aqui é informado o servidor ao qual o cliente deve-se conectar para pegar esse bean, no caso do value `rmi://` é o protocolo que será usado, a parte do `localhost` o IP aonde está o servidor a parte `1199` é a porta que foi aberta no servidor para isso e claro após isso `Target-Contrato` o path.

##### serviceInterface
Aqui será definido a interface, que é o tipo do objeto que o cliente espera receber do servidor, ou seja aqui você informa a interface que você uso no servidor, a interface usada no cliente e no servidor devem ser a mesma, lembrando que a interface informado aqui, [deve ser a mesma da usada no servidor](#finalmente-o-xml-para-configuração-do-rmi-server).

### Comparando na prática

#### Output do Servidor
    Data: Wed Dec 23 22:35:25 BRT 2020
    Aleatorio: 0.4748476516419503
    Servidor está ouvindo...
#### Output do cliente
    Wed Dec 23 22:35:25 BRT 2020
    Cliente acessando:Wed Dec 23 22:35:25 BRT 2020
    Numero aleatorio: 0.4748476516419503

#### Explicando
Repare que o número aleatório é o mesmo no cliente e no servidor, isso ocorre porque esse número aleatório foi implementado de maneira estática, como visto em [Classe](#classe-concreta-rmi), ou seja ambos estão usando o mesmo tipo de objeto, além disso ambos os sistemas apresentam o mesmo dado em **Data**, sendo o servidor `Data: Wed Dec 23 22:35:25 BRT 2020` e o cliente `Wed Dec 23 22:35:25 BRT 2020`, ou seja o cliente e o servidor compartilham do mesmo objeto.




