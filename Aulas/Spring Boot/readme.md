# Spring boot
[Clique aqui para acessar o WIZARD](https://start.spring.io/)

[XML Exemplo](pom.xml)

[Documentação do Spring Boot](https://spring.io/projects/spring-boot)

[Guia Rápido](https://spring.io/guides/gs/spring-boot/)

Você pode criar um arquivo *pom* através de um **wizard** de maneira automatizada, seguindo esse site [WIZARD](https://start.spring.io/), no caso, ao menos por enquanto o site disponibiliza um zip com os arquivos criados com base nas configurações do [WIZARD](https://start.spring.io/), segue em anexo um arquivo pom pego desse site, no caso nesse XML foi incluído também o JUnit 5, mas tirando isso toda a configuração foi feita no [WIZARD](https://start.spring.io/). O Spring boot permite criar uma aplicação no java de maneira simplificada.

1.[Configuração básica no Arquivo XML](#sobre-o-arquivo-pomxml)

2.[Básico para funcionar](#basico)

3.[Controller Básico](#controller-basico)

4.[Controlador Rest](#controlador-rest)

## Sobre o arquivo POM.XML
### Configuração
    <parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.4.2</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>

Nessa parte é feito a configuração, essa parte é obrigatória.

### Dependencias

    <dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
    </dependencies>

Essas são as dependências básicas para o funcionamento do SpringBoot, apenas cuidado para não repetir esse trecho do código no arquivo *POM*, isso pode gerar conflito e fazer com que não funcione direito.

### Versão do Java

    <properties>
		<java.version>1.8</java.version>
	</properties>

Aqui é definido a versão do java, o mínimo para funcionar é a versão 8 do Java.

### Colocando teste

    <dependency>
	    <groupId>junit</groupId>
	    <artifactId>junit</artifactId>
	    <scope>test</scope>
	</dependency>

### Plugin básico necessário para o funcionamento e automatização

    <build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>


### Não vem no wizard, mas é necessário para funcionar a API Rest

    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>

Se faz necessário colocar essa dependência dentro do arquivo [POM.XML](pom.xml) para que funcione a aplicação na web, essa parte faz toda a configuração do *Tom Cat*, cuidado para não repetir esse trecho do código no arquivo *POM*, isso pode gerar conflito e fazer com que não funcione direito.

## Basico
No arquivo main deve ter uma anotação de classe chamada `@SpringBootApplication` oriunda de `import org.springframework.boot.autoconfigure.SpringBootApplication;` e também se faz necessário executar o método run do objeto `SpringApplication` oriundo de `org.springframework.boot.autoconfigure.SpringBootApplication;`, dentro do método Main, ao exemplo abaixo:

    package br.com;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;

    @SpringBootApplication
    public class Application {

    	public static void main(String[] args) {		
    		SpringApplication.run(Application.class, args);
    	}

    }

### Output

         .   ____          _            __ _ _
     /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
     \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
      '  |____| .__|_| |_|_| |_\__, | / / / /
     =========|_|==============|___/=/_/_/_/
     :: Spring Boot ::                (v2.4.2)

    2021-02-08 18:32:22.593  INFO 10076 --- [           main] br.com.Application                       : Starting Application using Java 1.8.0_231 on desktop-w10 with PID 10076    (C:\Users\crono\eclipse-workspace\SpringBootJP\target\classes started by crono in C:\Users\crono\eclipse-workspace\SpringBootJP)
    2021-02-08 18:32:22.595  INFO 10076 --- [           main] br.com.Application                       : No active profile set, falling back to default profiles: default
### Documentação:

[SpringApplication](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html).

[@SpringBootApplication](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/SpringBootApplication.html).

## Controller Basico
Inicialmente se faz necessário incluir isso no arquivo POM, para que as anotações sejam importadas

    <!-- https://mvnrepository.com/artifact/org.springframework/spring-web -->
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-web</artifactId>
        <version>5.3.3</version>
    </dependency>

## Controlador Rest
Uma vez que tudo esteja configurado e que o método main tenha a implementação conforme [vista aqui](#basico). Uma vez que tudo esteja funcionando e tenha uma classe com a anotação `@RestController` e pelo menos um método com `@RequestMapping` o output deve ser mais ou menos semelhante a esse:


      .   ____          _            __ _ _
     /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
    ( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
     \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
      '  |____| .__|_| |_|_| |_\__, | / / / /
     =========|_|==============|___/=/_/_/_/
     :: Spring Boot ::                (v2.4.2)

    2021-02-08 18:32:22.593  INFO 10076 --- [           main] br.com.Application                       : Starting Application using Java 1.8.0_231 on desktop-w10 with PID 10076    (C:\Users\crono\eclipse-workspace\SpringBootJP\target\classes started by crono in C:\Users\crono\eclipse-workspace\SpringBootJP)
    2021-02-08 18:32:22.595  INFO 10076 --- [           main] br.com.Application                       : No active profile set, falling back to default profiles: default
    2021-02-08 18:32:23.598  INFO 10076 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)
    2021-02-08 18:32:23.609  INFO 10076 --- [           main] o.apache.catalina.core.StandardService   : Starting service [Tomcat]
    2021-02-08 18:32:23.609  INFO 10076 --- [           main] org.apache.catalina.core.StandardEngine  : Starting Servlet engine: [Apache Tomcat/9.0.41]
    2021-02-08 18:32:23.673  INFO 10076 --- [           main] o.a.c.c.C.[Tomcat].[localhost].[/]       : Initializing Spring embedded WebApplicationContext
    2021-02-08 18:32:23.674  INFO 10076 --- [           main] w.s.c.ServletWebServerApplicationContext : Root WebApplicationContext: initialization completed in 1039 ms
    2021-02-08 18:32:23.819  INFO 10076 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
    2021-02-08 18:32:23.965  INFO 10076 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8080 (http) with context path ''
    2021-02-08 18:32:23.973  INFO 10076 --- [           main] br.com.Application                       : Started Application in 1.671 seconds (JVM running for 1.982)

Repare que o Tomcat é configurado de maneira automatizada, sem precisar mexer com XML, conforme visto aqui `o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat initialized with port(s): 8080 (http)`, ou seja o Spring boot faz com que a configuração de uma API rest seja feito de maneira rápida, aumentando assim a produtividade.

### Classe com @RestController Básico
[Bean.java](Bean.java) -> Bean Usado nesse exemplo

    public class Bean {
	    private int id;
	    private String name;	
    
	    public Bean(int id, String name) {
	    	this.id = id;
	    	this.name = name;
	    }
    
	    public Bean() {
        
	    }
    
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
    }

[Controller Basico](ControllerBasico.java) -> Controllador Básico

    @RestController
    public class ControllerBasico {	
        
        @RequestMapping(value = "/api/", method=RequestMethod.GET)
        public Bean index() {
            System.out.println("Acessando Index");		
            Bean bean = new Bean(1,"João");
            return bean;
        }
    }

Esse exemplo é o mínimo para que a aplicação funcione, no caso se tudo der certo e a aplicação estiver funcionando, ao cliente acessar, como nesse exemplo o **http://localhost:8080/api**, usando o método *GET*, será reproduzido o seguinte conteúdo `return bean;`, ou seja esse objeto `Bean bean = new Bean(1,"João");` será transformado em um **JSON**. No caso a API rest transforma um objeto JAVA em um objeto JSON, no caso o output desse método acima é o abaixo se acessado a url **http://localhost:8080/api**:

    {"id":1,"name":"João"}

Lógico que o método deve ter um **getter** e um **setter** e cada **getter**, pois é com base nos *getters* que são gerado esse **JSON**.

### @RestController
Essa anotação indica ao **Spring Boot** que a classe é uma *controller*, logo ela é obrigatória e vem da seguinte biblioteca `import org.springframework.web.bind.annotation.RestController;`, [Documentação](https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/bind/annotation/RestController.html) 

    @RestController
    public class ControllerBasico {	...

### @RequestMapping
Se passado apenas um parametro `@RequestMapping("/api/")` você informa a url ao qual esse método acessa, quando o parametro method é omitido, a resposta desse método será o GET, no caso ao acessar o `http://host/api` pelo método get a resposta será o que o método retorna:

    @RequestMapping(value = "/api/", method=RequestMethod.GET)
        public Bean index() {
            System.out.println("Acessando Index");		
            Bean bean = new Bean(1,"João");
            return bean;
        }
#### method
Também é possível informar a url e o método ao qual esse controller responde, porém para isso a url deve ser passado como valor de *value*. Como nesse caso aqui `@RequestMapping(value = "/api/", method=RequestMethod.GET)`.