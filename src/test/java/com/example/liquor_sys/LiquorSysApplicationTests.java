package com.example.liquor_sys;

import com.example.liquor_sys.entity.Goods;
import com.example.liquor_sys.mapper.GoodsMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LiquorSysApplicationTests {

	@Autowired
	private GoodsMapper goodsMapper;

	@Test
	void testConnection() {
		System.out.println("----- 🚀 数据库连接测试开始 -----");

		List<Goods> goodsList = goodsMapper.selectList(null);
		goodsList.forEach(System.out::println);

		System.out.println("----- 🚀 数据库连接测试结束 -----");
	}
}