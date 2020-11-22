package pflorindo.tfg.buysales.data;

import com.google.gson.Gson;

import org.json.JSONObject;
import org.json.simple.JSONArray;

public class UsuarioConvert {

    private final static String userAttrName = "nombre";
    private final static String userAttrLast = "apellidos";
    private final static String userAttrKey = "clave";
    private final static String userAttrMail = "email";

    public static Usuario jsonStringToUser(String userJson) {

        Usuario toReturn = null;

        /*try {
            JSONObject json = new JSONObject(userJson);
            toReturn = new Usuario(json.getString(userAttrName),
                    json.getString(userAttrLast),
                    json.getString(userAttrKey),
                    json.getString(userAttrMail));
        }catch (Exception e) {
            e.printStackTrace();
        }*/
        Gson gson = new Gson();
        Usuario[] users = gson.fromJson(userJson, Usuario[].class);

        toReturn = users[0];

        return toReturn;
    }

}
