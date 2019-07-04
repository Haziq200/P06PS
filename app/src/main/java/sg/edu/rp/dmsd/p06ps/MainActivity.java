package sg.edu.rp.dmsd.p06ps;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = findViewById(R.id.btnNorth);
        btn2 = findViewById(R.id.btnCentral);
        btn3 = findViewById(R.id.btnEast);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);


        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                LatLng poi_default = new LatLng(1.3521, 103.8198);
                Marker cp = map.addMarker(new
                        MarkerOptions()
                        .position(poi_default)
                        .title("Singapore")
                        .snippet("")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                UiSettings ui = map.getUiSettings();
                ui.setCompassEnabled(true);
                ui.setZoomControlsEnabled(true);
            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LatLng poi_North = new LatLng(1.451208, 103.7784246);
                Marker north = map.addMarker(new
                        MarkerOptions()
                        .position(poi_North)
                        .title("HQ-North")
                        .snippet("Block 333, Admiralty Ave 3, 765654 Operating hours: 10am-5pm\n" +
                                "Tel:65433456\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));

                Toast.makeText(getBaseContext(), "North - HQ",
                        Toast.LENGTH_SHORT).show();
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_North, 15));
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LatLng poi_Central = new LatLng(1.351616, 103.808053);
                Marker central = map.addMarker(new
                        MarkerOptions()
                        .position(poi_Central)
                        .title("Central")
                        .snippet("Block 3A, Orchard Ave 3, 134542 \n" +
                                "Operating hours: 11am-8pm\n" +
                                "Tel:67788652\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                Toast.makeText(getBaseContext(), "Central",
                        Toast.LENGTH_SHORT).show();
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_Central, 15));
            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                LatLng poi_East = new LatLng(1.3497355, 103.9322365);
                Marker east = map.addMarker(new
                        MarkerOptions()
                        .position(poi_East)
                        .title("East-HQ")
                        .snippet("Block 555, Tampines Ave 3, 287788 \n" +
                                "Operating hours: 9am-5pm\n" +
                                "Tel:66776677\"\n")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                Toast.makeText(getBaseContext(), "East - HQ",
                        Toast.LENGTH_SHORT).show();
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(poi_East, 15));

            }
        });
    }
}
