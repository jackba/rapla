Here's a summary of the most important changes:

## User changes: ##

  * multi edit of resources, users and reservations (in tableview)
  * undo for most user actions and for the reservation edit window
  * experimental ical import
  * multiple categories selectable for one attribute
  * structured conflict tree (ordered by resources and time)
  * for a more detailed list look int the [changelog](http://code.google.com/p/rapla/issues/list?can=1&q=Milestone%3D1.7++status%3AFixed)

## Admin changes: ##


  * Rapla comes in a war. That means its easy to deploy and upgrade in a web container. That also means the data shouldn't be stored in the WEB-INF directory any more. It would be deleted by the next update. Data configuration is now done in the container via jndi. Look into contexts/rapla.xml for the jetty configuration.
  * raplaserver.xconf is inside the war and shouldn't be toched by the admin. All configuration should be done in contexts/rapla.xml
  * Logging is done via logback. All logging including jetty and ical4j will be done under the logs folder in the main distribution folder. The configuration file resides in resources/logback.xml
  * If you use mysql, postgres or hsqldb you don't need to create the database schema, you just need to create a database (not necessary with hsqldb) and rapla will create or upgrade the tables. We recommend exporting the data before upgrading to 1.7 . Drop the database and let Rapla create a fresh database, because some table types have changed to support large data sets. The database layer in Rapla will be tested against mysql, postgres and hsqldb for each release. Other databases will not be officialy supported by the rapla team unless someone volunteers todo so.

## Developer changes: ##

  * Use the org.rapla.bootstrap classes to start rapla in eclipse (replacment of the Main classes)
  * `Resource*.xml` files are now converted to propreties files instead of `Resource*.class` files
  * All server classes reside in server folders. In addition servletpages and the file and db storages are also server only classes. This allows for a better separation between client and server and compiler support to avoid usage of server code on client. Rapla builds to jars rapla.jar with all classes for the server and rapla-client.jar for the webclients.
  * The standalone mode now uses an embedded server (without ports)  as backend. This allows the use of webservice calls to the server (like the IcalExport2file), which were only available in client mode before. It also minimizes the differences when testing standalone and client mode.
  * [ServerInstallation](ServerInstallation.md) and [DatabaseInstallation](DatabaseInstallation.md) are also updated to reflect all the changes so take a look.

#### The Plugin api has changed significantly: ####

  * The old avalon classes are removed and replaced by type safe constructs.
  * All string roles have been replaced by TypedComponentRoles for extensions or typed classes for services.
  * Lookup hints are removed. All Information is provided via TypedComponentRoles
  * All ExtensionPoints should be configured in the provideService Method of the plugin, no lookup required to add extension points.
  * Client and Server Plugins are seperated: You no longer need to query, if the plugin is invoked on the client or server. ServerPlugins will use the configuration of the ClientPlugins.

#### A plugin build is available via build.xml: ####

if you specify the following to options in build.properties
```
plugin.base=${main.dir}/..
plugin.includes=*_plugin
```
build.xml in the rapla folder will look for the plugin base directory (the parent folder of Rapla) and include all folders matching the pattern `*_plugin` into the build and deploy process. If you only want specific plugins you can enter them with comma
```
plugin.includes=demo_plugin,occupationview_plugin
```

The [Javadoc](http://rapla.googlecode.com/svn/trunk/javadoc/index.html), [DevelopersGuide](DevelopersGuide.md) are also updated to reflect all the changes so take a look.