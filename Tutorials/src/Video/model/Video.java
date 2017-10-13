/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Video.model;

/**
 *
 * @author omrsemr
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Video {
    String title;
    Integer year;

    //constructor
    // does not specify return type
    //same name as class

    public Video(String title, Integer year) {
        this.title = title;
        this.year = year;
    }

    //method called toString returning a String
    public String toString() {
       return title + "(" + year + ")";

    }

    public static void main(String args[]) {
        Video video = new Video("James", 1980);
        System.out.println(video);
}
}


