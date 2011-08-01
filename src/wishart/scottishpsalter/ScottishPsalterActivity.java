package wishart.scottishpsalter;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;

public class ScottishPsalterActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        GridView gridView = (GridView)findViewById(R.id.gridview);
        gridView.setAdapter(new PsalmSelectorAdapter(this));
        
        gridView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
            	String message = v.getContext().getString(R.string.loading_psalm) + " " + ++position;
            	Toast.makeText(ScottishPsalterActivity.this, message, Toast.LENGTH_SHORT).show();
            	
            	Intent intent = new Intent(v.getContext(), ViewPsalmActivity.class);
            	intent.putExtra("SELECTED_PSALM", position); // position has already been incremented.
            	startActivityForResult(intent, 0);
            }
        });
    }
}