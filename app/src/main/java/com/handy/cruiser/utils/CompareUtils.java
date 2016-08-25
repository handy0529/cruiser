package com.handy.cruiser.utils;

import android.util.Log;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by handy on 16/8/24.
 */
public class CompareUtils {
    public static String TAG = "CompareUtils";

    /**
     * @param aList
     * @param bList
     * @param getSameOrDiff 获取相同项还是不同项 true：相同  false：不同
     * @return
     */

    public static List<CornerMarkResult.CornerMarkItem> compare(List<CornerMarkResult.CornerMarkItem> aList, List<CornerMarkResult.CornerMarkItem> bList, boolean getSameOrDiff) {

//        if (CheckUtils.isEmpty(aList)) {
//            return null;
//        }
//
//        if (CheckUtils.isEmpty(bList)) {
//            return null;
//        }

        long ts = System.currentTimeMillis();

        int aListCount = aList.size();
        int bListCount = bList.size();

        ArrayList<CornerMarkResult.CornerMarkItem> sameList = new ArrayList<CornerMarkResult.CornerMarkItem>(Math.min(aListCount, bListCount));
        ArrayList<CornerMarkResult.CornerMarkItem> differentList = new ArrayList<CornerMarkResult.CornerMarkItem>(Math.min(aListCount, bListCount));

        for (int i = 0; i < bListCount; i++) {
            for (int j = 0; j < aListCount; j++) {
                CornerMarkResult.CornerMarkItem bListInfo = bList.get(i);
                CornerMarkResult.CornerMarkItem aListInfo = aList.get(j);
//                if (!CheckUtils.isEmpty(aListInfo.biz) && !CheckUtils.isEmpty(bListInfo.biz) && bListInfo.biz.equals(aListInfo.biz)) {
                    //相同项
                    sameList.add(aListInfo);
                    continue;
//                }
            }
        }
        if (sameList.size()<aListCount){
            for (int i = 0; i < sameList.size(); i++) {
             for (int j = 0; j < aListCount; j++) {
                    CornerMarkResult.CornerMarkItem sameListInfo = sameList.get(i);
                    CornerMarkResult.CornerMarkItem bigListInfo = aList.get(j);
//                    if (!CheckUtils.isEmpty(bigListInfo.biz) && !CheckUtils.isEmpty(sameListInfo.biz) && !sameListInfo.biz.equals(bigListInfo.biz)) {
                        differentList.add(bigListInfo);
                        continue;
//                    }
                }//Flight
        }}
        long es = System.currentTimeMillis();
        Log.i("handy", " compare waste time " + (es - ts) + " size " + sameList.size());
        Log.i("handy", " same " + sameList.size() + " diff " + differentList.size());
        if (getSameOrDiff) {
            return sameList;
        } else {
            return differentList;
        }
    }

    public static List<CornerMarkResult.CornerMarkItem> getDiffrent(List<CornerMarkResult.CornerMarkItem> list1, List<CornerMarkResult.CornerMarkItem> list2) {
        long st = System.nanoTime();
        List<CornerMarkResult.CornerMarkItem> diff = new ArrayList<CornerMarkResult.CornerMarkItem>();
        for(CornerMarkResult.CornerMarkItem str:list1)
        {
            if(!list2.contains(str))
            {
                diff.add(str);
                Log.e("handy","getDiffrent diff str "+str);
            }
        }
        Log.e("handy","getDiffrent total times "+(System.nanoTime()-st));
        return diff;
    }

    public static List<CornerMarkResult.CornerMarkItem> getDiffrent5(List<CornerMarkResult.CornerMarkItem> list1, List<CornerMarkResult.CornerMarkItem> list2) {
        long st = System.nanoTime();
        List<CornerMarkResult.CornerMarkItem> diff = new ArrayList<CornerMarkResult.CornerMarkItem>();
        List<CornerMarkResult.CornerMarkItem> maxList = list1;
        List<CornerMarkResult.CornerMarkItem> minList = list2;
        if(list2.size()>list1.size())
        {
            maxList = list2;
            minList = list1;
        }
        Map<CornerMarkResult.CornerMarkItem,Integer> map = new HashMap<CornerMarkResult.CornerMarkItem,Integer>(maxList.size());
        for (CornerMarkResult.CornerMarkItem string : maxList) {
            map.put(string, 1);
        }
        for (CornerMarkResult.CornerMarkItem string : minList) {
            if(map.get(string)!=null)
            {
                map.put(string, 2);
                continue;
            }
            diff.add(string);
        }
        for(Map.Entry<CornerMarkResult.CornerMarkItem, Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
            {
                diff.add(entry.getKey());
            }
        }
        Log.e("handy","getDiffrent5 total times "+(System.nanoTime()-st));
        return diff;

    }

