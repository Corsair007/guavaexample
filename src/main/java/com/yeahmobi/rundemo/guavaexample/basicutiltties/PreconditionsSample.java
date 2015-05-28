package com.yeahmobi.rundemo.guavaexample.basicutiltties;

import com.google.common.base.Preconditions;

import static com.yeahmobi.rundemo.guavaexample.utils.PrintUtils.*;

/**
 * @rundemo_name Preconditions的检验参数
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
