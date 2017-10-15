package com.example.akash.references;

/**
 * Created by Akash on 9/29/17.
 */

public class Book extends Source{
    String firstName, middleI, lastName, contributor, title, volume, series, publisher, city, state, annotation;
    String citation;
    int year, edition;
    public Book(String firstName, String middleI, String lastName, String contributor, String title, String volume, int edition, String series, String publisher, String city, String state, int year, String annotation, String format){
        this.firstName = firstName;
        this.middleI = middleI;
        this.lastName = lastName;
        this.contributor = contributor;
        this.title = title;
        this.volume = volume;
        this.edition = edition;
        this.series = series;
        this.publisher = publisher;
        this.city = city;
        this.state = state;
        this.year = year;
        this.annotation = annotation;
        setFormat(format);
        if(format.equals("MLA")){
            citation = lastName + ", " + firstName + " " + middleI + ". " + title + ". " + Source.ordinal(edition) + " Ed., Vol." + volume + ", " + city + ", " + state + ", " + publisher + ", " + year + ". " + annotation;
         }
         else if(format.equals("APA")){

        }
        else{

        }
    }

}
