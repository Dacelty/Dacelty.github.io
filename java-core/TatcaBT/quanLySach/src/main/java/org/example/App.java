package org.example;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;


public class App
{

    public static void main(String[] args )
    {
        String json = "    \"id\": 1,\n" +
                "    \"title\": \"Heaven's Burning\",\n" +
                "    \"category\": [\"Action\",\"Drama\"],\n" +
                "    \"author\": \"Shawn Calvey\",\n" +
                "    \"page_number\": 61,\n" +
                "    \"release_year\": 2009";
        Gson gson = new Gson();
        ArrayList<Book> list = new ArrayList();
        Service s = new Service();
        Scanner scanner = new Scanner(System.in);

        try {
            FileReader reader = new FileReader("src/main/book.json");
            Type type = (new TypeToken<ArrayList<Book>>() {
            }).getType();
            System.out.println(type);
            list = (ArrayList)gson.fromJson(reader, type);
        } catch (FileNotFoundException var6) {
            System.out.println("Sai đường dẫn file");
        }

        Iterator<Book> var8 = list.iterator();

        while(var8.hasNext()) {
            Book b = (Book)var8.next();
            System.out.println(b.getId() + " - " + b.getTitle() + " - " + Arrays.toString(b.getCategory()) + " - " + b.getAuthor() + " - " + b.getPage_number() + " - " + b.getRelease_year());
        }

        System.out.println();

        while (true){
            Util.menu();
            System.out.println("Lựa chọn của bạn là: ");
                int choose = Integer.parseInt(scanner.nextLine());

            switch (choose){
                case 1:
                    System.out.println("Nhập tên sách cần tìm:");
                    String fName = scanner.nextLine();
                    System.out.println("Sách cần tìm là:");
                    s.findBookByTitle(list,fName);
                    System.out.println();
                    break;
                case 2:
                    System.out.println("Nhập thể loại sách cần tìm:");
                    String fCategory = scanner.nextLine();
                    System.out.println("Sách cần tìm là:");
                    s.findBookByCategory(list,fCategory);
                    System.out.println();
                    break;
                case 3:
                    s.sxSachTheoSoTrang(list);
                    System.out.println("Danh sách sau khi sắp xếp: ");
                    for (Book b : list){
                        System.out.println(b.getId() + " - " + b.getTitle() + " - " + Arrays.toString(b.getCategory()) + " - " + b.getAuthor() + " - " + b.getPage_number() + " - " + b.getRelease_year());
                    }
                    break;
                case 4:
                    s.sxSachTheoNamXuatBan(list);
                    System.out.println("Danh sách sau khi sắp xếp: ");
                    for (Book b : list){
                        System.out.println(b.getId() + " - " + b.getTitle() + " - " + Arrays.toString(b.getCategory()) + " - " + b.getAuthor() + " - " + b.getPage_number() + " - " + b.getRelease_year());
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Không có lựa chọn này");
            }
        }

    }
}
