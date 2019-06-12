package io.natsusai.redis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author liufuhong
 * @since 2019-06-10 15:04
 */

public class Startup implements CommandLineRunner {


  @Autowired
  RedisTemplate redisTemplate;

  @Override
  public void run(String... args)
      throws Exception {


    ValueOperations ops = redisTemplate.opsForValue();
    ops.set("test", "value");
    System.out.println(ops.get("test"));
  }

}
