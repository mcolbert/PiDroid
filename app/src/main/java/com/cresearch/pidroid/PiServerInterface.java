package com.cresearch.pidroid;

import android.util.Log;

import org.alexd.jsonrpc.JSONRPCClient;
import org.alexd.jsonrpc.JSONRPCException;
import org.alexd.jsonrpc.JSONRPCParams;

/**
 * Created by mcolbert on 12/21/14.
 */
public class PiServerInterface {

  private static final String TAG = PiServerInterface.class.getSimpleName();
  private final JSONRPCClient client;

  public PiServerInterface() {
    client = JSONRPCClient.create("http://192.168.1.150/rpc", JSONRPCParams.Versions.VERSION_2);
    client.setConnectionTimeout(2000);
    client.setSoTimeout(2000);
  }

  public Boolean enableX10() {
    try {
      return client.callBoolean("x10", true);
    } catch (JSONRPCException e) {
      Log.e(TAG, e.getStackTrace().toString());
      return false;
    }
  }
}
