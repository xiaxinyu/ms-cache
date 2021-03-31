package com.sailfish.cache.redis;

import com.sailfish.cache.redis.utils.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.CollectionUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

/**
 * @author XIAXINYU3
 * @date 2021/3/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {RedisCacheApplication.class})
public class RedisUtilsTest {
    @Autowired
    RedisUtils redisUtils;

    @Test
    public void setRedisUtils() {
        String key = "online-number";

        Date date = new Date();
        long t1 = date.getTime();
        redisUtils.add(key, "t1", t1);

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long t2 = calendar.getTime().getTime();
        redisUtils.add(key, "t2", t2);
        System.out.println("t2 = " + t2);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long t3 = calendar.getTime().getTime();
        redisUtils.add(key, "t3", t3);
        System.out.println("t3 = " + t3);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long t4 = calendar.getTime().getTime();
        redisUtils.add(key, "t4", t4);
        System.out.println("t4 = " + t4);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long t5 = calendar.getTime().getTime();
        redisUtils.add(key, "t5", t5);
        System.out.println("t5 = " + t5);

        calendar.add(Calendar.DAY_OF_MONTH, 1);
        long t6 = calendar.getTime().getTime();
        redisUtils.add(key, "t6", t6);
        System.out.println("t6 = " + t6);

        Set<Object> items = redisUtils.rangeByScore(key, t2, t4);
        if (!CollectionUtils.isEmpty(items)) {
            for (Object item : items) {
                System.out.println("item=" + item);
            }
        }

        System.out.println("count=" + redisUtils.count(key, t2, t4));


        System.out.println("count=" + redisUtils.zrem(key, "t3"));

        System.out.println("count=" + redisUtils.count(key, t2, t4));
    }
}
