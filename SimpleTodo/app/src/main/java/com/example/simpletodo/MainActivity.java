//Source code for the application

//    Implementation: Tasks & Sub-Tasks -- Project Overview

// 1. Construct user interface in res/layout/activity_main.xml
//      . Add list view for displaying items
//      . Add text field and button for adding item
// 2. Implement model as List of String
//      . Mock data at first
//      . Populate list view on app startup
// 3. Implement mutation actions
//      . Add logic on button press
//      . Remove logic on press-and-hold
// 4. Implement persistence
//      . Load model from file system on app startup
//      . Store the file system after changes to model

// -----------------------------------------------------------------------------

// 2.3 - Render the list of Items -- Overview

// In this step, we'll write Java code which manages the data model and adapter, and wires the list
    //to-do items in a list using a RecyclerView

//Objectives
    // . Understanding basics of Java coding
    // . Extending onCreate()
    // . Adding new methods to activity class
    // . Defining a data model
    // . Defining an adapter and viewHolder
    // . Using Android layouts
    // . Binding the adapter to the data source


// 2.3 - Render the list of Items -- Start of Part 1

//Now that we built our UI for our application, we can move on to the rest of our implementation.
//What we've done so far is essentially number one which is constructing the UI in
    //activity_main.xml
//Next we want to implement a model the model for our list of to-do objects.
    //This is going to be a list of strings and we're initially going to mock the data.
    //We're also going to build the RecyclerView which will actually render the list of
    //to-do items into our application.
//So the work we've done have primarily been so far been in the XML file activity main.
    //The work we're going yo do is almost entirely going to be in MainActivity.java
    //which is the source code for our application so the first thing you should notice is that
    //there's a starter code here
/*
public class MainActivity extends AppCompatActivity {
}
*/
    //and there's a method defined which is onCreate.
    //This method is called by the android system and inform us that our application or activity
    //the MainActivity has been created.
    //Here you can take actions based on the creation of our activity.
    //So the starter code sets the layout, our activity_main.xml file as the content (setContentView)
    //of our activity.
    //That's how we're even able to see the UI when we ran our application.

// -----------------------------------------------------------------------------


package com.example.simpletodo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

//Starter Code.
public class MainActivity extends AppCompatActivity {

    // # 1
    //So first thing we can do is define a list of strings as our model. And call it Items.
        //You'll need to actually import it to your application.
        //Shortcut Command: Option + Enter
    List<String> items;

    // # 3
    //Next we want to get a reference of each view in our MainActivity.java file.
    //So for each of the button, edit text, and RecyclerView, we want to be able to get an
        //a handle on it in our MainActivity so that we can add the appropriate logic for each
        //component.
    //The way we will do that is to add a member variable from each view.
    Button btnAdd;
    EditText etItem;
    RecyclerView rvItems;

    //Enabling us to see the UI when we run our application.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // # 4
        //On the OnCreate method.
        //We need to actually define what each of these member variables in #3 are for.
        //For example btnAdd will be FindViewById and we need to pass in the id that we defined
            //earlier in the view XML.
        btnAdd = findViewById(R.id.btnAdd);
        etItem = findViewById(R.id.etItem);
        rvItems = findViewById(R.id.rvItems);

        // # 5 a)
        //So now that we have each of the views as reference on our java file
            //we can actually start to do something interesting with them.
            //As one quick example each of these views have a different set of methods that you call
            //on them.
            //For example on the EditText we can actually set the test which is located inside of it.
            //So I can say setText("I'm doing this from java!");
            //Call on etItem to write text in it.
        /*
        etItem.setText("I'm doing this from java!");
        */

        // # 5 b)
        //So now if we run the application and go back to emulator, you can see that the text actually
            //got updated it.
            //So this is just proof that we have a lot of control from our Java file to be able
            //To modify and take action on the different views of our application.


        // # 2
        //Instantiate the model.
        //In the onCreate is where we will actually instantiate the model.
            //To call a constructor of a Class which creates an instance or object, of the type of
            //that Class.

        // # 7
        // 2.3 - Render the list of Items -- Start of Part 3

        //Now that we've completed our adapter implementation the next step is we actually want to use
        //this in our MainActivity.

        //From itemsAdapter.java
        //There are a couple of different steps here
        //First thing we want to do is actually construct our adapter plus a new itemsAdapter.
            //And we need to pass in our items.
            //And because we're actually defining items below, I'm going to move the line

        /*
        new ItemsAdapter(items);
        */

        //below where we established what our items are.


        // # 2 continue...)
        //In the onCreate is where we will actually instantiate the model.
        items = new ArrayList<>();

        //Let's start out with some mock data
        items.add("Buy milk");
        items.add("Go to the gym");
        items.add("Have fun!");

        // # 7 a)
        //This is going to return to us an ItemsAdapter
        ItemsAdapter itemsAdapter = new ItemsAdapter(items);

        //and what we need to do is first set the adapter on the RecycleReview
            //so rvItems is referring to our RecycleReview and there's a method called
            //setAdapter and you pass in itemsAdapter.
        rvItems.setAdapter(itemsAdapter);

        // # 7 b)
        //The next thing we need to do is setLayoutManager on our RecyclerView items.
        //We're going to use the most basic layout manager it's a LinearLayoutManager
            //and by default this is going to put things on your UI in a vertical way.
            //And that should be it.
        rvItems.setLayoutManager(new LinearLayoutManager(this));


