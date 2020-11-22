package pflorindo.tfg.buysales.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

import pflorindo.tfg.buysales.data.Usuario;
import pflorindo.tfg.buysales.data.UsuarioConvert;
import pflorindo.tfg.buysales.ui.MainActivity;

public class AsyncHttpLauncher implements LoaderManager.LoaderCallbacks {

    public static final String ACTION_LOGIN = "LOGIN";
    public static final String ACTION_INSERTAR = "REGISTRO";
    private static int idTask = 0;

    private LoaderManager loaderManager;
    private Activity activityCaller;
    private Context currentContext;
    private String action;
    private String[] params;
    private Object data = null;
    private int currentTaskId;
    private boolean isFinished;

    public AsyncHttpLauncher(AppCompatActivity currentActivity, String action, String ... params){
        super();
        Log.e("method: AsyncHttpLa...", "AsyncHttpLauncher called");
        this.currentContext = currentActivity.getApplicationContext();
        this.activityCaller = currentActivity;
        this.action = action;
        this.params = params;
        AsyncHttpLauncher.idTask++;
        this.currentTaskId = idTask;
        this.loaderManager = LoaderManager.getInstance(currentActivity);
        this.isFinished = false;

        Loader loader = loaderManager.initLoader(currentTaskId, Bundle.EMPTY, this);
        loader.forceLoad();

    }

    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        Log.e("method:  onCreateLoader", "onCreateLoader called");

        Loader toReturn = null;

        switch (action) {
            case ACTION_LOGIN:
                toReturn = new AsyncHttpRequest(currentContext, Constantes.URL_EXISTE+"?correo="+params[0]);
                break;
            case ACTION_INSERTAR:
                toReturn = new AsyncHttpRequest(currentContext, Constantes.URL_INSERTAR+"?correo="+params[0]+"&pass="+params[1]);
                break;
        }


        return toReturn;
    }

    @Override
    public void onLoadFinished(@NonNull Loader loader, Object data) {
        Log.e("method: onLoadFinished", "onLoadFinished called");

        switch (action) {
            case ACTION_LOGIN:
                Toast.makeText(currentContext, "Finalizó", Toast.LENGTH_LONG).show();
                Log.e("log: data", data.toString());
                this.data = data;
                if (data.toString().equals("[]")){
                    ((MainActivity) activityCaller).loginOK(false);
                } else {
                    ((MainActivity) activityCaller).loginOK(true);
                }
                break;
        }

        this.isFinished = true;
        loader.abandon();
    }

    @Override
    public void onLoaderReset(@NonNull Loader loader) {
        Log.e("method:  onLoaderReset", "onLoaderReset called");

    }

    public Object getFinishedData(){
        Log.e("method: getFinishedData", "getFinishedData called");
        return data;
    }

    public boolean getIsFinished(){
        Log.e("method: getIsFinished", "getIsFinished called");
        return isFinished;
    }

}
