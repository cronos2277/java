<h1>Sobre o Hibernate</h1>
<p>Documentacao: <a href="https://docs.jboss.org/hibernate/core/3.6/reference/pt-BR/html/preface.html">Hibernate Documentacao</a>
<p>Configurando o Basico do hibernate</p>
<h2>Property</h2>
<p>Para mais informacoes: <a href="https://www.tutorialspoint.com/hibernate/hibernate_configuration.htm">Property Hibernate Link</a></p>
<p>As seguintes properties sao obrigatorias: "<b>username,password,driver,dialect,url</b>", alem disso voce precisa mapear as classes, seja usando addAnnotatedClass ou no xml</p>
<p>As configuracoes de property citadas aqui podem ser aplicadas de tres formas:<br>
    1) colocando-as dentro do arquivo hibernate.cfg.xml, nesse caso seguiria a estrutura XML, veja o arquivo de exemplo: <a href="./XML/hibernate.cfg.xml" ></a><br>
    2) colocando-as dentro do arquivo "<b>hibernate.properties</b>", nesse caso voce coloca o "property=valor", nao vai dentro de aspas e o separador eh o enter, veja exemplo: <a href="https://github.com/hibernate/hibernate-orm/blob/master/etc/hibernate.properties" target"_blank">Hibernate.properties caught</a><br>
    3) Criando de maneira dinamica dentro da aplicacao e em tempo de execucao, nesse caso instancie o objeto  "<b>Configuration configuration = new AnnotationConfiguration();</b>" Melhor explicado abaixo.
</p>
<p>
    Primeiramente cria um objeto configuration, contendo as suas entidades. <br>
    "<b>Configuration configuration = new AnnotationConfiguration() <br> 
    .addAnnotatedClass(Entidade1.class) <br>
    .addAnnotatedClass(Entidade2.class) <br>
    .addAnnotatedClass(Entidade3.class); </b>"<br>
    Nao precisa especificar isso na hora da instanciacao, voce tambem pode usar o metodo, valido lembrar que aqui sao adicionados classes com anotacoes @, as mesmas devem estar devidamente anotada: <br>
    "<b>configuration.addAnnotatedClass(Entidade.class);</b>" <br>
    Apos isso, defina as properties, como no exemplo abaixo:<br>
    "<b>configuration.setProperty("ALGUMA_PROPERTY_EXPLICADA","VALOR_DA_PROPERTY_EM_FORMATO_STING");</b>" <br>
    apesar de algumas properties seguir o formato de booleano ou inteiro, os mesmos devem ser passados como string aqui.
