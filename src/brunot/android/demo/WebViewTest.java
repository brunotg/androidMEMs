package brunot.android.demo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class WebViewTest extends Activity {
	 
    @Override
    public void onCreate(Bundle savedInstanceState){
    
    	super.onCreate(savedInstanceState);
    	
    	// get the message from the intent
    //	Intent intent = getIntent();
    	//String message = intent.getStringExtra(MyFirstActivity.EXTRA_MESSAGE);

 //    	To provide a WebView in your own Activity, include a in your layout, or set the entire Activity window as a WebView during onCreate():

    	 WebView webview = new WebView(this);
    	 setContentView(webview);
    			
    }

}
