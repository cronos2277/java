# Java Spring
## Instalando
Esse é o arquivo pom.xml que foi usado. Você pode encontra-lo aqui:[pom.xml](pom.xml)

    `<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
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
    </project>`

## Arquivo Básico
### Um Exemplo com comentários explicando.
    `<?xml version="1.0" encoding="UTF-8"?>
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
        </beans>`

### Um exemplo de um arquivo sem comentários
    `<?xml version="1.0" encoding="UTF-8"?>
    <!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN"
            "http://www.springframework.org/dtd/spring-beans-2.0.dtd">
    <beans>
        <bean name="bean1" class="Spring.home.Bean1" >		
            <property name="valor" value="valor Padrao"/>
        </bean>	
    </beans>`

## Explicando
### Arquivo XML.
Você o encontra aqui esse arquivo básico: [ApplicationContext](ApplicationContext.xml)

### Sobre o XML Acima.

`<?xml version="1.0" encoding="UTF-8"?>` => Codificação do XML, recomenda-se o uso do UTF-8 para evitar problemas com caractéres latinos.

`<!DOCTYPE beans PUBLIC "-//SPRING//DTD BEAN 2.0//EN" "http://www.springframework.org/dtd/spring-beans-2.0.dtd">` => Arquivo de validacao do XML, jogue essa url na web para ver isso ainda está validando. Essa url precisa funcionar para esse ser um arquivo de validação, o java requer um doctype válido para funcionar, ai está uma cópia se quiser dar uma olhada [spring-beans-2.0.dtd](spring-beans-2.0.dtd).

`<beans>` **O BEAN AQUI** `</beans>` => Um container de beans o seu bean deve estar dentro dessas tags.

`<bean name="bean1" class="Spring.home.Bean1" >` **property** `</bean>` => Aqui fica a definição da sua classe, ao qual o Spring deve fazer a injeção de dependência. O **name** é como ele será referenciado e o **class** é path mais o nome da classe. XML e Java são sensetive case.

`<property name="valor" value="valor Padrao"/>` => Nesse contexto o name se refere ao atributo e o value, o valor inícial que esse atributo deve ter, você deve usar apenas se voce quiser que esse atributo inicie com algum valor.