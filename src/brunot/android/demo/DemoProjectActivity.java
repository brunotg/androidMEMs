package brunot.android.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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
    }
}