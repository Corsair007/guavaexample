package com.yeahmobi.rundemo.guavaexample.collections.newtypes;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name 新集合之Table
 * @desc 当我们需要多个索引的数据结构的时候，通常使用Map<FirstName, Map<LastName, Person>>来实现。
 *        为此Guava提供了一个新的集合类型－Table集合类型，来支持这种数据结构的使用场景。
 *       Table支持“row”和“column”，而且提供多种视图。　
 * @author root
 *
 */

public class TableSample {
	public static void main(String[] args) {
		Table<String, Integer, String> aTable = HashBasedTable.create();

		for (char a = 'A'; a <= 'C'; ++a) {
			for (Integer b = 1; b <= 3; ++b) {
				aTable.put(Character.toString(a), b,
						String.format("%c%d", a, b));
			}
		}

		print("aTable.column(2)结果", aTable.column(2));
		print("aTable.row('B')结果", aTable.row("B"));
		print("aTable.get('B', 2)结果", aTable.get("B", 2));

		print("Table.contains('D', 1)结果", aTable.contains("D", 1));
		print("aTable.containsColumn(3)结果", aTable.containsColumn(3));
		print("aTable.containsRow('C')结果", aTable.containsRow("C"));
		print("aTable.columnMap()结果", aTable.columnMap());
		print("aTable.rowMap()结果", aTable.rowMap());

		print("aTable.remove('B', 3)结果", aTable.remove("B", 3));
		/**
		 * Table视图： 
		　　rowMap()返回一个Map<R, Map<C, V>>的视图。rowKeySet()类似地返回一个Set<R>。 
		　　row(r)返回一个非null的Map<C, V>。修改这个视图Map也会导致原表格的修改。 
		　　和列相关的方法有columnMap(), columnKeySet()和column(c)。（基于列的操作会比基于行的操作效率差些） 
		　　cellSet()返回的是以Table.Cell<R, C, V>为元素的Set。这里的Cell就类似Map.Entry，但是它是通过行和列来区分的
		 */
	}

}
