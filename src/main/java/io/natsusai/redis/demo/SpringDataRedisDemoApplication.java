package io.natsusai.redis.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataRedisDemoApplication {

  public static void main(String[] args) {

    SpringApplication.run(SpringDataRedisDemoApplication.class, args);
  }

//  @Repository
//  public class UserDao {
//
//    @Autowired
//    private RedisTemplate<Serializable, Serializable> redisTemplate;
//
//    public void saveUser(final SecurityProperties.User user) {
//      redisTemplate.execute(new RedisCallback<Object>() {
//        public Object doInRedis(RedisConnection redisConnection)
//            throws DataAccessException {
//          redisConnection.set(redisTemplate.getStringSerializer()
//                                           .serialize("user.id." + user.getId()),
//                              redisTemplate.getStringSerializer()
//                                           .serialize((user.getUsername())));
//          return null;
//        }
//      });
//    }
//
//    public User getUser(final long id)    {
//      return redisTemplate.execute(new RedisCallback<User>() {
//        public User doInRedis(RedisConnection redisConnection)
//            throws DataAccessException {
//          byte[] key = redisTemplate.getStringSerializer()
//                                    .serialize("user.id." + id);
//          if (redisConnection.exists(key)) {
//            byte[] value = redisConnection.get(key);
//            String username = redisTemplate.getStringSerializer()
//                                           .deserialize(value);
//            User   user = new User();
//            user.setUsername(username);
//            user.setId(id);
//            return user;
//          }
//          return null;
//        }
//      });
//    }
//
//  }

}
