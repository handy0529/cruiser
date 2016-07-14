package com.handy.cruiser.drawer.drawer2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.DrawerLayout.DrawerListener;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.handy.cruiser.R;


public class SecondDemoActivity extends FragmentActivity implements
		OnItemClickListener {

	private DrawerLayout mDrawerLayout;
	private ListView mLv;
	private FragmentManager fragmentManager;
	private Fragment fragment1, fragment2, fragment3;
	private String[] str;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_second);

		init();
	}

	private void init() {
		mDrawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout2);
		mDrawerLayout.setDrawerListener(new DrawerListener() {
			@Override
			public void onDrawerStateChanged(int arg0) {
				Log.i("drawer", "aaaaaa" + arg0);
			}
			@Override
			public void onDrawerSlide(View arg0, float arg1) {
				Log.i("drawer", arg1 + "");
			}
			@Override
			public void onDrawerOpened(View arg0) {
				Log.i("drawer", "bbbbb");
			}
			@Override
			public void onDrawerClosed(View arg0) {
				Log.i("drawer", "cccccc");
			}
		});
		
		mDrawerLayout.setDrawerListener(new DrawerLayout.SimpleDrawerListener() {
			@Override
			public void onDrawerClosed(View drawerView) {
				super.onDrawerClosed(drawerView);
			}
			@Override
			public void onDrawerOpened(View drawerView) {
				super.onDrawerOpened(drawerView);
			}
		});
		
		
		mLv = (ListView) findViewById(R.id.id_lv);
		str = new String[] { "item1", "item2", "item3"};
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, str);
		mLv.setAdapter(adapter);
		mLv.setOnItemClickListener(this);

		fragmentManager = getSupportFragmentManager();
		fragment1 = new Fragment1();
		fragment2 = new Fragment2();
		fragment3 = new Fragment3();
	}
	
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
							long id) {
		switch (position) {
		case 0:
			fragmentManager.beginTransaction()
					.replace(R.id.id_framelayout2, fragment1).commit();
			break;
		case 1:
			fragmentManager.beginTransaction()
					.replace(R.id.id_framelayout2, fragment2).commit();
			break;
		case 2:
			fragmentManager.beginTransaction()
					.replace(R.id.id_framelayout2, fragment3).commit();
			break;
		}
		setTitle(str[position]);
		mDrawerLayout.closeDrawers();
	}

}
