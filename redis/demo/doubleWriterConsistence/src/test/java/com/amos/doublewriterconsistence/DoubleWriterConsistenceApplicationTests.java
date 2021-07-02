package com.amos.doublewriterconsistence;

import com.alibaba.fastjson.JSONObject;
import com.amos.doublewriterconsistence.mapper.InventoryMapper;
import com.amos.doublewriterconsistence.mapper.ShopInventoryMapper;
import com.amos.doublewriterconsistence.service.impl.InventoryCacheServiceImpl;
import com.amos.doublewriterconsistence.service.impl.InventoryServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DoubleWriterConsistenceApplicationTests {

    @Autowired
    InventoryMapper shopInventoryMapper;

    @Test
    public void contextLoads() {
    }

    @Test
    public void selectById(){

        System.out.println(JSONObject.toJSONString(shopInventoryMapper.selectById("1")));

    }

}
