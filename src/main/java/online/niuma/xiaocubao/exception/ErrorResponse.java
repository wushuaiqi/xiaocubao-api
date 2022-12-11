package online.niuma.xiaocubao.exception;

import lombok.Data;

/**
 * {@code @date} 2022/12/8
 *
 * @author 一颗蛋50斤
 * IntelliJ IDEA
 */
@Data
public class ErrorResponse {
    private Integer code;
    private String message;
    private Object trace;
}
