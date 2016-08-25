package com.handy.cruiser.utils;


import java.io.Serializable;
import java.util.List;

/**
 * Created by handy on 16/8/11.
 */
public class CornerMarkResult implements Serializable {
    private static final long serialVersionUID = -1;
    public CornerMarkList data;
    public static class CornerMarkList implements Serializable {
        public List<CornerMarkItem> cornerMarkList;
    }

    public static class CornerMarkItem implements Serializable {
        public String biz;//业务名称
        public String url;//角标图片地址fffff
    }
}