</p>
<hr>
<h4>Explicando as Property basicas e uteis.</h4>
<hr>
<h3> username (hibernate.connection.username) </h3>
<p>proprieade correspondente ao seu user id no banco de dados, recebe um valor do tipo string.</p>
<hr>
<h3>Password (hibernate.connection.password)</h3>
<p>Campo responsavel pelo password da sua conta no banco de dados</p>
<hr>
<h3>Estatisticas do Hibernate (hibernate.generate_statistics)</h3>
<p>Permite fazer estatisticas da aplicacao, mais informacao: <a href="https://docs.jboss.org/hibernate/core/3.6/javadocs/org/hibernate/stat/Statistics.html">Artigo a respeito</a></p>
<hr>
<h3>Exibir SQL (hibernate.show_sql)</h3>
<p>Se definido como True, exbibe o SQL.</p>
<hr>
<h3>Exibir SQL formatado no console? (hibernate.format_sql)</h3>
<p>Recebe um valor booleano, precisa ter a propriedade hibernate.show_sql = true para funcionar</p>
<hr>
<h3>Define o numero maximo de conexoes (hibernate.pool_size)</h3>
<p>Recebe um valor inteiro correspondente ao numero de conexoes maximas permitidas.</p>
<hr>
<h3>Comandos DDL no Hibernate(hibernate.hbm2ddl.auto)</h3>
<p>Essa property permite com que o Hibernate modele por completo as tabelas do banco de dados, com essa property ativada o Hibernate pode fazer o que for definido aqui na tabela:<br>
opcoes:<br>
"<b>validate</b>": validar o schema, nao faz mudancas no banco de dados, apenas analiza se os relacionamentos estao certos e se a tabela esta ok.
"<b>update</b>": Faz update no schema, permite com que o hibernate atualize a tabela de acordo com o mapeamento das suas configuracoes. (Pode ser interessante para pequenos ambientes de producao e ambientes sem concorrencia)
"<b>create</b>": cria o schema, destruindo dados anteriores, recria a tabela a cada inicializacao da aplicacao, apagando dados antigos. (Pode ser interessante para testes)
"<b>create-drop</b>": drop o schema quando ao terminar a sessão, ou seja assim que a sessao termina, a tabela eh apagada. (Pode ser interessante para testes de conexao)
</p>
<hr>
<h3>Lista de Drivers (hibernate.connection.driver_class)</h3>
<div>
<p style="color:red">Mais provaveis de serem usado:</p>
<p>"<b>oracle.jdbc.driver.OracleDriver</b>" => Oracle</p>
<p>"<b>com.mysql.jdbc.Driver"</b> => MySQL</p>
<p>"<b>com.microsoft.sqlserver.jdbc.SQLServerDriver</b>" => MS SQL Server</p>
<p>"<b>org.postgresql.Driver</b>" => PostgreSQL</p>
<p>"<b>org.sqlite.JDBC</b>" => SQL Lite</p>
<p>"<b>org.mariadb.jdbc.Driver</b>" => Maria DB</p>
<p>"<b>org.firebirdsql.jdbc.FBDriver</b>" => Firebird</p>
<p>"<b>org.apache.derby.jdbc.EmbeddedDriver</b>" => Derby </p>
</div>
<div>
<p style="color:red">Os demais Drivers</p>
<p>"<b>org.hsqldb.jdbcDriver</b>" => HypersonicSQL</p>
<p>"<b>org.h2.Driver</b>" => H2</p>
<p>"<b>com.timesten.jdbc.TimesTenDriver</b>" => TimesTen</p>
<p>"<b>com.sybase.jdbc2.jdbc.SybDriver</b>" => Sybase</p>
<p>"<b>com.mckoi.JDBCDriver</b>" => Mckoi SQL</p>
<p>"<b>com.sap.dbtech.jdbc.DriverSapDB</b>" => SAP DB</p>
<p>"<b>net.sourceforge.jtds.jdbc.Driver</b>" => jTDS (since version 0.9)</p>
<p>"<b>org.hibernate.dialect.InterbaseDialect</b>" => Interbase</p>
<p>"<b>interbase.interclient.Driver</b>" => InterClient</p>
<p>"<b>com.pointbase.jdbc.jdbcUniversalDriver</b>" => Pointbase</p>
<p>"<b>ca.edbc.jdbc.EdbcDriver</b>" => Ingres (before Ingress 2006)</p>
<p>"<b>com.ingres.jdbc.IngresDriver</b>" => Ingres 2006 or later</p>
<p>"<b>com.mimer.jdbc.Driver</b>" => Mimer SQL</p>
<p>"<b>com.intersys.jdbc.CacheDriver</b>" => InterSystems Cache</p>
</div>
<hr>
<h3>Lista de URLs (hibernate.connection.url)</h3>
<p>Lista de padrões de URLS a serem usadas. O "||", significa ou, e && e, caso você encontre "||" ou "&&", favor apenas selecionar um outro, uma vez que isso é usado como separador aqui.  </p>
<p>"<b>jdbc:mysql:///test</b>" => MySQL</p>
<p>"<b>jdbc:mariadb://localhost/hibernate_orm_test</b>" => Maria DB</p>
<p>"<b>jdbc:sqlserver://localhost || jdbc:microsoft:sqlserver://1E1;DatabaseName=test;SelectMethod=cursor</b>" => SQL Server</p>
<p>"<b>jdbc:oracle:thin:@localhost:1521:orcl || jdbc:oracle:thin:@localhost:1522:XE</b>" => Oracle</p>
<p>"<b>jdbc:sqlite:mydb.db</b>" => SQL Lite</p>
<p>"<b>jdbc:hsqldb:./build/db/hsqldb/hibernate</b>" => HypersonicSQL</p>
<p>"<b>jdbc:h2:tcp://dbserv:8084/sample; || jdbc:h2:ssl://secureserv:8085/sample;  || jdbc:h2:ssl://secureserv/testdb;cipher=AES</b>" => HypersonicSQL</p>
<p>"<b>jdbc:db2://localhost:50000/somename || jdbc:db2:somename</b>" => DB2</p>
<p>"<b>jdbc:timesten:direct:test</b>" => TimesTen</p>
<p>"<b>jdbc:derby:build/db/derby/hibernate;create=true</b>" => Derby</p>
<p>"<b>jdbc:sybase:Tds:co3061835-a:5000/tempdb</b>" => Sybase</p>
<p>"<b>jdbc:mckoi:/// || jdbc:mckoi:local://C:/mckoi1.0.3/db.conf</b>" =>Mckoi SQL </p>
<p>"<b>jdbc:interbase://localhost:3060/C:/firebird/test.gdb</b>" => InterClient</p>
<p>"<b>jdbc:pointbase:embedded:sample</b>" => Pointbase</p>
<p>"<b>jdbc:edbc://localhost:II7/database && jdbc:ingres://localhost:II7/database;CURSOR=READONLY;auto=multi</b>" => Ingres Old && Ingres New</p>
<p>"<b>jdbc:mimer:multi1</b>" => Mimer SQL</p>
<p>"<b>jdbc:Cache://127.0.0.1:1972/HIBERNATE</b>" => InterSystems Cache</p>

