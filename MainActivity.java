package com.example.iksoks;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    char igrac='o';
    //matrica koja na pocetku sadrzi u svakom polju char p;
    char mat[][] = new char[3][3];

    private void zabraniClick() {
        /**
         * Ova funkcija zabranjuje kliktanje svih imageView
         * */
        ImageView im = MainActivity.this.findViewById(R.id.imageView);
        im.setClickable(false);
        im = MainActivity.this.findViewById(R.id.imageView2);
        im.setClickable(false);
        im = MainActivity.this.findViewById(R.id.imageView3);
        im.setClickable(false);
        im = MainActivity.this.findViewById(R.id.imageView4);
        im.setClickable(false);
        im = MainActivity.this.findViewById(R.id.imageView5);
        im.setClickable(false);
        im = MainActivity.this.findViewById(R.id.imageView6);
        im.setClickable(false);
        im = MainActivity.this.findViewById(R.id.imageView7);
        im.setClickable(false);
        im = MainActivity.this.findViewById(R.id.imageView8);
        im.setClickable(false);
        im = MainActivity.this.findViewById(R.id.imageView9);
        im.setClickable(false);
    }

    private void popuni() {
        for (int p = 0; p < 3; p++) {
            for (int q = 0; q < 3; q++)
                mat[p][q] = 'p';
        }
    }

    public void novaIgra(MainActivity m){
        //ova funkcija se aktivira pri pokretanju aplikacije ili klikom na dugme
igrac = 'o';
            ImageView im = m.findViewById(R.id.imageView);
            im.setImageResource(0);
            im.setClickable(true);
            im = m.findViewById(R.id.imageView2);
            im.setImageResource(0);
        im.setClickable(true);
        im = m.findViewById(R.id.imageView3);
        im.setImageResource(0);
        im.setClickable(true);

        im = m.findViewById(R.id.imageView4);
        im.setImageResource(0);
        im.setClickable(true);
        im = m.findViewById(R.id.imageView5);
        im.setImageResource(0);
        im.setClickable(true);
        im = m.findViewById(R.id.imageView6);
        im.setImageResource(0);
        im.setClickable(true);
        im = m.findViewById(R.id.imageView7);
        im.setImageResource(0);
        im.setClickable(true);
        im = m.findViewById(R.id.imageView8);
        im.setImageResource(0);
        im.setClickable(true);
        im = m.findViewById(R.id.imageView9);
        im.setImageResource(0);
        im.setClickable(true);
        TextView tv = m.findViewById(R.id.textView);
        tv.animate().translationY(-1000);

        popuni();

    }

    public void Dugme(View view){
        novaIgra(MainActivity.this);
    }
    //detektovanje pobede u vrsti, koloni i dijagonalama
    private void pobeda(char igrac){
        TextView tv= MainActivity.this.findViewById(R.id.textView);

        //provera da li je doslo do pobede u p-toj vrsti;
        for(int p=0,q;p<3;p++){
            int isti =1;
            q=0;
            char e = mat[p][q++];
            for(;q<3;q++){
                if (mat[p][q]!=e || mat[p][q]=='p') break;
                isti++;
            }
            if(isti==3) {
                System.out.print("\nPobedio je igrac "+igrac+" u "+p+" vrsti\n");
                zabraniClick();
                if(igrac =='x'){
                    tv.setText("BRAVO IKS!");


                   // tv.setTextColor(5);
                }
                else{
                    tv.setText("BRAVO OKS!");
                }
                tv.animate().translationY(200).setDuration(2000);
                //OVDE IDE KOD KADA SE DESI POBEDA U p-toj vrsti;
            }

        }
        //DETEKTUJE POBEDU U Q-TOJ KOLONI
        for(int q=0,p;q<3;q++){
            int isti =1;
            p=0;
            char e = mat[p++][q];
            for(;p<3;p++){
                if (mat[p][q]!=e || mat[p][q]=='p') break;
                isti++;
            }
            if(isti==3) {
                zabraniClick();
                if(igrac =='x'){
                    tv.setText("BRAVO IKS!");

                    // tv.setTextColor(5);
                }
                else{
                    tv.setText("BRAVO OKS!");
                }
                tv.animate().translationY(200).setDuration(2000);

                System.out.print("\nPobedio je igrac "+igrac+" u "+q+" koloni\n");
                //OVDE IDE KOD KADA SE DESI POBEDA U q-toj KOLONI;
            }

        }
        //POBEDA U GLAVNOJ DIJAGONALI
        for(int p = 0;p<3;p++){
            if(mat[p][p]=='p') break;
            if(mat[0][0]==mat[1][1] && mat[1][1]==mat[2][2]){
                zabraniClick();
                if(igrac =='x'){
                    tv.setText("BRAVO IKS!");
                    // tv.setTextColor(5);
                }
                else{
                    tv.setText("BRAVO OKS!");
                }
                tv.animate().translationY(200).setDuration(2000);

                System.out.print("\nPobedio je igrac "+igrac+" u glavnoj dijagonali");
                break;
                //kod za pobedu u glavnoj dijagonali
            }
        }
        //POBEGA U SPOREDNOJ DIJAGONALI
        for(int p=0;p<3;p++) {
            if ((mat[0][2] == mat[1][1] && mat[1][1] == mat[2][0]) && mat[1][1]!='p') {
                zabraniClick();
                if(igrac =='x'){
                    tv.setText("BRAVO IKS!");

                    // tv.setTextColor(5);
                }
                else{
                    tv.setText("BRAVO OKS!");
                }
                tv.animate().translationY(200).setDuration(2000);

                System.out.print("\nPobedio je igrac "+igrac+" u sporednoj dijagonali");
                break;
                //kod za pobedu u sporednoj dijagonali
            }
        }
    }


    public void pojava(View view){
        //za element uzimam trenutno kliknuti image view
        ImageView element = (ImageView) view;
        //U atributu tag svakog image view-a sam upisao poyiciju u matrici
        String t = (String)element.getTag();
        //i i j su intidzeri koji omogucavaju pristum elemtima matrice
        int i,j;
        element.setClickable(false);
        i = Character.getNumericValue(t.toCharArray()[0]);
        j = Character.getNumericValue(t.toCharArray()[1]);


            if (igrac != 'x') {
                element.setImageResource(R.drawable.x);
                igrac = 'x';
                mat[i][j] = 'x';
                pobeda(igrac);
            } else {
                element.setImageResource(R.drawable.o);
                igrac = 'o';
                mat[i][j] = 'o';
                pobeda(igrac);

        }
        //ispisivanje matrice u konzoli---->provera
        for (int m = 0; m < 3; m++) {
            for (int n = 0; n <3; n++) {
                System.out.print(mat[m][n] + " ");
            }
            System.out.println();
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        novaIgra(MainActivity.this);

    }
}
