# Week6WeekendVarietyApplication
This application is mainly for implementing and showing a variety of Android components including: a splash screen, a PDF viewer, a dialog fragment, three Alert Dialogs each with a default layout, custom layout and a list of option to select from, the usage of the Notification Manager and Pending Intents, the SmsManager class, and the Timerclass with a TimerTask.

## Splash Activity
This activity shows a picture in the background as it starts the Main Activity.

<img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot0.png?raw=true" width=300>

## Main Activity
This activity is home to a single red button that when pressed, brings up an Alert Dialog with multiple choices that activates different features of the application.

<img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot1.png?raw=true" width=300>

## Option List Dialog
This Alert Dialog has 5 options to choose from: 
- PDF Viewer which starts a new activity that hold a PDF viewer that displays a PDF file in internal memory
- Dialog Fragment which creates the Double Confirmation Dialog before bringing up the Image Dialog Fragment
- Send SMS which brings up an AlertDialog with a custom view that asks for the permission to send SMS messages, then sends an SMS message
- Timer which starts the Timer Activity
- Send Notificaiton which sends out a notification.

<img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot2.png?raw=true" width=300>

## Double Confirmation Dialog
This dialog takes in a boolean as a parameter. It is initally launched with the boolean set to False, and asks for confirmation. If yes is selected, it relaunches itself with the boolean set to true which changes the title and message of the dialog to make sure the user is sure before launching the Image Dialog Fragment.

<img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot3.png?raw=true" width=250> <img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot4.png?raw=true" width=250>

## Image Dialog Fragment
This Dialog Fragment displays a picture in a Dialog with an ImageView then dismisses itself after 3 seconds.

<img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot5.png?raw=true" width=300>

## Sms Dialog
This Dialog contains 2 EditTexts and 1 Button. The first EditText only takes in numbers to a maximum length of 10 to represent the phone number to send the SMS message to. The second EditText is the message to be sent. When the Send Button is pressed, the dialog creates an SmsManager and uses the sendTextMessage() method to send the message to the given number. A toast is used to display whether the text was successfully sent or not.

<img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot6.png?raw=true" width=250> <img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot7.png?raw=true" width=250> <img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot8.png?raw=true" width=250> <img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot13.png?raw=true" width=250>

## PdfViewer Activity
This activity uses a 3rd Party Library to create a PDF View. The PDF is loaded in from the assets folder of the project and displayed. 

<img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot9.png?raw=true" width=300>

## Timer Activity
This activity holds 2 FrameLayouts to host 2 Fragments. The first fragment, TimerDisplayFragment, holds a TextView to display a variables that are incremented as the Timer class is running. The second fragment, TimerButtonsFragment, holds 3 Buttons that control the running of the Timer class; they allow the user to Start and Stop the Timer, as well as Reset the values in the TextView. The values in the TextView and the functionality of the Buttons are handled by the TimerViewModel. The view model uses the Timer class to schedule a TimerTask that increments a variable every 100 ms. This variable representing the seconds and another variable respresenting the minutes are used to update a String variable that is bound to the TextView in the TimerDisplayFragment.

<img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot10.png?raw=true" width=250> <img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot11.png?raw=true" width=250>

## Notification
The NotificationManager is used to send out notifications. Notifications are created with a specific channel and sent to the appropriate channel in devices with API 26 or higher. In devices with API 25 or lower, a notificaiton without a channel is created and simply sent out. A PendingIntent is attached to the notification which opens up the PdfViewer Activity when selected.

<img src= "https://github.com/josecatalasan/Week6WeekendVarietyApplication/blob/master/screenshot12.png?raw=true" width=300>
