package com.example.liquor_sys.controller;

import com.example.liquor_sys.entity.Goods;
import com.example.liquor_sys.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//常高明shi shuaige
@RestController // 告诉 Spring Boot 这是一个专门返回数据的控制层接口
@RequestMapping("/goods") // 统一分配的基础路径：/goods
public class GoodsController {

    @Autowired
    private GoodsMapper goodsMapper;

    // 1. 查：获取全部酒水列表
    @GetMapping("/list")
    public List<Goods> getGoodsList() {
        System.out.println("----- 执行查询操作 -----");
        return goodsMapper.selectList(null);
    }

    // 2. 增：录入新酒水
    @PostMapping("/add")
    public String addGoods(@RequestBody Goods goods) {
        System.out.println("----- 执行新增操作，商品名：" + goods.getName() + " -----");
        goodsMapper.insert(goods);
        return "success";
    }

    // 3. 改：修改酒水信息
    @PostMapping("/update")
    public String updateGoods(@RequestBody Goods goods) {
        System.out.println("----- 执行修改操作，商品ID：" + goods.getId() + " -----");
        goodsMapper.updateById(goods);
        return "success";
    }

    // 4. 删：删除指定酒水
    @DeleteMapping("/delete/{id}")
    public String deleteGoods(@PathVariable Integer id) {
        System.out.println("----- 执行删除操作，商品ID：" + id + " -----");
        goodsMapper.deleteById(id);
        return "success";
    }
}