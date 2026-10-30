package com.ajpanel.mobile;
import android.app.*;import android.os.*;import android.widget.*;
import androidx.media3.common.MediaItem;import androidx.media3.exoplayer.ExoPlayer;import androidx.media3.ui.PlayerView;
public class PlayerActivity extends Activity {
 ExoPlayer player;
 public void onCreate(Bundle b){super.onCreate(b);LinearLayout root=new LinearLayout(this);root.setOrientation(1);root.setBackgroundColor(0xff101820);
 TextView t=new TextView(this);t.setText(getIntent().getStringExtra("name"));t.setTextColor(-1);root.addView(t);
 PlayerView v=new PlayerView(this);root.addView(v,new LinearLayout.LayoutParams(-1,0,1));setContentView(root);
 player=new ExoPlayer.Builder(this).build();v.setPlayer(player);String u=getIntent().getStringExtra("url");player.setMediaItem(MediaItem.fromUri(u));player.prepare();player.play();}
 protected void onStop(){super.onStop();if(player!=null){player.release();player=null;}}
}
