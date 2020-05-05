# Hibernate Herança

## Table Joined

Esse modelo é focado na separação total das tabelas (Interessante para Normalizar).

Aqui nós temos as classes filhas unidas a classe Pai através de uma chave estrangeira,
Todas as entidades tem uma tabela no banco de dados incluindo a classe pai que não
é mapeada no **hibernate.cfg.xml**. Essa pode ser uma estratégia interessante para 
normalizar tabela. 

## Exemplo:
Aqui temos o arquivo de Mapemento: [hibernate.cfg.xml](hibernate.cfg.xml)

Aqui temos a classe Abstrata, que corresponde a classe mais Genérica: [Classe.java](Classe.java)

Aqui temos a primeira classe filha: [SubClasse1.java](SubClasse1.java)

Aqui temos a segunda classe filha: [SubClasse2.java](SubClasse2.java)

## Observações
Na hora de mapear não esqueça de informar o nome do pacote se houver, no **hibernate.cfg.xml**.