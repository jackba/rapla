This installation is tested with jboss-eap-6.1 it requires rapla 1.7.3 or later.

  1. Go to the management console in jboss
  1. Add a datasource
    * Set name to **`rapladb`**
    * And jndiname to **`java:jboss/datasources/rapladb`**
    * you can choose the default h2 database with a connection url like the following
```
    jdbc:h2:file:${jboss.server.data.dir}${/}rapla
```
    * or the database of your choice. For configuring different databases with jboss see the jboss documentation for your driver e.g. http://www.mastertheboss.com/jboss-datasource/how-to-configure-a-datasource-with-jboss-7
  1. Upload rapla.war via console and try at `localhost:8080` or whatever port you configured in jboss.

### Notes ###

If you want to configure different settings (e.g. another root context) open rapla.war with a zip editor like 7 zip and modify WEB-INF/jboss-web.xml


If you dont have `java:jboss/mail/Default` as in the default configuration alter or uncomment (if you don't need container mailing) from the following line from the WEB-INF/jboss-web.xml
```
<resource-ref>
    <description>Rapla mail service</description>
    <res-ref-name>mail/Session</res-ref-name>
    <res-type>javax.mail.Session</res-type>
    <jndi-name>java:/jboss/mail/Default</jndi-name>
    <res-auth>Container</res-auth>
</resource-ref>
```