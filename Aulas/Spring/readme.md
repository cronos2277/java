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

