# Annotations
 Toda as anotações devem ter outras duas anotações, no caso a **@Retention** que define aonde será executada e a **@Target** que é o alvo a ser executado, além disso uma anotação se assemelha em sua sintaxe a uma interface, como por exemplo:

    @Retention(RUNTIME) 
    @Target(METHOD)
    public @interface MetodoRuntime {
        String valor();
        String ref = "Referencia +";
    }

Repare que a forma de indicar que se trata de uma anotação é: `@interface` Nesse caso, ao menos quatro pacotes devem ser importados, inicialmente as anotações:

    import java.lang.annotation.Retention;
    import java.lang.annotation.Target;

Depois as enums que contém o valor para essas anotações:

    import static java.lang.annotation.ElementType.METHOD;
    import static java.lang.annotation.RetentionPolicy.RUNTIME;

Para o **Retention** são aceito três valores: `RUNTIME`, `SOURCE`, `CLASS`, sendo:

`RUNTIME` => Indica que deve ser executado em tempo de execução. No caso esse tipo de anotação permite a reflexão, uma vez que o seu valor fica disponível em tempo de execução, segue um  exemplo de uma classe de checagem que será usado aqui: [Check](Check.java)

`SOURCE` => Passa instruções a JVM, exemplos: `@SuppressWarnings`, `@Override`, essas anotações não estaram disponíveis em tempo de execução, mas serve para instruit a JVM de como está estruturado o código e se no caso não seguir essa estrutura, lançar um erro, como é o caso do `@Override`, nesse caso se o metodo por exemplo não existir na classe pai o método, é lançado um erro, até mesmo na IDE antes de compilar se for o caso. Lembrando que essa anotação não fica acessível em tempo de execução.

`CLASS` => Informa como a classe deve ser compilada, também não está disponível em tempo de execução, mas está dispoível dentro dos arquivos **.class**, no caso essas anotações servem mais para dizer como a classe deve ser compilada.

## Pra que serve?
As anotações são úteis para situações ao qual você precisa interagir com um código que por hora não está acessível. Por exemplo, quando foi projetado o VSCode ou o Eclipse, os projetistas não saberiam nem quantos e nem quais seria os plugins que iriam criar para isso, nesse caso a programação relexiva permite ler o novo código, estudar os métodos, classe e dessa forma interagir com o novo código, esse tipo de coisa é usada muito na criação de plugins e frameworks, veja o caso do Hibernate por exemplo, o Hibernate ele pode usar ou o XML, como era feito antigamente ou as anotações, para saber quais são as entidades, qual campo é o ID, como que ele deve gerar um novo ID, como essa entidade está relacionada com as outras, etc...

## Runtime Annotations
### Método Main
[Main.java](Main.java)

    package annotations;
    public class Main {
        public static void main(String[] args) {
            Check check = new Check(ClasseExemplo.class);	
            check.anotacaoMetodo();
            check.anotacaoConstructor();
            check.anotacaoCampo();
            check.anotacaoClasse();
            check.anotacaoParametro();
        }
    }

Repare que a classe [Check](Check.java) é a que faz a verificação das anotações, no caso existe as anotações e as classes que fazem checagem em cima dessas anotações, nesse exemplo estamos usando anotações do tipo Runtime. No caso esse método verificado aceita uma classe como parametro como podemos ver aqui: `Check check = new Check(ClasseExemplo.class);`

### Início
Inicialmente a classe de checagem, pega uma classe e faz um procedimentos em cima:

    private Class<?> clazz;		
	public Check(Class<?> clazz) {
		this.clazz = clazz;		
	}	

O tipo **Class** é o tipo classe, nesse tipo de dados, você pode armazenar toda a estrutura de um objeto ou até mesmo uma classe, usando do métodos **getClass()**, que os objetos tem. Além disso todas as classes de reflexão necessárias para trabalhar com o RunTime vem de> `java.lang.reflect.*;`, e no caso `java.lang.annotation.*` para criar novas anotações e definir-las

### java.lang.annotation.ElementType.*
Essa classe contém as definições que deve ser usada no target, ou seja é com auxílio dessa classe que você define aonde que essa anotação deve ser aplicada, se será uma anotação de método, construtor, classe, etc... Aqui por exemplo, estamos definindo como uma anotação de método ` @Target(METHOD)`.

### Classe de exemplo contendo todas as anotações Runtime aqui explicadas:
    package annotations;
    @TypeRuntime(num = 5) 
    public class ClasseExemplo {
        
        @FieldRuntime(numero1 = 1)
        public int valor;
        
        @ConstrutorRuntime
        public ClasseExemplo() {
            System.out.println("Instanciado");
        }
        
        @MetodoRuntime(valor = "lklkl")
        public int metodo(@ParameterRuntime(num = 9) int parametro) {
            return parametro;
        }
    }


