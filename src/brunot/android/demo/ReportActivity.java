package brunot.android.demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.content.Intent; 
import android.widget.TextView;
import android.widget.ImageView;

// -- activity class to handle reports

public class ReportActivity extends Activity {
	
	public final static String FIRST_REPORT = "rpt0";
	
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState); 
		System.out.print("\nthe intent is not null");
		// get the message from the intent
		Intent intent = getIntent();
		//String message = intent.getStringExtra(MyFirstActivity.EXTRA_MESSAGE); 
		ImageView imgViewReport = new ImageView(this);
		imgViewReport.setBackgroundResource(R.drawable.rpt0);
		// ImageView imgViewReport = (ImageView) findViewById(R.id.imgViewReport);
		setContentView(imgViewReport);
		
		// get the message from the intent
	/*	Intent intent = getIntent();
		String message = intent.getStringExtra(MyFirstActivity.EXTRA_MESSAGE);
		
		// create the text view
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(message);
		
		setContentView(textView);
		*/
	}
}
