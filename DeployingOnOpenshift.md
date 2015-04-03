# Introduction #

Openshift is a cloud platform from redhat. It offers a limited cloud service for free.

https://www.openshift.com/


# Details #

There is a github project for easy installation.

  1. Go to openshift and registered as new user
  1. create a new domain (I used rapla, so you have to use another one :-) )
  1. create a new application on tomcat7 (I named it rapla, so it will be available as rapla-rapla)
  1. add https://github.com/rapla/rapla-openshift.git as git source
  1. add mysql 5.5 cartridge and phpmysql admin cartridges
  1. install the rhc client tools and install git client. You don't need the client tools and git installed, you can also use putty. See https://developers.openshift.com/en/managing-remote-connection.html for more information.
  1. ssh to openshift via  putty or
```
rhc ssh YOUR_APPLICATION_NAME (in my case rapla)
```
  1. Install the mysql driver oh the server via the ssh shell
```
wget https://repo1.maven.org/maven2/mysql/mysql-connector-java/5.1.34/mysql-connector-java-5.1.34.jar -O app-root/data/mysql.jar
```
  1. Configure git for update replace rapla.git with YOUR\_APPLICATION\_NAME.git
```
git --git-dir git/rapla.git config remote.origin.fetch 'refs/heads/*:refs/heads/*'
```
  1. redeploy the application via web interface or in the ssh shell
```
ctl_app deploy HEAD
```
and voila rapla is in the cloud:

http://rapla-rapla.rhcloud.com/

## Updating the rapla version ##

  1. ssh to openshift via  putty or
```
rhc ssh YOUR_APPLICATION_NAME (in my case rapla)
```
  1. If not done via initial setup set git config (replace rapla.git with YOUR\_APPLICATION\_NAME.git)
```
git --git-dir git/rapla.git config remote.origin.fetch 'refs/heads/*:refs/heads/*'
```
  1. Sync with github original
```
git --git-dir git/rapla.git fetch origin
```
  1. Restart and Redeploy from HEAD
```
ctl_app deploy HEAD
```