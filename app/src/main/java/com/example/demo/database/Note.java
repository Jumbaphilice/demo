package com.example.demo.database;

public class Note {
 private int id;
 private  String Title;
 private  String noteText;


    public Note(int id, String title, String noteText) {
        this.id = id;
        Title = title;
        this.noteText = noteText;
    }

    public Note() {
    }

    public Note(String title, String noteText) {
        Title = title;
        this.noteText = noteText;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getnoteText() {
        return noteText;
    }

    public void setnoteText(String noteText) {
        this.noteText = noteText;
    }
}

