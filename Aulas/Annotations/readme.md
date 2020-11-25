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

`RUNTIME` => Indica que deve ser executado em tempo de execução. No caso esse tipo de anotação permite a reflexão, uma vez que o seu valor fica disponível em tempo de execução.

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



### Verificação de método com o check.anotacaoMetodo();
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