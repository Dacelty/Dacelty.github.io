package com.example.springbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.*;

@SpringBootApplication
public class SpringbookApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringbookApplication.class, args);
		
		Gson gson = new Gson();
		ArrayList<Book> list = new ArrayList();
		Service s = new Service();
		try (Scanner scanner = new Scanner(System.in)) {
			try {
			    FileReader reader = new FileReader("src/main/resources/MOCK_DATA.json");
			    Type type = (new TypeToken<ArrayList<Book>>() {
			    }).getType();
			    System.out.println(type);
				System.out.println("Doc du lieu tu JSON thanh cong.");
			    list = (ArrayList)gson.fromJson(reader, type);
			} catch (FileNotFoundException var6) {
			    System.out.println("Sai duong dan file.");
			}

			System.out.println();

			for (Book b : list){
				System.out.println(b.getId() + " - " + b.getTitle() + " - " + b.getAuthor() + " - " + b.getYear());
			}

			System.out.println();

			while(true){
				System.out.println("Bạn có thể thực hiện: ");
				System.out.println("1 - Sắp xếp sách theo Author");
				System.out.println("2 - Sắp xếp sách theo Title");
				System.out.println("3 - Sắp xếp sách theo Year");
				System.out.println("0 - Thoát chương trình");
				int choose = Integer.parseInt(scanner.nextLine());

				switch(choose){
					case 1:
						s.sxSachTheoAuthor(list);
						System.out.println("Danh sách sau khi sắp xếp: ");
						for (Book b : list){
							System.out.println(b.getId() + " - " + b.getTitle() + " - " + b.getAuthor() + " - " + b.getYear());
						}
						break;
					case 2:
						s.sxSachTheoTitle(list);
						System.out.println("Danh sách sau khi sắp xếp: ");
						for (Book b : list){
							System.out.println(b.getId() + " - " + b.getTitle() + " - " + b.getAuthor() + " - " + b.getYear());
						}
						break;
					case 3:
						s.sxSachTheoYear(list);
						System.out.println("Danh sách sau khi sắp xếp: ");
						for (Book b : list){
							System.out.println(b.getId() + " - " + b.getTitle() + " - " + b.getAuthor() + " - " + b.getYear());
						}
						break;
					case 0:
						System.exit(0);
						break;
					default:
			            System.out.println("Không có lựa chọn này");
				}
			}
		} catch (JsonIOException | JsonSyntaxException | NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
