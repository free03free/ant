package com.ajpanel.mobile;
import java.io.*;import java.util.*;import java.util.regex.*;
public final class M3uParser {
 private static final Pattern A=Pattern.compile("([\\w-]+)=\\"([^\\"]*)\\"");
 public static List<Channel> parse(InputStream in)throws IOException{
  List<Channel> out=new ArrayList<>();BufferedReader r=new BufferedReader(new InputStreamReader(in,"UTF-8"));
  String s,n="",g="",l="";
  while((s=r.readLine())!=null){s=s.trim();
   if(s.startsWith("#EXTINF")){int k=s.lastIndexOf(',');n=k>=0?s.substring(k+1).trim():"قناة";g="";l="";Matcher m=A.matcher(s);
    while(m.find()){if(m.group(1).equalsIgnoreCase("group-title"))g=m.group(2);if(m.group(1).equalsIgnoreCase("tvg-logo"))l=m.group(2);}
   }else if(!s.isEmpty()&&!s.startsWith("#")&&(s.startsWith("http://")||s.startsWith("https://"))){out.add(new Channel(n.isEmpty()?s:n,s,g,l));n="";g="";l="";}
  }return out;
 }
}
