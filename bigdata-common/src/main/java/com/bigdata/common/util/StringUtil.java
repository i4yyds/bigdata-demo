package com.bigdata.common.util;

import com.alibaba.fastjson.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    // 转换为 List<String>
    public static List<String> JsonArray2ListStr(JSONArray jsonArray) {

        if (jsonArray == null) {
            return null;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < jsonArray.size(); i++) {
            list.add(jsonArray.getString(i));
        }
        return list;
    }

}
