package com.eebbk.popupwindow3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.PopupWindow;

public class MainActivity extends Activity implements OnClickListener
{
    public Button popBtn = null; 
    
    public List<HashMap<String, String>> groupList = new ArrayList<HashMap<String, String>>();
    public List<List<HashMap<String, String>>> childList = new ArrayList<List<HashMap<String, String>>>();
    
    public static final String GROUP = "group";
    public static final String CHILD = "child";
    
    public ExListAdapter adapter;
    public ExpandableListView elv;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
//		setContentView(R.layout.pop1);
		setContentView(R.layout.activity_main);
//		setContentView(R.layout.summary);
		
//		setContentView(R.layout.exp_list);
		
		popBtn = (Button)findViewById(R.id.popup_btn);
		popBtn.setOnClickListener(this);
		
        System.out.println("githut test....................................")

		for(int i = 0; i < 2; i++)
		{
			HashMap<String, String> groupMap = new HashMap<String, String>();
			groupMap.put(GROUP, "group " + i);
			groupList.add(groupMap);
			
			List<HashMap<String, String>> childItemList = new ArrayList<HashMap<String, String>>();
			for(int j = 0; j < 3; j++)
			{
				HashMap<String, String> childMap = new HashMap<String, String>();
				childMap.put(CHILD, "child " + j);
				childItemList.add(childMap);
			}
			childList.add(childItemList);
		}
		
//		adapter = new ExListAdapter(this, groupList, childList);
//		elv = (ExpandableListView)findViewById(R.id.list2);
//		elv.setAdapter(adapter);
//		elv.setGroupIndicator(null);
//		elv.setDivider(null);
	}
	
	
	@Override
	public void onClick(View v)
	{
         switch(v.getId())
         {
             case R.id.popup_btn:
             {
            	 showPopupWindow();
            	 break;
             }
         }
	}
	
	public void showPopupWindow()
	{
		LayoutInflater inflater = (LayoutInflater)this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View myView = inflater.inflate(R.layout.summary, null);
		
		adapter = new ExListAdapter(this, groupList, childList);
		elv = (ExpandableListView)myView.findViewById(R.id.list2);
		elv.setAdapter(adapter);
		elv.setGroupIndicator(null);
//		elv.setDivider(null);
		
		PopupWindow pw = new PopupWindow(myView, 300, 250, true);
		
		pw.showAsDropDown(popBtn);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	

}
