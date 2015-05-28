package com.yeahmobi.rundemo.guavaexample.basicutiltties.ordering;

import java.util.List;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name 排序操作
 * @author root
 *
 */
public class OrderingSample {

	public static void main(String[] args) {
		/**
		 * 1.创建Ordering<T>对象，常见的静态方法： natural()：使用Comparable类型的自然顺序，
		 * 例如：整数从小到大，字符串是按字典顺序; usingToString()：使用toString()返回的字符串按字典顺序进行排序； 　　
		 * arbitrary()：返回一个所有对象的任意顺序， 即compare(a, b) == 0 就是 a == b (identity
		 * equality)。 本身的排序是没有任何含义， 但是在VM的生命周期是一个常量。
		 */
		List<String> list = Lists.newArrayList();
		list.add("peida3h");
		list.add("jerry");
		list.add("harry");
		list.add("eva");
		list.add("jhon");
		list.add("neron");

		print("list", list);

		Ordering<String> naturalOrdering = Ordering.natural();
		Ordering<Object> usingToStringOrdering = Ordering.usingToString();
		Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

		// 也可以自定义排序
		Ordering<String> byLengthOrdering = new Ordering<String>() {
			public int compare(String left, String right) {
				return Ints.compare(left.length(), right.length());
			}
		};

		print("naturalOrdering", naturalOrdering.sortedCopy(list));
		print("usingToStringOrdering", usingToStringOrdering.sortedCopy(list));
		print("arbitraryOrdering", arbitraryOrdering.sortedCopy(list));
		print("byLengthOrdering", byLengthOrdering.sortedCopy(list));

		dividingLine();
		/**
		 * reverse(): 返回与当前Ordering相反的排序: 　　
		 * nullsFirst(): 返回一个将null放在non-null元素之前的Ordering，其他的和原始的Ordering一样；
		 * nullsLast()：返回一个将null放在non-null元素之后的Ordering，其他的和原始的Ordering一样；
		 * compound(Comparator)：返回一个使用Comparator的Ordering，Comparator作为第二排序元素，
		 * 例如对bug列表进行排序，先根据bug的级别，再根据优先级进行排序；
		 * lexicographical()：返回一个按照字典元素迭代的Ordering；
		 * onResultOf(Function)：将function应用在各个元素上之后, 在使用原始ordering进行排序；
		 * greatestOf(Iterable iterable, int k)：返回指定的第k个可迭代的最大的元素，按照这个从最大到最小的顺序。是不稳定的。 　　leastOf(Iterable<E>
		 * iterable,int k)：返回指定的第k个可迭代的最小的元素，按照这个从最小到最大的顺序。是不稳定的。
		 * isOrdered(Iterable)：是否有序，Iterable不能少于2个元素。
		 * isStrictlyOrdered(Iterable)：是否严格有序。请注意，Iterable不能少于两个元素。
		 * sortedCopy(Iterable)：返回指定的元素作为一个列表的排序副本。
		 */
		List<Integer> listReduce= Lists.newArrayList();
        for(int i=9;i>0;i--){
            listReduce.add(i);
        }
        
        List<Integer> listtest= Lists.newArrayList();
        listtest.add(1);
        listtest.add(1);
        listtest.add(1);
        listtest.add(2);
        
        
        Ordering<Integer> naturalIntReduceOrdering = Ordering.natural();
        
        print("listtest", listtest);
        print("naturalIntReduceOrdering.isOrdered(listtest)", naturalIntReduceOrdering.isOrdered(listtest));
        print("naturalIntReduceOrdering.isStrictlyOrdered(listtest)", naturalIntReduceOrdering.isStrictlyOrdered(listtest));
        
        
        print("naturalIntReduceOrdering.sortedCopy(listReduce)", naturalIntReduceOrdering.sortedCopy(listReduce));
        print("listReduce", listReduce);
        
        
        print("naturalIntReduceOrdering.isOrdered(naturalIntReduceOrdering.sortedCopy(listReduce))", naturalIntReduceOrdering.isOrdered(naturalIntReduceOrdering.sortedCopy(listReduce)));
        print("naturalIntReduceOrdering.isStrictlyOrdered(naturalIntReduceOrdering.sortedCopy(listReduce))", naturalIntReduceOrdering.isStrictlyOrdered(naturalIntReduceOrdering.sortedCopy(listReduce)));
        

        Ordering<String> natural = Ordering.natural();
              
        List<String> abc = ImmutableList.of("a", "b", "c");
        print("natural.isOrdered(abc)", natural.isOrdered(abc));
        print("natural.isStrictlyOrdered(abc)", natural.isStrictlyOrdered(abc));
        
        print("isOrdered reverse ", natural.reverse().isOrdered(abc));
 
        List<String> cba = ImmutableList.of("c", "b", "a");
        print("natural.isOrdered(cba)", natural.isOrdered(cba));
        print("natural.isStrictlyOrdered(cba)", natural.isStrictlyOrdered(cba));
        
        dividingLine();
        
        print("cba = natural.sortedCopy(cba)", cba = natural.sortedCopy(cba));
        print("max", natural.max(cba));
        print("min", natural.min(cba));
        
        print("leastOf", natural.leastOf(cba, 2));
        print("naturalOrdering", naturalOrdering.sortedCopy(list));    
        print("leastOf list", naturalOrdering.leastOf(list, 3));
        print("greatestOf", naturalOrdering.greatestOf(list, 3));
        print("reverse list ", naturalOrdering.reverse().sortedCopy(list));    
        print("isOrdered list ", naturalOrdering.isOrdered(list));
        print("isOrdered list ", naturalOrdering.reverse().isOrdered(list));
        list.add(null);
        print(" add null list", list);
        print("nullsFirst list ", naturalOrdering.nullsFirst().sortedCopy(list));
        print("nullsLast list ", naturalOrdering.nullsLast().sortedCopy(list));

	}

}
