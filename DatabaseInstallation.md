It is possible to store the data in a SQL-Database like Postgres or MySQL. This has several advantages over storing
in an xml-file.

  * Incremental: Everytime you store an object, the DBOperator will only stores the changed objects and their dependencies instead of rewriting all objects. Therefor the DBOperator scales much better than the FileOperator does.
  * There are many backup solutions for the above databases.
  * The DBOperator takes also advantage of Databases that support transactions. If an error occurs during storing the store operation will be rolled back.
  * You can access rapla data easily from other applications

But also the disadvantage that it's installation requires some work.

# DATABASE SETUP  in Rapla 1.7 and later #

Note: In the following section replace url.to.yourserver with the
domain or ip of your server and your\_db\_name, db\_user, your\_pwd with
some appropriate values.


---

## A) HSQLDB ##
This is a 100% java sql-database. Installation for this database
is easy in rapla.

1) Open context/rapla.xml and edit the rapladatasource entry
```
 <New id="rapladatasource" class="org.eclipse.jetty.plus.jndi.EnvEntry">
    <Arg></Arg>
    <Arg>rapladatasource</Arg>
    <Arg type="java.lang.String">raplafile</Arg>
    <Arg type="boolean">true</Arg>
 </New>
```
Change raplafile to rapladb.

2) Thats it! Start the server and the data in your data.xml will be imported. If you want to change the location of the database edit

```
  <New class="org.hsqldb.jdbc.JDBCDataSource">
    <Set name="Url">jdbc:hsqldb:<SystemProperty name="jetty.home" default="." />/data/rapla-hsqldb</Set>
    <Set name="User">db_user</Set>
    <Set name="Password">your_pwd</Set>
  </New>
```

3) IMPORT: There are two commandline options that allow you import and export data from an to the data.xml later

on Windows:
```
raplaimport.bat 
```
on Linux:
```
raplaserver.sh import 
```
imports file from `source` (This is the file Operatator) into `dest` this is the sql operator.

on Windows:
```
raplaexport.bat 
```
on Linux:
```
raplaserver.sh export
```
exports file from `dest` (This is the sql Operatator) into `source` this is the file operator.

If the database is empty the import will be done automaticaly on the first start.


---

## B) Postgres: ##

1) First you have to login as postgres user. Then you can create a new user with \\
```
createuser -P -d db_user 
password: your_pwd
```

2) Create a database with
```
createdb -E UNICODE -O db_user your_db_name
```
''(Note: We strongly recommend using UNICODE as encoding for your database. If your postgres-version doesn't support unicode you might try your local encoding e.g. LATIN\_1)''

3) On some systems (debian) you need to add the following lines to pg\_hda.conf.
```
host         your_db_name  db_user        127.0.0.1    255.0.0.0  password
```
and restart postres (there must be a tab character between each entry)

4) You can now test the connection with
```
psql -h localhost -U db_user your_db_name -W
```

5) Download the postgres driver from http://jdbc.postgresql.org/ and put it into your lib/ext directory.

6) Now you need to change the database settings in contexts/rapla.xml\\
Uncomment and edit the postgres settings and comment out the hsqldb settings
```
   <New class="org.postgresql.ds.PGPoolingDataSource">
           <Set name="User">db_user</Set>
           <Set name="Password">your_pwd</Set>
           <Set name="DatabaseName">your_db_name</Set>
           <Set name="ServerName">localhost</Set>
           <Set name="PortNumber">5432</Set>
    </New>
```

7) Change the rapladatasource entry from raplafile to rapladb (see HSQLDB point 1)

8) initialization and import (see HSQLDB)



---

## C) Mysql: ##

1) Use the mysql client and connect to the mysql database.

2) Create new database with
```
CREATE DATABASE your_db_name;
```

3) Create user with
```
GRANT ALL PRIVILEGES ON your_db_name.* TO db_user@localhost IDENTIFIED BY 'your_pwd';
GRANT ALL PRIVILEGES ON your_db_name.* TO db_user@127.0.0.1 IDENTIFIED BY 'your_pwd';
```
If rapla server is running from a different host add the ip adress or the name of the host.

4) Download the driver from http://dev.mysql.com/downloads/connector/j/ and
and put it into your lib/ext directory .