<hr>
<h3>Lista de Dialetos (hibernate.connection.dialect)</h3>
<p>repare que todos os dialetos começam com <b>"org.hibernate.dialect."</b>, esse valor é igual para todos, porem o valor que varia é após esse ultimo ponto. </p>
<div>
<p style="color:red">Mais provaveis de serem usado:</p>
<p>"<b>org.hibernate.dialect.MySQLDialect</b>" => MySQL</p>
<p>"<b>org.hibernate.dialect.MySQLInnoDBDialect</b>" => MySQL with InnoDB</p>
<p>"<b>org.hibernate.dialect.MySQLMyISAMDialect</b>" => MySQL with MyISAM</p>
<p>"<b>org.hibernate.dialect.PostgreSQLDialect</b>" => PostgreSQL</p>
<p>"<b>org.hibernate.dialect.SQLServerDialect</b>" => Microsoft SQL Server</p>
<p>"<b>org.hibernate.dialect.OracleDialect</b>" =>  Oracle 8</p>
<p>"<b>org.hibernate.dialect.Oracle9Dialect</b>" => Oracle 9i/10g</p>
<p>"<b>org.hibernate.dialect.MariaDBDialect</b>" =>  Maria DB</p>
<p>"<b>org.hibernate.dialect.MariaDB53Dialect</b>" =>  Maria DB</p>
<p>"<b>org.hibernate.dialect.SQLiteDialect</b>" =>  SQL Lite</p>
<p>"<b>org.hibernate.dialect.FirebirdDialect</b>" => Firebird</p>
<p>"<b>org.hibernate.dialect.DB2Dialect</b>" => DB2</p>
<p>"<b>org.hibernate.dialect.DerbyDialect</b>" => Derby</p>
</div>
<div>
<p style="color:red">Os demais Dialetos</p>
<p>"<b>org.hibernate.dialect.DB2400Dialect</b>" => DB2 AS/400</p>
<p>"<b>org.hibernate.dialect.DB2390Dialect</b>" =>  DB2 OS390</p>
<p>"<b>org.hibernate.dialect.SybaseDialect</b>" => Sybase</p>
<p>"<b>org.hibernate.dialect.SybaseAnywhereDialect</b>" => Sybase Anywhere</p>
<p>"<b>org.hibernate.dialect.SAPDBDialect</b>" => SAP DB</p>
<p>"<b>org.hibernate.dialect.InformixDialect</b>" => Informix</p>
<p>"<b>org.hibernate.dialect.HSQLDialect</b>" => HypersonicSQL</p>
<p>"<b>org.hibernate.dialect.IngresDialect</b>" => Ingres</p>
<p>"<b>org.hibernate.dialect.ProgressDialect</b>" => Progress</p>
<p>"<b>org.hibernate.dialect.MckoiDialect</b>" => Mckoi SQL</p>
<p>"<b>org.hibernate.dialect.InterbaseDialect</b>" => Interbase</p>
<p>"<b>org.hibernate.dialect.PointbaseDialect</b>" => Pointbase</p>
<p>"<b>org.hibernate.dialect.FrontbaseDialect</b>" => FrontBase</p>
</div>
<a href="https://github.com/hibernate/hibernate-orm/blob/master/etc/hibernate.properties" target"_blank">Hibernate.properties caught</a>