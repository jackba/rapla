# The Html Calendar Installation: #

Requirements: You will need to have a client/server running.


You can export the calendar in rapla via the export button to html:

  * Select a week, filter, resources, reservation (as you like)
  * Click the `export` button
  * Select the html export checkbox.
  * enter a filename (Don't use any special characters or umlaute here)
  * You can enter a title or use the suggested title.
  * done.


The calendar will be available under

http://raplace_with_hostname:8051/rapla?page=calendar&user=replace_with_rapla_username&file=replace_with_your_filename

Note: If you want to the view always to display the current situation append `&today` at the end of to the link.

Note: You can change the colors and fonts with the default.css stylesheet.

Note: The language of the displayed HTML calendar is the language environment in which the rapla server is launched. So don't forget to set LANG and LC\_ALL to the correct values before running the server.