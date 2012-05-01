package brunot.android.demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
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
            			registerForContextMenu(view);
            			//showReportIncidents(view);
            		break;
            		case TWITTER:
            			showTwitterStream(view);
            		break; 
            		case USER_INFO: 
            			ComingSoon("User Information");
            		break;	
            		case SETTINGS:
            			ComingSoon("MEMS settings");
            		break; 
            		default:
            		break;
            	}
            }
        } );
    }
    
    // http://stackoverflow.com/questions/5085760/contextmenu-shows-item-i-have-not-specified-in-context-menu-xml
    // http://www.stealthcopter.com/blog/2010/04/android-context-menu-example-on-long-press-gridview/
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo){
    	
        super.onCreateContextMenu(menu, v, menuInfo); 
        menu.setHeaderTitle("Reporting");  
        menu.add(0, v.getId(), 0, "Create New Report");
        menu.add(0, v.getId(), 1, "Edit Ongoing Report");  
        menu.add(0, v.getId(), 2, "Save Ongoing Report");
        menu.add(0, v.getId(), 3, "Share Report");
        menu.add(0, v.getId(), 4, "Agregate Daily Reports"); 
    }

    // keep in mind: you're only showing different views, not really launching new activities here
    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	switch (item.getOrder())
    	{
    		case 0:
    			AddReport();
    		break;
    		case 1:
    			EditReport();
        	break;
    		case 2:
    			SaveReport();
    		case 3:
    			ShareReport();
    		break;
    		case 4:
    			ComingSoon(item.getTitle().toString());
    		break;
        	default:
        		// do nothing
        	break; 
    	}	 
        return true;
    }
    
    public void ShareReport()
    {
    	ComingSoon("You should be able to share this report with your EMT team.");
    }
    
    public void SaveReport()
    { 
    	Toast.makeText(this, "The current report has been saved to your mems", Toast.LENGTH_LONG).show();
    }
    
    public void ComingSoon(String menuOption)
    {
    	Toast.makeText(this, menuOption+" is coming soon to your MEMS!, see the next update!", Toast.LENGTH_SHORT).show();
    }
    
    public void function1(int id)
    {
    	Toast.makeText(this, "function 1 was called"+Integer.toString(id), Toast.LENGTH_SHORT).show();
    }   
    
    public void function2(int id)
    {
    	Toast.makeText(this, "function 2 was called", Toast.LENGTH_SHORT).show();
    }
    
    // called when the user selects the send button
    // this must be public -> have a void return value -> have a view
    public void sendMessage(View view)
    {
    	//An Intent is an object that provides runtime binding between separate components (such as two activities). 
    	//The Intent represents an appÕs "intent to do something." You can use an Intent for a wide variety of tasks, but most often theyÕre used to start another activity.
    	//Intent intent = new Intent(this, DisplayMessageActivity.class); 
    	//EditText editText = (EditText)findViewById(R.id.edit_message); 
    	// String message = editText.getText().toString();
    	// carry data in a key , value pair fashion
    	// intent.putExtra(MyFirstActivity.EXTRA_MESSAGE, message);
    	Intent intent  = new Intent(Intent.ACTION_CALL_BUTTON);
    	startActivity(intent); 
    }
    //https://docs.google.com/document/d/1dJBkS67CGnWBRyvy6xOUuQ3e_Ly6nw4-2XiRB0BMKJo/edit
    public void showReportIncidents(View view)
    { 
    	
	   	Intent intent = new Intent(this, ReportActivity.class);
	   	if (intent==null)
	   		System.out.print("\nthe intent is not null");
	   //	intent.putExtra(ReportActivity.FIRST_REPORT, stImg);
	   	startActivity(intent);
    }
    // new report link > https://docs.google.com/document/d/1MvUtYI0V57zo7inziDJqEpJaEjiWpfbXHRrmbMT-RRA/edit
    
    public void EditReport()
    {
    	String mapUri="https://docs.google.com/document/d/1dJBkS67CGnWBRyvy6xOUuQ3e_Ly6nw4-2XiRB0BMKJo/edit"; 
    	Uri uri = Uri.parse(mapUri); 
	   	Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	   	startActivity(intent); 
    }
    
    public void AddReport()
    {
    	String mapUri="https://docs.google.com/document/d/1MvUtYI0V57zo7inziDJqEpJaEjiWpfbXHRrmbMT-RRA/edit"; 
    	Uri uri = Uri.parse(mapUri); 
	   	Intent intent = new Intent(Intent.ACTION_VIEW, uri);
	   	startActivity(intent); 
    }
    
    public void mapCurrentLocation(View view)
    { 
    	String mapUri="http://maps.google.com/maps?saddr=NASA+Ames+Research+Park&daddr=2500+Grant+Road,+Mountain+View,+CA+94040+(El+Camino+Hospital)&hl=en&sll=37.389663,-122.071838&sspn=0.053669,0.09347&geocode=FTXUOgIdtHW5-CG1Rbs_4GW8FQ%3BFec0OgIdPjS5-CECtCrTJjkO6Q&oq=El+Camino+Hospital,+250&mra=ls&t=m&z=14"; 
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
    
}