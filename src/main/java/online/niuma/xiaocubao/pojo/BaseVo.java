package online.niuma.xiaocubao.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * {@code @date} 2022/12/9
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public abstract class BaseVo {

    private Long id;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private LocalDateTime createdTime;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyyMMddHHmmss")
    private LocalDateTime updatedTime;

}
