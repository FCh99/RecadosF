package com.example.faustocheca.recadosf.getservice;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.util.Log;

import com.example.faustocheca.recadosf.Main2Activity;
import com.example.faustocheca.recadosf.Recado;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 * <p>
 * TODO: Customize class - update intent actions, extra parameters and static
 * helper methods.
 */
public class MyIntentService extends IntentService {

    //////////////////////////////////

    private String baseUrl = "http://elrecadero-ebtm.rhcloud.com/";
    private MyRetrofitInterface myRetrofitInterface=null;
    private Call<String> recadosResp= null;
    private JSONArray jsonArray= null;
    private Context context= null;
    private ArrayList <Recado> recados=null;





    // TODO: Rename actions, choose action names that describe tasks that this
    // IntentService can perform, e.g. ACTION_FETCH_NEW_ITEMS
    private static final String ACTION_FOO = "com.example.faustocheca.recadosf.getservice.action.FOO";
    private static final String ACTION_BAZ = "com.example.faustocheca.recadosf.getservice.action.BAZ";

    // TODO: Rename parameters
    private static final String EXTRA_PARAM1 = "com.example.faustocheca.recadosf.getservice.extra.PARAM1";
    private static final String EXTRA_PARAM2 = "com.example.faustocheca.recadosf.getservice.extra.PARAM2";

    public MyIntentService() {
        super("MyIntentService");
    }

    /**
     * Starts this service to perform action Foo with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionFoo(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_FOO);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    /**
     * Starts this service to perform action Baz with the given parameters. If
     * the service is already performing a task this action will be queued.
     *
     * @see IntentService
     */
    // TODO: Customize helper method
    public static void startActionBaz(Context context, String param1, String param2) {
        Intent intent = new Intent(context, MyIntentService.class);
        intent.setAction(ACTION_BAZ);
        intent.putExtra(EXTRA_PARAM1, param1);
        intent.putExtra(EXTRA_PARAM2, param2);
        context.startService(intent);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            final String action = intent.getAction();
            if (ACTION_FOO.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionFoo(param1, param2);
            } else if (ACTION_BAZ.equals(action)) {
                final String param1 = intent.getStringExtra(EXTRA_PARAM1);
                final String param2 = intent.getStringExtra(EXTRA_PARAM2);
                handleActionBaz(param1, param2);
            }
        }
        /////////////////////////////





        // Retrofit to get data


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();



        myRetrofitInterface = retrofit.create(MyRetrofitInterface.class);

        recadosResp = myRetrofitInterface.traerRecados();

        recadosResp.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {

                try {
                    jsonArray=new JSONArray(response.body());
                    Log.i(">>jsonArray", String.valueOf(jsonArray.toString()));

                    ///////////

                    recados = new ArrayList<>();



                    for (int i=0; i<jsonArray.length();i++){



                        String fecha_hora_Rec = null;
                        String nombre_cliente_Rec= null;
                        String telefono_Rec= null;
                        String direccion_recogida_Rec= null;
                        String direccion_entrega_Rec= null;
                        String descripcion_Rec= null;
                        String fecha_hora_max_Rec= null;



                        try {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);


                      // Download json data

                            fecha_hora_Rec = jsonObject.getString("fecha_hora");
                            nombre_cliente_Rec = jsonObject.getString("nombre_cliente");
                            telefono_Rec = jsonObject.getString("telefono");
                            direccion_recogida_Rec = jsonObject.getString("direccion_recogida");
                            direccion_entrega_Rec = jsonObject.getString("direccion_entrega");
                            descripcion_Rec = jsonObject.getString("descripcion");
                            fecha_hora_max_Rec = jsonObject.getString("fecha_hora_maxima");






                        // Received Data loaded to ArrayList

                            recados.add(new Recado(fecha_hora_Rec,
                                    nombre_cliente_Rec,
                                    telefono_Rec,direccion_recogida_Rec,
                                    direccion_entrega_Rec,descripcion_Rec,
                                    fecha_hora_max_Rec));





                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }





                } catch (JSONException e) {
                    e.printStackTrace();
                }


                // Send Intent with parcelable version of ArrayList

                Intent intent1 = new Intent(getApplicationContext(), Main2Activity.class);
                intent1.putParcelableArrayListExtra("array",recados);
                intent1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Log.i(">>recados",String.valueOf(recados));
                Log.i(">>intent1",String.valueOf(intent1));

                startActivity(intent1);

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {

            }
        });


    }

    /*

    private void ordenarArrayList(ArrayList<Recado> recados) {

        Collections.sort(recados, new Comparator<Recado>() {


            @Override
            public int compare(Recado recado2, Recado recado1) {

                return recado2.getFecha_hora_Rec()
                        .compareTo(recado1.getFecha_hora_Rec());
            }
        });





    }

    // Ejemplo de String a formatear "Sep 14, 2016 12:50:03 PM" pattern


    private Date myDateFormat(String fecha) {

        Date fechaFormateada = null;
        String resultString;
        StringBuilder stringBuilder;

        // if fecha substring is Sep > crear una nueva cadena con la t de Sept

        if (fecha.substring(0, 3).equals("Sep")){    // end is exclusive

            stringBuilder = new StringBuilder(fecha);
            resultString = stringBuilder.insert(3, 't').toString();

        }else{
            resultString = fecha;
        }

        //resultString = fecha;

        Log.d (">>Metodo1 ", resultString);

        SimpleDateFormat format = new SimpleDateFormat("MMM dd, yyyy hh:mm:ss");
        try {
            fechaFormateada = format.parse(resultString);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Log.d (">>Metodo2 ", String.valueOf(fechaFormateada));

        return fechaFormateada;


    }
    */


    /**
     * Handle action Foo in the provided background thread with the provided
     * parameters.
     */
    private void handleActionFoo(String param1, String param2) {
        // TODO: Handle action Foo
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Handle action Baz in the provided background thread with the provided
     * parameters.
     */
    private void handleActionBaz(String param1, String param2) {
        // TODO: Handle action Baz
        throw new UnsupportedOperationException("Not yet implemented");
    }



}
