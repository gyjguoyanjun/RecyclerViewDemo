package com.bwie.test.smartdroiddemo.beans;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by tianjieyu on 2017/5/12.
 */

public class CheckBean implements Parcelable {
    boolean flag = false;
    String text;
    String imgs;


    public CheckBean(String text, String imgs, boolean flag) {
        this.text = text;
        this.imgs = imgs;
        this.flag = flag;
    }

    public String getImgs() {
        return imgs;
    }

    public void setImgs(String imgs) {
        this.imgs = imgs;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "CheckBean{" +
                "flag=" + flag +
                ", text='" + text + '\'' +
                ", imgs='" + imgs + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(this.flag ? (byte) 1 : (byte) 0);
        dest.writeString(this.text);
        dest.writeString(this.imgs);
    }

    protected CheckBean(Parcel in) {
        this.flag = in.readByte() != 0;
        this.text = in.readString();
        this.imgs = in.readString();
    }

    public static final Parcelable.Creator<CheckBean> CREATOR = new Parcelable.Creator<CheckBean>() {
        @Override
        public CheckBean createFromParcel(Parcel source) {
            return new CheckBean(source);
        }

        @Override
        public CheckBean[] newArray(int size) {
            return new CheckBean[size];
        }
    };
}
