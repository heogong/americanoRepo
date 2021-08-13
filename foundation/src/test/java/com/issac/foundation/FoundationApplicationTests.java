package com.issac.foundation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class FoundationApplicationTests {

	@Test
	public void contextLoads() {

		ArrayList<Map<String, Integer>> listMap = new ArrayList<Map<String, Integer>>();
		ArrayList<Map<String, Object>> listSender2 = new ArrayList<Map<String, Object>>();

		Map<String, Integer> productCoupon1 = new HashMap<String, Integer>();
		Map<String, Integer> productCoupon2 = new HashMap<String, Integer>();

		Map<String, Object> qrCoponCount1 = new HashMap<String, Object>();
		Map<String, Object> qrCoponCount2 = new HashMap<String, Object>();
		Map<String, Object> qrCoponCount3 = new HashMap<String, Object>();
		Map<String, Object> qrCoponCount4 = new HashMap<String, Object>();
		Map<String, Object> qrCoponCount5 = new HashMap<String, Object>();

		productCoupon1.put("product", 1111);
		productCoupon1.put("stNo", 1);
		productCoupon1.put("edNo", 10);
		productCoupon1.put("count", 10);

		listMap.add(productCoupon1);

		productCoupon2.put("product", 2222);
		productCoupon2.put("stNo", 25);
		productCoupon2.put("edNo", 35);
		productCoupon2.put("count", 10);

		listMap.add(productCoupon2);

		qrCoponCount1.put("qrName", "qr1");
		qrCoponCount1.put("qrCount", 4);

		listSender2.add(qrCoponCount1);

		qrCoponCount2.put("qrName", "qr2");
		qrCoponCount2.put("qrCount", 4);

		listSender2.add(qrCoponCount2);

		qrCoponCount3.put("qrName", "qr3");
		qrCoponCount3.put("qrCount", 4);

		listSender2.add(qrCoponCount3);

		qrCoponCount4.put("qrName", "qr4");
		qrCoponCount4.put("qrCount", 4);

		listSender2.add(qrCoponCount4);

		qrCoponCount5.put("qrName", "qr5");
		qrCoponCount5.put("qrCount", 4);

		listSender2.add(qrCoponCount5);

		int remainderValue = 0;

		// 제품 반복

		int index = 0;

		for(Map<String, Integer> aa : listMap) {

			int product = aa.get("product");
			int stNo = aa.get("stNo");
			int edNo = aa.get("edNo");
			int totalCount = aa.get("count");

			while(totalCount > 0) {

				System.out.println("1 : totalCount : "+totalCount);
				System.out.println("qrName : "+listSender2.get(index).get("qrName"));

				int qrCount = (int) listSender2.get(index).get("qrCount");
				int couponEdNo = 0;

				if(qrCount <= totalCount) {
					couponEdNo = stNo + ((qrCount - 1) - remainderValue);
					qrCount -= remainderValue;
					remainderValue = 0;
					index++;
				} else {
					couponEdNo = stNo + ((qrCount - totalCount) - 1);
					remainderValue = qrCount - totalCount;
				}

				System.out.println("index : "+index);
				System.out.println("couponStNo : "+stNo);

				stNo = couponEdNo + 1;
				totalCount = totalCount - qrCount;


				System.out.println("couponEdNo : "+couponEdNo);
				System.out.println("2: totalCount : "+totalCount);
				System.out.println("qrCount : "+qrCount);
				System.out.println("remainderValue : "+remainderValue);
				System.out.println("==================================");

			}

		}
	}

	@Test
	public void contextLoads2() {

		ArrayList<Map<String, Integer>> listMap = new ArrayList<Map<String, Integer>>();
		ArrayList<Map<String, Object>> listSender2 = new ArrayList<Map<String, Object>>();

		Map<String, Integer> productCoupon1 = new HashMap<String, Integer>();
		Map<String, Integer> productCoupon2 = new HashMap<String, Integer>();

		Map<String, Object> qrCoponCount1 = new HashMap<String, Object>();
		Map<String, Object> qrCoponCount2 = new HashMap<String, Object>();
		Map<String, Object> qrCoponCount3 = new HashMap<String, Object>();
		Map<String, Object> qrCoponCount4 = new HashMap<String, Object>();
		Map<String, Object> qrCoponCount5 = new HashMap<String, Object>();

		productCoupon1.put("product", 1111);
		productCoupon1.put("stNo", 1);
		productCoupon1.put("edNo", 10);
		productCoupon1.put("count", 10);

		listMap.add(productCoupon1);

		productCoupon2.put("product", 2222);
		productCoupon2.put("stNo", 25);
		productCoupon2.put("edNo", 35);
		productCoupon2.put("count", 10);

		listMap.add(productCoupon2);

		qrCoponCount1.put("qrName", "qr1");
		qrCoponCount1.put("qrCount", 5);

		listSender2.add(qrCoponCount1);

		qrCoponCount2.put("qrName", "qr2");
		qrCoponCount2.put("qrCount", 5);

		listSender2.add(qrCoponCount2);

		qrCoponCount3.put("qrName", "qr3");
		qrCoponCount3.put("qrCount", 5);

		listSender2.add(qrCoponCount3);

		qrCoponCount4.put("qrName", "qr4");
		qrCoponCount4.put("qrCount", 5);

		listSender2.add(qrCoponCount4);

		int remainderValue = 0;

		// 제품 반복

		int index = 0;

		for(Map<String, Integer> aa : listMap) {

			int product = aa.get("product");
			int stNo = aa.get("stNo");
			int edNo = aa.get("edNo");
			int totalCount = aa.get("count");

			while(totalCount > 0) {

				System.out.println("1 : totalCount : "+totalCount);
				System.out.println("qrName : "+listSender2.get(index).get("qrName"));

				int qrCount = (int) listSender2.get(index).get("qrCount");
				int couponEdNo = 0;

				if(qrCount <= totalCount) {
					couponEdNo = stNo + ((qrCount - 1) - remainderValue);
					qrCount -= remainderValue;
					remainderValue = 0;
					index++;
				} else {
					couponEdNo = stNo + ((qrCount - totalCount) - 1);
					remainderValue = qrCount - totalCount;
				}

				System.out.println("index : "+index);
				System.out.println("couponStNo : "+stNo);

				stNo = couponEdNo + 1;
				totalCount = totalCount - qrCount;


				System.out.println("couponEdNo : "+couponEdNo);
				System.out.println("2: totalCount : "+totalCount);
				System.out.println("qrCount : "+qrCount);
				System.out.println("remainderValue : "+remainderValue);
				System.out.println("==================================");

			}

		}
	}

}
