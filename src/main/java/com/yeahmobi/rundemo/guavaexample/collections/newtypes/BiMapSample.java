package com.yeahmobi.rundemo.guavaexample.collections.newtypes;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name 新集合之BiMap
 * @desc BiMap提供了一种新的集合类型，它提供了key和value的双向关联的数据结构。
 * @use scene 例如，一个星期几的中英文表示的相互映射，例如Monday对应的中文表示是星期一，同样星期一对应的英文表示是Monday
 * @author root
 *
 */

public class BiMapSample {
	public static void main(String[] args) {
		/**
		 * 传统的使用map实现键值的翻转，需要考虑：
		 * 1). 如何处理重复的value的情况。不考虑的话，反转的时候就会出现覆盖的情况.
		 * 2). 如果在反转的map中增加一个新的key，倒转前的map是否需要更新一个值呢?
		 * 这时可考虑使用guava的BiMap
		 */
		 BiMap<String,String> weekNameMap = HashBiMap.create();
        weekNameMap.put("星期一","Monday");
        weekNameMap.put("星期二","Tuesday");
        weekNameMap.put("星期三","Wednesday");
        weekNameMap.put("星期四","Thursday");
        weekNameMap.put("星期五","Friday");
        weekNameMap.put("星期六","Saturday");
        weekNameMap.put("星期日","Sunday");

        System.out.println("星期日的英文名是" + weekNameMap.get("星期日"));
        System.out.println("Sunday的中文是" + weekNameMap.inverse().get("Sunday"));
        
        dividingLine();
        /**
        *inverse方法会返回一个反转的BiMap，但是注意这个反转的map不是新的map对象，
         * 它实现了一种视图关联，这样你对于反转后的map的所有操作都会影响原先的map对象
         */
        BiMap<Integer,String> logfile_Map = HashBiMap.create(); 
        logfile_Map.put(1,"a.log");
        logfile_Map.put(2,"b.log");
        logfile_Map.put(3,"c.log"); 
        System.out.println("logfile_Map:"+logfile_Map); 
        BiMap<String,Integer> filelog_Map = logfile_Map.inverse();
        System.out.println("filelog_Map:"+logfile_Map);
        
        logfile_Map.put(4,"d.log"); 

        System.out.println("logfileMap:"+logfile_Map); 
        System.out.println("filelogMap:"+filelog_Map); 
        dividingLine();
        /**
         * 在使用BiMap时，会要求Value的唯一性。如果value重复了则会抛出错误：java.lang.IllegalArgumentException，
         * 如果我们确实需要插入重复的value值，那可以选择forcePut方法。但是我们需要注意的是前面的key也会被覆盖了。
         */
        BiMap<Integer,String> logfileMap = HashBiMap.create(); 
        logfileMap.put(1,"a.log");
        logfileMap.put(2,"b.log");
        logfileMap.put(3,"c.log");         
        logfileMap.put(4,"d.log"); 
        logfileMap.put(5,"d.log"); 
	}
	
}
