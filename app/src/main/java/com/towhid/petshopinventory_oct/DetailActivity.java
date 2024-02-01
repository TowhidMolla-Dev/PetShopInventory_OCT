package com.towhid.petshopinventory_oct;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.towhid.petshopinventory_oct.HomeFragment;
import com.towhid.petshopinventory_oct.MainActivity;
import com.towhid.petshopinventory_oct.R;
import com.towhid.petshopinventory_oct.UploadActivity;

public class DetailActivity extends AppCompatActivity {
    ImageButton detailArrowBtn;
    TextView detailPetName, detailPetType, detailDesc, detailCage,detailSellerName,detailSellerAddress,detailPrice,detailDate;
    ImageView detailImage;
    FloatingActionButton deleteButton, editButton;
    String key = "";
    String imageUrl = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        detailPetName = findViewById(R.id.detailPetName);
        detailPetType = findViewById(R.id.detailPetType);
        detailDesc = findViewById(R.id.detailDesc);
        detailCage = findViewById(R.id.detailCage);
        detailSellerName = findViewById(R.id.detailSellerName);
        detailSellerAddress = findViewById(R.id.detailSellerAddress);
        detailPrice = findViewById(R.id.detailPrice);
        detailDate = findViewById(R.id.detailDate);
        detailImage = findViewById(R.id.detailImage);
        deleteButton = findViewById(R.id.deleteButton);
        editButton = findViewById(R.id.editButton);

        detailArrowBtn = findViewById(R.id.detailArrowBtn);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            detailPetType.setText(bundle.getString("Pet Type"));
            detailPetName.setText(bundle.getString("Pet Name"));
            detailDesc.setText(bundle.getString("Pet Description"));
            detailCage.setText(bundle.getString("Cage No"));
            detailSellerName.setText(bundle.getString("Seller Name"));
            detailSellerAddress.setText(bundle.getString("Seller Address"));
            detailPrice.setText(bundle.getString("Price"));
            detailDate.setText(bundle.getString("Purchase Date"));
            key = bundle.getString("Key");
            imageUrl = bundle.getString("Image");
            Glide.with(this).load(bundle.getString("Image")).into(detailImage);
        }
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final DatabaseReference reference = FirebaseDatabase.getInstance().getReference("PetShopDB_FireBase");
                FirebaseStorage storage = FirebaseStorage.getInstance();
                StorageReference storageReference = storage.getReferenceFromUrl(imageUrl);
                storageReference.delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        reference.child(key).removeValue();
                        Toast.makeText(DetailActivity.this, "Deleted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        finish();
                    }
                });
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DetailActivity.this, UpdateActivity.class)
                        .putExtra("Pet Name", detailPetName.getText().toString())
                        .putExtra("Description", detailPetType.getText().toString())
                        .putExtra("Cage No", detailCage.getText().toString())
                        .putExtra("Image", imageUrl)
                        .putExtra("Key", key);
                startActivity(intent);
            }
        });
    }
}