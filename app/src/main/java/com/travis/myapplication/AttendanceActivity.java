package com.travis.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class AttendanceActivity extends AppCompatActivity {

    int class_selected=0;
    int class_id;
    int teacher_selected=0;
    int teacher_id;

    int latitude_1,latitude_2,longitude_1,longitude_2;
    String newSSID,newPASS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        final RelativeLayout class1 = findViewById(R.id.class1);
        final RelativeLayout class2 = findViewById(R.id.class2);
        final RelativeLayout class3 = findViewById(R.id.class3);
        final RelativeLayout class4 = findViewById(R.id.class4);
        final RelativeLayout class5 = findViewById(R.id.class5);
        final RelativeLayout class6 = findViewById(R.id.class6);
        final RelativeLayout teacher1 = findViewById(R.id.teacher1);
        final RelativeLayout teacher2 = findViewById(R.id.teacher2);
        final RelativeLayout teacher3 = findViewById(R.id.teacher3);
        final RelativeLayout teacher4 = findViewById(R.id.teacher4);
        final RelativeLayout teacher5 = findViewById(R.id.teacher5);
        final RelativeLayout teacher6 = findViewById(R.id.teacher6);

        class1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(class_selected==0) {
                    class1.setBackgroundColor(getResources().getColor(R.color.amber));
                    class_selected=1;
                    class_id=1;
                }
            }
        });
        class2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(class_selected==0) {
                    class2.setBackgroundColor(getResources().getColor(R.color.amber));
                    class_selected=1;
                    class_id=2;
                }
            }
        });
        class3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(class_selected==0) {
                    class3.setBackgroundColor(getResources().getColor(R.color.amber));
                    class_selected=1;
                    class_id=3;
                }
            }
        });
        class4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(class_selected==0) {
                    class4.setBackgroundColor(getResources().getColor(R.color.amber));
                    class_selected=1;
                    class_id=4;
                }
            }
        });
        class5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(class_selected==0) {
                    class5.setBackgroundColor(getResources().getColor(R.color.amber));
                    class_selected=1;
                    class_id=5;
                }
            }
        });
        class6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(class_selected==0) {
                    class6.setBackgroundColor(getResources().getColor(R.color.amber));
                    class_selected=1;
                    class_id=6;
                }
            }
        });
        teacher1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teacher_selected==0) {
                    teacher1.setBackgroundColor(getResources().getColor(R.color.amber));
                    teacher_selected=1;
                    teacher_id=1;
                }
            }
        });
        teacher2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teacher_selected==0) {
                    teacher2.setBackgroundColor(getResources().getColor(R.color.amber));
                    teacher_selected=1;
                    teacher_id=2;
                }
            }
        });
        teacher3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teacher_selected==0) {
                    teacher3.setBackgroundColor(getResources().getColor(R.color.amber));
                    teacher_selected=1;
                    teacher_id=3;
                }
            }
        });
        teacher4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teacher_selected==0) {
                    teacher4.setBackgroundColor(getResources().getColor(R.color.amber));
                    teacher_selected=1;
                    teacher_id=4;
                }
            }
        });
        teacher5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teacher_selected==0) {
                    teacher5.setBackgroundColor(getResources().getColor(R.color.amber));
                    teacher_selected=1;
                    teacher_id=5;
                }
            }
        });
        teacher6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(teacher_selected==0) {
                    teacher6.setBackgroundColor(getResources().getColor(R.color.amber));
                    teacher_selected=1;
                    teacher_id=6;
                }
            }
        });

        switch(class_id)
        {
            case 1: break;
            //Link Firebase
            case 2: latitude_1=0;
                    latitude_2=0;
                    longitude_1=0;
                    longitude_2=0;
                    break;
            case 3: break;
            case 4: break;
            case 5: break;
            case 6: break;
            default: break;
        }

        switch(teacher_id)
        {
            case 1: break;
            //Link Firebase
            case 2: newSSID=" ";
                    newPASS=" ";
                    break;
            case 3: break;
            case 4: break;
            case 5: break;
            case 6: break;
            default: break;
        }








    }
}
