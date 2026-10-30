package com.ajpanel.mobile;
public class Channel {
 public final String name,url,group,logo;
 public Channel(String n,String u,String g,String l){name=n;url=u;group=g;logo=l;}
 @Override public String toString(){return name+(group.isEmpty()?"":"  •  "+group);}
}
