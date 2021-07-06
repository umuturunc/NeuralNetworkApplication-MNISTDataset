import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // write your code here
        String egitimDosyaYolu = "C:\\Users\\Umut\\IdeaProjects\\Odev\\src\\odev-data\\mnist-train";
        String testDosyaYolu = "C:\\Users\\Umut\\IdeaProjects\\Odev\\src\\odev-data\\mnist-test";

        int trainSize = 2000;
        int testSize = 1000;
        int hiddenNodeCount = 30;
        int inputSize = 28 * 28; //her bir resimdeki pixel adedi kadar input değerimiz var
        int outputSize = 10; //Toplanda 10 sınıfımız olduğu için çıktı katmanında 10 node mevcut
        int maxEpoch = 100;
        float learningRate = 0.01f;

        //train verileri hazırlık
        float[][] x = new float[trainSize][28 * 28]; //inputlar/veriler
        int[][] t = new int[trainSize][10];      // verilerin gerçek değerleri
        //eğer veri gerçekte 5 rakamına ait ise 5.indise 1, diğer indislere 0 değeri saklıyorum
        VeriSetiYukleyici veriSetiYukleyici = new VeriSetiYukleyici();
        veriSetiYukleyici.yukle(x, t, egitimDosyaYolu);

        //test verileri hazırlık
        float[][] xTest = new float[testSize][28 * 28];
        int[][] tTest = new int[testSize][10];
        veriSetiYukleyici.yukle(xTest, tTest, testDosyaYolu);


        Neural neural = new Neural(inputSize, hiddenNodeCount, outputSize, learningRate);

        for (int epoch = 0; epoch < maxEpoch; epoch++) {
            for (int ornek = 0; ornek < trainSize; ornek++) {
                neural.inputAyarla(x[ornek]);
                neural.egit(t[ornek]);
            }
            // Bütün örnekler üzerinden geçildi
            // Doğruluk hesapla
            float trainAcuracy = neural.dogrulukOraniHesapla(x, trainSize, t);
            System.out.println(epoch + ". epoch " + "Train Genel Accuracy: " + trainAcuracy);
        }


        float[] trainAccuracies = new float[10];
        float[] testAccuracies = new float[10];

        for (int i = 0; i < 10; i++) {
            float[][] parca_x = Arrays.copyOfRange(x, i * 200, (i + 1) * 200); //her bir sınıftaki verileri parça parça tutup sınıfların train accuracy hesabını yapacağız
            int[][] parca_t = Arrays.copyOfRange(t, i * 200, (i + 1) * 200);
            float trainClassAccuracy = neural.dogrulukOraniHesapla(parca_x, 200, parca_t);
            trainAccuracies[i] = trainClassAccuracy;
            System.out.println(i + ". sınıf için Train Accuracy: " + trainClassAccuracy);
        }

        for (int i = 0; i < 10; i++) {
            float[][] parca_x = Arrays.copyOfRange(xTest, i * 100, (i + 1) * 200); //her bir sınıftaki verileri parça parça tutup sınıfların test accuracy hesabını yapacağız
            int[][] parca_t = Arrays.copyOfRange(tTest, i * 100, (i + 1) * 200);
            float testClassAccuracy = neural.dogrulukOraniHesapla(parca_x, 100, parca_t);
            testAccuracies[i] = testClassAccuracy;
            System.out.println(i + ". sınıf için Test Accuracy: " + testClassAccuracy);
        }

        SonuclariKaydet sonuclariKaydet = new SonuclariKaydet();    //Sonuçları tablo şeklinde dosyaya yazdırma
        sonuclariKaydet.dosyayaYaz(trainAccuracies, testAccuracies);


    }

}

