package online.niuma.xiaocubao.utils;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.IFill;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.LikeTable;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.fill.Column;
import online.niuma.xiaocubao.pojo.BaseEntity;

import java.util.ArrayList;

/**
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
public class Generator {

    public static void main(String[] args) {

        // 配置数据库
        DataSourceConfig dataSource = new DataSourceConfig.Builder("jdbc:mysql://localhost:3306/xiaocubao?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&useSSL=true&serverTimezone=GMT%2B8",
                "root", "Root123.").build();

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig.Builder()
                // 禁止打开输出目录
                .disableOpenDir()
                // 设置作者
                .author("一颗蛋50斤")
                // 代码生成目录
                .outputDir(System.getProperty("user.dir") + "/src/main/java")
                // 开启 swagger
                .enableSwagger()
                // 使用 java.time 包下的时间策略
                .dateType(DateType.TIME_PACK)
                // 注释日期
                .commentDate("yyyy-MM-dd")
                .build();
        // 包配置
        PackageConfig packageConfig = new PackageConfig.Builder()
                // 设置父包名
                .parent("online.niuma.xiaocubao")
                // 设置实体类包名
                .entity("pojo.entity")
                // 设置 service 包名
                .service("service")
                // 设置 service 实现类包名
                .serviceImpl("service.impl")
                // 设置 mapper 包名
                .mapper("repository")
                // 设置 mapper xml 包名
                .xml("mybatisXml")
                // 设置 controller 包名
                .controller("controller")
                .build();

        // 设置自动填充字段
        ArrayList<IFill> iFills = new ArrayList<>();
        iFills.add(new Column("created_time", FieldFill.INSERT));
        iFills.add(new Column("updated_time", FieldFill.INSERT_UPDATE));
        // 策略配置
        StrategyConfig strategyConfig = new StrategyConfig.Builder()
                // 添加表过滤前缀
                .addTablePrefix("tb_")
                // 添加忽略的表
                .notLikeTable(new LikeTable("flyway_schema_history"))
                // 实体策略配置
                .entityBuilder()
                // 设置父类
                .superClass(BaseEntity.class)
                // 开启 lombok
                .enableLombok()
                // 开启 Boolean 类型字段移除 is 前缀
                .enableRemoveIsPrefix()
                // 乐观锁的数据库字段
                .versionColumnName("version")
                // 乐观锁的实体类属性名
                .versionPropertyName("version")
                // 逻辑删除的数据库字段
                .logicDeleteColumnName("deleted")
                // 逻辑删除的实体类属性名
                .logicDeletePropertyName("deleted")
                // 设置下划线转驼峰命名
                .naming(NamingStrategy.underline_to_camel)
                // 添加自动填充字段
                .addTableFills(iFills)
                // 定义 id 的类型
                .idType(IdType.ASSIGN_ID)
                // 添加忽略字段
                .addIgnoreColumns("created_time", "updated_time")
                // controller 策略
                .controllerBuilder()
                // 开启 rest 风格
                .enableRestStyle()
                // mapper 策略
                .mapperBuilder()
                // 开启 @Mapper 注解
                .enableMapperAnnotation()
                .formatMapperFileName("%sRepository")
                .formatXmlFileName("%sRepository")
                .build();

        AutoGenerator autoGenerator = new AutoGenerator(dataSource);
        autoGenerator.global(globalConfig);
        autoGenerator.packageInfo(packageConfig);
        autoGenerator.strategy(strategyConfig);
        autoGenerator.execute();
    }
}
