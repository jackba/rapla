# Conflict overview #
Conflicts arise whenever two meetings are scheduled for the same date or using the same resources (e.g. areas or computer, etc..). In the example here, two meetings want at the same time the test resource, which will not function naturally:

![https://rapla.googlecode.com/svn/wiki/files/conflicts.png](https://rapla.googlecode.com/svn/wiki/files/conflicts.png)

Note that the two conflicts shown here refer to the same resource/time. That is because the user that is logged in has administrator rights, and sees the conflicts from the perspective of all "conflict parties". A normal user would only see one line.

Right click on the conflict entry and choose edit to open an appropriate working dialog to change the event that cause the conflict. You can also resolve the conflict by dragging the event in the view.

You can prevent conflict creation explicitly by changing the [Permissions](Permissions.md) for the resources.


**Note:**Since version 0.10.2 only current conflicts shown, i.e. if at least one of the two dates involved ends after the current date.

**Note:** The number of conflicts is indicated directly under the conflict-Icon in the left-panel. If you see (0), you don't need to open the conflict overview, since it will be empty.