package com.jbondia.basicjsonparser.task;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.jbondia.basicjsonparser.R;
import com.jbondia.basicjsonparser.model.Character;
import com.jbondia.basicjsonparser.delegate.AsyncDelegate;
import com.jbondia.basicjsonparser.util.CharacterDataParser;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ProtocolException;

/**
 * Created by jbondia on 10/03/15.
 */
public class GetCharacterTask extends AsyncTask<String, Void, JSONObject> {

    private static String LOG_TAG = "Obtained Character";

    private AsyncDelegate asyncDelegate;
    private ProgressDialog progressDialog;

    public GetCharacterTask(Context context, AsyncDelegate asyncDelegate) {
        this.asyncDelegate = asyncDelegate;
        this.progressDialog = new ProgressDialog(context);
        this.progressDialog.setMessage(context.getString(R.string.progress_description));
        this.progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        this.progressDialog.show();
    }

    @Override
    protected JSONObject doInBackground(String... params) {

        try {

            DefaultHttpClient httpClient = new DefaultHttpClient();
            HttpResponse httpResponse = null;
            HttpEntity httpEntity = null;

            HttpGet httpGet = new HttpGet(params[0]);
            httpResponse = httpClient.execute(httpGet);

            httpEntity = httpResponse.getEntity();
            String response = EntityUtils.toString(httpEntity);

            return new JSONObject(response);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(JSONObject jsonObject) {
        super.onPostExecute(jsonObject);
        progressDialog.dismiss();

        Character character = CharacterDataParser.jsonCharacterParser(jsonObject);
        Log.i(LOG_TAG, character.toString());

        asyncDelegate.asyncComplete(character);

    }
}
