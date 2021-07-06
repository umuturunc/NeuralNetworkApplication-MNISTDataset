import java.util.Random;

public class Neural {

    float learningRate;
    int inputSize;
    int outputSize;
    int hiddenNodeCount;

    float[] input;
    float[] output;
    float[] hidden;

    float[][] w_hidden;   //gizli katman ağırlıkları
    float[] wb_hidden;    //gizli katmandaki node'ların bias ağırlığı değerleri

    float[][] w_output;   //çıktı katmanı ağırlıkları
    float[] wb_output;    //çıktı katmandaki node'ların bias ağırlığı değerleri

    float[] e_output;     //çıktı katmanı hata değerleri
    float[] e_hidden;     //gizli katman hata değerleri

    float[] d_output;         //çıktı katmanı delta değişim değerleri
    float[] d_hidden;         //gizli katman delta değişim değerleri
    float[][] d_w_hidden;
    float[] d_wb_hidden;
    float[][] d_w_output;
    float[] d_wb_output;

    Random r;

    public Neural(int inputSize, int hiddenNodeCount, int outputSize, float learningRate) {
        this.learningRate = learningRate;
        this.inputSize = inputSize;
        this.outputSize = outputSize;
        this.hiddenNodeCount = hiddenNodeCount;

        this.input = new float[inputSize];
        this.output = new float[outputSize];
        this.hidden = new float[hiddenNodeCount];

        w_hidden = new float[hiddenNodeCount][inputSize];
        wb_hidden = new float[hiddenNodeCount];

        w_output = new float[outputSize][hiddenNodeCount];
        wb_output = new float[outputSize];

        e_output = new float[outputSize];
        e_hidden = new float[hiddenNodeCount];
        d_output = new float[outputSize];
        d_hidden = new float[hiddenNodeCount];
        d_w_hidden = new float[hiddenNodeCount][inputSize];
        d_wb_hidden = new float[hiddenNodeCount];
        d_w_output = new float[outputSize][hiddenNodeCount];
        d_wb_output = new float[outputSize];


        r = new Random();

        for (int i = 0; i < hiddenNodeCount; i++) {
            wb_hidden[i] = rastgeleDegerAta();
            for (int j = 0; j < inputSize; j++) {
                w_hidden[i][j] = rastgeleDegerAta();
            }
        }

        for (int i = 0; i < outputSize; i++) {
            wb_output[i] = rastgeleDegerAta();
            for (int j = 0; j < hiddenNodeCount; j++) {
                w_output[i][j] = rastgeleDegerAta();
            }
        }
//        System.out.println("Bitti");
    }

    public void inputAyarla(float[] degerler) {
        for (int i = 0; i < inputSize; i++) {
            input[i] = degerler[i];
        }
    }

    public void tahminEt() {

        //Gizli katmandaki her bir node'un çıktı değerini hesapla, aktivasyon fonksiyonuna sok
        for (int i = 0; i < hiddenNodeCount; i++) {
            hidden[i] = 0;
            for (int j = 0; j < inputSize; j++) {
                hidden[i] += input[j] * w_hidden[i][j];
            }
            hidden[i] += wb_hidden[i];
            hidden[i] = aktivasyonFonksiyonu(hidden[i]);
        }

        //Output katmanındaki her bir node'un çıktı değerini hesapla, aktivasyon fonksiyonuna sok
        for (int i = 0; i < outputSize; i++) {
            output[i] = 0;
            for (int j = 0; j < hiddenNodeCount; j++) {
                output[i] += hidden[j] * w_output[i][j];
            }
            output[i] += wb_output[i];
        }

        float toplam_output = 0;
        for (int i = 0; i < outputSize; i++) {
            toplam_output += Math.exp(output[i]);
        }

        if (toplam_output != 0) {
            for (int i = 0; i < outputSize; i++) {
                output[i] = (float) (Math.exp(output[i]) / toplam_output);
            }
        }

    }

