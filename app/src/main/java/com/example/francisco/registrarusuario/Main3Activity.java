package com.example.francisco.registrarusuario;

import android.content.ContentResolver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class Main3Activity extends AppCompatActivity {

    ImageView imageView;

    private String[] imagenes = {"https://i.pinimg.com/originals/c0/a6/ee/c0a6ee7da0d94ed1da6b0a9ed873e665.jpg", "https://i.pinimg.com/originals/78/38/a8/7838a8f837019e74f4b9c66b0e93b537.png","https://imagenesparaperfildewasap.com/wp-content/uploads/im%C3%A1genes-graciosas-animadas-para-whatsapp-297x300.jpg"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        imageView = (ImageView)findViewById(R.id.imageView);

        Random r = new Random();

        int imagen = r.nextInt(imagenes.length);


        Picasso.get().load(imagenes[imagen]).into(imageView);




    }
}