    public static List<CornerMarkResult.CornerMarkItem> getDiffrent4(List<CornerMarkResult.CornerMarkItem> list1, List<CornerMarkResult.CornerMarkItem> list2) {
        long st = System.nanoTime();
        Map<CornerMarkResult.CornerMarkItem,Integer> map = new HashMap<CornerMarkResult.CornerMarkItem,Integer>(list1.size()+list2.size());
        List<CornerMarkResult.CornerMarkItem> diff = new ArrayList<CornerMarkResult.CornerMarkItem>();
        List<CornerMarkResult.CornerMarkItem> maxList = list1;
        List<CornerMarkResult.CornerMarkItem> minList = list2;
        if(list2.size()>list1.size())
        {
            maxList = list2;
            minList = list1;
        }
        for (CornerMarkResult.CornerMarkItem string : maxList) {
            map.put(string, 1);
        }
        for (CornerMarkResult.CornerMarkItem string : minList) {
            Integer cc = map.get(string);
            if(cc!=null)
            {
                map.put(string, ++cc);
                continue;
            }
            map.put(string, 1);
        }
        for(Map.Entry<CornerMarkResult.CornerMarkItem, Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
            {
                diff.add(entry.getKey());
            }
        }
        Log.e("handy","getDiffrent4 total times "+(System.nanoTime()-st));
        return diff;

    }
    /**
     * 获取两个List的不同元素
     * @param list1
     * @param list2
     * @return
     */
    public static List<CornerMarkResult.CornerMarkItem> getDiffrent3(List<CornerMarkResult.CornerMarkItem> list1, List<CornerMarkResult.CornerMarkItem> list2) {
        long st = System.nanoTime();
        Map<CornerMarkResult.CornerMarkItem,Integer> map = new HashMap<CornerMarkResult.CornerMarkItem,Integer>(list1.size()+list2.size());
        List<CornerMarkResult.CornerMarkItem> diff = new ArrayList<CornerMarkResult.CornerMarkItem>();
        for (CornerMarkResult.CornerMarkItem string : list1) {
            map.put(string, 1);
        }
        for (CornerMarkResult.CornerMarkItem string : list2) {
            Integer cc = map.get(string);
            if(cc!=null)
            {
                map.put(string, ++cc);
                continue;
            }
            map.put(string, 1);
        }
        for(Map.Entry<CornerMarkResult.CornerMarkItem, Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
            {
                diff.add(entry.getKey());
            }
        }
        Log.e("handy","getDiffrent3 total times "+(System.nanoTime()-st));
        return diff;
    }

    /**
     * 获取连个List的不同元素
     * @param list1
     * @param list2
     * @return
     */
    public static List<CornerMarkResult.CornerMarkItem> getDiffrent2(List<CornerMarkResult.CornerMarkItem> list1, List<CornerMarkResult.CornerMarkItem> list2) {
        long st = System.nanoTime();
        list1.retainAll(list2);
        Log.e("handy","getDiffrent2 total times "+(System.nanoTime()-st));
        return list2;
    }

    /**
     * 获取两个List的不同元素
     * @param list1
     * @param list2
     * @return
     */
    public static List<CornerMarkResult.CornerMarkItem> getDiffrent6(List<CornerMarkResult.CornerMarkItem> list1, List<CornerMarkResult.CornerMarkItem> list2) {
        long st = System.nanoTime();
        List<CornerMarkResult.CornerMarkItem> diff = new ArrayList<CornerMarkResult.CornerMarkItem>();
        List<CornerMarkResult.CornerMarkItem> lista = new ArrayList<CornerMarkResult.CornerMarkItem>(list1);//构建list1的副本
        lista.removeAll(list2);// 去除相同元素
        List<CornerMarkResult.CornerMarkItem> listb = new ArrayList<CornerMarkResult.CornerMarkItem>(list2);//构建list2的副本
        listb.removeAll(list1);// 去除相同元素
        diff.addAll(lista);
        diff.addAll(listb);
        Log.e("handy","getDiffrent6 total times "+(System.nanoTime()-st));
        return diff;
    }
}
