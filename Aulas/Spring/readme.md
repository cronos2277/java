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