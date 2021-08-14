package com.example.tugas_uas_akb_10118330_if8.maps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.example.tugas_uas_akb_10118330_if8.R;


public class MapsWisata1Activity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    TextView tvDetailNamaWisata1, tvDetailBiayaMasukWisata1, tvDetailAlamatTempatWisata1;
    ImageView ivDetailMaps1;
    ImageButton btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps_wisata1);

        tvDetailNamaWisata1 = findViewById(R.id.tvDetailNamaWisata1);
        tvDetailNamaWisata1.setText(getIntent().getStringExtra("nama_tempat"));

        tvDetailBiayaMasukWisata1 = findViewById(R.id.tvDetailBiayaMasukWisata1);
        tvDetailBiayaMasukWisata1.setText("Biaya Masuk : " + getIntent().getStringExtra("biaya_masuk"));

        tvDetailAlamatTempatWisata1 = findViewById(R.id.tvDetailAlamatTempatWisata1);
        tvDetailAlamatTempatWisata1.setText("Alamat : " + getIntent().getStringExtra("alamat_tempat"));

        ivDetailMaps1 = findViewById(R.id.ivDetailMaps1);
        Glide.with(this)
                .load(getIntent().getStringExtra("gambar_tempat"))
                .into(ivDetailMaps1);
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
        Double latitude = getIntent().getDoubleExtra("latitude", 0.0);
        Double longitude = getIntent().getDoubleExtra("longitude", 0.0);

        // Add a marker in Sydney and move the camera
        LatLng wisata1 = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(wisata1).title(getIntent().getStringExtra("nama_tempat").toString()));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(wisata1));
    }
}