       // # 8
        // 2.3 - Render the list of Items -- End of Part 3

        //So now if we run our application we should see the dummy and mock data that we have
            //show up in our application.
            //And indeed you can see that we have
                //Buy milk
                //Go to the gym
                //Have fun!
            //The three items that we added show up on our list.


        // # 10
        // 2.4 Implement add and remove functionality -- Start

        //Now that we're able to render a list of mock data using the RecyclerView
            //we can move on to number three in our plan of attack which is to implement mutation
            //actions.
        //The first thing we'll do is add logic on button press.
            //The idea is that when a user taps on the add button we want to take the content in our
            //edit text and add it to the RecyclerView.
            //The way we'll go about doing this is by adding an onClickListener on the button.
            //What this means is that we'll be notified every time the user taps on the button
            //and we'll be able to take the corresponding action.
        //So we'll do btnAdd.setOnClickListner
            //And as you type you'll notice that Android Studio can actually auto fill some of the
            //method for you

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //So when get inside of here, the onClick that means someone is actually
                    //tapped on our button.
                //So like we mentioned what we want to do is we want to grab the the contents
                    //of whatever is inside of our edit text.
                    //The way we can do that is say:

                /*

                etItem.getText()
                 */

                //And this is actually going to return something called an editable and instead
                    //of an editable we want a string and so we'll call toString() on it.

                String todoItem = etItem.getText().toString();

                // # 10 a)
                //Next we have to do two things.
                    //First we have to add this new item to the model.
                    //Second we need to notify the adapter that we've inserted an item.
                //Adding an item to the model is simply a call to items and we're adding another
                    //string and notifying the adapter is a call on our the adapter we've
                    //just defined.
                    //And the position where the item is inserted is going to be the last position
                    //in our model which is items.size() - 1

                //Add item to the model.
                itemsAdapter.notifyItemInserted(items.size()-1);

                    //And then finally one thing we want to do is clear the edit text once we've
                    //submitted it.
                    etItem.setText("");
            }
        });






    }
}

// -----------------------------------------------------------------------------

// # 6

// 2.3 - Render the list of Items -- End of Part 1

//So now we can actually start to implement the rendering of the items using
    //the RecyclerView.
//There are a few steps to make the RecyclerView work, so what I recommend go to
    //Google for codepath RecyclerView and you'll end up on this guide which talks about
    //what the RecyclerView is and how to use it.
//RecyclerView
//So the RecyclerView liked we talked about is a successor to holder views which were used to render
    //A list of items. So the RecyclerView is the recommended way going forward even though it is
    //A bit more complicated.
//With a RecyclerView you need a few different components.
//One is the Adapter which handles the data collection and binds to a view.
//A LayoutManager which helps positioning the items.
//And an item animator if you're trying yo animate anything.
//And LayoutManager will be very simple. It'll just be the default vertical LayoutManager.
//So the place we will spend the majority of our time inside the RecyclerView is dealing with
    //the adapter.
    //The adapter is a brand new class that will create and will actually also define the ViewHolder.
    //The ViewHolder as the name implies is a holder for the view.
    //So each item in our to-do list is going to have its own TextView to represent it and the
    //ViewHolder will hold onto the TextView and populate data from our model into a view.

//So there's a lot going on but we can break down the six different steps
    //We've actually done a lot of these steps already.
//First we need to add the RecyclerView AndroidX library.
    //This was done for us when we dragged on the RecyclerView into our XML layout.
//Define a model class to use as the data source.
    //That's already done because our model class is simply a list of strings.
// 3. Add a RecyclerView to your activity to display the items.
    //We just did that. We have the rvItems member variable.
// 4. Then we going to create a custom row layout XML file to visualize the item.
    //Actually we are going to utilize a built-in Android layout which will make this very simple
    //as well.
// 5. And then we need to create a RecyclerView.Adapter and ViewHolder to render the item.
    //Let's do that.
// 6. Bind the adapter to the data source to populate the RecyclerView.


//Lets build the RecyclerView.Adapter and ViewHolder to render the item.
//Let's get started by creating the new adapter
    //Open up MainActivity.java and we want to go to place in the directory structure where
    //MainActivity.java lives.
//So one way you can do that is by tapping on this target icon on the upper left tab next to the
    //Android logo.
    //And you'll see that MainActivity is inside app/java/and inside the first package name.
    //Right here we want to right click and New/Java Class
    //And this where we're going to create our new adapter.
    //Lets call it ItemsAdapter and click OK.

// # 8
// 2.3 - Render the list of Items -- End of Part 3

//So now if we run our application we should see the dummy and mock data that we have
    //show up in our application.
    //And indeed you can see that we have
    //Buy milk
    //Go to the gym
    //Have fun!
//The three items that we added show up on our list.


// # 9
// 2.4 Implement add and remove functionality -- Overview

//In this step, complete the implementation of the app by setting up event listeners and handlers,
    //and implementing persistence of the data to device file system. You'll learn how to use
    //Toasts and logging as well

//Objectives
    // . Wiring code and design
    // . Using onClick() handlers
    // . Setting up event listeners
    // . Understand functional areas
    // . Persistence
    // . Toast and Logging

