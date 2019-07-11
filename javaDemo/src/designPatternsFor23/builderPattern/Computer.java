package designPatternsFor23.builderPattern;

import java.util.ArrayList;
import java.util.List;

public class Computer {
	/**
     * �����������
     */
    private List<String> parts = new ArrayList<String>();

    public void Add(String part) {
        parts.add(part);
    }

    public void print() {
        for (String part : parts) {
            System.out.println("���:" + part + "װ����...");
        }
        System.out.println("������װ���...");
    }
}
