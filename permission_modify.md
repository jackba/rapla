# Introduction #

Sometimes you want your reservations editable for a group of users without granting admin rights.

With the permission\_modifiy attribute you can set for each event a group of users which is allowed to modify it.

# How to enable #

  * Open the reservation type of your choice in the eventtype-editor (right click on the event-type in the left tree, when admin)
  * Add a new attribute with the key permission\_modify .
  * Make the attribute an category atrribute.
  * Select the users-category as root type. Alternativly you can create a subcategory containing all the user groups you want to be selectable as event editors.
  * Choose a group as default-value. Users who belong to this group can  edit the event. (if not changed by the user who creates an event)
  * If you don't want the user who creates the event to change the group, mark the attribute invisible.
  * Save the reservation type.
  * To grant editing rights to the users assign them to the appropriate user-groups or the default-group.

# How to use #

  * When creating a new event the user can now change the group that can modify the event. If the admin selected not\_visible the default group is used.
  * Add and remove users to the user groups to reassing permissions to edit.

# Example data.xml #

I added an example [data.xml](http://rapla.googlecode.com/issues/attachment?aid=840005000&name=data.xml&token=XEPt7QByElB759yJRrjo6y8Txp0%3A1380277457627)

  1. Added a group with the name can-edit-events-from-others
  1. Added a user test and put him into the group
  1. Editet default reservation-type, added permission\_modify as attribute type category with root usergroups and default can-edit-events-from-others
  1. Created a new event with admin
  1. Logged on as test
  1. Switched of only\_own\_reservations
  1. editet test event