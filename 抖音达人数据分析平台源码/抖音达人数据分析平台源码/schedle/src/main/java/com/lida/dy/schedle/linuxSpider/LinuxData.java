package com.lida.dy.schedle.linuxSpider;

import lombok.Data;

/**
 * @Auther: lida
 * @Description:
 * @Date 2020/3/2 0002 11:42
 * @Version: 1.0
 */
@Data
public class LinuxData {
    int maxPlatformSource = 3;
    int platformSource;
    int maxCatagoryNum;
    int currentCatagoryNum;
    int totalCount; //该分类下总达人数量
    int currentTotalCount; //已經爬取的大人數量
    int limit = 20;
    boolean isRefreshTotalCount = true; //是否装载totalCount，从网页中
    boolean end = false;    //是否结束

    public int getPage() {
        if (isRefreshTotalCount) {
            return 1;
        }
        if (totalCount > currentTotalCount + limit) {
            return currentTotalCount % limit + 1;
        } else {
            return -1;
        }
    }

    public void setisRefreshTotalCount(boolean isRefreshTotalCount) {
        this.isRefreshTotalCount = isRefreshTotalCount;
    }

    public void addTalent() {
        currentTotalCount++;
        if (currentTotalCount == totalCount) {
            currentTotalCount = 0;
            isRefreshTotalCount = true;
            currentCatagoryNum++;
            if (currentCatagoryNum == maxCatagoryNum) {
                currentCatagoryNum = 1;
                platformSource++;
                if (platformSource == maxPlatformSource) {
                    end = true;
                    LinuxUtil.end();
                    return;
                } else {
                    maxCatagoryNum = CategoryData.getCategoryTotal(platformSource);
                }
            }
            setMaxCatagory();
        }
    }

    public void setMaxCatagory() {
        maxCatagoryNum = CategoryData.getCategoryTotal(platformSource);
    }
}
