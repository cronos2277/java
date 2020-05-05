# Hibernate Herança

## Table Per Class

Esse modelo é focado na Generalização e especialização.

Apenas as classes concretas devem ser mapeadas e apenas essas
mesmas classes concretas existirão no banco de dados, sendo que
os valores da classe genérica será encorporado em cada classe
concreta. Por Exemplo: 
Temos duas classes Filhas, filhaA e filhaB que extendem de Pai, 
existira duas tabelas uma para filhaA e outra para filhaB, o
Pai não existirá, porém tanto a filhaA como a filhaB terão
dentro de si os atributos correspondentes da tabela Pai.

## Entidades
Aqui temos o arquivo de Mapemento: [hibernate.cfg.xml](hibernate.cfg.xml)

Aqui temos a classe Abstrata, que corresponde a classe mais Genérica: [Abstrata.java](Abstrata.java)

Aqui temos a primeira classe filha: [ConcretaDireita.java](ConcretaDireita.java)

Aqui temos a segunda classe filha: [ConcretaEsquerda.java](ConcretaEsquerda.java)