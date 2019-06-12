package io.natsusai.redis.demo;

import java.io.Serializable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author liufuhong
 * @since 2019-06-10 15:05
 */

//@Configuration
public class RedisConfig {



  /**
   * 直接new 一个对象返回，即默认它的各项属性(端口，主机名，密码等等)为默认值，
   *
   * @return
   */
  @Bean
  public JedisConnectionFactory jedisConnectionFactory() {

    JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(jedisPoolConfig());
    jedisConnectionFactory.setUsePool(true);
    return jedisConnectionFactory;
  }

  /**
   * jedis连接池配置,直接new 一个对象返回，使用默认值，如有需要可以为其各个属性配置值
   *
   * @return
   */
  @Bean
  public JedisPoolConfig jedisPoolConfig() {

    return new JedisPoolConfig();
  }

  @Bean
  public RedisTemplate<Serializable, Serializable> redisTemplate() {

    RedisTemplate<Serializable, Serializable> redisTemplate = new RedisTemplate<Serializable, Serializable>();
    redisTemplate.setConnectionFactory(jedisConnectionFactory());
    return redisTemplate;
  }
}
