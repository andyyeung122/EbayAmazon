# EbayAmazon

We want to develop an eBusiness platform such that every responsible user can bid/buy and sell items. There are three types of users to this system: superusers (SUs), ordinary users (OUs) and guests (GUs).

# Motivation

This is a computer science courese group project. The goal for this project is that all group members work as a team, and help each other. The primary goal for any team is to grow better and better as each day goes by. But this cannot be achieved unless the whole team stays committed to this goal. A team’s success lies on how well their foundation is built. One of the best ways to enhance the skills and abilities of each member of your team is by conducting a thorough training process from the beginning until the end of your team’s journey. 



# Screenshots

![image](https://user-images.githubusercontent.com/25621594/57823953-69179200-7767-11e9-856e-150ef2502a37.png)
![image](https://user-images.githubusercontent.com/25621594/57824028-ab40d380-7767-11e9-9036-21bc5da042b0.png)

![image](https://user-images.githubusercontent.com/25621594/57824015-9f551180-7767-11e9-9f55-3ac66dc8348b.png)
![image](https://user-images.githubusercontent.com/25621594/57824017-a3812f00-7767-11e9-9fcb-2c1af3a1da8b.png)

# Features

1. user can sign up to become a ordinary user.
2. ordinary user can add other user as friend and send message to each other.
3. ordinary user can recieve special notification according to their key word.


# Code Example
connect to database
```
private static void getConnection(){
        try{
            String host = "jdbc:mysql://localhost:3306/";
            String databaseHost = "jdbc:mysql://localhost:3306/EbayAmazon";
            String user = "root";

            String password = "";




            String createDatabase = "CREATE DATABASE IF NOT EXISTS EbayAmazon;";

            connection = DriverManager.getConnection(host,user,password);
            Statement statement = connection.createStatement();

            executeUpdate(createDatabase);

            connection = DriverManager.getConnection(databaseHost,user,password);
            statement = connection.createStatement();

            statement.close();

        }catch(Exception expt){
            expt.printStackTrace();
        }
    }
```

# Installation

1. download the mysql in order to use database
[click here to download](https://dev.mysql.com/downloads)

2 download database driver and add it as library
[click here to download](https://dev.mysql.com/downloads/connector/)



# Tests
All the functions we need are in the Data class. Run the Testing class in data file, so it will create database table for you. Also some users and data will insert to the table.


