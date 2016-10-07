package com.echolima.mismapas;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    public String destino;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        Bundle parametros = getIntent().getExtras();
        destino = parametros.getString("destino");

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);


    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;


        // Add a marker in Sydney and move the camera
        //LatLng sydney = new LatLng(-34, 151);

        switch(destino){
            case "castillo":
                LatLng castilloSagunto = new LatLng(39.67572952737254, -0.27682827261126697);
                mMap.addMarker(new MarkerOptions()
                        .position(castilloSagunto)
                        .snippet(getResources().getString(R.string.snippet_castillo))
                        .title("Castillo de Sagunto"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(castilloSagunto,15));
                break;
            case "montaña":
                LatLng playa = new LatLng(39.69694846344338, -0.36977754381335437);
                mMap.addMarker(new MarkerOptions()
                        .position(playa)
                        .snippet(getResources().getString(R.string.snippet_montaña))
                        .title("Mirador Garbi"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(playa, 15));
                break;
            case "playa":
                LatLng cine = new LatLng(39.712676814774625, -0.1927597954574889);
                mMap.addMarker(new MarkerOptions()
                        .position(cine)
                        .snippet(getResources().getString(R.string.snippet_playa))
                        .title("Playa Malvarrosa de Corinto"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(cine, 15));
                break;
            case "cine":
                LatLng montaña = new LatLng(39.657269117856025, -0.22066415694392383);
                mMap.addMarker(new MarkerOptions()
                        .position(montaña)
                        .snippet(getResources().getString(R.string.snippet_cine))
                        .title("Alucine Sagunto"));
                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(montaña, 15));
                break;
        }


        Toast.makeText(this, "Localización actual: " + destino, Toast.LENGTH_SHORT).show();
        /*LatLng castilloSagunto = new LatLng(39.67572952737254, -0.27682827261126697);
        mMap.addMarker(new MarkerOptions().position(castilloSagunto).title("Castillo de Sagunto"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(castilloSagunto));*/
    }
}
