## What are dynamic types? ##

Different types of objects have different types of attributes: Notebooks, rooms and vehicles all have
their own characeristics; lectures have attributes different from meetings or conferences.
You can easily customize Rapla for your domain by creating or modifying
resource-, person- and event-types.

If you manage rooms, you can create a resource-type **"room"** and add attributes like
**"number of seets"**, **"department"**or **"has blackboard"**.

Or if you manage courses create an event type **"lecture"** with the attributes **"year"** and **"study course"**.

This types are called **"dynamic types"**, because you can create and change attributes on running Rapla-System.


## Example: Creating a resource-type **"room"** ##

Right click on the **"resources"** node in the left tree, select and click **"new resource-type"** and enter **"room"** in the 'typename' text field.

Now, add a new attribute with the name **"number of seats"** and type **"integer"** and save to create the resource-type.
To create new rooms, right-click and choose new **"room"** in the menu. You can now enter the **"name"** of the room and the **"number of seats"**

## Adding a category-attribute to the resource-type **"room"** ##

We now want to assing the rooms to the departments they belong to. We do this by adding an attribute of type **"category"**. But before that, we need to enter our department-categories in the [category-view|Categories]. Create a new category with the name **"departments"** and add three sub-categories **"Department A"**, **"Department B"** and **"Department C"**.

Save the categories and go back and edit the resource-type **"room"**. Add a third attribute with the name **"department"** and the type **"category"** and click on the **"root"** button. Now you can select the category that should be used as the root for this attribute. The sub-categories of the selected root represent all valid values for the attribute.

Choose **"departments"** as root and save the modified resource-type. Try to add a new room, you should be able to select a department for the room.

## Using attributes for filtering ##

The attributes of a dynamict type have mainly informational purpose but also can be used for [wiki:Filter filtering]:
```
Show me only the rooms in department A on the first floor.
```
or
```
Show me the foundation lectures and courses of the department of computer-science.
```