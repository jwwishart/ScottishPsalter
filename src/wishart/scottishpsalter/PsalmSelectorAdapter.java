package wishart.scottishpsalter;

import android.content.Context;
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
		return ++arg0;
	}

	@Override
	public long getItemId(int position) {
		return (long)++position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		TextView result;
		
		if (convertView == null) {
			String s = ((String.valueOf(++position)));
			
			result = new TextView(context);
			result.setText(s);
			result.setPadding(1,1,1,1);
		} else {
			result = (TextView) convertView;
		}
		
		return result;
	}

}