5) Now you need to change the database settings in contexts/rapla.xml\\
Uncomment and edit the mysql settings and comment out the hsqldb settings
```
   <New class="com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource">
         <Set name="Url">jdbc:mysql://localhost/your_db_name</Set>
         <Set name="User">db_user</Set>
         <Set name="Password">your_pwd</Set>
   </New>
```

6) Change the rapladatasource entry from raplafile to rapladb (see HSQLDB point 1)

7) initialization and import (see HSQLDB)




---




# DATABASE SETUP  in Rapla 1.5-1.6 #

Note: In the following section replace url.to.yourserver with the
domain or ip of your server and your\_db\_name, db\_user, your\_pwd with
some appropriate values.


---

## A) HSQLDB ##
This is a 100% java sql-database. Installation for this database
is easy in rapla.

1) You need to download the latest version from
hsqldb.sf.net unzip it and place hsqldb.jar
in lib/server (or WEB-INF/lib in the webapp distributin)

2) then replace `<store>file</store>` with `<store>sql</store>` in raplaserver.xconf
under storage-service and facade.

3) IMPORT: There are two commandline options that allow you import and export data from an to the data.xml.
(in webapp distribution you need to change to `webapp/WEB-INF`)

```
raplaserver.sh import
```
imports file from `source` (This is the file Operatator) into `dest` this is the sql operator.

```
raplaserver.sh export
```
exports file from `dest` (This is the sql Operatator) into `source` this is the file operator.

If the database is empty the import will be done automaticaly on the first start.
See the configuration entries of the operators in raplaserver.xconf for more infos.




---

[Postgresql-webapp-update]
## B) Postgres: ##

1) First you have to login as postgres user. Then you can create a new user with \\
```
createuser -P -d db_user 
password: your_pwd
```

2) Create a database with
```
createdb -E UNICODE -O db_user your_db_name
```
''(Note: We strongly recommend using UNICODE as encoding for your database. If your postgres-version doesn't support unicode you might try your local encoding e.g. LATIN\_1)''

3) On some systems (debian) you need to add the following lines to pg\_hda.conf.
```
host         your_db_name  db_user        127.0.0.1    255.0.0.0  password
```
and restart postres (there must be a tab character between each entry)

4) You can now test the connection with
```
psql -h localhost -U db_user your_db_name -W
```
Execute the postgres SQL Statement in your rapla download to create the table.
You will find the script in the webapp/WEB-INF folder
```
psql -h localhost -U db_user your_db_name -W < rapla-postgres.sql
```


5) Download the postgres driver from http://jdbc.postgresql.org/ and put it into your lib/server directory (WEB-INF/lib in the webapp distribution).

6) Now you need to change the database settings in raplaserver.xconf\\
```
  <db-storage id="sql">
    <driver>org.postgresql.Driver</driver>
    <url>jdbc:postgresql://localhost/your_db_name</url>
    <user>db_user</user>
    <password>your_pwd</password>
  </db-storage>
```

7) Change the store from file to sql (see HSQLDB)
```
    <store>sql</store>
```

8) initialization and import (see HSQLDB)



---

## C) Mysql: ##

Had no time to test this, but it should work with the above description and some minor modfications.

EDIT : I have test with EasyPHP (create Database), Navicat MySQL (for Grant) and Eclipse. All is ok !

1) Use the mysql client and connect to the mysql database.

2) Create new database with
```
CREATE DATABASE your_db_name;
```

3) Create user with
```
GRANT ALL PRIVILEGES ON your_db_name.* TO db_user@localhost IDENTIFIED BY 'your_pwd';
GRANT ALL PRIVILEGES ON your_db_name.* TO db_user@127.0.0.1 IDENTIFIED BY 'your_pwd';
```
If rapla server is running from a different host add the ip adress or the name of the host.

4) Execute the rapla-mysql.sql to create the new tables. You will find the script in the webapp/WEB-INF folder

5) Download the driver from http://dev.mysql.com/downloads/connector/j/ and
and put it into your lib/server directory (WEB-INF/lib in the webapp distribution).

6) Change settings in raplaserver.xconf to
```
  <db-storage id="sql">
    <driver>org.gjt.mm.mysql.Driver</driver>
    <url>jdbc:mysql://localhost/your_db_name</url>
    <user>db_user</user>
    <password>your_pwd</password>
  </db-storage>
```

7) Change the store from file to sql (see HSQLDB)
```
    <store>sql</store>
```

8) initialization and import (see HSQLDB)