/**
 * Copyright (c) 2011-2016, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.baomidou.mybatisplus.test.generator;

import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.converts.OracleTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.*;

/**
 * <p>
 * 代码生成器演示
 * </p>
 *
 * @author hubin
 * @date 2016-12-01
 */
public class OrcaleGenerator {

    /**
     * <p>
     * MySQL 生成演示
     * </p>
     */
    public static void main(String[] args) {
        int result = scanner();
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
            // 全局配置
            new GlobalConfig()
                .setOutputDir("F:/open_source_framework/persistence/mybatis-plus/mybatis-plus-generate/develop/code/")//输出目录
                .setFileOverride(true)// 是否覆盖文件
                .setActiveRecord(true)// 开启 activeRecord 模式
                .setEnableCache(false)// XML 二级缓存
                .setBaseResultMap(true)// XML ResultMap
                .setBaseColumnList(true)// XML columList
                .setAuthor("lics")
        ).setDataSource(
            // 数据源配置
            new DataSourceConfig()
                .setDbType(DbType.ORACLE)// 数据库类型
                .setTypeConvert(new OracleTypeConvert() {
                    // 自定义数据库表字段类型转换【可选】
                    @Override
                    public DbColumnType processTypeConvert(String fieldType) {
                        System.out.println("转换类型：" + fieldType);
                        return super.processTypeConvert(fieldType);
                    }
                })
                .setDriverName("oracle.jdbc.driver.OracleDriver")
                .setUsername("omsprd")
                .setPassword("oms123prd")
                .setUrl("jdbc:oracle:thin:@localhost:omsbit")
        ).setStrategy(
            // 策略配置
            new StrategyConfig()
                .setTablePrefix(new String[]{"", ""})// 此处可以修改为您的表前缀
                .setTableSuffix(new String[]{"T","View"}) //此处可以修改为您的表后缀
                .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                .setInclude(new String[] {
                   /* "SYSTEM_CONFIG_T",
                    "MESSAGE_SHORTMSG_T",
                    "ERROR_NOTIFY_T",
                    "WMS_MALL_ITEM_T",
                    "EOS_ITEM_LOG_T",
                    "ERP_ITEM_INFO_T",*/
//                    "SHOP_STOCK_ONLINE_LOG_T"
//                    "SHOP_ITEM_INFO_T",
                    "WTC_MIX_ITEM_T"
                }) // 需要生成的表

        ).setPackageInfo(
            // 包配置
            new PackageConfig()
                .setMapper("dao") // 这里是DAO包名，默认 mapper
                .setEntity("model") // 这里是Entity包名，默认 entity
                .setParent("com.suneee.ep.product")// 自定义包路径
                .setController("controller") // 这里是控制器包名，默认 web
                .setXml("mapper")  // 这里是XML映射文件, 默认 xml
        ).setCfg(
            // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
            new InjectionConfig() {
                @Override
                public void initMap() {
                    Map<String, Object> map = new HashMap<>();
                    map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                    this.setMap(map);
                }
            }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig(
                "/templates/mapper.xml" + ((1 == result) ? ".ftl" : ".vm")) {
                // 自定义输出文件目录
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return "/develop/code/xml/" + tableInfo.getEntityName() + ".xml";
                }
            }))
        ).setTemplate(
            //开启 xml 生成
            new TemplateConfig()
        );
        // 执行生成
        if (1 == result) {
            mpg.setTemplateEngine(new FreemarkerTemplateEngine());
        }
        mpg.execute();
        // 打印注入设置，这里演示模板里面怎么获取注入内容【可无】
        System.err.println(mpg.getCfg().getMap().get("abc"));
    }

    public static int scanner() {
//        Scanner scanner = new Scanner(System.in);
//        StringBuilder help = new StringBuilder();
//        help.append(" ！！代码生成, 输入 0 表示使用 Velocity 引擎 ！！");
//        help.append("\n对照表：");
//        help.append("\n0 = Velocity 引擎");
//        help.append("\n1 = Freemarker 引擎");
//        help.append("\n请输入：");
//        System.out.println(help.toString());
//        int slt = 0;
//        // 现在有输入数据
//        if (scanner.hasNext()) {
//            String ipt = scanner.next();
//            if ("1".equals(ipt)) {
//                slt = 1;
//            }
//        }
//        return slt;
        return 0;
    }
}
