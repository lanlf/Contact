package com.lan.contact;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.provider.ContactsContract;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lan on 2016/7/16.
 */
public class ContactInfo {


   public static List<Map<String,String>> getContactInfo(Context context){
        List <Map<String,String>> list = new ArrayList<Map<String, String>>();
        ContentResolver resolver = context.getContentResolver();

// 获取手机联系人   我自己写的方法
    Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null, null, null, null);
    if (phoneCursor != null) {
        while (phoneCursor.moveToNext()){
            String name = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            String num = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            Map<String ,String> map = new HashMap<String,String>();
            map.put("name",name);
            map.put("num",num);
            list.add(map);
        }
        return list;
    }
    return null;
}



    //视频的写法  每次启动app，list都会再次把联系人加进去，出现重复联系人
   public static List<ConInfo>  getCon(Context context){
        ContentResolver resolver = context.getContentResolver();
// 获取手机联系人
        Cursor phoneCursor = resolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,null, null, null, null);
       List<ConInfo> list = new ArrayList<ConInfo>();
        if (phoneCursor != null) {
            while (phoneCursor.moveToNext()){
                String name = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
                String num = phoneCursor.getString(phoneCursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                ConInfo conInfo = new ConInfo(name,num);
                list.add(conInfo);
            }
        }
       return list;
    }
}
