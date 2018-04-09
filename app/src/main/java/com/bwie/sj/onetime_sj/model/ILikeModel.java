package com.bwie.sj.onetime_sj.model;

import java.util.Map;

/**
 * 点赞的
 * Created by Administrator on 2018/04/04.
 */

public interface ILikeModel {
    //uid=12790&token=7AB84A69BF4A4174F939A40734060657&wid=282
    void getLike(Map<String,String> map, GetDataListener getDataListener);
}
