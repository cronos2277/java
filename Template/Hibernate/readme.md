<h1>Sobre o Hibernate</h1>
<hr>
<h2>Arquivo hibernate.cfg.xml</h2>
<h3>Observações</h3>
<p>
Esse arquivo deve estar na pasta src da aplicação dentro da raiz, pode acontecer de dar erros de compilação caso esse arquivo não esteja no diretório correto.<br>
Alem disso tomar cuidado com o Doctype, o mesmo precisa ser valido para a aplicao funcionar, de preferencia copie e cole o que esta ali, mas antes disso, coloque
o link no navegador e veja se esse doctype é válido, pois qualquer erro desse tipo pode condenar a renderização desse arquivo xml. Por fim apague os comentários
nos templates e substitua os valores no XML pelo equivalente ao banco de dados que você possui.
</p>
<h3>Lista de Dialetos</h3>
<p>repare que todos os dialetos começam com <b>"org.hibernate.dialect."</b>, esse valor é igual para todos, porem o valor que varia é após esse ultimo ponto. </p>
<div>
<p>Mais provaveis de serem usado:</p>
<p>"<b>org.hibernate.dialect.MySQLDialect</b>" => MySQL</p>
<p>"<b>org.hibernate.dialect.PostgreSQLDialect</b>" => PostgreSQL</p>
<p>"<b>org.hibernate.dialect.SQLServerDialect</b>" => Microsoft SQL Server</p>
<p>"<b>org.hibernate.dialect.OracleDialect</b>" =>  Oracle 8</p>
<p>"<b>org.hibernate.dialect.MariaDBDialect</b>" =>  Maria DB</p>
<p>"<b>org.hibernate.dialect.SQLiteDialect</b>" =>  SQL Lite</p>
</div>
<div>
<p>Os demais Dialetos</p>
<p>"<b>org.hibernate.dialect.DB2Dialect</b>" => DB2</p>
<p>"<b>org.hibernate.dialect.DB2400Dialect</b>" => DB2 AS/400</p>
<p>"<b>org.hibernate.dialect.DB2390Dialect</b>" =>  DB2 OS390</p>
<p>"<b>org.hibernate.dialect.MySQLInnoDBDialect</b>" => MySQL with InnoDB</p>
<p>"<b>org.hibernate.dialect.MySQLMyISAMDialect</b>" => MySQL with MyISAM</p>
<p>"<b>org.hibernate.dialect.Oracle9Dialect</b>" => Oracle 9i/10g</p>
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
<p>"<b>org.hibernate.dialect.FirebirdDialect</b>" => Firebird</p>
</div>
