package com.org.Demo.mp.config;

import com.p6spy.engine.spy.appender.MessageFormattingStrategy;
import org.springframework.context.annotation.Configuration;

/**
 * @author xujiafu
 * @date 2021/11/28 10:43
 */

public class P6spyLogFormatStrategy implements MessageFormattingStrategy {


    /**
     * 日志格式化方式（打印SQL日志会进入此方法，耗时操作，生产环境不建议使用）
     *
     * @param connectionId: 连接ID
     * @param now:          当前时间
     * @param elapsed:      花费时间
     * @param category:     类别
     * @param prepared:     预编译SQL
     * @param sql:          最终执行的SQL
     * @param url:          数据库连接地址
     * @return 格式化日志结果
     * @date 2020/1/16 9:52
     * @author lixiangx@leimingtech.com
     **/
    @Override
    public String formatMessage(int connectionId, String now, long elapsed,
                                String category, String prepared, String sql,
                                String url) {
        return "SQL耗时【" + elapsed + "毫秒】 连接信息【" + url + "】 最终执行SQL【" + sql + "】";
    }
}
