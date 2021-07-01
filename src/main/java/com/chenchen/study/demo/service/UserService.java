package com.chenchen.study.demo.service;

import com.chenchen.study.demo.dao.UserEntity;
import com.chenchen.study.demo.dao.mapper.UserMapper;
import com.chenchen.study.demo.domain.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @Description
 * @Author:sjZhao
 * @Date:2021/6/2819:03
 */
@Service
public class UserService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private RedisTemplate redisTemplate;

    List<UserInfo> getInfos(){
        List<UserInfo> userInfos = new ArrayList<UserInfo>();
        UserEntity userEntity =userMapper.selectById("1112");

        /**RedisTemplate 的试用代码 start**/

        //根据key删除redis中的数据
        String deleteKey ="123";
        List<String> deleteKeys = new LinkedList<>();
        redisTemplate.delete(deleteKey);
        redisTemplate.delete(deleteKeys);
        //指定key的失效时间
        String expireKey = "123";
        redisTemplate.expire(expireKey,1, TimeUnit.MINUTES );
        long timeOut = redisTemplate.getExpire(expireKey);
        //判断key是否存在
        boolean ifExist = redisTemplate.hasKey(expireKey);
        //*****************String   strat*******************************************
        //通过redisTemplate设置值
        redisTemplate.boundValueOps("test1").set("20210701");
        redisTemplate.boundValueOps("test2").set("20210701",120,TimeUnit.MINUTES);
        //通过BoundValueOperations获取值
        BoundValueOperations StringKey =  redisTemplate.boundValueOps("test1");
        String StringValue = (String)StringKey.get();
        //通过valueOperations设置值
        ValueOperations operations = redisTemplate.opsForValue();
        operations.set("test3","202107011416");
        operations.set("test4","202107011417",1,TimeUnit.MINUTES);
        //通过RedisTemplate设置值
        String  val1 = (String) redisTemplate.boundValueOps("test1").get();
        //通过BoundValueOperations获取值
        BoundValueOperations stringKey = redisTemplate.boundValueOps("StringKey");
        String str2 = (String)stringKey.get();
        //通过ValueOperations获取值
        ValueOperations ops = redisTemplate.opsForValue();
        String StringValue2 = (String) ops.get("test1");
        //删除 key
        Boolean result = redisTemplate.delete("StringKey");
        //顺序递增
        redisTemplate.boundValueOps("StringKey").increment(3L);
        //顺序递减
        redisTemplate.boundValueOps("StringKey").increment(-3L);


        //*********************String   end***************************************

        //**********************hash  start******************************************
        //通过redisTemplate设置值
        redisTemplate.boundHashOps("hashKey1").put("smallkey","HashValue");
        //通过BoundHashOperations获取值
        BoundHashOperations hashKey2 = redisTemplate.boundHashOps("hashKey2");
        //通过ValueOperations设置值
        HashOperations hashOperations = redisTemplate.opsForHash();
        hashOperations.put("HashKey","SmallKey","HashValue");
        //添加一个Map集合
        HashMap<String ,String> hashMap = new HashMap<>();
        redisTemplate.boundHashOps("HashKey").putAll(hashMap);
        //提取所有的小key
        Set keys1 = redisTemplate.boundHashOps("hashKey").keys();
        BoundHashOperations boundHashOperations = redisTemplate.boundHashOps("hashKey1");
        Set keys2 = boundHashOperations.keys();
        HashOperations operations1 = redisTemplate.opsForHash();
        Set keys3 = operations1.keys("hashKey");
        //提取所有的value
        List values1 = redisTemplate.boundHashOps("hashKey").values();
        BoundHashOperations boundHashOperations1 = redisTemplate.boundHashOps("hashKey");
        List values2 = boundHashOperations1.values();
        HashOperations hashOperations1 = redisTemplate.opsForHash();
        List values3 =  hashOperations1.values("hashKey");
        //根据key提取value值
        String value1 = (String)redisTemplate.boundHashOps("hashKey").get("smallKey");
        BoundHashOperations hashOperations2 = redisTemplate.boundHashOps("hashKey");
        String value2 = (String)hashOperations2.get("smallKey");
        HashOperations hashOperations3 = redisTemplate.opsForHash();
        String value3 = (String)hashOperations3.get("HashKey", "SmallKey");
        //获取所有的键值对集合
        Map map = redisTemplate.boundHashOps("hashkey").entries();
        BoundHashOperations boundHashOperations2 = redisTemplate.boundHashOps("hashKey");
        Map map1 = boundHashOperations2.entries();
        HashOperations hashOperations4 = redisTemplate.opsForHash();
        Map map2 = hashOperations4.entries("hashKey");
        //删除
        redisTemplate.boundHashOps("hashkey").delete("smallkey");
        redisTemplate.delete("hashkey");
        //判断hash中是否含有该值
        boolean flag = redisTemplate.boundHashOps("hashKey").hasKey("smallkey");
        //***********************hash  end***************************************

        //***********************List start***************************************
        //通过redisTemplate设置值
        redisTemplate.boundListOps("listkey").leftPush("listleftvalue1");
        redisTemplate.boundListOps("lsitkey").rightPush("listrightvalue2");
        //通过BoundListOperations设置值
        BoundListOperations boundListOperations = redisTemplate.boundListOps("lsitkey");
        boundListOperations.rightPush("listrightvalue2");
        boundListOperations.leftPush("listleftvalue2");
        //将List放入缓存
        List<String> list = new LinkedList<String>();
        redisTemplate.boundListOps("listKey").rightPush(list);
        redisTemplate.boundListOps("listkey").leftPush(list);
        //获取List缓存全部内容（起始索引，结束索引）
        List listKey = redisTemplate.boundListOps("listkey").range(0,100);
        //从左或者从右弹出一个元素
        String listKey1 = (String)redisTemplate.boundListOps("listkey").leftPop();
        String listKey2 = (String)redisTemplate.boundListOps("listkey").rightPop();
        String listkey3 =  (String)redisTemplate.boundListOps("listkey").index(3);
        Long size = redisTemplate.boundListOps("listKey").size();
        redisTemplate.boundListOps("listKey").set(3,"value");
        //移除N个值为value（key，移除个数，值）
        redisTemplate.boundListOps("listKey").remove(3L,"value");
        //***********************List  end***************************************

        //***********************Zset  end***************************************
        //1、通过redisTemplate设置值
        redisTemplate.boundZSetOps("zsetkey").add("zsetvalue",100D);
        //2.通过BoundZSetOperations设置值
        BoundZSetOperations zsetkey = redisTemplate.boundZSetOps("zsetkey");
        zsetkey.add("zsetvalue",100D);
        //3.通过ValueOperations设置值
        ZSetOperations zSetOperations = redisTemplate.opsForZSet();
        zSetOperations.add("zsetkey","zsetvalue",100D);
        //向集合中插入多个元素，并设置分数
        DefaultTypedTuple<String> p2 = new DefaultTypedTuple<>("zSetVaule2", 3.3D);
        DefaultTypedTuple<String> p1 = new DefaultTypedTuple<>("zSetVaule1", 2.1D);
        redisTemplate.boundZSetOps("zSetKey").add(new HashSet<>(Arrays.asList(p1,p2)));
        //按照排名先后（从小到大）打印指定区间内的元素，-1为打印全部。
        Set<String> range = redisTemplate.boundZSetOps("zsetkey").range(0,-1);
        //获得指定元素的分数
        Double score = redisTemplate.boundZSetOps("zsetkey").score("zsetvalue");
        //返回集合内的成员个数
        Long size1 = redisTemplate.boundZSetOps("zsetkey").size();
        //返回集合内指定分数范围的成员个数（Double类型）
        Long count = redisTemplate.boundZSetOps("zsetkey").count(0D,2.2D);
        //返回集合内元素在指定的分数范围内的排名（从小到大）
        Set byScore = redisTemplate.boundZSetOps("zsetkey").rangeByScore(0D,2.2D);
        //带偏移量和个数，(key，起始分数，最大分数，偏移量，个数)
        Set<String> ranking2 = redisTemplate.opsForZSet().rangeByScore("zSetKey",0D,2.2D,1, 3);
        //返回集合内元素的排名，以及分数（从小到大）
        Set<ZSetOperations.TypedTuple<String>> tuples = redisTemplate.boundZSetOps("zSetKey").rangeWithScores(0L, 3L);
        for (ZSetOperations.TypedTuple<String> tuple : tuples) {
            System.out.println(tuple.getValue() + " : " + tuple.getScore());
        }

        //***********************Zset  end***************************************
        /**RedisTemplate 的试用代码 end**/
        return userInfos;
    }
}
