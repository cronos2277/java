# Hibernate com '@Annotation'

## MAPEANDO
Mapeamento de classes nao precisa extensao, apenas o pacote e o nome do arquivo .java
`<mapping class="Pacote.Classe" />`

## Exemplos de Mapeamento
Aqui temos o arquivo de Mapemento: [hibernate.cfg.xml](hibernate.cfg.xml)

Aqui temos um exemplo básico de como funciona: [Exemplo Básico](Basico.java)

Aqui temos a classe auxiliar, a classe ao qual todos os exemplos citam: [Veja a Entidade Auxiliar](Auxiliar.java)

Aqui temos um exemplo de como Coleções funciona: [Exemplo de Coleções](Colecoes.java)

Aqui temos um exemplo de como OneToOne funciona: [Exemplo de OneToOne](OneOne.java)

Aqui temos um exemplo de como ManyToOne e OneToMany funciona: [Exemplo de OneToOne e OneToMany](ManyOneMany.java)

Aqui temos um exemplo de como ManyMany funciona: [Exemplo de ManyMany](ManyMany.java)

## Exemplos de mapeamento com Herança

Aqui exemplos de como funciona a Herança (Generalização): [Exemplos de Herança](./Table-Per-Class)

Aqui exemplos de como funciona a Herança (Hierarquia): [Exemplos de Herança](./Single-Table)

Aqui exemplos de como funciona a Herança (Normalizado): [Exemplos de Herança](./Joined)

## Observação
As entidades tem os atributos publicos, mas isso é apenas para reduzir código, uma
vez que os getters e setters iriam poluir muito a Entidade e deixar o código um 
pouco mais complexo, use Bean se precisar de algo profissional, evite atributos publicos.