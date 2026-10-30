package com.ajpanel.mobile;
import android.app.*;import android.os.*;import android.widget.*;import androidx.media3.common.MediaItem;import androidx.media3.exoplayer.ExoPlayer;import androidx.media3.ui.PlayerView;
public class PlayerActivity extends Activity {
 ExoPlayer player;
 public void onCreate(Bundle b){super.onCreate(b);LinearLayout root=new LinearLayout(this);root.setOrientation(1);root.setBackgroundColor(0xff101820);TextView title=new TextView(this);title.setText(getIntent().getStringExtra("name"));title.setTextColor(-1);title.setPadding(16,16,16,16);root.addView(title);PlayerView pv=new PlayerView(this);root.addView(pv,new LinearLayout.LayoutParams(-1,0,1));setContentView(root);player=new ExoPlayer.Builder(this).build();pv.setPlayer(player);String u=getIntent().getStringExtra("url");if(u!=null){player.setMediaItem(MediaItem.fromUri(u));player.prepare();player.play();}}
 @Override protected void onStop(){super.onStop();if(player!=null){player.release();player=null;}}
}
