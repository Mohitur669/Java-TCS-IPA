import java.util.Scanner;

public class BookBank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = new Book[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sc.nextLine();
            String c = sc.nextLine();
            String d = sc.nextLine();
            double e = sc.nextDouble();

            books[i] = new Book(a, b, c, d, e);
        }

        sc.nextLine();
        String t = sc.nextLine();

        Book[] bk = findBookWithMaximumPrice(books);
        if (bk.length != 0) {
            for (Book book : bk) {
                System.out.println(book.getId() + " " + book.getTitle());
            }
        } else {
            System.out.println("No Book found with mentioned attribute.");
        }

        Book ans = searchBookByTitle(books, t);
        if (ans != null) {
            System.out.println(ans.getId());
            System.out.println(ans.getPages());
        } else {
            System.out.println("No Book found with mentioned attribute.");
        }
    }

    public static Book searchBookByTitle(Book[] books, String t) {
        Book ans = null;

        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(t)) {
                ans = b;
            }
        }

        return ans;
    }

    public static Book[] findBookWithMaximumPrice(Book[] books) {
        int count = 0;
        double max = books[0].getPrice();
        for (Book b : books) {
            if (b.getPrice() > max) {
                max = b.getPrice();
            } else if (max == b.getPrice()) {
                count++;
            }
        }

        int i = 0;
        Book[] book = new Book[count];
        for (Book b : books) {
            if (b.getPrice() == max) {
                book[i++] = b;
            }
        }

        return book;
    }
}

class Book {
    private int id, pages;
    private String title, author;
    private double price;

    public Book(int id, int pages, String title, String author, double price) {
        this.id = id;
        this.pages = pages;
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

}