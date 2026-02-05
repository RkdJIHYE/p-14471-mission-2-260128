package com.ll.wiseSaying.entity;

import java.time.LocalDateTime;

public class WiseSaying {
    private int cnt ;
    private String author;
    private String content;
    private LocalDateTime CreateDate;
    private LocalDateTime ModifyDate;

    public void setCreateDate(LocalDateTime createTime) {
        CreateDate = createTime;
    }

    public void setModifyDate(LocalDateTime modifyDate) {
        ModifyDate = modifyDate;
    }

    public LocalDateTime getCreateDate() {
        return CreateDate;
    }

    public LocalDateTime getModifyDate() {
        return ModifyDate;
    }

    public WiseSaying(int id, String content, String author){
        this.cnt = id;
        this.content = content;
        this.author = author;
    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }
}


