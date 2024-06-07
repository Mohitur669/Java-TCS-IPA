/*
create the class Song with below attributes.

songId - int
title - String
artist -  String
duration-double

The above attributes should be private, getters, setters and parameterized constructor as required.

Create class MyClass with main method. Implement two static methods - findSongDurationForArtist and
getSongsInAscendingOrder in MyClass class.

findSongDurationForArtist method:
----------------------------------------------------
This method will take two input parameters of Song objects and String parameter.
The method will return the sum of song duration from array of Song object for the given artist (String parameter passed).

If no Song with the given artist is present in the array of Song objects, then the method should return zero.

getSongsInAscendingOrder method:
----------------------------------------------------
This method will take input parameters array, of Song objects and String parameter.The method will return Song objects array
in an ascending order of their duration, from the array of Song objects whose artist attribute matches with the input String
parameter.

If no Song with the given artist is present in the array of Song objects, then the method should return null.

Note:
----------
1. No two Song object would have the same songid.
2. Combination of artist and duration should be unique.
3. All the searches should be case insensitive.

The above mentioned static methods should be called from the main method.

For getfindSongDuration ForArtist method - in method should print the sum of duration of artist as it is, if the returned
value is greater than 0 or it should print "There are no songs with given artist".

For getSongsinAscendingOrder method - The main method should print the song id and title from the returned song object array
if the returned value is not null. If the returned value is null then it should print "There are no songs with given artist".


For Example,

112
ABC

where 112 is song ld. ABC is song title.

Before calling these static methods in main, use. Scanner object to read the values of five Song objects referring attributes
in the above mentioned attribute sequence. Next, read two String values for capturing artists.

*****************************************************************



Sample Input 1:
------------------

2150
In time
Justin Timberlake
4
250
Cry Me
Justin Timberlake
3
1200
Mirrors
Justin Timberlake
5
1300
That's the way it is
celion dion
5
500
Ashes
celion dion
3
celion dion
Justin Timberlake


Sample output1:
------------------------

8.0
250
Cry Me
2150
In time
1200
Mirrors



Sample Input 2:
----------------------

2150
Cry Me
Justin Timberlake
3
1000
Why Not
Enrique Iglesius
5
1200
Mirrors
Justin Timberlake
5
1300
That's the way it is
Celion Dion
5
500
Ashes
celion Dion
3
Bryan Adams
Michael Larkson


Output 2:
-----------------------

There are no songs with given artist
There are no songs with given artist
 */

import java.util.*;

public class Songs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Song[] song = new Song[5];
        for (int i = 0; i < song.length; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            String c = sc.nextLine();
            double d = sc.nextDouble();

            song[i] = new Song(a, b, c, d);
        }

        sc.nextLine();
        String artist = sc.nextLine();
        String artist2 = sc.nextLine();

        double ans = findSongDuration(song, artist);
        if (ans > 0) {
            System.out.println(ans);
        } else {
            System.out.println("There are no songs with given artist");
        }

        Song[] result = getSongs(song, artist2);
        if (result.length > 0) {
            for (Song s : result) {
                System.out.println(s.getId());
                System.out.println(s.getTitle());
            }
        } else {
            System.out.println("There are no songs with given artist");
        }

    }

    public static double findSongDuration(Song[] song, String artist) {
        double ans = 0;

        for (Song s : song) {
            if (s.getArtist().equalsIgnoreCase(artist)) {
                ans += s.getDuration();
            }
        }

        return ans;
    }

    public static Song[] getSongs(Song[] song, String artist) {
        Song[] result = new Song[0];

        for (Song s : song) {
            if (s.getArtist().equalsIgnoreCase(artist)) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = s;
            }
        }

        for (int i = 0; i < result.length - 1; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i].getDuration() > result[j].getDuration()) {
                    Song temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }

        return result;
    }
}

class Song {
    int id;
    String title;
    String artist;
    double duration;

    public Song(int id, String title, String artist, double duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.duration = duration;
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

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}