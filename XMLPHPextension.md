# XML Export Plugin + PHP extension #

## Introduction - Please read first ##

### Who could care about this ? ###

  * If you want to fetch reservations in xml format, with all resources & attributes. The Xml export plugin permits you to fetch (over http) all the "blocks" between two dates given as parameters in the url, in xml format.
  * If you need specific print results, sorted in different ways (not released yet). This is done with a php development.
  * AND you don't use the default xml storage engine, but a sql one (only tested with mysql)

### What is this about ? ###

  * First part is a plugin to rapla. It offers a specific url to your rapla server which takes some arguments (start & end) and produces an xml file
  * Second part is a standalone php project which :
    * fetches the xml file and stores it in database
    * connects to rapla's database
    * brings up some web forms asking the user what he wants to print

### Requirements ###
  * SQL Storage engine as rapla's backend
  * Apache & PHP5 with simplexml extension (this one fetches the xml file)
  * Smarty template engine
  * PEAR DB module for the database connexion

## Setup ##

The XML Export plugin is available as a seperate plugin under,
http://code.google.com/p/rapla/source/browse/#svn%2Fplugins%2Fxmlexport_plugin%2Ftrunk

checkout and build the plugin jar and drop it into the WEB-INF/lib/ folder and webclient folder then you can activate it in the admin plugin menu