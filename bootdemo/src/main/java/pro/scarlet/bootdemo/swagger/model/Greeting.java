package pro.scarlet.bootdemo.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/***
 * @author scarlet
 * @date
 */

@ApiModel("问候实体")
public class Greeting {
    @ApiModelProperty("问候id")
    private final long id;
    @ApiModelProperty("问候内容")
    private final String content;

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

}
