/*
Create a class Music with below attributes:

playListNo - int
type -String
count - int
duration(minutes) -double.


The above attributes should be private.Write Getter and Setter and parametrized constructor as required.

Create class Solution with main method.

****************************************************************************

Implement two static methods: findAvgOfCount and sortTypeByDuration in Solution Class.



findAvgOfCount Method:
----------------------------------------
This method will take an array of Music objects and an int value as input parameters.The method will find out Average
(as int) of count for those objects whose count is more than the given Count(int parameter passed).This method will return
average if found.If there is no Type that matches then the method should return 0.

for this method- main method should print average ,if the returned value is not 0.If the returned value is 0 then main method
should print "No playlist found".


sortTypeByDuration method:
-----------------------------------------
This method will take an array of Music objects and an int value as input parameters.This method should return an array of
Music objects in an ascending order of their duration which are more than the given duration (int parameter passed) value.
If there are no such objects ,then the method should return null.

for this method-The main method should print the type from the returned Music object array if the returned value is not null.
If the returned value is null then the main method should print "No playlist found with mentioned attribute".

****************************************************************************

Consider the below input and output:

input1:
------------
111
WorkOut
10
15.2
321
Dance Party
20
55.500
721
Childhood Jams
6
50.60
521
Chill
30
78.89
15
20

output1:
--------------------
25
Childhood Jams
Dance Party
Chill


input2:
-----------------------
111
Oldies but Goodies
17
55
321
Guilty Pleasures
27
27
721
night drive
21
345
521
Rainy day
34
21
50
5000


output 2:
-----------------------
No playlist found.
No playlist found with mentioned attribute.
 */

import java.util.*;

public class MusicPlaylist {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Music[] music = new Music[4];
        for (int i = 0; i < 4; i++) {
            int a = sc.nextInt();
            sc.nextLine();
            String b = sc.nextLine();
            int c = sc.nextInt();
            sc.nextLine();
            double d = sc.nextDouble();
            sc.nextLine();
            music[i] = new Music(a, b, c, d);
        }

        int count = sc.nextInt();
        int duration = sc.nextInt();

        int ans = findAvg(music, count);
        if (ans > 0) {
            System.out.println(ans);
        } else {
            System.out.println("No playlist found");
        }

        Music[] result = sortType(music, duration);
        if (result.length > 0) {
            for (Music r : result) {
                System.out.println(r.getType());
            }
        } else {
            System.out.println("No playlist found with mentioned attribute");
        }
    }

    public static int findAvg(Music[] music, int count) {
        int ans = 0;
        int obj = 0;

        for (Music m : music) {
            if (m.getCount() > count) {
                ans += m.getCount();
                obj++;
            }
        }

        if (ans == 0) {
            return 0;
        } else {
            return ans / obj;
        }
    }

    public static Music[] sortType(Music[] music, int duration) {
        Music[] result = new Music[0];

        for (Music m : music) {
            if (m.getDuration() > duration) {
                result = Arrays.copyOf(result, result.length + 1);
                result[result.length - 1] = m;
            }
        }

        for (int i = 0; i < result.length - 1; i++) {
            for (int j = i + 1; j < result.length; j++) {
                if (result[i].getDuration() > result[j].getDuration()) {
                    Music temp = result[i];
                    result[i] = result[j];
                    result[j] = temp;
                }
            }
        }

        return result;
    }
}

class Music {
    int pNo, count;
    String type;
    double duration;

    public Music(int pNo, String type, int count, double duration) {
        this.pNo = pNo;
        this.type = type;
        this.count = count;
        this.duration = duration;
    }

    public int getPNo() {
        return pNo;
    }

    public void setPNo(int pNo) {
        this.pNo = pNo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
}