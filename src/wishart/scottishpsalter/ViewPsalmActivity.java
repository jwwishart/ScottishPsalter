package wishart.scottishpsalter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import android.app.Activity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ViewPsalmActivity extends Activity {
	
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.viewpsalm);
        
        TextView textView = (TextView)findViewById(R.id.viewpsalm);
        int selectedPsalm = getIntent().getExtras().getInt("SELECTED_PSALM");
        
        textView.setMovementMethod(new ScrollingMovementMethod());
        
		textView.setText( "Psalm " + selectedPsalm + "\n\n" + readTxt(selectedPsalm) );
		
		// Setup back button
		final Button button = (Button) findViewById(R.id.select_psalm);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	finish();
            }
        });
	}
    
    private String readTxt(int psalmNumber){
    	int textId = getResources().getIdentifier("raw/psalm" + psalmNumber, null, getPackageName());
    	InputStream inputStream = getResources().openRawResource(textId);
    	
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        
        int i;
        try {
        	i = inputStream.read();
        	while (i != -1)
        	{
        		byteArrayOutputStream.write(i); 
        		i = inputStream.read();
        	}
        	inputStream.close();
        } catch (IOException e) {
        	Toast.makeText(ViewPsalmActivity.this, "AARRGGGHH", Toast.LENGTH_SHORT).show(); 
        	e.printStackTrace();
        }
        
        return byteArrayOutputStream.toString();
	}
}
