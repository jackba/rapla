Rapla joins the plugin hype. Version 1.0 comes with its own plugin API.
At the moment of writing there are 11 standard plugins in the Rapla-distribution
and we've developed some more specific for our university.

We introduced the plugin concept into Rapla, so that
other devoloper can extend Rapla for their needs
and have the possibility to share their extensions with other users
without breaking too much of the Rapla framework.

Most of the concept is "borrowed" from the Eclipse project,
they invested a lot in plugin research.

But lets get started in writing a Rapla plugin in Eclipse.

## Preparation: ##

### 1. Start eclipse and checkout the latest Rapla sources ###
  * see [BuildingRaplaWithEclipse](BuildingRaplaWithEclipse.md) and follow step 1-3

### 2. Checkout the My Rapla project ###
  * see http://code.google.com/p/rapla/source/checkout for instructions to checkout rapla. Goto the repository view and checkout the plugins/demo\_plugin/trunk folder.

### 3. Now run Rapla with My Rapla on the classpath ###
  * Rightclick on `org.rapla.bootstrap.RaplaStandaloneLoader` and select Run to Rapla without plugin and to create a run entry
  * now close Rapla right click again and select Run As/Run
  * Click on the classpath tab than add the demo\_plugin project to the User Entries
  * Click run to start Rapla with demo\_plugin on the classpath

### 4. Enable the plugin ###
  * go to file/adminstrator/preferences/plugins
  * Enable My Rapla plugin and restart Rapla (file/adminstrator/restart rapla)
  * Now the Plugin is active it adds 3 extensions to Rapla
    1. It adds an import functionality in the file menu
    1. It adds an info dialog in the help menu
    1. It adds an option dialog in the user preferences

## How does this work? ##

The entry point for the Plugin is `org.rapla.plugin.demo.MyPlugin`.
Rapla will discover and start the Plugin if its defined
in the file `generated-src/META-INF/rapla-plugin.list`

This file is automaticaly created by the build file in the demo\_plugin project.

The Plugin class must implement the
[PluginDescriptor Interface](http://rapla.googlecode.com/svn/trunk/javadoc/org/rapla/framework/PluginDescriptor.html)

When the Rapla system start it calls all `provideService` methods of all Plugin Descripors.

So this is the place where you tell Rapla what extension the plugin provides. Lets take a look at MyPlugin.java

```
public static final boolean ENABLE_BY_DEFAULT = false;
public static final TypedComponentRole<I18nBundle> RESOURCE_FILE = new TypedComponentRole<I18nBundle>(MyPlugin.class.getPackage().getName() + ".MyPluginResources");

public void provideServices(ClientServiceContainer container, Configuration config) {
  if ( !config.getAttributeAsBoolean("enabled", ENABLE_BY_DEFAULT) )
     return;

  container.addContainerProvidedComponent( RESOURCE_FILE, I18nBundleImpl.class,I18nBundleImpl.createConfig( RESOURCE_FILE.getId() ) );

  container.addContainerProvidedComponent( RaplaClientExtensionPoints.USER_OPTION_PANEL_EXTENSION, MyOption.class);

  container.addContainerProvidedComponent( RaplaClientExtensionPoints.EXPORT_MENU_EXTENSION_POINT, MyExportMenuExtension.class);

  container.addContainerProvidedComponent( RaplaClientExtensionPoints.HELP_MENU_EXTENSION_POINT, MyHelpMenuExtension.class);

}


```

The if condition at the beginnig of the provide Service method only adds the extensions if the plugin is enabled.

The first extension is a resource bundle extension, it adds translations for the demo plugin to the rapla system.

The second extension will add an option panel to the user preferences. The MyOption class will only be instanciated when the option dialog is called.

We also add the two menu entries: The help menu and the import menu.
Both will be initialized when the menubar is initalized.

That's it, basically.


## Now for writing your own plugin: ##

Now we want to develop our own view-extension.
For a more extensions see

[ClientExtensionPoints](http://rapla.googlecode.com/svn/trunk/javadoc/org/rapla/client/RaplaClientExtensionPoints.html)

[ServerExtensionPoints](http://rapla.googlecode.com/svn/trunk/javadoc/org/rapla/server/RaplaServerExtensionPoints.html)

[TableViewExtensionPoints](http://rapla.googlecode.com/svn/trunk/javadoc/org/rapla/plugin/tableview/TableViewExtensionPoints.html)