package wishart.scottishpsalter;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class PsalmSelectorAdapter extends BaseAdapter {
	private Context context;
	
	public PsalmSelectorAdapter(Context context) {
		this.context = context;
	}

	@Override
	public int getCount() {
		return 150;
	}

	@Override
	public Object getItem(int arg0) {
		return arg0 + 1;
	}

	@Override
	public long getItemId(int position) {
		return (long)position + 1;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView result;
		
		int number = position + 1;
		String s = ((String.valueOf(number)));
		
		if (convertView == null) {	
			result = new TextView(context);
			result.setPadding(1,1,1,1);
			result.setTextSize(35);
			result.setSingleLine();
			result.setGravity(Gravity.CENTER);
		} else {
			result = (TextView) convertView;
		}
		
		result.setId(number - 1);
		result.setText(s);
		
		return result;
	}

}
