A user can subscribe for one or more resource. When someone creates, modifies or delete a booking for that resource(s) the user will get an email with the description of the change. (The user can turn of mails for modifications she/he made by her/him-self).

## Installation ##

  * Enable the mail plugin in the admin menu and enter your mail server and port.
  * If you want to test the settings, than you need to enter an email in your user account.
  * Enable the notification plugin.
  * Restart the server
  * You can now go to the options menu and register yourself for a notification on a resource change.
  * If you make a reservation for this resource, a mail should be send to the email-address of every user who registered for notification on this resource (You can edit the email address in when editing a user)

## Example Configs for googlemail ##

  * Mailserver: smtp.gmail.com
  * UseSSl: checked
  * Mailport: 465
  * Username/Password: Your googlemail/username/password