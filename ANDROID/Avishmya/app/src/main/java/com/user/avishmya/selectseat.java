package com.user.avishmya;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class selectseat extends AppCompatActivity {

    String arr[],rsv[];
    int myseat[];
    TextView seatresv;
    static String number,str="",st="";
    ImageView seat[];
    int count=0;
    ImageView st1,st2,st3,st4,st5,st6,st7,st8,st9,st10,st11,st12,st13,st14,st15,st16,st17,st18,st19,st20,st21,st22,st23,st24,st25,st26,st27,st28,st29,st30,st31,st32,st33,st34,st35,st36,st37,st38,st39,st40,st41,st42,st43,st44,st45,st46,st47,st48,st49,st50,st51,st52,st53,st54,st55,st56,st57,st58,st59,st60;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectseat);
        DisplayMetrics dm=new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width=dm.widthPixels;
        int height=dm.heightPixels;
        Bundle bundle=getIntent().getExtras();
        number=bundle.getString("no");
        //number=""+(Integer.parseInt(number)-1);
        //getWindow().setLayout((int)(width*.10),(int)(height*.10));
        myseat=new int[Integer.parseInt(number)];
        //myseat[0]=33;
       // Toast.makeText(selectseat.this,""+myseat[0], Toast.LENGTH_SHORT).show();

        seatresv=(TextView)findViewById(R.id.seatt);

        st1=(ImageView)findViewById(R.id.st1);
        st2=(ImageView)findViewById(R.id.st2);
        st3=(ImageView)findViewById(R.id.st3);
        st4=(ImageView)findViewById(R.id.st4);
        st5=(ImageView)findViewById(R.id.st5);
        st6=(ImageView)findViewById(R.id.st6);
        st7=(ImageView)findViewById(R.id.st7);
        st8=(ImageView)findViewById(R.id.st8);
        st9=(ImageView)findViewById(R.id.st9);
        st10=(ImageView)findViewById(R.id.st10);
        st11=(ImageView)findViewById(R.id.st11);
        st12=(ImageView)findViewById(R.id.st12);
        st13=(ImageView)findViewById(R.id.st13);
        st14=(ImageView)findViewById(R.id.st14);
        st15=(ImageView)findViewById(R.id.st15);
        st16=(ImageView)findViewById(R.id.st16);
        st17=(ImageView)findViewById(R.id.st17);
        st18=(ImageView)findViewById(R.id.st18);
        st19=(ImageView)findViewById(R.id.st19);
        st20=(ImageView)findViewById(R.id.st20);
        st21=(ImageView)findViewById(R.id.st21);
        st22=(ImageView)findViewById(R.id.st22);
        st23=(ImageView)findViewById(R.id.st23);
        st24=(ImageView)findViewById(R.id.st24);
        st25=(ImageView)findViewById(R.id.st25);
        st26=(ImageView)findViewById(R.id.st26);
        st27=(ImageView)findViewById(R.id.st27);
        st28=(ImageView)findViewById(R.id.st28);
        st29=(ImageView)findViewById(R.id.st29);
        st30=(ImageView)findViewById(R.id.st30);
        st31=(ImageView)findViewById(R.id.st31);
        st32=(ImageView)findViewById(R.id.st32);
        st33=(ImageView)findViewById(R.id.st33);
        st34=(ImageView)findViewById(R.id.st34);
        st35=(ImageView)findViewById(R.id.st35);
        st36=(ImageView)findViewById(R.id.st36);
        st37=(ImageView)findViewById(R.id.st37);
        st38=(ImageView)findViewById(R.id.st38);
        st39=(ImageView)findViewById(R.id.st39);
        st40=(ImageView)findViewById(R.id.st40);
        st41=(ImageView)findViewById(R.id.st41);
        st42=(ImageView)findViewById(R.id.st42);
        st43=(ImageView)findViewById(R.id.st43);
        st44=(ImageView)findViewById(R.id.st44);
        st45=(ImageView)findViewById(R.id.st45);
        st46=(ImageView)findViewById(R.id.st46);
        st47=(ImageView)findViewById(R.id.st47);
        st48=(ImageView)findViewById(R.id.st48);
        st49=(ImageView)findViewById(R.id.st49);
        st50=(ImageView)findViewById(R.id.st50);
        st51=(ImageView)findViewById(R.id.st51);
        st52=(ImageView)findViewById(R.id.st52);
        st53=(ImageView)findViewById(R.id.st53);
        st54=(ImageView)findViewById(R.id.st54);
        st55=(ImageView)findViewById(R.id.st55);
        st56=(ImageView)findViewById(R.id.st56);
        st57=(ImageView)findViewById(R.id.st57);
        st58=(ImageView)findViewById(R.id.st58);
        st59=(ImageView)findViewById(R.id.st59);
        st60=(ImageView)findViewById(R.id.st60);
        seat= new ImageView[]{st1, st2, st3, st4, st5, st6, st7, st8, st9, st10, st11, st12, st13, st14, st15, st16, st17, st18, st19, st20, st21, st22, st23, st24, st25, st26, st27, st28, st29, st30, st31, st32, st33, st34, st35, st36, st37, st38, st39, st40, st41, st42, st43, st44, st45, st46, st47, st48, st49, st50, st51, st52, st53, st54, st55, st56, st57, st58, st59, st60};

        StringRequest stringRequest = new StringRequest
                (Request.Method.POST, Data.URL + "avlseat.jsp",
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                String ak[]=response.toString().trim().split("=");
                                rsv=ak;
                                for(int i=0;i<ak.length;i++){
                                    seat[Integer.parseInt(ak[i])-1].setBackgroundColor(Color.parseColor("#ff4040"));
                                }

                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_LONG).show();
                            }
                        }) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("code","hhh");
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(stringRequest);


        for(int i=0;i<seat.length;i++){
            final int finalI = i;
            seat[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(selectseat.this, ""+(finalI+1), Toast.LENGTH_SHORT).show();
                    if(chk(finalI)){
                        Toast.makeText(selectseat.this, "Sorry it's reserved", Toast.LENGTH_SHORT).show();
                    }
                    else {
                        if(count <= Integer.parseInt(number)) {
                            seat[finalI].setBackgroundColor(Color.parseColor("#FF0CAA07"));
                            boolean b=false;
                            for(int j=0;j<myseat.length;j++){
                                if(myseat[j]==(finalI+1)){
                                    b=true;
                                    break;
                                }
                            }
                            if(b){
                                seat[finalI].setBackgroundColor(Color.parseColor("#0008ff00"));
                                for(int k=0;k<myseat.length;k++){
                                    if(myseat[k]==(finalI+1)){
                                       myseat[k]=0;
                                        break;
                                    }
                                }
                                count--;
                            }
                           else {
                                for(int m=0;m<myseat.length;m++){
                                    if(myseat[m]==0){
                                        myseat[m]=finalI+1;
                                        break;
                                    }
                                }
                                count++;
                            }
                           if(count==Integer.parseInt(number)){
                               boolean bl=false;
                               String k="";
                               for(int i=0;i<myseat.length;i++){
                                   if(bl){k=k+",";}
                                   k=k+myseat[i];
                                   bl=true;
                               }
                                st=k;
                                Intent i = new Intent(getApplicationContext(), seat.class);
                                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                                startActivity(i);
                            }
                          //  seatresv.setText(str);
                        }
                    }
                }
            });
        }


    }

    boolean chk(int j){
        boolean rtn=false;
        for(int i=0;i<rsv.length;i++){
            if((j+1)==Integer.parseInt(rsv[i])){
                rtn=true;
                break;
            }
        }
        return rtn;
    }
}
