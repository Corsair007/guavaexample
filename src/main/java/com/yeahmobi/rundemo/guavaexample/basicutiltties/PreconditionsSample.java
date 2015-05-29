package com.yeahmobi.rundemo.guavaexample.basicutiltties;

import com.google.common.base.Preconditions;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name 检验参数是否合法
 * @desc Preconditions提供静态方法来检查方法或构造函数，被调用是否给定适当的参数。它检查的先决条件。
 *        其方法失败抛出IllegalArgumentException。
 * @author root
 */
public class PreconditionsSample {
	public static void main(String[] args) throws Exception {

		getPersonByPrecondition(8, "peida");

		try {
			getPersonByPrecondition(-9, "peida");
		} catch (Exception e) {
			print("getPersonByPrecondition(-9, \"peida\")", e.getMessage());
		}

		try {
			getPersonByPrecondition(8, "");
		} catch (Exception e) {
			print("getPersonByPrecondition(8, \"peida\")", e.getMessage());
		}

		try {
			getPersonByPrecondition(8, null);
		} catch (Exception e) {
			print("getPersonByPrecondition(8, null)", e.getMessage());
		}
	}

	public static void getPersonByPrecondition(int age, String neme)
			throws Exception {
		Preconditions.checkNotNull(neme, "name为null");
		Preconditions.checkArgument(neme.length() > 0, "neme为\'\'");
		Preconditions.checkArgument(age > 0, "age 必须大于0");
		System.out.println("a person age:" + age + ",name:" + neme);
	}
}