### Verificação de método com o check.anotacaoMetodo();
[Arquivo de anotação](MetodoRuntime.java)
#### Anotação MetodoRuntime
    package annotations;
    import static java.lang.annotation.ElementType.METHOD;
    import static java.lang.annotation.RetentionPolicy.RUNTIME;
    import java.lang.annotation.Retention;
    import java.lang.annotation.Target;
    @Retention(RUNTIME) 
    @Target(METHOD)
    public @interface MetodoRuntime {
        String valor();
        String ref = "Referencia +";
    }
#### local de uso:
    @MetodoRuntime(valor = "lklkl")
        public int metodo(@ParameterRuntime(num = 9) int parametro) {
            return parametro;
        }

Tem duas anotações essa explicação refere-se a `@MetodoRuntime(valor = "lklkl")`, que é uma anotação de método.
#### Método para fazer a checagem de métodos
    //Metodo que vefica se tem a anotacao no metodo e o seu valor.
	public void anotacaoMetodo() {
		System.out.println();
		Method[] methods = clazz.getDeclaredMethods();
		System.out.println(methods.length+" metodo(s) tem essa anotacao de metodo");
		for(Method method:methods) {			
			System.out.printf("O metodo %s tem uma anotacao RUNTIME", method);
			System.out.println();
			System.out.printf("Possui a anotacao 'MetodoRuntime'? %b",method.getAnnotation(MetodoRuntime.class).valor());
			System.out.println();
			System.out.printf("Qual o valor do 'MetodoRuntime'? %s",method.getAnnotation(MetodoRuntime.class).valor());
		}
		System.out.println();
	}

##### Method
Quando você for trabalhar reflexão com métodos, deve usar a classe **Method** oriundo de: `import java.lang.reflect.Method;`, no caso é pego todos métodos que essa classe que está sendo analisada tem `Method[] methods = clazz.getDeclaredMethods();` e após isso feito as interações. Aqui pegamos o valor do atributo **valor** da anotação `method.getAnnotation(MetodoRuntime.class).valor());`, no caso especificamente esse:

    @Retention(RUNTIME) 
    @Target(METHOD)
    public @interface MetodoRuntime {
        String valor(); //Esse é o valor que está sendo pego
        String ref = "Referencia +";
    }

Se você precisar pegar qualquer valor passado para uma anotação, após pego todos os métodos, você pode usar o método **getAnnotation()**, que aceita como argumento a classe da anotação que você quer pegar, no caso o **MetodoRuntime.class** seria o arquivo de classe compilada da anotação **MetodoRuntime**, válido lembrar que o argumento será sempre a classe da sua anotação, com ponto e o método que você quer pegar, nesse caso é sempre válido lembrar que uma anotação é uma interface, ou seja poderia ser uma constante ou um método contendo o valor que o usuário da anotação informou. 
#### Anotação para construtores
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

#### Local de uso
    @ConstrutorRuntime
	public ClasseExemplo() {
		System.out.println("Instanciado");
	}

Como você pode ver, existe uma anotação específica para construtores.
#### Método para fazer checagem de construtores
    //Metodo que vefica se tem a anotacao no construtor e o seu valor.
	public void anotacaoConstructor() {
		System.out.println();
		Constructor[] constructors = clazz.getDeclaredConstructors();
		System.out.println(constructors.length+" construtore(s) tem essa anotacao de construtor");
		for(Constructor constructor:constructors) {			
			System.out.printf("O construtor %s tem uma anotacao RUNTIME", constructor);
			System.out.println();
			System.out.printf("Possui a construtor 'ConstructorRuntime'? %b",constructor.getAnnotation(ConstrutorRuntime.class));
			System.out.println();
			System.out.printf("Qual o valor do 'ConstructorRuntime'? %s",constructor.getAnnotation(ConstrutorRuntime.class));
		}
		System.out.println();
	}

##### getDeclaredConstructors() 
Segue a mesma idéia dos métodos, lembrando que construtores aceitam sobrecarga, logo, assim como métodos, sempre deve ser armazenados inicialmente em arrays, sendo feito isso aqui: `clazz.getDeclaredConstructors();`, após uma varredura feita com o foreach, assim como foi feito com os métodos acima `for(Constructor constructor:constructors)`, no caso o construtor tem um método semelhante ao de um método, o funcionamento é bem parecido mesmo no que tange a reflexão. A parte interessante vem aqui: `System.out.printf("Qual o valor do 'ConstructorRuntime'? %s",constructor.getAnnotation(ConstrutorRuntime.class));`, no caso temos o **%s** que formata em String o argumento do método *printf*, pois bem, toda a classe Java herda de `Java.Lang.Object` e nessa classe está implementada o `toString()`, que permite transformar um objeto em string quando o mesmo for tratado como String e nesse caso, devido a essa característica, será impresso um array no formato chave valor o atributo e o seu respectivo dado.