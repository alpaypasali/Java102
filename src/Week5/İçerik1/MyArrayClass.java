package Week5.İçerik1;

import java.util.Random;

import java.util.Random;

public class MyArrayClass  {
    private int index;
    private int[] array;

    public MyArrayClass() {
        this.index = 10;  // Varsayılan index değeri
        this.array = new int[10];  // 10 elemanlı array oluştur
        Random random = new Random();
        for (int i = 0; i < this.array.length; i++) {
            this.array[i] = random.nextInt(100);  // 0-99 arasında rastgele sayılar ata
        }
    }

    public int set(int index) throws ArrayIndexOutOfBoundsException {
        index = index - 1;
        try {
            return  array[index];

        } catch (ArrayIndexOutOfBoundsException e) {
            throw  new ArrayIndexOutOfBoundsException(e.getMessage());
        }
    }




    public int getIndex() {
        return index;
    }



    public int[] getArray() {
        return array;
    }


}

