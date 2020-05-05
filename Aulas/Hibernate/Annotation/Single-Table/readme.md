# Hibernate Herança

## Table Single Table

Esse modelo é focado na Hierarquia.

No caso esse modelo une todas as entidades junto com a entidade Pai
em uma unica tabela no banco de dados, incluindo tambem os atributos
das classes filhas tambem. Nesse modelo, voce cria um campo ao qual
cada instancia eh identificada no banco de dados. Esse modelo eh 
interessante voce colocar todos os atributos obrigatorios na classe
Pai, e os opcionais na classe filho, alem disso voce pode criar
um campo de descriminacao para que cada classe gere um valor diferente
nesse atributo.

## Exemplo:
Aqui temos o arquivo de Mapemento: [hibernate.cfg.xml](hibernate.cfg.xml)

Aqui temos a classe Abstrata, que corresponde a classe mais Genérica: [Avo.java](Avo.java)

Aqui temos a primeira classe filha: [Mae.java](Mae.java)

Aqui temos a segunda classe filha: [Pai.java](Pai.java)

## Observações
Na hora de mapear não esqueça de informar o nome do pacote se houver, no **hibernate.cfg.xml**.