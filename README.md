# StudyBuddy - Zuck's Children

<img width="700" alt="Screen Shot 2022-12-05 at 9 14 02 AM" src="https://user-images.githubusercontent.com/107783734/205658383-b9125772-ad0b-4a77-af51-cc5c33721888.png">

StudyBuddy is a networking app - but for studying purposes. This program allows students on the UofT campus to find and connect with peers to study together. By creating an account and specifying personal and preferred information for studying such as study spots, academic programs, and studying styles, users are recommended with other users with similar preferences to study with. Users are prompted with potential matches and can reject or deny them using a swiper algorithm. Users can also chat with matched buddies!

## Specification
The technology used is Java.

Challenge's faced include testing and deserialization with chat data.

Features we hope to implement in the future include more ways to personalize 
a user's profile, group chats and a map.

## Core Features

### Authorization
It is the first page the user will face when the program runs.\
The user can register a new account with a username and a password or sign in with existing account.\
When an account is authorized, the window will be closed and open the main window.

### Swiper - Matching
<img width="1126" alt="Screen Shot 2022-12-08 at 9 56 36 PM" src="https://user-images.githubusercontent.com/102633707/206614412-78bbcf2c-348a-44e3-90e5-c848905ddd6e.png">

The user can see matched profiles and choose to accept or reject other students to be a StudyBuddy.\
The matching is produced by our matching algorithm based on information provided in a profile, for example, one's field of study.\
Once two users accept each other, the program creates a new chat room of the two users.



### Profile Customization
<img width="450" alt="Screen Shot 2022-12-05 at 9 25 42 AM" src="https://user-images.githubusercontent.com/107783734/205661179-9bb536c5-f109-4896-b1e5-a2642d75d728.png">
The users can customize their profile including a pronoun, a year of study, a program, and study style.
The profile is used in the matching algorithm to generate a possible matches for our program's one of the most important feature.

#### Builder Design Pattern
Before, the profile feature utilized a ProfileBuilder class to construct new Profile entity objects. The original intent was to avoid passing a long parameter list into a Profile constructor, as the Profile entity has numerous attributes that need to be set independently. Yet, the design pattern ultimately was not implemented because it is not certain what and how many fields the user will make changes to on the ProfileUI with every save. Therefore, inputs in all editable fields should always be passed in as a ProfileInModel. In the future, when section edits are developed and only a defined portion of the fields are modified, for example, a builder pattern will be practical.

### Chat
The Chat feature implements the general chatting system of a software. It has a list of chat room and the user can open a chat room
to make a chat with other users.

### Study Spot
As a part of that chat room functionality, the program uses the algorithm to make three recommendations of study spot in a chat room. It takes account preference of both users in a room.

### Notification
<img width="450" alt="Screen Shot 2022-12-05 at 9 26 02 AM" src="https://user-images.githubusercontent.com/107783734/205661460-af741a56-517a-4c72-9927-7709a82ecb20.png">
When there is a new match or a new message, the program creates a notification to notify the user about a new update.

#### Clear Notification & Navigating to a chat room
Users are able to view all notifications and clear all notifications. Moreover, after selecting a message notification, you can open the corresponding chat room directly through the notification.

#### Testing

####Profile:
Testing for the profile feature was done on three levels, focusing on the UI, the use cases, and the entity. It achieved 100%, 98%, and 80% coverage for all classes, methods, and lines, respectively. It tests the connection between classes in the CA and makes sure input data is successfully stored into the UserDatabase and presented back to the user.

####Swiper:
Testing for the Swiper consisted of checking for different combinations. This included the situation if the current user accepted a potential user but the potential user either did not accept them yet or rejected them, the situation where the current user accepted a potential user and they also accepted them beforehand. The tests checked for proper outputs and they all passed. These particular tests were repeated through the interactor, through the controller and through the UI with different number of accounts. The UI tests also consisted of pressing each button (or at least creating a fake button press), to see if the list of matches for each account was modified correctly (as I cannot access the output from the UI directly). In the end, coverage was 100% for all classes, methods and even lines!


## About Us
Group Members:
  - Lance Madarang - https://github.com/lancenigel
  - Xi Wang - https://github.com/XiWang16
  - Kenji Tan - https://github.com/tankenji
  - Karen Riani - https://github.com/karenrni
  - Nina Huang - https://github.com/nina-huangg
  - Sanzhar Shamshiyev - https://github.com/SanzSS
  - John Lee - https://github.com/SiruLee
