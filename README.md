# Milestone 1 - MindfulMind

## Table of Contents

1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)

## Overview

### Description

MindfulMind will allow users to have track and develop their mental health. They will be able to view mental health resources, choose among relaxing spotify playlist, read quotes, and input daily journal entries. 



### App Evaluation

[Evaluation of your app across the following attributes]
- **Category:** Wellness
- **Mobile:** Mindful mind is essential for people to track their mental health.They will get motivation from daily quotes, journaling, and access to mental health resources if the need arises.

- **Story:** Connects users with build a habit of daily motivation. Allows them to reflect on past days, develop a list of mantras, and a network of mental health organizations.


- **Market:** Young adults and adults can use this app to track and improve their mental health. 


- **Habit:** Mental health is a basic necessity. Users are likely to check the app daily to view quotes, write about their day, and listen to music that calms them down or inspires them daily. 


- **Scope:** V1 allow users to login to their account, view quotes, view a list of spotify playlists, add entries to their journal, and view a list of mental health resources. They will also be able to view and edit their profiles.  V2 allows the will be able to like and save their favorite quotes for later, and view more information about a specific quote, song or mental health resource. 


## Product Spec

### 1. User Features (Required and Optional)

## Required Features

- [x] **Use four Fragments**



- [x] **User can see quotes, notes,add notes, an about page and profile activity**

- [x] **User can input new notes using textviews**

- [x] **Use one of the Navigation UI Views (BottomNavigation, Drawer Layout, Top Bar) to navigate between fragments**

- [x] **Users' notes are stored in a database**

- [x] **Users can stay logged in after reopening app**

**Stretch Features**
- [ ] **User can see playlists, and mental health resources on a recyclerview**
- [ ] **Make requests to the spotify API, quotes API, and mental health resources API**
- [ ] **Users can login using facebook or google**
- [ ] **Users can save their favorite songs and quotes to a database**
- [ ] **Users can customize the recyclerview layout**
- [ ] **Users can view details about music, quotes and mental health resources**

### 2. Screen Archetypes

- **Login Screen**
  - User can input username and password to login to their account or be prompted to  signs up.
  
- **Stream screen** 
    
  - User can view a list of quotes
  - User can view a list of songs
  - User can view a list of previous journal entries
  - User can view a list of mental health resources

- **Profile Screen**
  - User can see their bio
  - User can monitor their mental health progress
  - display view the number of times they asked for help



- **Details Screen**
  - User can read the details of a selected song
  - User can view the  orgiin of a selected quote 
  - User can view their previous notes in full 
  - User can see more information about a mental health rresource

- **Creation Screen**
    - User can add a new journal entry

### 3. Navigation

**Tab Navigation** (Tab to Screen)
- Quotes
- Calm music 
- Journal 
- Seek help


**Flow Navigation** (Screen to Screen)

- **Login Screen**
    => Quotes fragment for displaying quotes
    
    
- **Stream screen** 
  => To journal entry screen
  => Detail screen for a quote
  => Detail screen for a song
  => Detail screen for a mental health resource
    
- **Creation Screen**
    => Back to list of notes
    
    
- **Details Screen**
  => Back to quotes fragment
  => Back to calm music fragment
  => Back to journal fragment
  => Back to seek help fragment

- **Profile Screen**
  => Back to main screen

## Wireframes

<img src="https://i.imgur.com/iC4IXc4.png" width=600>
<img src="https://i.imgur.com/NnUYuCL.png" width=600>


https://user-images.githubusercontent.com/77579038/197669044-d8a92112-4b0b-4a93-b9e3-1095a4073e0a.mp4

## Video at current stage

![mindwalkthru.git](https://github.com/AndroidGrp9Codepath/MindfulMind/blob/main/mindfulmindWalkthru.gif)

## Presentation Link
note download presentationVideo to watch

![presentationlink](https://github.com/AndroidGrp9Codepath/MindfulMind/blob/main/video3815078054.mp4)