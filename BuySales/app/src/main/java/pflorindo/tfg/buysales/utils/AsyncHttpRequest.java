package pflorindo.tfg.buysales.utils;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class AsyncHttpRequest extends AsyncTaskLoader {

    public static final String GET_METHOD = "get";
    public static final String POST_METHOD = "post";
    private String method = null;
    private String url = null;
    private String valuea = null;

    public String result = null;

    public AsyncHttpRequest(@NonNull Context context, String method, String url, String values) {
        super(context);
        this.method = method;
        this.url = url;
        this.valuea = values;
    }

    public AsyncHttpRequest(@NonNull Context context, String method, String url) {
        super(context);
        this.method = method;
        this.url = url;
        this.valuea = "";
    }

    public AsyncHttpRequest(@NonNull Context context, String url) {
        super(context);
        this.method = GET_METHOD;
        this.url = url;
        this.valuea = "";
    }



    @Nullable
    @Override
    public Object loadInBackground() {
        Log.e("method: loadInBackg...", "loadInBackground called");

        String toReturn = null;

        switch (method){
            case GET_METHOD:
                toReturn = GET_REQUEST(url);
                break;
            case POST_METHOD:
                toReturn = POST_REQUEST(url, valuea);
                break;
        }

        result = toReturn;
        return toReturn;
    }

    private static String POST_REQUEST(String url, String values) {
        try {
            StringBuilder result = new StringBuilder();
            URL url2 = new URL(url);
            URLConnection conn = url2.openConnection();
            conn.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
            wr.write(values);
            wr.flush();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            wr.close();
            rd.close();
            return result.toString();

        } catch (MalformedURLException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }

    private static String GET_REQUEST(String url) {
        try {
            StringBuilder result = new StringBuilder();
            String URL = url ;
            URL obj = new URL(URL);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                result.append(inputLine);
            }
            return result.toString();

        } catch (MalformedURLException e) {
            return e.toString();
        } catch (IOException e) {
            return e.toString();
        }
    }

}
