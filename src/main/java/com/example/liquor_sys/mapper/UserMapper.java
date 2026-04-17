package com.example.liquor_sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.liquor_sys.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}