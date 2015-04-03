# Experimental LDAP Authentication support #

It is possible to authenticate your users against an LDAP database instead the internal rapla-users.

## Example Mapping ##

Assuming you have your users stored in a LDAP Database in the following format.
```
# Define a user entry for Janet Jones
dn: uid=jjones,dc=example,dc=com
objectClass: inetOrgPerson
uid: jjones
sn: jones
cn: janet jones
mail: j.jones@example.com
userPassword: secret
```

you need to add the following configuration entry in plugin options, assuming a LDAP-Server is running on the same host ({{localhost}}) and the connection-password is {{secret}}.
Go to the admin/preferences/plugin and enable the LDAP Plugin with the following entries:

```
connectionName:     uid=admin,ou=system
connectionPassword: secret
connectionURL:      ldap://localhost:10389
userPassword:       userPassword
userMail:           mail
userCn:             cn
userSearch:         (uid={0})
userBase:           dc=mycompany,dc=com
```

For a full description see http://jakarta.apache.org/tomcat/tomcat-4.1-doc/realm-howto.html#JNDIRealm

You can test the connection by pressing the "test access" button. You will be prompted for a login. Please enter the login information of a user that is in the LDAP directory and should be able to login into Rapla. If the test succeeds you can enable the plugin and restart Rapla.

## Test Installation ##

The LDAP Authentication has been tested with
[Apache Directory](http://directory.apache.org/apacheds/)

You can test the the LDAP connection by downloading the

  * [Apache Directory LDAP Server](http://directory.apache.org/apacheds/)
  * [Apache Directory LDAP Client](http://directory.apache.org/studio/)

After installing start the ldap client and add the following connection

```
port: 10389
connectionName:     ou=system,uid=admin
password:           secret
```

the newer installations of apache directory server may not have a password at all.

Import the example user file [example.ldif](https://rapla.googlecode.com/svn/wiki/files/example.ldif)

Browse the imported users to find some famous scientists like aeinstein.

After the import you can switch to rapla and enable the plugin in rapla with has the defaults entries correctly set for the example.

Press test and enter:

```
user:               aeinstein
password:           secret
```


If you still have problems, maybe you find the informatation in the following ticket discussion helpful:

http://code.google.com/p/rapla/issues/detail?id=318