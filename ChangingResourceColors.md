Since Rapla 0.12.4 you can assign a specific color for each resource. Assigning colors for events works the same, just replace resource type with event type and resource with event in the following description. (In the Menu, choose Edit/
options/calendar/color and choose resources or event)

## Manually assigning a color resources to affiliate ressource's colo) ##

To do this, edit a resource type, e.g. the default-resource and add a new attribute of type string with the name color (or another meaningful name). Next switch to advanced settings and change the KEY from "a?" to "color". Since rapla 1.6 you can simply choose attribute "color" in the color chooser drop box below, which automaticaly creates the color for you.

Now save this type and you can assign the colors to all resources of the type default-resource.

Edit a resource and you will see a field with the name color.
Enter the RGB Hex value for the color the resource should have ( i.e. #A2A3FE)


If you want Rapla to choose a color, just leave the color field blank, but if you never liked the resource coloring of Rapla, simply set all resources to your favourite color (you can use the same color for all resources)

## Using categories to define colors ##

An alternative approach of assigning a color is to define a color for a category. Say you have an attribute room-types, that is connectected to a category room-types with the subcategories lecture, practice and others:

```
dynamic-type:   room
with attribute: room-type (Category-Attribute)
                    |
                    |
                    v
Category:      room-type
             /     |     \
       lecture practice others
          |        |      |
Color:  red     green    gray
```

To assign a color to each category we have to edit the category (and select "show settings for experienced users" for Rapla <1.7). Now we can assign the color for each category.

Last we have to rename the attribute-key of the room-type attribute to "color" (first you have to select "show settings for exp. "). Hopefully this last step will be obsolute in future Rapla versions.

Now we can change the color of a resource of the edited resource-type by selecting a category from a drop down box.