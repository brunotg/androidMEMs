package brunot.android.demo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class DemoProjectActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*
        ListView listView = (ListView) findViewById(R.id.lstOptions);
        String[] values = new String[] { "Incident", "Reference", "Guidance",
        	"Route to location", "Alert", "Communicate with other teams"};

        // First paramenter - Context
        // Second parameter - Layout for the row
        // Third parameter - ID of the View to which the data is written
        // Forth - the Array of data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        	android.R.layout.simple_list_item_1, android.R.id.text1, values);

        // Assign adapter to ListView
        listView.setAdapter(adapter);
        */
        setContentView(R.layout.main);
        //ListView listView = (ListView) findViewById(R.id.lstOptions);
        //listView.setClickable(true);
     
    
     //http://stackoverflow.com/questions/5994451/android-how-to-make-the-items-from-listview-opens-to-diff-activity-intent
   
    }

    // called when the user selects the send button
    // this must be public
    // have a void return value
    // have a view
    public void sendMessage(View view)
    {
    	//An Intent is an object that provides runtime binding between separate components (such as two activities). 
    	//The Intent represents an app’s "intent to do something." You can use an Intent for a wide variety of tasks, but most often they’re used to start another activity.
    	Intent intent = new Intent(this, DisplayMessageActivity.class);
    	
    	EditText editText = (EditText)findViewById(R.id.edit_message);
    	String message = editText.getText().toString();
    	// carry data in a key , value pair fashion
    	intent.putExtra(MyFirstActivity.EXTRA_MESSAGE, message);
    	startActivity(intent);
    	
    }
    
    public void showReportIncidents(View view)
    {
    	
    }
}
/*
 * */

/*<activity
            android:name=".DemoProjectActivity"
            android:label="@string/app_name" 
            android:debuggable="true">
 * */ 