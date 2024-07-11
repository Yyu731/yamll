package com.ymall.item.controller;


import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymall.common.domain.PageDTO;
import com.ymall.common.domain.R;
import com.ymall.item.domain.po.ItemDoc;
import com.ymall.item.domain.query.ItemPageQuery;
import com.ymall.item.service.IItemService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.data.elasticsearch.core.query.highlight.Highlight;
import org.springframework.data.elasticsearch.core.query.highlight.HighlightField;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "搜索相关接口")
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {

    private final IItemService itemService;

    private final ElasticsearchTemplate template;

    @Operation(summary = "搜索商品")
    @GetMapping("/list")
    public R<PageDTO<ItemDoc>> search(ItemPageQuery query) {
        // 分页查询
//        Page<Item> docList = itemService.lambdaQuery()
//                .like(StrUtil.isNotBlank(query.getKey()), Item::getName, query.getKey())
//                .eq(StrUtil.isNotBlank(query.getBrand()), Item::getBrand, query.getBrand())
//                .eq(StrUtil.isNotBlank(query.getCategory()), Item::getCategory, query.getCategory())
//                .eq(Item::getStatus, 1)
//                .between(query.getMaxPrice() != null, Item::getPrice, query.getMinPrice(), query.getMaxPrice())
//                .page(query.toMpPage("update_time", false));


        //elasticsearch 查询

        Criteria criteria = new Criteria();
        if (StrUtil.isNotBlank(query.getKey())) {
            criteria.and(new Criteria("name").is(query.getKey()));
        }
        if (StrUtil.isNotBlank(query.getCategory())) {
            criteria.and(new Criteria("category").is(query.getCategory()));
        }
        if (StrUtil.isNotBlank(query.getBrand())) {
            criteria.and(new Criteria("brand").is(query.getBrand()));
        }
        if (ObjectUtil.isNotEmpty(query.getMinPrice())) {
            criteria.and(new Criteria("price").greaterThanEqual(query.getMinPrice()));
        }
        if (ObjectUtil.isNotEmpty(query.getMaxPrice())) {
            criteria.and(new Criteria("price").greaterThanEqual(query.getMaxPrice()));
        }
        Query criteriaQuery = new CriteriaQueryBuilder(criteria)
                .withPageable(PageRequest.of(query.getPageNo() - 1, query.getPageSize()))
                .withHighlightQuery(new HighlightQuery(new Highlight(List.of(new HighlightField("name"))), null))
                .withSort(Sort.by(new Order(
                        query.getIsAsc() ? Sort.Direction.ASC : Sort.Direction.DESC
                        , StrUtil.isBlank(query.getSortBy())?"updateTime":query.getSortBy())))
                .build();
        SearchHits<ItemDoc> searchHits = template.search(criteriaQuery, ItemDoc.class);
        List<ItemDoc> docList = new ArrayList<>();
        for (SearchHit<ItemDoc> searchHit : searchHits.getSearchHits()) {
            ItemDoc itemDoc = searchHit.getContent();
            String name = searchHit.getHighlightField("name").stream().reduce(String::concat).orElse(null);
            if (StrUtil.isNotBlank(name)) {
                itemDoc.setName(name);
            }
            docList.add(searchHit.getContent());
        }
        // 封装并返回
        return R.ok(PageDTO.of(Page.of(query.getPageNo(), query.getPageSize(), searchHits.getTotalHits()), docList));
    }
}
