# Project 3 - Instagram

Instagram is a photo sharing app using Parse as its backend.

Time spent: 13 hours spent in total

## User Stories

The following **required** functionality is completed:

- [X] User sees app icon in home screen.
- [X] User can sign up to create a new account using Parse authentication
- [X] User can log in and log out of his or her account
- [X] The current signed in user is persisted across app restarts
- [X] User can take a photo, add a caption, and post it to "Instagram"
- [X] User can view the last 20 posts submitted to "Instagram"
- [X] User can pull to refresh the last 20 posts submitted to "Instagram"
- [X] User can tap a post to view post details, including timestamp and caption.

The following **stretch** features are implemented:

- [X] Style the login page to look like the real Instagram login page.
- [X] Create a custom Camera View on your phone.
- [X] Run your app on your phone and use the camera to take the photo
- [X] User should switch between different tabs - viewing all posts (feed view), capture (camera and photo gallery view) and profile tabs (posts made) using a Bottom Navigation View.
- [X] After the user submits a new post, show an indeterminate progress bar while the post is being uploaded to Parse
- [X] User can load more posts once he or she reaches the bottom of the feed using endless scrolling.
- [ ] Style the feed to look like the real Instagram feed.
- [ ] Show the username and creation time for each post
- User Profiles:
  - [ ] Allow the logged in user to add a profile photo
  - [ ] Display the profile photo with each post
- [ ] User can comment on a post and see all comments for each post in the post details screen.
- [ ] User can like a post and see number of likes for each post in the post details screen.


The following **additional** features are implemented:

- [X] User's profile page shows a grid view of the user's posts 

Please list two areas of the assignment you'd like to **discuss further with your peers** during the next class (examples include better ways to implement something, how to extend your app in certain ways, etc):

1. The tapping of an image/post that will lead to another activity to see timestamp, stops

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src='https://github.com/bemedel/codepath-Instagram/blob/master/insta-gif.gif' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Credits

List an 3rd party libraries, icons, graphics, or other assets you used in your app.

- [Android Async Http Client](http://loopj.com/android-async-http/) - networking library


## Notes

Parse and Fragment were a tough topic for me to learn in less time than my other projects i.e Flicks, twitter. There were many times a change would make my working app crash.

## License

    Copyright [2019]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
