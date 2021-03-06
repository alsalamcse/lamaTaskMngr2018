package com.sholi.lama.lamataskmngr2018.data;

import java.util.Date;

public class MyTask {
    private String key;
    private String title;
    private String text;
    private int important;
    private int necessary;
    private Date createdAt;
    private Date dueDate;

    public MyTask (){

    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle(String title) {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getImportant() {
        return important;
    }

    public void setImportant(int important) {
        this.important = important;
    }

    public int getNecessary(int nercessary) {
        return necessary;
    }

    public void setNecessary(int necessary) {
        this.necessary = necessary;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "MyTask{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", important=" + important +
                ", necessary=" + necessary +
                ", createdAt=" + createdAt +
                ", dueDate=" + dueDate +
                '}';
    }

    public void setOwner(String email) {

    }

}
