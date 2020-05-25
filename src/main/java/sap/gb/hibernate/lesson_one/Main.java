package sap.gb.hibernate.lesson_one;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import sap.gb.hibernate.lesson_one.dto.Buyer;
import sap.gb.hibernate.lesson_one.dto.Product;
import sap.gb.hibernate.lesson_one.service.Service;
import sap.gb.hibernate.lesson_one.service.ServiceImpl;

import java.util.List;
import java.util.Scanner;

@ComponentScan
public class Main {
    /**
     * Комманды:
     * getb пробел цифра - выводит продукты покупателя по переданному id
     * getp пробел цифра - выводит покупателей продукта по переданному id
     * delb пробел цифра - удаляет покупателя
     * delp пробел цифра - удаляет продукт
     * showb - выводит всех покупателей
     * showp - выводит все продукты
     */

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Main.class);
        Service service = applicationContext.getBean("service", ServiceImpl.class);

        Scanner scanner = new Scanner(System.in);
        String[] command;



        while (true) {
            System.out.println("Введите команду: ");
            command = scanner.nextLine().split("\\s");
            if (command[0].equals("getp")) {
                List<Buyer> buyers = service.getBuyersByProductId(Long.parseLong(command[1]));
                for (Buyer buyer : buyers) {
                    System.out.println(buyer);
                }
            } else if (command[0].equals("getb")) {
                List<Product> products = service.getProductsByBuyerId(Long.parseLong(command[1]));
                for (Product product : products) {
                    System.out.println(product);
                }
            } else if (command[0].equals("delb")) {
                service.deleteBuyer(Long.parseLong(command[1]));
            } else if (command[0].equals("delp")) {
                service.deleteProduct(Long.parseLong(command[1]));
            } else if (command[0].equals("showb")) {
                for (Buyer buyer : service.getAllBuyers()) {
                    System.out.println(buyer);
                }
            } else if (command[0].equals("showp")) {
                for (Product product : service.getAllProducts()) {
                    System.out.println(product);
                }
            } else if (command[0].equals("exit")) {
                break;
            }

        }
    }

}
