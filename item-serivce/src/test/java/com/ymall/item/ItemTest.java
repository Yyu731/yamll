package com.ymall.item;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.BulkRequest;
import co.elastic.clients.elasticsearch.core.BulkResponse;
import co.elastic.clients.elasticsearch.core.CreateRequest;
import co.elastic.clients.elasticsearch.core.CreateResponse;
import co.elastic.clients.elasticsearch.core.bulk.BulkResponseItem;
import co.elastic.clients.elasticsearch.indices.CreateIndexRequest;
import co.elastic.clients.elasticsearch.indices.CreateIndexResponse;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ymall.item.domain.po.Item;
import com.ymall.item.domain.po.ItemDoc;
import com.ymall.item.service.IItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQueryBuilder;
import org.springframework.data.elasticsearch.core.query.HighlightQuery;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.highlight.Highlight;
import org.springframework.data.elasticsearch.core.query.highlight.HighlightField;

import java.io.IOException;
import java.io.StringReader;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ClassName: ItemTest
 * Package: com.ymall.item
 * Description:
 *
 * @Author yy
 * @Create 2024-07-07 21:45
 * @Version 1.0
 */
@SpringBootTest
public class ItemTest {

    @Autowired
    private ElasticsearchClient client;

    @Autowired
    private IItemService itemService;

    @Autowired
    private ElasticsearchTemplate template;

    @Test
    public void createIndexTest() throws IOException {
        CreateIndexRequest request = new CreateIndexRequest.Builder()
                .index("items")
                .withJson(new StringReader(MAPPING_TEMPLATE))
                .build();
        CreateIndexResponse response = client.indices().create(request);
        System.out.println(response);
    }

    @Test
    public void InsertTest() throws IOException {
        int pageNo = 1;
        int pageSize = 2000;
        while (true) {
            Page<Item> page = itemService.page(Page.of(pageNo, pageSize));
            if (page.getSize() == 0) {
                break;
            }
            System.out.println(pageNo + "  " + page.getSize());
            BulkRequest.Builder br = new BulkRequest.Builder();
            for (Item item : page.getRecords()) {
                ItemDoc itemDoc = BeanUtil.copyProperties(item, ItemDoc.class);
                br.operations(op -> op
                        .index(idx -> idx
                                .index("users")
                                .id(itemDoc.getId())
                                .document(itemDoc))
                );
            }
            BulkResponse response = client.bulk(br.build());
            for (BulkResponseItem item : response.items()) {
                if (item.error() != null) {
                    System.out.println(item.error());
                    break;
                }
            }
            boolean errors = response.errors();
            if (errors) {
                System.out.println("err");
                break;
            }
            pageNo++;
        }
    }

    @Test
    public void test1() throws IOException {
        ItemDoc itemDoc = new ItemDoc();
        itemDoc.setId("2");
        itemDoc.setName("ceshi");
        itemDoc.setUpdateTime(LocalDateTime.now());

        CreateResponse createResponse = client.create(
                new CreateRequest.Builder<>()
                        .index("items")
                        .id(itemDoc.getId())
                        .document(itemDoc).build()
        );
        System.out.println(createResponse);

    }

    @Test
    public void test2() {
        IndexOperations indexOpt = template.indexOps(ItemDoc.class);
        indexOpt.delete();
        boolean mapping = indexOpt.createWithMapping();
        System.out.println(mapping);
        ItemDoc itemDoc = new ItemDoc();
        itemDoc.setId("1");
        itemDoc.setName("ceshi");
        itemDoc.setUpdateTime(LocalDateTime.now());
        ItemDoc save = template.save(itemDoc);
    }
    
    @Test
    public void test3() {
        IndexOperations indexOpt = template.indexOps(ItemDoc.class);
        indexOpt.delete();
        indexOpt.createWithMapping();
        int pageNo = 1;
        int pageSize = 1000;
        while (true) {
            Page<Item> page = itemService.page(Page.of(pageNo, pageSize));
            if (CollectionUtil.isEmpty(page.getRecords())) {
                break;
            }
            List<ItemDoc> itemDocs = page.getRecords().stream().map(item -> BeanUtil.copyProperties(item, ItemDoc.class)).collect(Collectors.toList());
            template.save(itemDocs);
            pageNo++;
        }
    }
    
    @Test
    public void test4() {
        Criteria criteria = new Criteria();
        criteria.and(new Criteria("name").is("脱脂牛奶"));
        Query query =  new CriteriaQueryBuilder(criteria)
                .withPageable(PageRequest.of(1,20))
                .withHighlightQuery(new HighlightQuery(new Highlight(List.of(new HighlightField("name"))),null))
                .build();
        SearchHits<ItemDoc> searchHits = template.search(query, ItemDoc.class);
        for (SearchHit<ItemDoc> searchHit : searchHits.getSearchHits()) {
            System.out.println(searchHit.getHighlightFields());
        }
    }

    static final String MAPPING_TEMPLATE = "{\n" +
            "  \"mappings\": {\n" +
            "    \"properties\": {\n" +
            "      \"id\": {\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"name\":{\n" +
            "        \"type\": \"text\",\n" +
            "        \"analyzer\": \"ik_max_word\"\n" +
            "      },\n" +
            "      \"price\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"stock\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"image\":{\n" +
            "        \"type\": \"keyword\",\n" +
            "        \"index\": false\n" +
            "      },\n" +
            "      \"category\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"brand\":{\n" +
            "        \"type\": \"keyword\"\n" +
            "      },\n" +
            "      \"sold\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"commentCount\":{\n" +
            "        \"type\": \"integer\"\n" +
            "      },\n" +
            "      \"isAD\":{\n" +
            "        \"type\": \"boolean\"\n" +
            "      },\n" +
            "      \"updateTime\":{\n" +
            "        \"type\": \"date\"\n" +
            "      }\n" +
            "    }\n" +
            "  }\n" +
            "}";
}
