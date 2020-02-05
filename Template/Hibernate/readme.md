<h1>Sobre o Hibernate</h1>
<p>Configurando o Basico do hibernate</p>





<hr>
<h2>Lista de Drivers</h2>
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
<h2>Lista de Dialetos</h2>
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
<p>"<b>org.hibernate.dialect.SQLiteDialect</b>" =>  SQL Lite</p>
<p>"<b>org.hibernate.dialect.FirebirdDialect</b>" => Firebird</p>
<p>"<b>org.hibernate.dialect.DB2Dialect</b>" => DB2</p>
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