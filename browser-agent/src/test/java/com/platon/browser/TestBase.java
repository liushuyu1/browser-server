package com.platon.browser;

import com.alibaba.fastjson.JSON;
import com.platon.browser.bean.TransactionBean;
import com.platon.browser.dto.*;
import com.platon.browser.engine.cache.NodeCache;
import com.platon.browser.exception.CacheConstructException;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @Auther: Chendongming
 * @Date: 2019/9/7 16:35
 * @Description:
 */
public class TestBase {
    private static Logger logger = LoggerFactory.getLogger(TestBase.class);
    private static String prefix = "data/",suffix=".json",encode="UTF8";
    private static String[] dataFile = {"node","block","transaction","staking","delegation","unDelegation"};

    public static NodeCache NODE_CACHE = new NodeCache();
    public static List<CustomNode> nodes= Collections.EMPTY_LIST;
    public static List<CustomBlock> blocks= Collections.EMPTY_LIST;
    public static List<TransactionBean> transactions= Collections.EMPTY_LIST;
    public static List<CustomStaking> stakings= Collections.EMPTY_LIST;
    public static List<CustomDelegation> delegations= Collections.EMPTY_LIST;
    public static List<CustomUnDelegation> unDelegations= Collections.EMPTY_LIST;
    static {
        Arrays.asList(dataFile).forEach(fileName->{
            try {
                URL url = TestBase.class.getClassLoader().getResource(prefix+fileName+suffix);
                String path = url.getPath();
                String content = FileUtils.readFileToString(new File(path),encode);

                switch (fileName){
                    case "node":
                        nodes = JSON.parseArray(content,CustomNode.class);
                        break;
                    case "block":
                        blocks = JSON.parseArray(content,CustomBlock.class);
                        break;
                    case "transaction":
                        transactions = JSON.parseArray(content,TransactionBean.class);
                        break;
                    case "staking":
                        stakings = JSON.parseArray(content,CustomStaking.class);
                        break;
                    case "delegation":
                        delegations = JSON.parseArray(content,CustomDelegation.class);
                        break;
                    case "unDelegation":
                        unDelegations = JSON.parseArray(content,CustomUnDelegation.class);
                        break;

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        Map<Long,List<CustomTransaction>> txMap = new HashMap<>();
        transactions.forEach(tx->{
            List<CustomTransaction> txes = txMap.computeIfAbsent(tx.getBlockNumber(), k -> new ArrayList<>());
            txes.add(tx);
        });
        blocks.forEach(block -> {
            List<CustomTransaction> txes = txMap.get(block.getNumber());
            if(txes!=null) block.setTransactionList(txes);
        });

        try {
            NODE_CACHE.init(nodes,stakings,delegations,unDelegations);
        } catch (CacheConstructException e) {
            e.printStackTrace();
        }
        logger.info("测试数据加载完成！");
    }
}
