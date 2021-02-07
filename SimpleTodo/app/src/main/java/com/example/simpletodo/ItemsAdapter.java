// 2.3 - Render the list of Items -- Start of Part 2

//Now we can actually start to implement the rendering of the items using the RecyclerView

//RecyclerView
//So the RecyclerView liked we talked about is a successor to holder views which were used to render
    //A list of items. So the RecyclerView is the recommended way going forward even though it is
    //A bit more complicated.
//It is used to render a list of items.
    //The RecyclerView class supports the display of a collection of data.
    //Comes with default animations for removing and adding elements.
    //Allow to use different layout managers for positioning items.

//Components of the RecyclerView
    //With a RecyclerView you need a few different components
//Adapter: RecyclerView.Adapter handles the data collection and binds to a view.
    //It manages the data model and adapts it to the individual entries in the widget.
//So the place we will spend the majority of our time inside the RecyclerView is dealing with
    //the adapter.
    //The adapter is a brand new class that will create and will actually also define the ViewHolder.
    //The ViewHolder as the name implies is a holder for the view.
    //So each item in our to-do list is going to have its own TextView to represent it and the
    //ViewHolder will hold onto the TextView and populate data from our model into a view.

//LayoutManager: helps positioning the items.
    //Very simple. It will be the default vertical layout manager.

//ItemAnimator: if you're trying to animate anything.
    //Helps animating the items for common operations such as Addition or removal of item.

//Guide to implement
    //Using a RecyclerView has the following key steps:
    //We've actually done a lot of these steps already.
//Steps to implement and using the RecyclerView.
// 1. Add RecyclerView AndroidX library to the Gradle build file.
    //This was done for us when we dragged on the RecyclerView into our XML layout.
// 2. Define a model class to use as the data source.
    //That's already done because our model class is simply a list of strings.
// 3. Add a RecyclerView to your activity to display the items.
    //We just did that. We have the rvItems member variable.
// 4. Create a custom row layout XML file to visualize the item.
    //Actually we are going to utilize a built-in Android layout which will make this very simple
        //as well.
// 5. Create a RecyclerView.Adapter and ViewHolder to render the item.
// 6. Bind the adapter to the data source to populate the RecyclerView.

//Lets build the RecyclerView.Adapter and ViewHolder to render the item.

// -----------------------------------------------------------------------------


package com.example.simpletodo;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


// # 2
//RecyclerView.Adapter
// Now that we've define the Recycler.View.ViewHolder
    //we can actually flush out the ItemsAdapter in a bit more detail.
//The adapter is responsible for taking the data at a particular position and putting it into
    //a ViewHolder.
//Similar to the ViewHolder we want to actually extend a base RecyclerView.Adapter
    //So let's say extends RecyclerView.Adapter
    //This RecyclerView.Adapter is actually parametrized by a ViewHolder.
    //And that's why it's important to define the ViewHolder first.
    //Parametrized it and inside the brackets and actually reference the ViewHolder that we just
    //defined in #1
    //You have a few options for ViewHolder, make sure you're selecting the one that's inside
    //of your package name.
//So again you'll have this red underline underneath the class which is saying that you haven't
    //implemented certain methods that are required.
    //So again we can tap on the right light bulb and the set implement methods and click OK.

