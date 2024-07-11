package com.ymall.item.domain.po;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDateTime;

@Data
@Schema(description = "索引库实体")
@Document(indexName = "items")
public class ItemDoc {

    @Schema(description = "商品id")
    @Id
    @Field
    private String id;

    @Schema(description = "商品名称")
    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    private String name;

    @Schema(description = "价格（分）")
    @Field(type = FieldType.Integer)
    private Integer price;

    @Schema(description = "商品图片")
    @Field(type = FieldType.Keyword, index = false)
    private String image;

    @Schema(description = "类目名称")
    @Field(type = FieldType.Keyword)
    private String category;

    @Schema(description = "品牌名称")
    @Field(type = FieldType.Keyword)
    private String brand;

    @Schema(description = "销量")
    @Field(type = FieldType.Integer)
    private Integer sold;

    @Schema(description = "评论数")
    @Field(type = FieldType.Integer)
    private Integer commentCount;

    @Schema(description = "是否是推广广告，true/false")
    @Field(type = FieldType.Boolean)
    private Boolean isAD;

    @Schema(description = "更新时间")
    @Field(type = FieldType.Date,format = {DateFormat.date_hour_minute_second_millis, DateFormat.epoch_millis})
    private LocalDateTime updateTime;
}