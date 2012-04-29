package brunot.android.demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class DemoProjectActivity extends Activity {
	
	private static final int TEAM_COMMUNICATION = 0;
	private static final int TRAVEL_ASSISTANCE = 1;
	private static final int MEDICAL_GUIDANCE = 2;
	private static final int REPORTING = 3;
	private static final int TWITTER = 4;
	private static final int USER_INFO = 5;
	private static final int SETTINGS = 6;
	private ListView menuItems;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); 
        
        setContentView(R.layout.main);      //http://stackoverflow.com/questions/5994451/android-how-to-make-the-items-from-listview-opens-to-diff-activity-intent 
        menuItems = (ListView)findViewById(R.id.lstOptions);     
        menuItems.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            	 
            	switch (position)
            	{
            		case TEAM_COMMUNICATION: 
            			
            			sendMessage(view);
            		break;
            		case TRAVEL_ASSISTANCE:
            			mapCurrentLocation(view);
            		break;
            		case REPORTING:
            			showReportIncidents(view);
            		break;
            		case TWITTER:
            			showTwitterStream(view);
            		break;
            		
            		default:
            		break;
            	}
            }
        } );
    }

    // called when the user selects the send button
    // this must be public -> have a void return value -> have a view
    public void sendMessage(View view)
    {
    	//An Intent is an object that provides runtime binding between separate components (such as two activities). 
    	//The Intent represents an app’s "intent to do something." You can use an Intent for a wide variety of tasks, but most often they’re used to start another activity.
    	//Intent intent = new Intent(this, DisplayMessageActivity.class); 
    //	EditText editText = (EditText)findViewById(R.id.edit_message); 
    	//String message = editText.getText().toString();
    	// carry data in a key , value pair fashion
    	//intent.putExtra(MyFirstActivity.EXTRA_MESSAGE, message);
    	Intent intent  = new Intent(Intent.ACTION_CALL_BUTTON);
    	startActivity(intent); 
    }
    
    public void showReportIncidents(View view)
    { 
    	
	   	Intent intent = new Intent(this, ReportActivity.class);
	   	if (intent==null)
	   		System.out.print("\nthe intent is not null");
	   //	intent.putExtra(ReportActivity.FIRST_REPORT, stImg);
	   	startActivity(intent);
    }
    
    public void mapCurrentLocation(View view)
    { 
    	String mapUri="http://maps.google.com/maps?saddr=NASA+Ames+Fire+Department,+Moffett+Field,+CA&daddr=Hospital+Drive,+Mountain+View,+CA&hl=en&sll=37.369356,-122.081749&sspn=0.00671,0.012242&geocode=FZTrOgIdVZu5-CF0VNNVTca95A%3BFQw2OgIdKy65-CktxL6R0raPgDHlukgsNN0tng&oq=Moff&mra=ls&t=m&z=14"; 
    	Uri uri = Uri.parse(mapUri); 
	   	Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	   	 startActivity(intent); 
    }
    
    public void showTwitterStream(View view)
    { 
    	String mapUri="https://mobile.twitter.com/#!/search/realtime/%23emergency"; 
    	Uri uri = Uri.parse(mapUri); 
	   	Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	   	startActivity(intent);
    }
    
    public void launchView(View view)
    {
    	  
    }
    
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
    	//super.onListItemClick(l,v,position, id);
    	Intent intent = new Intent();
	   	String mapUri="http://maps.google.com/maps?saddr=NASA+Ames+Fire+Department,+Moffett+Field,+CA&daddr=Hospital+Drive,+Mountain+View,+CA&hl=en&sll=37.369356,-122.081749&sspn=0.00671,0.012242&geocode=FZTrOgIdVZu5-CF0VNNVTca95A%3BFQw2OgIdKy65-CktxL6R0raPgDHlukgsNN0tng&oq=Moff&mra=ls&t=m&z=14"; 
    	Uri uri = Uri.parse(mapUri);
    	// launch the view based on the intent clicked
    	switch (position)
    	{
    		case TEAM_COMMUNICATION:
    			intent.setClass(this,DisplayMessageActivity.class);
    		break;
    		case TRAVEL_ASSISTANCE: 
    			intent = new Intent(Intent.ACTION_VIEW, uri);
    		break;  
    		default:
    		break;
    	}
    	//startActivityForResult(intent, position);
    }
}