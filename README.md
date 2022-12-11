# StudyBuddy App - Zuck's Children

StudyBuddy is a networking app - but for studying purposes. This program allows students on the UTSG campus to find and connect with peers to study together. By creating an account and specifying personal and preferred information for studying such as study spots, academic programs, and studying styles, users are recommended with other users with similar preferences to study with. Users are prompted with potential matches and can reject or deny them using a swiper algorithm. Users can also chat with matched buddies!

#### IMPORTANT:
When running the program, never quit the program with command Q, only close it with the red button on the top left corner. Otherwise your data will not save!

## Specification
The technology used is Java.

Challenge's faced include testing and deserialization with chat data.

Features we hope to implement in the future include more ways to personalize 
a user's profile, group chats and a map.

## Core Features

To use this program, please run StudyBuddyApp.java in src.main.java.main_app! If you would like to access the program while on a different device, you will have to keep the same userDatabase.txt file from your original session(s) in order to see the accounts you created from your original device(s), which could mean comitting to the repo, or copy pasting the file.

### Login and Account Creation
<img width="700" alt="Screen Shot 2022-12-05 at 9 14 02 AM" src="https://user-images.githubusercontent.com/107783734/205658383-b9125772-ad0b-4a77-af51-cc5c33721888.png">

It is the first page the user will face when the program runs.\
The user can register a new account with a username and a password or sign in with an existing account.\
The user cannot create an account with an already registered username. The user cannot create an account with any empty parameters.\
The user can only login to a registered account with the correct password.\
When an account is authorized, the login window will be closed and the main navigation window will be opened.

### Swiper - Matching
<img width="1124" alt="Screen Shot 2022-12-08 at 10 56 25 PM" src="https://user-images.githubusercontent.com/102633707/206620784-77b6ec50-6d5e-4170-952b-4efa8ce4500d.png">

The user can see matched profiles and choose to accept or reject other students to be a StudyBuddy.\
The matching is produced by our matching algorithm based on information provided in a profile, for example, one's field of study.\
Once two users accept each other, the program creates a new chat room for the two users and sends a notification to both that they have matched.

### Profile Customization
<img width="450" alt="Screen Shot 2022-12-05 at 9 25 42 AM" src="https://user-images.githubusercontent.com/107783734/205661179-9bb536c5-f109-4896-b1e5-a2642d75d728.png">
The users can customize their personal information, including their name, pronouns, year in university, field of study, study styles, and preferences for their ideal study buddy and study spots.
Information on the profile is used by the matching algorithm for match-making, one of our program's most important features.

### Chat and Study Spot 

<img width="1163" alt="Screen Shot 2022-12-08 at 11 54 18 PM" src="https://user-images.githubusercontent.com/102633707/206627220-c5d42512-f83f-4f7d-94b1-0d7c82d463ae.png">

The Chat feature implements the general chatting system of a software. It has a list of chat room and the user can open a chat room
to make a chat with other users. As a part of that chat room functionality, the program uses the algorithm to make three recommendations of study spot in a chat room. It takes account preference of both users in a room.

### Notification
<img width="450" alt="Screen Shot 2022-12-05 at 9 26 02 AM" src="https://user-images.githubusercontent.com/107783734/205661460-af741a56-517a-4c72-9927-7709a82ecb20.png">
When there is a new match or a new message, the program creates a notification to notify the user about a new update.

#### Clear Notification & Navigating to a chat room
Users are able to view all notifications and clear all notifications. Moreover, after selecting a message notification, you can open the corresponding chat room directly through the notification.

#### Design Patterns:

#### Builder
Before, the profile feature utilized a ProfileBuilder class to construct new Profile entity objects. The original intent was to avoid passing a long parameter list into a Profile constructor, as the Profile entity has numerous attributes that need to be set independently. Yet, the design pattern ultimately was not implemented because it is not certain what and how many fields the user will make changes to on the ProfileUI with every save. Therefore, inputs in all editable fields should always be passed in as a ProfileInModel. In the future, when section edits are developed and only a defined portion of the fields are modified, for example, a builder pattern will be practical.

#### Singleton
Upon Hafsa's suggestion after Milestone 4, it was decided that implementing the singleton design pattern for the UserDatabase class was most appropriate. This is because the user database should necessarily be a single instance as there should only ever be one user database in usage as the program is running. In this way, to access any of the attributes associated with the user database, one would simply have to access the getter and setter methods and call them on the singleton instance. Getting the instance is also streamlined so that it only returns that one instance but if it doesn’t already exist, it will create the first singular instance for the running of the program. That instance is the one that will be returned each subsequent time the getUserDatabase() method is called.

