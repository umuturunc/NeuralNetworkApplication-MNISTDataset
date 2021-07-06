import java.io.FileWriter;
import java.io.IOException;

public class SonuclariKaydet {
    public void dosyayaYaz(float[] trainAccuracies, float[] testAccuracies) {
        try {
            FileWriter fileWriter = new FileWriter("output.txt");
            fileWriter.write("Rakam sınıfı\t\t\t");
            for (int i = 0; i < 10; i++)
                fileWriter.write(i + "\t");
            fileWriter.write("Ortalama\n");

            float trainOrtalama = 0;
            fileWriter.write("Train Accuracy Değerleri\t");
            for (int i = 0; i < 10; i++) {
                fileWriter.write(String.format("%.2f", trainAccuracies[i]) + "\t");
                trainOrtalama += trainAccuracies[i];
            }
            fileWriter.write(trainOrtalama / 10f + "\n");


            float testOrtalama = 0;
            fileWriter.write("Test Accuracy Değerleri\t\t");
            for (int i = 0; i < 10; i++) {
                fileWriter.write(String.format("%.2f", testAccuracies[i]) + "\t");
                testOrtalama += testAccuracies[i];
            }
            fileWriter.write(testOrtalama / 10f + "\n");

            fileWriter.flush();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
