package fptaptech;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static AddressBook addressBook = new AddressBook();

    public static void main(String[] args) {

        while (true) {
            System.out.println("1.Them lien he moi");
            System.out.println("2.Tim lien lac theo ten");
            System.out.println("3.Hien thi danh sach");
            System.out.println("4.Thoat");
            System.out.print("Nhap tuy chon cua ban: ");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    handleAddNewContact();
                    break;
                case 2:
                    handleFindContactByName();
                    break;
                case 3:
                    handleDisplayContacts();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
            }
        }
    }

    private static void handleDisplayContacts() {
        HashMap<String, Contact> contacts = addressBook.getAddressBook();
        Iterator iterator = contacts.entrySet().iterator();

        System.out.println("So dia chi");
        System.out.println(String.format("%-20s| %s", "Ten Lien Lac", "So Dien thoai"));
        while (iterator.hasNext()) {
            Map.Entry pair = (Map.Entry) iterator.next();
            Contact contact = (Contact) pair.getValue();
            System.out.println(String.format("%-20s| %s", contact.getName() , contact.getPhone()));
        }
        System.out.println();
    }

    private static void handleFindContactByName() {
        System.out.print("Nhap ten lien he de tim kiem: ");
        String name = scanner.next();
        Contact contact = addressBook.findByName(name);
        if (contact != null) {
            System.out.println();
                System.out.println(String.format("%-20s| %s", "Ten lien he", "So dien thoai"));
            System.out.println(String.format("%-20s| %s", contact.getName() , contact.getPhone()));
            System.out.println();
            return;
        }
        System.out.println("Ten lien lac '" + name + "' Khong tim thay" );
        System.out.println();
    }

    private static void handleAddNewContact() {
        System.out.print("Hay nhap ten: ");
        String name = scanner.next();
        System.out.print("Hay Nhap So dien thoai: ");
        String phone = scanner.next();
        addressBook.addContact(name, phone);
        System.out.println();
    }
}
