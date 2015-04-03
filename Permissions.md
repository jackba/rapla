Groups and permissions are available since rapla 0.11.

## Add a new groups ##

Add new sub-categories to "user-groups" to create new groups. You can also create hierarchical groups. Children will inherit the permissions from their parents. Assign the groups to users by editing the user-entry.


## Permissions ##

You can set permissions for each resource/person by editing it (right click when admin).
You can create n permissions for each resource/person.
A permission is always assigned to either a user or group.

You can also specify more then one permission per user or group, then if a user tries to get
access, all permissions will be checked and if one permission matches the access specified in this permission will be granted to the user: e.g. if one permission denies access for the user and another permission allows access, the user will get access.

There are different access-levels, you can define for each permission:

  * denied
  * can read
  * can allocate
  * can allocate and create conflicts
  * administrator rights

Choose ''denied'' to prevent the listing of the resource/person in the left selection list of the users and ''read'' to disallow booking of this resource/person to the affected users.

If you choose ''can allocate'' or ''can allocate and create conflicts'' it is possible to
specify absolute or relative booking-timeframes for the selected resource. You can, for example, prevent modifing appointments in the past, by setting the relative start-time to 0.

If you choose ''create conflicts'' all users that are matched by the permission, are allowed
to create conflicts for the resource.

### A complex example: ###

**"permission 1"**: group **"G"** can book until the end of the year, but has to book at least 3 days before the resource is needed.<br>
<b>"permission 2"</b>: user <b>"U"</b> belonging to G is allowed to create conflicts (but only for the next year)<br>
<br>
So user <b>"U"</b> can book in this year at least 3 days before the event, but isn't allowed to create a conflict. He can, however create a conflict for events in the next year.(enough time to resolve the conflict)<br>
<br>
<br>
<h2>Editing events</h2>

When a user creates or edits an event, the permissions for each resource he allocates<br>
are checked against the username and the groups the user was assigned to. Only one permission needs to be fullfilled to successfuly allocate a resource. A red "no-parking" sign will be visible left to the resource when the user isn't allowed to<br>
allocate it.<br>
<br>
When you edit an existing event, you aren't allowed to modifiy certain appointments or allocations that would violate any timeframe-constraints, e.g. you can't delete appointments in the past, if the relative start-time constraint is set to 0.<br>
<br>
<h2>Allowing multiple users to edit the same event</h2>

See the page <a href='permission_modify.md'>permission_modify</a>
<hr />
Note: you can edit rights in 'resources and persons' pane.<br>
Create or edit existing resource then in resource propeties edit proper rights to it.