package com.my.web.jedis;

import org.junit.Test;
import redis.clients.jedis.Jedis;


/**
 * Author：Jiang
 * Date：2019/12/15
 * Time：22:20
 * jedis的测试（java操作redis就是jedis）
 */
public class JedisTest {

    @Test
    public void test1(){
        //1.获取连接   ip+端口
        Jedis jedis = new Jedis("localhost",6379);
        //2.设值
        jedis.set("name","lisi");
        //3.关闭
        jedis.close();

    }
}
