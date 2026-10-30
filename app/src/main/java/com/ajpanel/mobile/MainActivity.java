package com.ajpanel.mobile;
import android.app.*; import android.os.*; import android.content.*; import android.net.Uri;
import android.view.*; import android.widget.*; import java.io.*; import java.net.*; import java.util.*;
import java.util.concurrent.*;
public class MainActivity extends Activity {
 static final int PICK=8; ArrayList<Channel> channels=new ArrayList<>(); ArrayAdapter<Channel> adapter;
 EditText url,box; TextView status; ExecutorService worker=Executors.newSingleThreadExecutor();
 int dp(int x){return (int)(x*getResources().getDisplayMetrics().density);}
 public void onCreate(Bundle b){super.onCreate(b);home();}
 LinearLayout page(String title){LinearLayout root=new LinearLayout(this);root.setOrientation(1);root.setPadding(dp(12),dp(12),dp(12),dp(12));root.setBackgroundColor(0xff101820);
 TextView h=new TextView(this);h.setText(title);h.setTextSize(23);h.setTextColor(-1);root.addView(h);setContentView(root);return root;}
 Button btn(String s,Runnable r){Button b=new Button(this);b.setText(s);b.setOnClickListener(v->r.run());return b;}
 void home(){LinearLayout l=page("AJPanel Mobile · Alpha");l.addView(btn("IPTV مستقل",()->iptv()));l.addView(btn("اتصال Enigma2",()->enigma()));TextView t=new TextView(this);t.setTextColor(-1);t.setText("مشغل IPTV يعمل دون رسيفر. إدارة الرسيفر قيد التطوير.");l.addView(t);}
 void iptv(){LinearLayout l=page("IPTV / M3U");url=new EditText(this);url.setSingleLine();url.setHint("رابط M3U أو M3U8");url.setTextColor(-1);l.addView(url);
 l.addView(btn("تحميل من الرابط",()->load(url.getText().toString().trim())));
 l.addView(btn("استيراد ملف من الهاتف",()->{Intent i=new Intent(Intent.ACTION_OPEN_DOCUMENT);i.setType("*/*");i.addCategory(Intent.CATEGORY_OPENABLE);startActivityForResult(i,PICK);}));
 status=new TextView(this);status.setTextColor(-1);l.addView(status);ListView list=new ListView(this);
 adapter=new ArrayAdapter<Channel>(this,android.R.layout.simple_list_item_1,channels);list.setAdapter(adapter);list.setOnItemClickListener((a,v,p,id)->{Intent i=new Intent(this,PlayerActivity.class);i.putExtra("url",channels.get(p).url);i.putExtra("name",channels.get(p).name);startActivity(i);});l.addView(list,new LinearLayout.LayoutParams(-1,0,1));l.addView(btn("رجوع",()->home()));}
 void load(String u){if(u.isEmpty()){status.setText("أدخل رابط القائمة");return;}status.setText("تحميل...");worker.execute(()->{try{HttpURLConnection c=(HttpURLConnection)new URL(u).openConnection();c.setConnectTimeout(15000);c.setReadTimeout(30000);List<Channel> a=M3uParser.parse(c.getInputStream());c.disconnect();runOnUiThread(()->{channels.clear();channels.addAll(a);adapter.notifyDataSetChanged();status.setText("عدد القنوات: "+a.size());});}catch(Exception e){runOnUiThread(()->status.setText("خطأ: "+e.getMessage()));}});}
 protected void onActivityResult(int q,int r,Intent d){super.onActivityResult(q,r,d);if(q==PICK&&r==-1&&d!=null){try{InputStream in=getContentResolver().openInputStream(d.getData());List<Channel>a=M3uParser.parse(in);channels.clear();channels.addAll(a);adapter.notifyDataSetChanged();status.setText("عدد القنوات: "+a.size());in.close();}catch(Exception e){status.setText(e.getMessage());}}}
 void enigma(){LinearLayout l=page("Enigma2 / OpenWebif");box=new EditText(this);box.setSingleLine();box.setHint("http://192.168.1.20:80");box.setTextColor(-1);l.addView(box);TextView result=new TextView(this);result.setTextColor(-1);l.addView(btn("اختبار /web/about",()->{String u=box.getText().toString().replaceAll("/$","");worker.execute(()->{try{HttpURLConnection c=(HttpURLConnection)new URL(u+"/web/about").openConnection();c.setConnectTimeout(6000);int code=c.getResponseCode();runOnUiThread(()->result.setText("HTTP "+code));c.disconnect();}catch(Exception e){runOnUiThread(()->result.setText("تعذر الاتصال: "+e.getMessage()));}});}));l.addView(result);l.addView(btn("رجوع",()->home()));}
}
