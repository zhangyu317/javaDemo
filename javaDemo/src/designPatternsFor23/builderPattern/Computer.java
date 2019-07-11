package designPatternsFor23.builderPattern;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	/**
     * 电脑组件集合
     */
    private List<String> parts = new ArrayList<String>();

    public void Add(String part) {
        parts.add(part);
    }

    public void print() {
        for (String part : parts) {
            System.out.println("组件:" + part + "装好了...");
        }
        System.out.println("电脑组装完毕...");
    }
}
