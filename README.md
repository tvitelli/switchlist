Switchlist Application
by Tim Vitelli

Model railroading is a hobby of mine.
Many model railroaders enjoy role playing as engineer and conductor, operating trains around model railroad layouts they have built.
This often involves handling actual paper waybills and paper car cards, or paper switch lists.
With smartphones, this could be replaced with a web application.

User Stories
As a user, I would like to enter my track locations in the app 
so they match the locations on my model railroad layout.
As a user, I would like to enter data on each piece of equipment I use on my train layout 
so I can track it with the app.
As a user, I would like to store the location of each piece of equipment on the model train layout 
so I know it’s location.
As a user, I would like to be able to change the locations of the equipment 
so I can track them as I switch them from industries and yards on my layout.
As a user, I would like to have a secure logon screen 
so I can limit who can access the data and change it.

Technical challenges and resolutions
Finding detailed documentation for Bootstrap and Thymeleaf variables/fields that I needed
to customize my application.  Once I found the documentation, I could customize fields to add 
validation for cleaner data entry on the front end.
Figuring out the RegExp code to verify my Reporting Marks field and injecting it as a 
verification step in my Create page.
Originally the user could delete a Track object that an Equipment object was tied to, 
resulting in a database error.  This was resolved with custom queries to validate whether the Track 
object was being used, and sending the user an error screen and redirect to delete the 
data reference in Equipment before executing the Track delete.