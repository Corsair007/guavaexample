package com.yeahmobi.rundemo.guavaexample.function;

import com.google.common.base.Function;
import com.google.common.base.Joiner;

/**
 * 将州的城市转换为字符串
 */
public class StateToCityString implements Function<State, String> {
    public String apply(State input) {
        return Joiner.on(",").join(input.getMainCities());
    }
}
