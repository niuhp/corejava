package com.niuhp.corejava.concurrent.poolcalc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by niuhaipeng on 2016/7/29.
 */
public class AsyncHttpGetTask implements Runnable {
  private String url;

  public AsyncHttpGetTask(String url) {
    this.url = url;
  }

  @Override
  public void run() {
    HttpURLConnection connection = null;
    BufferedReader reader = null;
    try {
      URL getUrl = new URL(url);
      connection = (HttpURLConnection) getUrl.openConnection();
      connection.connect();
      reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
      String line;
      while ((line = reader.readLine()) != null) {
       // System.out.println(line);
      }
    } catch (IOException e) {

    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (Exception e) {
        }
      }
      connection.disconnect();
    }
  }
}
