package com.platon.browser.service;

import com.platon.browser.elasticsearch.dto.Block;
import com.platon.browser.elasticsearch.dto.NodeOpt;
import com.platon.browser.elasticsearch.dto.Transaction;
import com.platon.browser.utils.HexTool;
import lombok.Data;
import org.apache.commons.codec.digest.DigestUtils;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Data
public class BlockResult {

    static class AddressCount {
        private String address;
        private Integer count=0;
        public String get(String newAddress){
            if(count==0||count>=100)  {
                address = newAddress;
                count=1;
                return address;
            }
            count++;
            return address;
        }
    }
    private static final AddressCount FROM_ADDRESS = new AddressCount();
    private static final AddressCount TO_ADDRESS = new AddressCount();

    private Block block;
    private List<Transaction> transactionList=new ArrayList<>();
    private List<NodeOpt> nodeOptList=new ArrayList<>();

    public void buildAssociation(BigInteger blockNumber, String nodeId,long nodeOptId){
        block.setNum(blockNumber.longValue());
        block.setNodeId(nodeId);
        String blockHash = HexTool.prefix(DigestUtils.sha256Hex(block.toString()));
        block.setHash(blockHash);
        int i = 0;
        for (Transaction tx : transactionList) {
            tx.setBHash(blockHash);
            tx.setNum(blockNumber.longValue());
            String txHash = HexTool.prefix(DigestUtils.sha256Hex(tx.toString()));
            tx.setHash(txHash);
            String from = HexTool.prefix(DigestUtils.sha1Hex(tx.toString()));
            tx.setFrom(FROM_ADDRESS.get(from));
            String to = HexTool.prefix(DigestUtils.sha1Hex(tx.toString()));
            tx.setTo(TO_ADDRESS.get(to));
            tx.setIndex(i);
            i++;
        }

        for (NodeOpt nodeOpt : nodeOptList) {
            nodeOpt.setId(nodeOptId++);
            nodeOpt.setNodeId(nodeId);
            nodeOpt.setBNum(blockNumber.longValue());
        }
    }
}
