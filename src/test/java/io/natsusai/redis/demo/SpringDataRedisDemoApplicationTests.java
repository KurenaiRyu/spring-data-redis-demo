package io.natsusai.redis.demo;

import com.alibaba.fastjson.JSON;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringDataRedisDemoApplicationTests {

  static final String permissionKey = "permission";

  @Autowired
  RedisTemplate<String, String> redisTemplate;

  @Test
  public void contextLoads() {

  }

  @Test
  public void testRedis() {

    ValueOperations<String, String> ops = redisTemplate.opsForValue();
    ops.set("test", "value");
    Assert.assertEquals("value", ops.get("test"));

    List<Permission> permissions = new ArrayList<>();
    Permission       permission  = new Permission();
    permission.setUrl("testUrl");
    permissions.add(permission);
    HashOperations<String, String, String> opsHash = redisTemplate.opsForHash(); opsHash.put("permission", "app", JSON.toJSONString(permissions));
    System.out.println(opsHash.get("permission", "list"));
    System.out.println(opsHash.delete(permissionKey, "delete"));
  }

  @Data
  class Permission implements Serializable {
    private String url;
  }


}
