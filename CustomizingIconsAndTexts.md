Rapla already allows modification of resource-, person- and reservationtypes
at runtime, but sometimes you need more customization.

If any icon or text displayed in rapla doesn't fit into your context, you can simply replace it.
This document explain how.
First you will need the source-distribution, because this is a compile-time customization.

## WHAT you should not do: ##

You should NOT change `src/org/rapla/RaplaResources.xml` or the generated properties files:
`org/rapla/RaplaResources.properties`
`org/rapla/RaplaResources_de.properties`
....

If you change them and download a newer version of rapla, you will have to apply the same changes
again and again  ...

Which could be quite a mess, because the Resource File is quite large and you need to track all your changes in a separate file. You could patch and diff but that could lead to merging-conflicts as well.

Exception: You found a typo,a better explanation, a candier icon or any
other change you want to contribute back to Rapla. Patches for the resource-files are always welcome.
Please send them to our [developers-list|http://lists.sourceforge.net/lists/listinfo/rapla-developers].


## What you can do: ##

Create a new resource-file and set Rapla Resources as parent. Example:

```
FILE: src/org/rapla/MyResources.xml

<?xml version="1.0" encoding="utf-8"?><!--*- coding: utf-8 -*-->
<!DOCTYPE resources SYSTEM "components/xmlbundle/resources.dtd">
<resources default="en" parent="org.rapla.RaplaResources">
  <entry key="icon.calendarUC">
    <icon src="gui/images/refresh.png"/>
  </entry>
  <entry key="license.text">
    <text lang="en"><strong>You're welcome</strong> <br/>Rapla version @doc.version@</text>
  </entry>
</resources>
```

This resource file overwrites the entries of its parent.
See also [TranslatingRapla](TranslatingRapla.md).

The big calender-icon will be replaced by the refresh-icon (I know this doesn't make sense) and the small license-info on the login dialog will be replaced by your own text.

To include My Resources you need to [Rebuild](Rebuild.md) and add the following entry in
rapla.xconf..
```
<rapla-config>
   <default-bundle>org.rapla.MyResources</default-bundle>
...
```

that's it!!!

Warning: Most plugins use the main resource file. You will override those values as well.