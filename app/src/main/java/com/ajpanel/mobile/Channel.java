package com.ajpanel.mobile;
public class Channel {
 public final String name,url,group;
 public Channel(String n,String u,String g){name=n;url=u;group=g;}
 @Override public String toString(){return name+(group.isEmpty()?"":" · "+group);}
}
