package com.yeahmobi.rundemo.guavaexample.collections.newtypes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name 新集合之MultiMap
 * @desc Multiset和Set的区别就是可以保存多个相同的对象，允许重复，但不保证顺序
 * @author root
 *
 */

public class MultiSetSample {
	public static void main(String[] args) {
		//1.常见使用场景：跟踪每种对象的数量，因此可以用来进行数字统计
		// 常见的普通实现方式如下：
		oldWordCount();
		
		dividingLine();
		
		//Multiset实现
		multsetWordCount();
	}
	
	/*
	   Multiset接口定义的接口主要有：
　　　　add(E element) :向其中添加单个元素
　　　　add(E element,int occurrences) : 向其中添加指定个数的元素
　　　　count(Object element) : 返回给定参数元素的个数
　　　　remove(E element) : 移除一个元素，其count值 会响应减少
　　　　remove(E element,int occurrences): 移除相应个数的元素
　　　　elementSet() : 将不同的元素放入一个Set中
　　　　entrySet(): 类似与Map.entrySet 返回Set<Multiset.Entry>。包含的Entry支持使用getElement()和getCount()
　　　　setCount(E element ,int count): 设定某一个元素的重复次数
　　　　setCount(E element,int oldCount,int newCount): 将符合原有重复个数的元素修改为新的重复次数
　　　　retainAll(Collection c) : 保留出现在给定集合参数的所有的元素 
　　　　removeAll(Collectionc) : 去除出现给给定集合参数的所有的元素
	 */
	
	public static void multsetWordCount(){
        String strWorld="wer|dfd|dd|dfd|dda|de|dr";
        String[] words=strWorld.split("\\|");
        List<String> wordList=new ArrayList<String>();
        for (String word : words) {
            wordList.add(word);
        }
        Multiset<String> wordsMultiset = HashMultiset.create();
        wordsMultiset.addAll(wordList);
     
        for(String key:wordsMultiset.elementSet()){
            System.out.println(key+" count："+wordsMultiset.count(key));
        }
    }
	public static void oldWordCount(){
        String strWorld="wer|dffd|ddsa|dfd|dreg|de|dr|ce|ghrt|cf|gt|ser|tg|ghrt|cf|gt|" +
                "ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr|wer|dffd|ddsa|dfd|dreg|de|dr|" +
                "ce|ghrt|cf|gt|ser|tg|gt|kldf|dfg|vcd|fg|gt|ls|lser|dfr";
        String[] words=strWorld.split("\\|");
        Map<String, Integer> countMap = new HashMap<String, Integer>();
        for (String word : words) {
            Integer count = countMap.get(word);
            if (count == null) { 
                countMap.put(word, 1); 
            }
            else { 
                countMap.put(word, count + 1); 
            }
        }        
        System.out.println("countMap：");
        for(String key:countMap.keySet()){
            System.out.println(key+" count："+countMap.get(key));
        }
    }
}