//Responsible for displaying data form the model into a row in th recycler view.
public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    // # 3
    //Filling out the adapter.
    //In order to fill out the adapter we need certain information which is going to be passed in
        //from MainActivity.java
        //MainActivity.java is what will actually construct our ItemsAdapter.
    //So lets add a constructor at the top of the file.
        //One you can do this is right click and go to generate/constructors

    // # 3 b)
    //Here were defining our variables that we can than use to reference in all the other methods.
    List<String> items;

    // # 3 a)
    //The main piece of information we need is data about the model which will be a list of strings.
        //So lets pass that as the parameter for our constructor
    public ItemsAdapter(List<String> items) {
        // # 3 c)
        //In the constructor we're setting the member variable equal to the variable passed in
            //through the constructor.
        this.items = items;
    }

    // # 2 a)
    //Implementing method in #2

    //onCreateViewHolder is responsible for creating each view.
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        // # 4
        //In onCreateViewHolder we are going to actually create a new view and wrap it inside
            //of a ViewHolder.
            //So the way we'll do that is
            //Use layout inflator to inflate a view.
            //The way we will do that is this method LayoutInflater.from and you pass in a context.
            //The context we can actually grab that from the ViewGroup which a parameter to the
            //onCreateViewHolder.
            //And now you need to pass in the XML file of the view you're creating.
            //We are going to use a built-in an Android resource file which is called
            //simple_List_item_1
            //And the other parameters you need to pass in are the root which will be the parent
            //which is passed in along with false which is attached to root.
            //The RecyclerView will the be attaching this view instead of attaching it to the rout.

        //Use layout inflator to inflate a view.
        View todoView = LayoutInflater.from(parent.getContext()).inflate(android.R.layout.simple_list_item_1, parent, false);


        //This is going to return to us a View and the next step is we need to warp this inside of a
        //ViewHolder and return it.
        //All we'll do is pass this into a ViewHolder.
        //wrap it inside a ViewHolder and return it.
        return new ViewHolder(todoView);
    }

    //onBindViewHolder is responsible for taking data at a particular position and putting it
        //into a ViewHolder.

    // # 4 a)
    //OnbindViewHolder is responsible for binding data to a particular ViewHolder.
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //The first step is we want to grab the item at the position.
            //and then we want to bind the item into the specified ViewHolder.

        // # 4 b)
        //The first step is given the position we want to get the corresponding item
            //that we can just do with the data that we just passed in the constructor items
            //and this is going to be a string

        //Grab the item at the position
        String item = items.get(position);

        // # 4 c)
        //Now we want to actually bind it into our ViewHolder
        //So we can do say holder.bind(item);
            //this .bind is method that will create, that will write inside of the ViewHolder class.

        //Bind the item into the specified ViewHolder.
        holder.bind(item);

        //One way that Android Studio can help us out is by taping on this red light ball on the
            //left of holder.bind(item);
            // and create the method for us.

    }

    //getItemCount is simply the number of items available in the data.

    // # 7
    //Finally the getItemCount.
    //This method is very simple.
        //It simply
    //Tells the RecyclerView how many items are on the list.
    @Override
    public int getItemCount() {
        //And there's already a method on the list class that we can just call.
            //items.size()
        return items.size();
    }

    // # 1
    // Define the ViewHolder.
    //The way I like to do adapters is first define the ViewHolder.
    //Create a new class which is a
        //Container to provide easy access to views that represent each row of the List.
        //So we will call it ViewHolder and importantly we want this to extend the base.
        //By extending the RecyclerView.ViewHolder you need to provide a constructor.
        //Tap on the red error message underline and light bulb icon and create a constructor.

    //Container to provide easy access to views that represent each row of the List.
    class ViewHolder extends RecyclerView.ViewHolder {

        // # 5
        //So We'll define a TextView here and call it TvItem
        TextView tvItem;


        //Creating a constructor
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //And then TvItem is going to be a view inside of the view that were passed in the ViewHolder.
            //Because this is a built-in Android resource we need to say android.R.id.text1
            tvItem = itemView.findViewById(android.R.id.text1);

        }

        // # 4 d)
        //The responsibility of the bind method is to update the view inside of the ViewHolder
            //with the data of the String item.
        //And so the way we'll do that is by actually getting a reference to the view that we can
        //actually access in bind.
        //So if you look inside the Android resource file that we are using simple_list_item_1 in
            // #4 a) this is built-in, it's very simple. It consists of a single text view which has
            //an ID called text1.
            //Let's use that information to get a reference to this TextView.

        //Update the view inside the ViewHolder with this data.
        public void bind(String item) {

            // #6
            //So now that we have the TextView we can simply set the text on the TextView to be the
                //contents of the item that were passed in.
            tvItem.setText(item);
        }
    }

}

// # 8
// 2.3 - Render the list of Items -- End of Part 2

//Now that we've completed our adapter implementation the next step is we actually want to use
    //this in our MainActivity.