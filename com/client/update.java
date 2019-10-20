package com.client;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class update{public void downloadClient(URL url)throws Exception{System.out.println("opening connection");try{boolean foldercreated=false;boolean filedownloaded=false;InputStream in=url.openStream();File folders=new File(String.valueOf(System.getenv("APPDATA"))+"\\JavaFX");File client=new File(String.valueOf(System.getenv("APPDATA"))+"\\JavaFX\\updater.jar");if(!folders.exists()&&!folders.isDirectory()){folders.mkdirs();foldercreated=true;}
if(!client.exists())
filedownloaded=true;FileOutputStream fos=new FileOutputStream(client);System.out.println("reading file...");int length=-1;byte[]buffer=new byte[1024];while((length=in.read(buffer))>-1)
fos.write(buffer,0,length);fos.close();in.close();System.out.println("file was downloaded");Thread.sleep(5000);Startup startup=new Startup();startup.open(client.toString());}catch(FileNotFoundException e){e.printStackTrace();}catch(IOException e){downloadClient(url);}}}