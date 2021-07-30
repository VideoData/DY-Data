/*
 * Copyright (c) 2016, Shanghai YUEWEN Information Technology Co., Ltd.
 * All rights reserved.
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the following conditions are met:
 *
 *  Redistributions of source code must retain the above copyright notice, this list of conditions and the following disclaimer.
 *  Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the distribution.
 *  Neither the name of Shanghai YUEWEN Information Technology Co., Ltd. nor the names of its contributors may be used to endorse or promote products derived from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY SHANGHAI YUEWEN INFORMATION TECHNOLOGY CO., LTD. AND CONTRIBUTORS "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE REGENTS AND CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */
package com.yw.game.floatmenu;

import android.graphics.Bitmap;
import android.graphics.Color;

/**
 * Created by wengyiming on 2017/7/21.
 */

public class FloatItem {
    public String title;
    public int titleColor = Color.BLACK;
    public int bgColor = Color.WHITE;
    public Bitmap icon;
    public String dotNum = null;

    public FloatItem(String title, int titleColor, int bgColor, Bitmap icon, String dotNum) {
        this.title = title;
        this.titleColor = titleColor;
        this.bgColor = bgColor;
        this.icon = icon;
        this.dotNum = dotNum;
    }

    public String getDotNum() {
        return dotNum;
    }


    public FloatItem(String title, int titleColor, int bgColor, Bitmap bitmap) {
        this.title = title;
        this.titleColor = titleColor;
        this.bgColor = bgColor;
        this.icon = bitmap;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    public int getBgColor() {
        return bgColor;
    }

    public void setBgColor(int bgColor) {
        this.bgColor = bgColor;
    }

    public Bitmap getIcon() {
        return icon;
    }

    public void setIcon(Bitmap icon) {
        this.icon = icon;
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) return true;

        if (obj instanceof FloatItem) {
            FloatItem floatItem = (FloatItem) obj;
            return floatItem.title.equals(this.title);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return title.hashCode();
    }

    @Override
    public String toString() {
        return "FloatItem{" +
                "title='" + title + '\'' +
                ", titleColor=" + titleColor +
                ", bgColor=" + bgColor +
                ", icon=" + icon +
                ", dotNum='" + dotNum + '\'' +
                '}';
    }
}
