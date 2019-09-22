package com.opot.count.mapper;
import com.opot.count.entity.Count;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CountMapper {
    /**
     * 获取用户总量
     * @return
     */
    @Select("Select count(*) from user")
    long getUsersNum();

    /**
     * 获取某一天的搜索总量
     * @param day
     * @return
     */
    @Select("SELECT COUNT(*) FROM history WHERE DATEDIFF(create_time,NOW())=#{day}")
    long getDaySearchNum(@Param("day")int day);

    /**
     * 获取最近三天搜索过的用户列表
     * @return
     */
    @Select("SELECT uid FROM history WHERE DATEDIFF(create_time,NOW())=0 OR DATEDIFF(create_time,NOW())=-1 or DATEDIFF(create_time,NOW())=-2 GROUP BY uid")
    List<Integer> getDayUsers();

    /**
     * 用户最近三天的搜索数量
     * @param uid
     * @return
     */
    @Select("#SELECT COUNT(*) FROM history WHERE uid =12 AND DATEDIFF(create_time,NOW())=0 \n" +
            "SELECT `user`.username,(SELECT COUNT(*) FROM history WHERE uid =#{uid} AND DATEDIFF(create_time,NOW())=0) AS today,(SELECT COUNT(*) FROM history WHERE uid =#{uid} AND DATEDIFF(create_time,NOW())=-1) AS yesterday,(SELECT COUNT(*) FROM history WHERE uid =#{uid} AND DATEDIFF(create_time,NOW())=-2) AS dayBeforeYesterday FROM `user` WHERE id =#{uid}")
    Count getUserInfo(@Param("uid")Integer uid);
}