#### Strategy
A strategy design pattern was initially considered to be used for the matching algorithm as more ways to determine how matching is done may be implemented in the future. This was ultimately not implemented as a key part of the strategy design pattern is that the client determines the way algorithm is run. As of now, the algorithm will always check year of study, field of study and study styles of all other users and compare them to the current client's preferences. In the future a strategy design pattern may be considered if matching is decided to be client side (for instance, a client can choose to match with other user's based on just year of study or field of study.

#### Testing:

As a note, the autograder never finishes grading because there are tests for UIs, which require clicking buttons to move on, so the autograder is just stuck. Overall, all the tests pass!

Test Coverage: 91% for classes, 86% for methods and 80% for lines (some were not tested for reasons listed below)

#### Login & Account Creation (+ UserDatabase):
Testing on the login and account creation follows the flow of the natural clean architecture. I create the controllers, their usecases, and inmodels and pass them in to recreate what would be done in the actionPerformed section of the loginUI. Note that testing the UI directly was not possible due how it requires the action of the button being clicked for either login or register account. Perhaps there is a way to test the UI with the use of a button but upon researching so far, there does not seem to be a feasible method to do so, hence this is raised as a future issue for further improvements in testing. However, the test cases cover all the classes and their methods in both creating a new account and logging into the account. There is just one method that is not covered in account_creation.account which is getBuddies() as that is called by the chatList use case elsewhere and is not under the purview of logging in or account creation. Apart from that, there is 100% coverage of these two usecases. Furthermore, UserDatabase is also covered because of its widespread use in getter and setter methods during the register and login use cases.

#### Profile:
Testing for the profile feature was done on three levels, focusing on the UI, the use cases, and the entity. It achieved 100%, 98%, and 80% coverage for all classes, methods, and lines, respectively. It tests the connection between classes in the CA and makes sure input data is successfully stored into the UserDatabase and presented back to the user. Some methods in the ProfileUI- like the actionPerformed method- are not tested because they rely on actual user input.

#### Swiper:
Testing for the Swiper consisted of checking for different combinations. This included the situation if the current user accepted a potential user but the potential user either did not accept them yet or rejected them, the situation where the current user accepted a potential user and they also accepted them beforehand. The tests checked for proper outputs and they all passed. These particular tests were repeated through the interactor, through the controller and through the UI with different number of accounts. The UI tests also consisted of pressing each button (or at least creating a fake button press), to see if the list of matches for each account was modified correctly (as I cannot access the output from the UI directly). In the end, coverage was 100% for all classes, methods and even lines!

#### Matching:
Testing for the matching algorithm consisted of checking for actual matching, if users were properly assigned scores and whether all other users (not including the current user) were correctly returned and if all final matchers were properly returned. It achieved 100%, 100%, 100% coverage for all classes, methods, and lines, respectively. It tests the connection between the user database and makes sure all other users are assigned a score based on the current user's preferences and the other users' study styles.

#### Chat:
Testing for the chat utility covers ChatDataAccess, opening a chat room, and sending a message. ChatDataAccess is tested on adding a chat room, and loading a chat room by a room id and an account. Moreover, the interactors are tested for opening a chat room and sending a message.

#### Study Spots
Testing the study spot feature focused on checking the correctness given different users' study spot preferences. It covers the 3 possible cases in generating a recommendation list, the first being if both users have the same study spot preferences, then if they have some overlap between their preferences and lastly, if the users selected N/A 3 or more times. However, certain classes and methods are not specifically covered in the study spot use case test as it prevents testing the recommendation itself. This is due to the lack of returns that can be tested, such as comparing values with assertions, if the certain classes and methods are included (See issue https://github.com/CSC207-2022F-UofT/course-project-zuck-s-children/issues/145).

## About Us
Group Members:
  - Lance Madarang - https://github.com/lancenigel
  - Xi Wang - https://github.com/XiWang16
  - Kenji Tan - https://github.com/tankenji
  - Karen Riani - https://github.com/karenrni
  - Nina Huang - https://github.com/nina-huangg
  - Sanzhar Shamshiyev - https://github.com/SanzSS
  - John Lee - https://github.com/SiruLee
