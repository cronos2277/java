# Segue a lista dos métodos:
[Artigo do site DEVSV](https://devsv.wordpress.com/2012/07/08/como-implementar-um-tablemodel/), **07/11/2020 22:45**.

## TableModel

### Quais são os métodos da interface TableModel?

#### getRowCount: 
retorna a quantidade total de linhas. Com esta informação, a JTable sabe quantas linhas devem ser exibidas;

#### getColumnCount: 
retorna a quantidade total de colunas que a JTable deve usar para montar a tabela;

#### getColumnName(int columnIndex): 
retorna o nome da coluna referente ao índice especificado por parâmetro. O nome da coluna é usado para definir o texto do cabeçalho;

#### getColumnClass(int columnIndex): 
retorna o tipo de dado associado a coluna especificada. Esta informação é utilizada para definir o “renderer” e o “editor” que serão associados às células pertencentes a coluna em questão;

#### isCellEditable(int rowIndex, int columnIndex): 
retorna um valor booleano que diz se a célula especificada pode ter seu valor alterado ou não. Isto significa que o método “setValueAt” só terá efeito se o retorno deste método for true;

#### getValueAt(int rowIndex, int columnIndex):
retorna o conteúdo da célula especificada;

#### setValueAt(Object value, int rowIndex, int columnIndex):
define um novo valor para célula especificada;

#### addTableModelListener(TableModelListener l):
adiciona o TableModelListener especificado na lista de listeners a serem notificados das mudanças nos dados da tabela;

#### removeTableModelListener(TableModelListener l):
remove o TableModelListener especificado da lista de listeners a serem notificados.

## AbstractTableModel

### Qual o papel da classe AbstractTableModel?
AbstractTableModel é uma classe abstrata que oferece a implementação de alguns métodos da interface TableModel, além de um conjunto de métodos úteis. Portanto o usual é estender esta classe ao invés de implementar TableModel diretamente.

### Precisamos conhecer estes métodos úteis da classe AbstractTableModel?
Não precisamos conhecer todos, mas considero importante conhecer os métodos “fire”, que servem para notificar a ocorrência de eventos, conforme descrito a seguir:

#### fireTableDataChanged:
notifica que todos os dados da tabela podem ter sido alterados. A JTable usa esta informação para redesenhar todas as células, atualizando seu conteúdo;

#### fireTableStructureChanged:
notifica que a estrutura da tabela foi modificada. Isto significa que a quantidade, o nome ou tipo das colunas podem ter sido alteradas. Este tipo de evento faz com que a JTable reconstrua sua estrutura na tela;

#### fireTableRowsInserted(int firstRow, int lastRow):
notifica que as linhas na faixa especificada foram adicionadas, fazendo com que a JTable redesenhe apenas as linhas que foram afetadas;

#### fireTableRowsUpdated(int firstRow, int lastRow):
notifica que as linhas na faixa especificada tiveram seu valor atualizado;

#### fireTableRowsDeleted(int firstRow, int lastRow):
notifica que as linhas na faixa especificada foram removidas;

#### fireTableCellUpdated(int row, int column):
notifica que o conteúdo da célula especificada foi atualizado, fazendo com que a JTable redesenhe apenas a célula em questão.