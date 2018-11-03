package com.blue.domin;

import java.io.Serializable;

/**
 * @author zhou
 * 文件上传进度所用
 */
public class Progress implements Serializable, Comparable<Progress> {
    private long pBytesRead;
    private long pContentLength;
    private long pItems;

    public long getpBytesRead() {
        return pBytesRead;
    }

    public void setpBytesRead(long pBytesRead) {
        this.pBytesRead = pBytesRead;
    }

    public long getpContentLength() {
        return pContentLength;
    }

    public void setpContentLength(long pContentLength) {
        this.pContentLength = pContentLength;
    }

    public long getpItems() {
        return pItems;
    }

    public void setpItems(long pItems) {
        this.pItems = pItems;
    }

    @Override
    public String toString() {
        return "Progress{" +
                "pBytesRead=" + pBytesRead +
                ", pContentLength=" + pContentLength +
                ", pItems=" + pItems +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Progress progress = (Progress) o;

        if (pBytesRead != progress.pBytesRead) return false;
        if (pContentLength != progress.pContentLength) return false;
        return pItems == progress.pItems;
    }

    @Override
    public int hashCode() {
        int result = (int) (pBytesRead ^ (pBytesRead >>> 32));
        result = 31 * result + (int) (pContentLength ^ (pContentLength >>> 32));
        result = 31 * result + (int) (pItems ^ (pItems >>> 32));
        return result;
    }

    public int compareTo(Progress o) {
        return (int) (getpContentLength() * o.getpContentLength());
    }
}