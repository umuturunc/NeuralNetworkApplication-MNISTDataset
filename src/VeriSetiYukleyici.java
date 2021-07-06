import java.io.File;

public class VeriSetiYukleyici {


    public void yukle(float[][] x, int[][] t, String dosyaAdi) {


        File file = new File(dosyaAdi);
        String sınıf;

        //float[][] veriler = new float[10][28*28];


        File[] klasorler = file.listFiles();

        GrayScaleImage grayScaleImage;

        int kacinciOrnek = 0;
        for (int i = 0; i < klasorler.length; i++) {        //sınıfları geziyoruz
            File kacinciKlasor = new File(klasorler[i].getAbsolutePath());
            for (int j = 0; j < kacinciKlasor.listFiles().length; j++) {        //herbir sınıftaki(klasördeki) resimleri geziyoruz
                String dosyaYolu = kacinciKlasor.listFiles()[j].getAbsolutePath();
                grayScaleImage = new GrayScaleImage(dosyaYolu);

                x[kacinciOrnek] = grayScaleImage.get1DimensionArray();

                for (int k = 0; k < 10; k++) {  //ait olduğu sınıfa 1, diğer sınıflara 0 değeri veriyoruz
                    if (k == i) t[kacinciOrnek][k] = 1;
                    else t[kacinciOrnek][k] = 0;
                }

                kacinciOrnek++;
                //grayScaleImage.printValues();
            }
            System.out.println(file.getName() + " -> " + i + ". sınıftaki veriler okundu");
        }
        System.out.println("Toplamda " + x.length + " adet veri okundu");
    }


}
