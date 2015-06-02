package com.yeahmobi.rundemo.guavaexample.function;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.dividingLine;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.google.common.base.Function;
import com.google.common.base.Functions;

/**
 * @rundemo_name 函数式编程
 * @author root
 *
 */
public class FunctionalSample {

	public static void main(String[] args) {
		// 1.使用Function接口:
		/**
		 * 其功能就是将输入类型转换为输出类型 public interface Function<F, T> { T apply(@Nullable
		 * F input); }
		 */
		/**
		 * 日期转换
		 */
		DateFormatFunction dateFormat = new DateFormatFunction();
		System.out.println(dateFormat.apply(new Date()));

		dividingLine();

		// 2.使用Functions类：
		// 现在你想在一个Map<String, State>(key为州的编号)对象中查找某个key, 你可以用
		// 2.1Functions.forMap()方法：
		Map<String, State> states = new HashMap<String, State>();
		states.put("k1", new State("亚特兰大", "YTLD"));
		Function<String, State> lookup = Functions.forMap(states);
		System.out.println(lookup.apply("k1").getName());// key不存在会抛异常

		// 你也可以给不存在的key指定一个默认值
		Function<String, State> lookup1 = Functions.forMap(states, new State(
				"上海", "SH"));

		dividingLine();

		// 2.2 Functions.compose()方法
		// 你可以通过组合Function，查找某州的城市列表
		states.get("k1").getMainCities().add(new City("H市", "HH", 100000));
		states.get("k1").getMainCities().add(new City("DEF市", "DEF", 900000));
		states.get("k1").getMainCities().add(new City("CSAD市", "CSAD", 343530));
		Function<String, State> lookup2 = Functions.forMap(states);
		Function<State, String> stateFunction = new StateToCityString(); // 州到城市的转换
		Function<String, String> stateCitiesFunction = Functions.compose(
				stateFunction, lookup); // 组合Function
		System.out.println(stateCitiesFunction.apply("k1"));
		// 等价于：
		System.out.println(stateFunction.apply(lookup2.apply("k1")));

		dividingLine();

		// 2.3使用Predicate接口(jdk8中已存在)：

		// Predicate接口
		/**
		 * 不同于Function.apply, 该apply用于过滤对象 public interface Predicate<T> {
		 * boolean apply(T input); }
		 */
		/**
		 * 过滤人口小于500000的城市
		 */
		PopulationPredicate populationPredicate = new PopulationPredicate();
		Set<City> cities = lookup2.apply("k1").getMainCities();
		Iterator<City> iterator = cities.iterator();
		for (; iterator.hasNext();) {
			System.out.println(populationPredicate.apply(iterator.next()));
		}

	}
}
