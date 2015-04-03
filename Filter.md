With a filter you can determine, which event, resources or persons should be visible.

## resource and person filter ##

A click on the "Filter"-Button over the resourcelist shows the following dialog:

![https://rapla.googlecode.com/svn/wiki/files/filter.png](https://rapla.googlecode.com/svn/wiki/files/filter.png)

> ''This filter shows only rooms of type bar with more than  seats and lecturers with a forename that contains "Hom"''

By default, all resourcetypes are checked, which stands for: Every resource is shown and noone is filtered out. You have two possibilities to further constraint the view:
  * With the checkboxes you can mark, which resource-types should pass through the filter. All unchecked types are filtered out and thus all resources belonging to that type are not displayed in the list anymore.
  * The resources belonging to a checked resource-types can be further constrained by rules. All resources of a resource-type, that don't match the rules specified right to their resource-type are hidden (They don't pass the filter).

Note: if the resource-type is checked, but there is no matching resource, then the resource-type won't show up in the list

You can create special constraints for each resource-type with the button **"new rule for"**.
Choose an attribute from the list for which you want to set the constraints. Thereupon a new filterrule
will be created. The rules differ deppending on the attribute-type:

  * If the attribute is a number, you can select between **"larger than"**, **"equals"** and **"smaller than"**.
  * If the attribute is a text, you can specify a string that should be contained.
  * If the attribute is a category, a list or a tree (if there are sub-categories) will be displayed. The filter will match the selected category and all subcategories. In the example above the selected category for the attribute room-type is bar.

If you press on **"new rule for"** again and choose another attribut, the two constraints will
be combined with **"AND"**, that means only resources that match both constraints pass the filter.

If you choose the same attribute twice, both constraint will be combined with
**"OR"**: Ressources will path the filter, if at least one of the constraints is matched,


A click on **"apply"** applies your settings to the list visible in the background, but the filter-dialog will  stay visible, so you can further adjust the filter.

A click on **"OK"** applies the settings and closes the Dialog.
**"Save"**saves the settings for future sessions.


## event filters ##

Click on the filter box above the calendar to show the event filter box.
The functionality is the same as with resource-types but this time for the events that are displayed in the calendar. Events that don't match the filter are grayed out. If you don't want to see the events that are filtered change the option "events not matched by filter" under edit/settings/calenendar

You can additionaly choose in the menu under "view/only own reservations", if you only want to see your events or the events from all other users.