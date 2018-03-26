package com.travis.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.firebase.client.DataSnapshot;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.kairos.*;
import org.json.JSONException;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import android.Manifest;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import static android.Manifest.permission.ACCESS_COARSE_LOCATION;
import static android.Manifest.permission.ACCESS_FINE_LOCATION;
import static android.content.ContentValues.TAG;

public class AttendanceActivity extends AppCompatActivity {

    String image1,image2,image3,image4,image5;
    int class_selected=0;
    int class_id;
    int teacher_selected=0;
    int teacher_id;
    int latitude_1,latitude_2,longitude_1,longitude_2;
    String newSSID,newPASS;
    private ArrayList<String> permissionsToRequest;
    private ArrayList<String> permissionsRejected = new ArrayList<>();
    private ArrayList<String> permissions = new ArrayList<>();
    private final static int ALL_PERMISSIONS_RESULT = 101;
    LocationTrack locationTrack;
    public static final int PICK_USER_PROFILE_IMAGE = 1000;
    Bitmap bmp;
    Kairos myKairos = new Kairos();
    String galleryId = "friends";
    private static final int CAMERA_CAPTURE_IMAGE_REQUEST_CODE = 100;
    private static final int CAMERA_CAPTURE_VIDEO_REQUEST_CODE = 200;
    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private static final String IMAGE_DIRECTORY_NAME = "Hello Camera";
    private Uri fileUri;
    EditText roll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendance);
        final TextView title1 = findViewById(R.id.title1_class);
        final TextView title2 = findViewById(R.id.title2_class);
        final TextView title3 = findViewById(R.id.title3_class);
        final TextView title4 = findViewById(R.id.title4_class);
        final TextView title5 = findViewById(R.id.title5_class);
        final TextView title6 = findViewById(R.id.title6_class);
        final TextView room1 = findViewById(R.id.room1_class);
        final TextView room2 = findViewById(R.id.room2_class);
        final TextView room3 = findViewById(R.id.room3_class);
        final TextView room4 = findViewById(R.id.room4_class);
        final TextView room5 = findViewById(R.id.room5_class);
        final TextView room6 = findViewById(R.id.room6_class);
        final TextView name1 = findViewById(R.id.title1_hostel);
        final TextView name2 = findViewById(R.id.title2_hostel);
        final TextView name3 = findViewById(R.id.title3_hostel);
        final TextView name4 = findViewById(R.id.title4_hostel);
        final TextView name5 = findViewById(R.id.title5_hostel);
        final TextView name6 = findViewById(R.id.title6_hostel);
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
        roll = findViewById(R.id.enter_roll);

        Toolbar mTopToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(mTopToolbar);
        class1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(class_selected==0) {
                    class1.setBackgroundColor(getResources().getColor(R.color.amber));
                    title1.setTextColor(getResources().getColor(R.color.black));
                    room1.setTextColor(getResources().getColor(R.color.black));
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
                    title2.setTextColor(getResources().getColor(R.color.black));
                    room2.setTextColor(getResources().getColor(R.color.black));
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
                    title3.setTextColor(getResources().getColor(R.color.black));
                    room3.setTextColor(getResources().getColor(R.color.black));
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
                    title4.setTextColor(getResources().getColor(R.color.black));
                    room4.setTextColor(getResources().getColor(R.color.black));
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
                    title5.setTextColor(getResources().getColor(R.color.black));
                    room5.setTextColor(getResources().getColor(R.color.black));
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
                    title6.setTextColor(getResources().getColor(R.color.black));
                    room6.setTextColor(getResources().getColor(R.color.black));
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
                    name1.setTextColor(getResources().getColor(R.color.black));
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
                    name2.setTextColor(getResources().getColor(R.color.black));
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
                    name3.setTextColor(getResources().getColor(R.color.black));
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
                    name4.setTextColor(getResources().getColor(R.color.black));
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
                    name5.setTextColor(getResources().getColor(R.color.black));
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
                    name6.setTextColor(getResources().getColor(R.color.black));
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

        String app_id = "2ea9db6c";
        String api_key = "f9269c59b261f7d5a4c4c874c58130e2";
        myKairos.setAuthentication(this, app_id, api_key);
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG,"Permission is granted");
            } else {

                Log.v(TAG,"Permission is revoked");
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
            }
        }
        else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG,"Permission is granted");
        }
        KairosListener listener1 = new KairosListener() {

            @Override
            public void onSuccess(String response) {

                Log.d("KAIROS en su DEMO", response);
            }

            @Override
            public void onFail(String response) {
                // your code here!
                Log.d("KAIROS en fa DEMO", response);
            }
        };

        final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
        final String rollno = roll.getText().toString();
        final DatabaseReference url1 = ref.child("androidchatapp-59bff").child("attendance").child(rollno).child("string1");
        final DatabaseReference url2 = ref.child("androidchatapp-59bff").child("attendance").child(rollno).child("string2");
        final DatabaseReference url3 = ref.child("androidchatapp-59bff").child("attendance").child(rollno).child("string3");
        final DatabaseReference url4 = ref.child("androidchatapp-59bff").child("attendance").child(rollno).child("string4");
        final DatabaseReference url5 = ref.child("androidchatapp-59bff").child("attendance").child(rollno).child("string5");


        url1.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                image1 = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        url2.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                image2 = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        url3.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                image3 = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        url4.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                image4 = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        url5.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
                image5 = dataSnapshot.getValue(String.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        try {
            String subjectId1 = "gElizabeth";
            String subjectId2 = "fElizabeth";
            String subjectId3 = "dElizabeth";
            String subjectId4 = "sElizabeth";
            String subjectId5 = "aElizabeth";
            myKairos.enroll(image1, subjectId1, galleryId, null, null, null, listener1);
            myKairos.enroll(image2, subjectId2, galleryId, null, null, null, listener1);
            myKairos.enroll(image3, subjectId3, galleryId, null, null, null, listener1);
            myKairos.enroll(image4, subjectId4, galleryId, null, null, null, listener1);
            myKairos.enroll(image5, subjectId5, galleryId, null, null, null, listener1);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        permissions.add(ACCESS_FINE_LOCATION);
        permissions.add(ACCESS_COARSE_LOCATION);
        permissionsToRequest = findUnAskedPermissions(permissions);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (permissionsToRequest.size() > 0)
                requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
        }
        Button btn = (Button) findViewById(R.id.mark);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captureImage();
                locationTrack = new LocationTrack(AttendanceActivity.this);
                if (locationTrack.canGetLocation()) {
                    double longitude = locationTrack.getLongitude();
                    double latitude = locationTrack.getLatitude();
                    Toast.makeText(getApplicationContext(), "Longitude:" + Double.toString(longitude) + "\nLatitude:" + Double.toString(latitude), Toast.LENGTH_SHORT).show();
                } else {
                    locationTrack.showSettingsAlert();
                }
            }
        });
        if (!isDeviceSupportCamera()) {
            Toast.makeText(getApplicationContext(),
                    "Sorry! Your device doesn't support camera",
                    Toast.LENGTH_LONG).show();
            finish();
        }
    }
    private ArrayList<String> findUnAskedPermissions(ArrayList<String> wanted) {
        ArrayList<String> result = new ArrayList<String>();

        for (String perm : wanted) {
            if (!hasPermission(perm)) {
                result.add(perm);
            }
        }
        return result;
    }
    private boolean hasPermission(String permission) {
        if (canMakeSmores()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
            }
        }
        return true;
    }
    private boolean canMakeSmores() {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }
    @TargetApi(Build.VERSION_CODES.M)
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode) {
            case ALL_PERMISSIONS_RESULT:
                for (String perms : permissionsToRequest) {
                    if (!hasPermission(perms)) {
                        permissionsRejected.add(perms);
                    }
                }
                if (permissionsRejected.size() > 0) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        if (shouldShowRequestPermissionRationale(permissionsRejected.get(0))) {
                            showMessageOKCancel("These permissions are mandatory for the application. Please allow access.",
                                    new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                                                requestPermissions(permissionsRejected.toArray(new String[permissionsRejected.size()]), ALL_PERMISSIONS_RESULT);
                                            }
                                        }
                                    });
                            return;
                        }
                    }
                }
                break;
        }
    }
    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
        new android.support.v7.app.AlertDialog.Builder(AttendanceActivity.this)
                .setMessage(message)
                .setPositiveButton("OK", okListener)
                .setNegativeButton("Cancel", null)
                .create()
                .show();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        locationTrack.stopListener();
    }
    private boolean isDeviceSupportCamera() {
        if (getApplicationContext().getPackageManager().hasSystemFeature(
                PackageManager.FEATURE_CAMERA)) {
            return true;
        } else {
            return false;
        }
    }
    private void captureImage() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
        startActivityForResult(intent, CAMERA_CAPTURE_IMAGE_REQUEST_CODE);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelable("file_uri", fileUri);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        fileUri = savedInstanceState.getParcelable("file_uri");
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_CAPTURE_IMAGE_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                previewCapturedImage();
            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled Image capture
                Toast.makeText(getApplicationContext(),
                        "User cancelled image capture", Toast.LENGTH_SHORT)
                        .show();
            } else {
                // failed to capture image
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to capture image", Toast.LENGTH_SHORT)
                        .show();
            }
        } else if (requestCode == CAMERA_CAPTURE_VIDEO_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                // video successfully recorded
                // preview the recorded video

            } else if (resultCode == RESULT_CANCELED) {
                // user cancelled recording
                Toast.makeText(getApplicationContext(),
                        "User cancelled video recording", Toast.LENGTH_SHORT)
                        .show();
            } else {
                // failed to record video
                Toast.makeText(getApplicationContext(),
                        "Sorry! Failed to record video", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }
    private void previewCapturedImage() {
        KairosListener listener = new KairosListener() {
            @Override
            public void onSuccess(String response) {
                if ((response.indexOf("no match found") !=-1? true: false)==true){
                    Toast.makeText(AttendanceActivity.this, "Sorry! Its a proxy", Toast.LENGTH_SHORT).show();
                }
                else{
                    final DatabaseReference ref = FirebaseDatabase.getInstance().getReference();
                    final String rollno = roll.getText().toString();
                    final DatabaseReference a = ref.child("record").child(rollno);
                    a.addListenerForSingleValueEvent(new com.google.firebase.database.ValueEventListener() {
                        @Override
                        public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {


                            Date c = Calendar.getInstance().getTime();
                            String date = c.toString();


                            String one = dataSnapshot.getValue(String.class);


                                one = one + " " + date;
                                a.setValue(one);

                        }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {

                        }
                    });

                    Toast.makeText(AttendanceActivity.this, "Attendance Marked", Toast.LENGTH_SHORT).show();
                }
                Log.d("KAIROS en su DEMO", response);
            }
            @Override
            public void onFail(String response) {
                Toast.makeText(AttendanceActivity.this, "Sorry! Its a proxy", Toast.LENGTH_SHORT).show();
            }
        };
        try {

            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inSampleSize = 8;
            final Bitmap bitmap = BitmapFactory.decodeFile(fileUri.getPath(),
                    options);
            myKairos.recognize(bitmap, galleryId, null, null, null, null, listener);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
    /**
     * ------------ Helper Methods ----------------------
     * */

    /**
     * Creating file uri to store image/video
     */
    public Uri getOutputMediaFileUri(int type) {
        return Uri.fromFile(getOutputMediaFile(type));
    }
    /**
     * returning image / video
     */
    private static File getOutputMediaFile(int type) {
        File mediaStorageDir = new File(
                Environment
                        .getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES),
                IMAGE_DIRECTORY_NAME);
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d(IMAGE_DIRECTORY_NAME, "Oops! Failed create "
                        + IMAGE_DIRECTORY_NAME + " directory");
                return null;
            }
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss",
                Locale.getDefault()).format(new Date());
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "IMG_" + timeStamp + ".jpg");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator
                    + "VID_" + timeStamp + ".mp4");
        } else {
            return null;
        }
        return mediaFile;
    }

}






