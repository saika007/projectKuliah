import java.util.*;

class Mahasiswa {
    private String nim;
    private String name;
    private String faculty;
    private String program;

    public Mahasiswa(String name, String nim, String faculty, String program) {
        this.nim = nim;
        this.name = name;
        this.faculty = faculty;
        this.program = program;
    }

    public static void tampilUniversitas() {
        System.out.println("Universitas Muhammadiyah Malang");
    }

    public void tampilMahasiswa() {
        System.out.println("NIM "+ nim);
        System.out.println("Nama: " + name);
        System.out.println("Faculty " + faculty);
    }
}

class Book {
    String idBuku;
    String namaBuku;
    String author;
    String category;
    int stokBuku;
    

    public Book(String idBuku, String namaBuku, String author, String category, int stokBuku) {
        this.idBuku = idBuku;
        this.namaBuku = namaBuku;
        this.author = author;
        this.category = category;
        this.stokBuku = stokBuku;
    }
}

class Student {
    String nim;
    String nama;
    String faculty;
    String programStudi;
    List<Book> bookList;

    public Student(String nama, String nim, String faculty, String programStudi) {
        this.nim = nim;
        this.nama = nama;
        this.faculty = faculty;
        this.programStudi = programStudi;
    }

    void displayBooks() {
        System.out.println("List of Books:");
        System.out.println("==================");

        for (Book book : bookList) {
            System.out.println("ID Buku: " + book.idBuku);
            System.out.println("Nama Buku: " + book.namaBuku);
            System.out.println("Author: " + book.author);
            System.out.println("ID Buku: " + book.idBuku);
            System.out.println("Stok Buku: " + book.stokBuku);
            System.out.println("------------------");
        }
    }

    void logout() {
        System.out.println("Logging out...");
    }
}

class Admin {
    String adminUsername;
    String adminPassword;
    List<Student> studentList;

    public Admin(String adminUsername, String adminPassword) {
        this.adminUsername = adminUsername;
        this.adminPassword = adminPassword;
        this.studentList = new ArrayList<>();
    }

    void addStudent(Scanner scanner) {
        System.out.print("Enter student name: ");
        String nama = scanner.next();

        System.out.print("Enter student NIM: ");
        String nim = scanner.next();
        while (String.valueOf(nim).length() != 15) {
            System.out.println("Nim Harus 15 Digit!!");
            System.out.print("Enter student NIM: ");
            nim = scanner.next();
        }

        System.out.print("Enter student faculty: ");
        String faculty = scanner.next();

        System.out.print("Enter student program: ");
        String programStudi = scanner.next();

        studentList.add(new Student(nama, nim, faculty, programStudi));
    }

    void displayStudents() {
        System.out.println("List of Students:");
        System.out.println("==================");

        for (Student student : studentList) {
            System.out.println("NIM: " + student.nim);
            System.out.println("Name: " + student.nama);
            System.out.println("Faculty: " + student.faculty);
            System.out.println("Program Studi: " + student.programStudi);
            System.out.println("------------------");
        }
    }

    boolean checkNim(String nim) {
        for (Student student : studentList) {
            if (student.nim.equals(nim)) {
                return true;
            }
        }
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    List<Book> bookList;
    List<Student> userStudent;
    Scanner scanner;

    public Main() {
        bookList = new ArrayList<>();
        userStudent = new ArrayList<>();
        scanner = new Scanner(System.in);

    }

    void menu() {
        System.out.println("\n=== Library System ===");
        System.out.println("1. Login as Student");
        System.out.println("2. Login as Admin");
        System.out.println("3. Exit");
        System.out.print("Choose option (1-3): ");
        int choice = scanner.nextInt();

        switch(choice) {
            case 1:
                menuStudent();
                break;
            case 2:
                menuAdmin();
                break;
            case 3:
                logout();
                break;
            default:
                System.out.println("Invalid choice.");
                menu();
        }
    }

    void menuStudent() {
        System.out.println("1. Input NIM");
        System.out.println("2. Logout");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter your NIM: ");
                String nim = scanner.next();
                if (checkNim(nim)) {
                    Student student = new Student(nim, "", "", "");
                    student.displayBooks();
                } else {
                    System.out.println("NIM tidak ditemukan.");
                }
                break;
            case 2:
                logout();
                break;
            default:
                System.out.println("Invalid choice.");
                menuStudent(); 
        }
    }

    void inputNim() {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your NIM : ");
        String nim = keyboard.next();
        keyboard.close();
    }

    void menuAdmin() {

        System.out.println("\n=== Admin Menu ===");
        System.out.println("1. Add Student");
        System.out.println("2. Display Students");
        System.out.println("3. Logout");
        System.out.print("Choose option (1-3): ");
        int choice = scanner.nextInt();

        Admin admin = new Admin("admin", "password");
        switch (choice) {
            case 1:
                admin.addStudent(scanner); 
                break;
            case 2:
                admin.displayStudents();
                break;
            case 3:
                logout();
                break;
            default:
                System.out.println("Invalid choice.");
                menuAdmin();
                break;
        }

    }

    void logout() {
        System.out.println("Logging out...");
    }

    boolean checkNim(String nim) {
        for (Student student : userStudent) {
            if (student.nim.equals(nim)) {
                return true;
            }
        }
        return false;
    }
}