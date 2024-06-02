/*
Create a class Book with below attributes

id - int

pages - int

title - String

author - String

price - double

The above attributes should be private, write getters and setters and parameterized constructor as required.

Create a class Solution with main method
--------------------------------------------
Implement two static methods - findBookWithMaximumPrice and searchBookByTitle in Solution class.

findBookWithMaximumPrice :
=============================
Create a static method findBookWithMaximumPrice in the Solution class. This method will take array of Book objects and
returns the Book object having the maximum Price if found else return null if not found.

searchBookByTitle :
=============================
Create a static method searchBookByTitle in the Solution class. This method will take array of Book objects and Title as
input and returns the Book object having the mentioned Title if found else return null if not found.

These methods should be called from the main method.

write code to perform the following tasks.

1. Take necessary input variable and call findBookWithMaximumPrice. For this method - The main method should print the Book
 object with the maximum of mentioned attribute as it is if the returned value is not null, or it should print
 "No Book found with mentioned attribute."

2. Take necessary input variable and call searchBookByTitle. For this method - The main method should print the Book object
details as it is, if the returned value is not null or it should print "No Book found with mentioned attribute."

The above mentioned static methods should be called from the main method. Also write the code for accepting the inputs and
printing the outputs. Don't use any static test or formatting for printing the result. Just invoke the method and print the
result.

All String comparison needs to be in case sensitive.

Input:

1
845
Bengali
Arijit
525.50
2
456
English
Raju
412.30
3
1022
History
Kaka
525.50
4
125
geography
MN
524
English

Output:

1 Bengali
3 History
2
456
 */

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