package Week5.İçerik2.PatikaStore;

import java.util.*;

public class Main {
    public static void main(String[] args) {


        List<Brand> brandList = Arrays.asList(
                new Brand("Samsung"),
                new Brand("Lenovo"),
                new Brand("Apple"),
                new Brand("Huawei"),
                new Brand("Casper"),
                new Brand("Asus"),
                new Brand("HP"),
                new Brand("Xiaomi"),
                new Brand("Monster")
        );

        List<Phone> phoneList = new ArrayList<>();

        Phone phone1 = new Phone(1, "SAMSUNG GALAXY A51",  brandList.get(0), 3199, 128, 6,6.5,  4000, "Siyah", 32 );
        Phone phone2 = new Phone(2,  "iPhone 11 64 GB",  brandList.get(2), 7379, 64, 6,6.1, 3046, "Mavi" ,5);
        Phone phone3 = new Phone(3,"Redmi Note 10 Pro 8GB",brandList.get(4),4012,128,12,6.5,4000,"Beyaz",35);
        phoneList.add(phone1);
        phoneList.add(phone2);
        phoneList.add(phone3);
        List<Notebook> notebookList = new ArrayList<>();
        Notebook notebook1 = new Notebook(1, "HUAWEI Matebook 14", brandList.get(3), 7000, 512, 14 ,14.0);
        Notebook notebook2 = new Notebook(2, "LENOVO V14 IGL", brandList.get(1), 3699, 1024, 8,14.0);
        Notebook notebook3 = new Notebook(3,"ASUS Tuf Gaming",brandList.get(5),8199,2048,32,15.6);
        notebookList.add(notebook1);
        notebookList.add(notebook2);
        notebookList.add(notebook3);

        boolean exit = false;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the PatikaStore Product Management Panel!");
        System.out.println("=========================================");
        while (!exit) {
            System.out.println("1 - Notebook Operations");
            System.out.println("2 - Mobile Phone Operations");
            System.out.println("3 - List Brands");
            System.out.println("0 - Exit");
            System.out.print("Your choice: ");
            int select = scanner.nextInt();
            switch (select){
                case 1:
                    System.out.println("----------------------------------------------------------------------------------------------------");

                    System.out.println("| ID | Product Name | Price  | Brand  | Storage  | Screen | RAM  |");
                    for (Notebook notebook : notebookList) {
                        System.out.println(notebook.toString());
                    }

                    System.out.println("----------------------------------------------------------------------------------------------------");
                    break;
                case 2:
                    System.out.println("----------------------------------------------------------------------------------------------------");

                    System.out.println("| ID | Product Name | Price  | Brand  | Storage  | Screen | Camera | Battery | RAM  | Color |");
                    for (Phone phone : phoneList) {

                        System.out.println(phone.toString());
                    }

                    System.out.println("----------------------------------------------------------------------------------------------------");

                    break;
                case 3:
                    System.out.println("Markalarımız");
                    System.out.println("--------------");
                    TreeSet<Brand> brands = new TreeSet<>(new OrderNameComperator());
                    brands.addAll(brandList);
                    for (Brand br : brands) {
                        System.out.println(br.getName());
                    }
                    System.out.println("----------------------");
                    break;
                case 0:
                    exit=true;
                    break;
                default:
                    // Geçersiz bir seçenek seçildiğinde kullanıcıya uyarı mesajı gösterilir.
                    System.out.println("Geçersiz bir seçim yaptınız. Lütfen tekrar deneyin.");
                    break;

            }



        }
        }

    }

