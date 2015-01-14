package com.shelwee.uilistview_demo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.shelwee.uilistview.ui.UiListView;
import com.shelwee.uilistview.ui.UiListView.ClickListener;

public class MainActivity extends Activity {

	private UiListView uiListView1, uiListView2, uiListView3, uiListView4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initUilist1();
		initUilist2();
		initUilist3();
		initUilist4();
		
	}

	private void initUilist4() {
		// TODO Auto-generated method stub
		uiListView4 = (UiListView) findViewById(R.id.uilist4);
		uiListView4.addBasicItem("��ť");
		uiListView4.commit();
		uiListView4.setClickListener(new ClickListener() {
			
			@Override
			public void onClick(int index) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "��ť���", Toast.LENGTH_SHORT).show();
			}
		});
	}

	private void initUilist3() {
		// TODO Auto-generated method stub
		uiListView3 = (UiListView) findViewById(R.id.uilist3);
		uiListView3.addBasicItem("����ģʽ");
		uiListView3.addBasicItem("�������");
		uiListView3.addBasicItem("���ֲ��Ӵ�");
		uiListView3.commit();
	}

	private void initUilist2() {
		// TODO Auto-generated method stub
		uiListView2 = (UiListView) findViewById(R.id.uilist2);
		uiListView2.addBasicItem("�������");
		uiListView2.addBasicItem("����","����ʾ��ͷ");
		uiListView2.addBasicItem(R.drawable.user_image,"����","��������ܹ�����ʱ�������");
		uiListView2.commit();
	}

	private void initUilist1() {
		uiListView1 = (UiListView) findViewById(R.id.uilist1);
		uiListView1.addBasicItem("Ĭ������");
		uiListView1.addBasicItem("����","����");
		uiListView1.addBasicItem(R.drawable.user_image,"����");
		uiListView1.commit();
		uiListView1.setClickListener(new ClickListener() {
			
			@Override
			public void onClick(int index) {
				// TODO Auto-generated method stub
				Toast.makeText(MainActivity.this, "���"+index, Toast.LENGTH_SHORT).show();
			}
		});
	}
}
