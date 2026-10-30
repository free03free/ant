package com.ajpanel.mobile;
import java.io.*; import java.util.*; import java.util.regex.*;
public final class M3uParser {
 private static final Pattern GROUP=Pattern.compile("group-title=\\\"([^\\\"]*)\\\"");
 public static List<Channel> parse(InputStream in)throws IOException{
  List<Channel> out=new ArrayList<>(); BufferedReader r=new BufferedReader(new InputStreamReader(in,"UTF-8"));
  String line,name="",group="";
  while((line=r.readLine())!=null){line=line.trim();
   if(line.startsWith("#EXTINF")){int c=line.lastIndexOf(',');name=c>=0?line.substring(c+1).trim():"Channel";
    Matcher m=GROUP.matcher(line);group=m.find()?m.group(1):"";
   } else if((line.startsWith("http://")||line.startsWith("https://"))&&!line.startsWith("#")){
    out.add(new Channel(name.isEmpty()?line:name,line,group));name="";group="";
   }
  } return out;
 }
}
