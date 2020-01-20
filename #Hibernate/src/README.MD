<h1>Sobre o os xml</h1>
<b>PRESTE MUITA ATENÇÃO NO DOCTYPE E NA TAG XML ACIMA, SE TIVER ERRO NISSO 
    PODE DAR MUITO ERRADO,</b> eu gastei muito tempo para entender um problema nisso
    Por exemplo essa url aqui: <b>http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd</b>
    verifique no navegador se a url não foi atualizada, tente primeiro <b>http://www.hibernate.org/dtd/</b>
    e veja o que aparece por exemplo, essa url deve ser valida pois a aplicação usa o dtd
    que é um padrão do XML para validar se é um xml valido.
    <p>Tambem nao esqueça da tag do xml: <b><?xml version="1.0" encoding="UTF-8"?></b>
    Erros do tipo: "<b>Could not parse mapping document: *.hbm.xml</b>" significa que o XML não esta 
    bem formatado.</p>
    <p>Além disso existe outra coisa que da muito problema no hibernate, o local que fica o hibernate.cfg.xml,
    nesse caso você verá mensagens desse tipo: "<b>Could not locate cfg.xml resource</b>".
    Isso significa que o arquivo não está no local certo. Esse arquivo deve estar na pasta src,
    esse é a pasta padrão para esse arquivo, algumas IDEs podem por exemplo não colocar esse arquivo
    no local certo.</p>
    <p> Tambem temos os erros do tipo "<b>Error accessing stax stream</b>", para contonar esse erro,
    verifique se o banco de dados foi inicializado. Aqui no caso eu resolvi esse erro abrindo e conectando
    no cliente do PostGres<p>
    Esses são os dois detalhes que mais pegam na configuração do Hibernate.