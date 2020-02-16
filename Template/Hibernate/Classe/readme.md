<h1>Instrucoes de uso</h1>
<h2>Instanciando</h2>
<h3>Modo minimo</h3>
<p>"<b>HibernateManager<ENTIDADE_MAIS_FORTE>(String query)</b>": Aqui voce instancia apenas informando uma Hibernate query, necessita dos arquivos xml no lugar certo.</p>
<p>"<b>new HibernateManager<ENTIDADE_MAIS_FORTE>(<br>
boolean isAnnotatedClass, String Restriction,String user, String password,<br>
String host, String driver, String dialect, String query,Class ...Entities)</b>": <br>
Esse eh a forma completa, não necessita do hibernate.cfg.xml, mas dependendo do caso pode precisar de um arquivo de notacao de classe.</p>
<ul>
<li>A respeito do construtor completo </li>
<li>"<b>boolean isAnnotatedClass</b>" => Coloque verdadeiro se houver anotacoes nas entidades, caso falso sera procurado o <b>hbm.xml</b> de cada entidade.</li>
<li>"<b>String Restriction</b>" => Aqui voce informa o parametro para o atributo "<b>hibernate.hbm2ddl.auto</b>", recomendado "none" ou "validator". CUIDADO!!!<br> 
Dependendo do valor, todo o gerenciamento do banco de dados pode ser feito pela aplicacao, ou seja voce pode dar poderes para a aplicacao modelar a estrutura banco de dados. </li>
<li><b>"String user"</b> => O nome do usuario no banco de dados.</li>
<li><b>"String password"</b> => A senha do banco de dados.</li>
<li><b>"String host"</b> => Aqui voce informa a url, procure no readme.md a estrutura o equivalente ao seu banco de dados. Se precisar pesquise por: <b>"Hibernate URL Seu banco de dados"</b></li>
<li><b>"String driver"</b> => O Driver do banco de dados, voce pode encontrar mais informacoes aqui tambem, se precisar pesquise por: "<b>Hibernate Drive do seu banco de dados</b>"</li>
<li><b>"String dialect"</b> => O Dialeto do banco de dados, voce tambem pode encontrar informacoes aqui, se precisar pesquise por: <b>"Hibernate dialeto do seu banco de dados."</b></li>
<li><b>"String query"</b> => Aqui voce informa a hibernate query, algo como: <b>"select from Sua_Entidade where ALGUMA_COISA order by ORDEM_ORDENACAO"</b></li>
<li><b>"Class ...Entities"</b> => Aqui voce coloca todos as entidades que devem ser registrado no hibernate.cfg.xml, inclusive a entidade que voce escolheu para colocar nos diamantes na hora da instanciacao.</li>

</ul>