package com.stomato.service;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.stomato.domain.Page;
import com.stomato.service.GoodsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class GoodsServiceTest {

	private static final Logger log = Logger.getLogger(GoodsServiceTest.class);
	@Resource
	GoodsService goodsService;
	
	@Test
	public void queryGoods(){
		Map<String,Object> paramMap  =new HashMap<String,Object>();
		paramMap.put("offset", 1);
		paramMap.put("pageSize", 5);
		try {
			Page<Map<String, Object>> result = goodsService.queryGoods(paramMap);
goodsService			System.out.println(result.getDataList());
		} catch (Exception err){
			log.error(err);
		}
	}
	@Test
	public void getGoodsDetail(){
		Map<String,Object> paramMap  =new HashMap<String,Object>();
		paramMap.put("id", 40);
		try {
			Map<String, Object> result = goodsService.getGoodsDetail(paramMap);
			System.out.println(result);
		} catch (Exception err){
			log.error(err);
		}
	}
}