    public int tahminEttigimizSinif() {
        double maxDeg = 0;
        int maxInd = 0;

        for (int i = 0; i < outputSize; i++) {
            if (output[i] >= maxDeg) {
                maxInd = i;
                maxDeg = output[maxInd];
            }
        }
        return maxInd;
    }

    public int olmasiGerekenSinif(int[][] t, int i) {
        for (int j = 0; j < outputSize; j++) {
            if (t[i][j] == 1) {
                return j;
            }
        }
        return -1;
    }

    public float dogrulukOraniHesapla(float[][] x, int veriSayisi, int[][] t ) {

        float dogrularinSayisi = 0;
        for (int i = 0; i < veriSayisi; i++) {      //bütün verileri geziyoruz

            inputAyarla(x[i]);
            tahminEt();

            int tahmin = tahminEttigimizSinif();
            int gereken = olmasiGerekenSinif(t, i);

            if (gereken == tahmin) {
                dogrularinSayisi++;
            }
        }
        return dogrularinSayisi / (float) veriSayisi;
    }

    public void egit(int[] t) {
        tahminEt();

        //Output katmanındaki hatalar hesaplandı
        for (int i = 0; i < outputSize; i++) {
            e_output[i] = (float) t[i] - output[i];
        }

        //Gerçek değer ile tahmin değeri arasındaki fark
        for (int i = 0; i < outputSize; i++) {
            d_output[i] = e_output[i];
        }

        //Output katmanındaki bias ağırlıkları güncellendi
        for (int i = 0; i < outputSize; i++) {
            for (int j = 0; j < hiddenNodeCount; j++) {
                d_w_output[i][j] = hidden[j] * d_output[i];
            }
            d_wb_output[i] = d_output[i];
        }

        // Hidden için yapılan işlemler
        for (int i = 0; i < hiddenNodeCount; i++) {
            e_hidden[i] = 0;
            for (int j = 0; j < outputSize; j++) {
                e_hidden[i] += d_output[j] * w_output[j][i];
            }
        }

        for (int i = 0; i < hiddenNodeCount; i++) {
            d_hidden[i] = e_hidden[i] * aktivasonFonksiyonuTurevi(hidden[i]);
        }

        for (int i = 0; i < hiddenNodeCount; i++) {
            for (int j = 0; j < inputSize; j++) {
                d_w_hidden[i][j] = input[j] * d_hidden[i];
            }
            d_wb_hidden[i] = d_hidden[i];
        }

        // Ağırlakları güncelle
        for (int i = 0; i < outputSize; i++) {  //Çıktı katmanı için
            for (int j = 0; j < hiddenNodeCount; j++) {
                w_output[i][j] += d_w_output[i][j] * learningRate;  //weight = weight + deltaWeight * learningRate
            }
            wb_output[i] += d_wb_output[i] * learningRate;  //weightBias = weightBias + deltaWeightBias * learningRate

        }

        for (int i = 0; i < hiddenNodeCount; i++) {     //Gizli katman için
            for (int j = 0; j < inputSize; j++) {
                w_hidden[i][j] += d_w_hidden[i][j] * learningRate;  //weight = weight + deltaWeight * learningRate
            }
            wb_hidden[i] += d_wb_hidden[i] * learningRate;  //weightBias = weightBias + deltaWeightBias * learningRate
        }

    }

    public float aktivasonFonksiyonuTurevi(float x) {
        return dsigmoid(x);
    }

    public float aktivasyonFonksiyonu(float x)  //
    {
        return sigmoid(x);
    }

    public float dsigmoid(double x) {
        return (float) (x * (1 - x));
    }

    public float sigmoid(float x) {
        return (float) (1 / (1 + Math.exp(-x)));
    }

    private float rastgeleDegerAta() {  // [-0.5,0.5] arası rastgele değer
        return (r.nextFloat() - 0.5f);
    }
}
