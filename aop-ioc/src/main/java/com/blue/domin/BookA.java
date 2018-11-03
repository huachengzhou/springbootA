package com.blue.domin;

/**
 * @Author noatn
 * @Description
 * @createDate 2018/11/3
 **/
public class BookA {
    private String author;
    private String bookmark;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBookmark() {
        return bookmark;
    }

    public void setBookmark(String bookmark) {
        this.bookmark = bookmark;
    }

    @Override
    public String toString() {
        return "BookA{" +
                "author='" + author + '\'' +
                ", bookmark='" + bookmark + '\'' +
                '}';
    }
}
