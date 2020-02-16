<h1>Instrucoes de uso</h1>
<h2>Instanciando</h2>
<h3>Entidade dentro do diamante</h3>
<p>Na hora da instanciacao, exemplo do modo minimo: new "<b>HibernateManager<\ENTIDADE_MAIS_FORTE>(String query)</b>"; <br> 
O <b>"\ENTIDADE_MAIS_FORTE"</b> na sintaxe acima deve ser substituida pela entidade mais forte do seu projeto, uma vez que essa classe tambem fara o DAO dela.</p>
<h3>Modo minimo</h3>
<p>"<b>HibernateManager<\ENTIDADE_MAIS_FORTE>(String query)</b>": Aqui voce instancia apenas informando uma Hibernate query, necessita dos arquivos xml no lugar certo.</p>
<h3>Modo Completo</h3>
<p>"<b>new HibernateManager<\ENTIDADE_MAIS_FORTE>(<br>
boolean isAnnotatedClass, String Restriction,String user, String password,<br>
String host, String driver, String dialect, String query,Class ...Entities)</b>": <br>
Esse eh a forma completa, não necessita do hibernate.cfg.xml, mas dependendo do caso pode precisar de um arquivo de notacao de classe.</p>
<p>
<ul>
<li>"<b>boolean isAnnotatedClass</b>" => Coloque verdadeiro se houver anotacoes nas entidades, caso falso sera procurado o <b>hbm.xml</b> de cada entidade.</li>
<li>"<b>String Restriction</b>" => Aqui voce informa o parametro para o atributo "<b>hibernate.hbm2ddl.auto</b>", recomendado "none" ou "validator". CUIDADO!!!<br> 
Dependendo do valor, todo o gerenciamento do banco de dados pode ser feito pela aplicacao, ou seja voce pode dar poderes para a aplicacao modelar a estrutura banco de dados. </li>
<li><b>"String user"</b> => O nome do usuario no banco de dados.</li>
<li><b>"String password"</b> => A senha do banco de dados.</li>
<li><b>"String host"</b> => Aqui voce informa a url, procure no readme.md a estrutura o equivalente ao seu banco de dados. Se precisar pesquise por: <b>"Hibernate URL Seu banco de dados"</b></li>
<li><b>"String driver"</b> => O Driver do banco de dados, voce pode encontrar mais informacoes aqui tambem, se precisar pesquise por: "<b>Hibernate Drive do seu banco de dados</b>"</li>
<li><b>"String dialect"</b> => O Dialeto do banco de dados, voce tambem pode encontrar informacoes aqui, se precisar pesquise por: <b>"Hibernate dialeto do seu banco de dados."</b></li>
<li><b>"String query"</b> => Aqui voce informa a hibernate query, algo como: <b>"select from Sua_Entidade where ALGUMA_COISA order by ORDEM_ORDENACAO"</b></li>
<li><b>"Class ...Entities"</b> => Aqui voce coloca todos as entidades que devem ser registrado no hibernate.cfg.xml, inclusive a entidade que voce escolheu para colocar nos diamantes na hora da instanciacao, coloque todas as entidades aqui, por exemplo:<br>
"<b>new HibernateManager<\ENTIDADE_MAIS_FORTE>(<br>
boolean isAnnotatedClass, String Restriction,String user, String password,<br>
String host, String driver, String dialect, String query,ENTIDADE_MAIS_FORTE.class,ENTIDADE_FRACA1.class, ENTIDADE.class, etc...)</b>"<br>
</ul></p>
<h2>Metodos:</h2>
<h3>setQuery(String query)</h3>
<p>Redefine a query informada na hora da instanciacao, esse metodo pode ser encadeado.</p>
<h3>insert(Entity entity)</h3>
<p>Insere um novo registro no banco de dados, voce precisa passar um objeto do tipo da Entidade usada no diamante. Esse metodo pode ser encadeado.</p>
<h3>update(Entity entity)</h3>
<p>Atualiza um registro no banco de dados, voce precisa passar um objeto do tipo da Entidade usada no diamante. Esse metodo pode ser encadeado.</p>
<h3>insertOrUpdate(Entity entity)</h3>
<p>Atualiza ou cria um novo registro no banco de dados, voce precisa passar um objeto do tipo da Entidade usada no diamante. Esse metodo pode ser encadeado.</p>
<h3>delete(Entity entity)</h3>
<p>deleta um registro no banco de dados, voce precisa passar um objeto do tipo da Entidade usada no diamante. Esse metodo pode ser encadeado.</p>
<h3>getAll(boolean isUpdate) ou getAll()</h3>
<p>Esse metodo atualiza a todos os registro pego do banco de dados e os retornam em uma lista, se passado um booleano como true, uma conexao com o banco de dados eh feito a forca, senao eh pego o salvo anteriormente.</p>
<h3>refresh()</h3>
<p>Forca a atualizacao de registro, diferente do metodo acima, esse pode ser encadeado e nao retorna uma lista</p>
<h3>errorsCaught()</h3>
<p>Retorna todos os erros registrados dentro de uma String</p>
<h3>hasErrors()</h3>
<p>Retorna um booleano, verdadeiro se houver erros e false se nao houver.</p>
<h3>hasNext()</h3>
<p>Esse metodo retorna true enquanto existir elemento, esse hasNext() foi projetado para ser usado em laco while, afim de fazer uma varredura, caso voce queira acessar todos os elementos ou pegar um em especifico.</p>
<h3>next()</h3>
<p>Retorna o objeto do tipo entidade e avanca na varredura, esse metodo foi projetado para ser usado dentro de um laco while em conjunto com o hasNext()</p>
<h3>iterator()</h3>
<p>Se o hasNext() e o next() nao forem o suficiente para a sua varredura, voce pode pegar um iterator e usa-lo como desejar.</p>
<h3>size()</h3>
<p>Retorna a quantidade de registro pego no banco de dados.</p>
<h3>getRecord(int queryPosition)</h3>
<p>Retorna um registro do banco de dados, o registro na posicao passada como parametro.</p>
<h3>firstRecord()</h3>
<p>Retorna o primeiro registro carregado no banco de dados.</p>
<h3>lastRecord()</h3>
<p>Retorna o ultimo registro carregado no banco de dados.</p>
<h3>toArray()</h3>
<p>Retorna todos os registros pego do banco de dados como um Array do tipo da entidade passada no diamante. </p>