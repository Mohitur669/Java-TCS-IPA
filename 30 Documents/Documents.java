/*
Create class Document with below attributes

id - int
title - String
folderName - String
pages - int

Write getters, setters and parameterized constructor as required.

Create class Solution with main method.

Implement static method - docsWithOddPages in Solution class.

This method will take array of Document objects and return another array with Document objects which has odd number of pages.

This method should be called from main method and display values of returned objects as shared in the sample (in ascending
order of id attribute).

Before calling this method, use Scanner object to read values for four Document objects referring attributes in the above
sequence.

Next call the method and display the result.

Consider below sample input and output:

Input:
1
resume
personal
50
2
question1
exams
55
3
question2
exams
45
4
India
misc
40


Output (each line has values separated by single space):
2 question1 exams 55
3 question2 exams 45



Note on using Scanner object:
Sometimes scanner does not read the new line character while invoking methods like nextInt(), nextDouble() etc.
Usually, this is not an issue, but this may be visible while calling nextLine() immediately after those methods.

Consider below input values:
22
hello

Referring below code:

Scanner sc = new Scanner(System.in);
int x = sc.nextInt();
String str = sc.nextLine(); -> here we expect str to have value hello. Instead it may be """".

If above issue is observed, then it is suggested to add one more explicit call to nextLine() after reading numeric value.

 */

import java.util.*;

public class Documents {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Document[] doc = new Document[4];

        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            int d = sc.nextInt();

            doc[i] = new Document(a, b, c, d);
        }

        Document[] ans = docsWithOddPages(doc);
        for (Document dc : ans) {
            System.out.println(dc.getId() + " " + dc.getTitle() + " " + dc.getFolderName() + " " + dc.getPages());
        }
    }

    // TODO - use of Arrays.copyOf()
    public static Document[] docsWithOddPages(Document[] doc) {
        Document[] ans = new Document[0];

        for (Document d : doc) {
            if (d.getPages() % 2 != 0) {
                ans = Arrays.copyOf(ans, ans.length + 1);
                ans[ans.length - 1] = d;
            }
        }

        for (int i = 0; i < ans.length - 1; i++) {
            for (int j = i + 1; j < ans.length; j++) {
                if (ans[i].getId() > ans[j].getId()) {
                    Document temp = ans[i];
                    ans[i] = ans[j];
                    ans[j] = temp;
                }
            }
        }

        return ans;
    }
}

class Document {
    int id;
    String title;
    String folderName;
    int pages;

    public Document(int id, String title, String folderName, int pages) {
        this.id = id;
        this.title = title;
        this.folderName = folderName;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFolderName() {
        return folderName;
    }

    public void setFolderName(String folderName) {
        this.folderName = folderName;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }
}