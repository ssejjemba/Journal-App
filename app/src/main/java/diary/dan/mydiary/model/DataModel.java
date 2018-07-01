package diary.dan.mydiary.model;

import java.util.Calendar;
import java.util.Date;

public class DataModel {

    public DataModel(int id, String title, String content, String location, int date, String image) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.location = location;
        this.date = date;
        this.image = image;
    }
    public DataModel(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  int id;
    public String title;
    public String content;
    public String location;
    public int date;
    public String image;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
