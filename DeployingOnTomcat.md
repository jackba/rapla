This installation is tested with Tomact 7. It requires rapla 1.7.3 or later.

Deploy rapla.war with the default context configuration by either placing it in the webapps folder or uploading it via the tomcat manager app.

Done.

## Further customization ##

If you need to configure database settings or a different location for the storage of the data.xml you need to create a context file. Tomcat Context configuration will done in file named after your webappplication. If you uploaded rapla.war then the context file name is rapla.xml

Place rapla.xml in the conf folder under the engine/host entry (e.g. CATALINA/localhost). Once you created rapla.xml and placed it in the appropriate folder tomcat will automaticaly reload rapla.

You can also modify the default context configuration of rapla by editing the content of META-INF/context.xml with a zip editor like 7 zip. But you will have to do this everytime you upload a new rapla.war.

## The Context File ##

This is the default configuration as placed in META-INF/conf use it as a template for your custom rapla.xml
```
<?xml version='1.0' encoding='utf-8'?>
<!-- Default context configuration for a tomcat container -->
<Context useHttpOnly="true">
  <!-- 
	If you want to use a database instead of file storage, just uncomment the used database driver and place the driver jar in the tomcat/lib folder
	and change rapladatasource to rapladb
   -->
<!--
    <Resource name="jdbc/rapladb" auth="Container" type="javax.sql.DataSource"
 maxActive="10" maxIdle="30" maxWait="10000"
 username="db_user" password="your_pwd" driverClassName="org.hsqldb.jdbcDriver"
 url="jdbc:hsqldb:${catalina.home}/data/rapla-hsqldb"/>
  <Resource name="jdbc/rapladb" 
auth="Container" type="javax.sql.DataSource"
              username="db_user" password="your_pwd" url="jdbc:mysql://localhost/your_db_name"
              driverClassName="com.mysql.jdbc.Driver"
              maxActive="20" maxIdle="10"/>
   -->
  <Environment name="raplafile" value="${catalina.home}/data/data.xml" type="java.lang.String" override="false"/>
  <!-- change this variable to rapladb if you want to use a database instead of the file -->
  <Environment name="rapladatasource" value="raplafile" type="java.lang.String" override="false"/>
  
  <!-- You can also add a mail config if its provided by tomcat
  <Resource name="mail/Session" auth="Container"
            type="javax.mail.Session"
            mail.smtp.host="localhost"/>
   -->
</Context>
```

There are two example entries for database installations.

The first is for a hsqldb database and in the tomcat home folder ${catalina.home}/data. The second for a mysql database. Note that you have to copy the hsqldb or mysql drivers into the tomcat lib folder, to work.

If you want to store in raplafile you may need to set the path to a different location, default is in ${catalina.home}/data/data.xml

The rapladatasource entry tells rapla wether to use which storage you choose.