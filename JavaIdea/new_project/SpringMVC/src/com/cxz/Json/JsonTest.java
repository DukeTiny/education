package com.cxz.Json;

import com.cxz.po.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonTest {
    public static void main(String[] args) {

        JSONObject jsonOne = new JSONObject();
        jsonOne.put("name", "kewen");
        jsonOne.put("age", "24");
        System.out.println(jsonOne.toString());
        JSONObject jsonTwo = new JSONObject();
        jsonTwo.put("hobbit", "Doto");
        jsonTwo.put("hobbit2", "wow");
        System.out.println(jsonTwo.toString());
        JSONObject jsonThree = new JSONObject();
        jsonThree.putAll(jsonOne);
        jsonThree.putAll(jsonTwo);
        System.out.println(jsonThree.toString());

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("UserName", "ZHULI");
        jsonObject.put("age", "30");
        jsonObject.put("workIn", "ALI");
        System.out.println("jsonObject1：" + jsonObject);

        HashMap<String, Object> hashMap = new HashMap<String, Object>();
        List list = new ArrayList();
        User user = new User("Duke",21);
        list.add(user);
        hashMap.put("list",list);
        hashMap.put("UserName", "ZHULI");
        hashMap.put("age", "30");
        hashMap.put("workIn", "ALI");
        System.out.println("jsonObject2：" + JSONObject.fromObject(hashMap));

        JSONArray jsonArray = new JSONArray();
        jsonArray.add(0, "ZHULI");
        jsonArray.add(1, "30");
        jsonArray.add(2, "ALI");
        System.out.println("jsonArray1：" + jsonArray);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("ZHULI");
        arrayList.add("30");
        arrayList.add("ALI");
        System.out.println("jsonArray2：" + JSONArray.fromObject(arrayList));


        System.out.println("jsonArray FROM HASHMAP：" + JSONArray.fromObject(hashMap));


        JSONObject jsonObject2 = new JSONObject();
        jsonObject2.put("UserName", "ZHULI");
        jsonObject2.put("age", "30");
        jsonObject2.put("workIn", "ALI");
        jsonObject2.element("Array", arrayList);
        jsonObject2.element("Map", hashMap);
        System.out.println("jsonObject2：" + jsonObject2);

    }
}
