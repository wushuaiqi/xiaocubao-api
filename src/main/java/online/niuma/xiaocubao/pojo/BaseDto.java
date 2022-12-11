package online.niuma.xiaocubao.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * {@code @date} 2022/12/9
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public abstract class BaseDto {

    private Long id;

    private LocalDateTime createdTime;

    private LocalDateTime updatedTime;

}
