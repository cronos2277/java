# Spring boot
[Clique aqui para acessar o WIZARD](https://start.spring.io/)

[XML Exemplo](pom.xml)

[Documentação do Spring Boot](https://spring.io/projects/spring-boot)

[Guia Rápido](https://spring.io/guides/gs/spring-boot/)

Você pode criar um arquivo *pom* através de um **wizard** de maneira automatizada, seguindo esse site [WIZARD](https://start.spring.io/), no caso, ao menos por enquanto o site disponibiliza um zip com os arquivos criados com base nas configurações do [WIZARD](https://start.spring.io/), segue em anexo um arquivo pom pego desse site, no caso nesse XML foi incluído também o JUnit 5, mas tirando isso toda a configuração foi feita no [WIZARD](https://start.spring.io/). O Spring boot permite criar uma aplicação no java de maneira simplificada.

1.[Configuração básica no Arquivo XML](#sobre-o-arquivo-pomxml)

2.[Básico para funcionar](#basico)

3.[Controller Básico](#controller-basico)

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

Essas são as dependências básicas para o funcionamento do SpringBoot.

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

Se faz necessário colocar essa dependência dentro do arquivo [POM.XML](pom.xml) para que funcione a aplicação na web.

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

### Documentação:

[SpringApplication](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/SpringApplication.html).

[@SpringBootApplication](https://docs.spring.io/spring-boot/docs/current/api/org/springframework/boot/autoconfigure/SpringBootApplication.html).

## Controller Basico