package com.platon.browser.engine.cache;

import com.platon.browser.dto.CustomBlock;
import com.platon.browser.dto.CustomDelegation;
import com.platon.browser.dto.CustomNode;
import com.platon.browser.dto.CustomStaking;
import com.platon.browser.engine.BlockChain;
import com.platon.browser.engine.stage.BlockChainStage;
import com.platon.browser.engine.stage.StakingStage;
import com.platon.browser.exception.NoSuchBeanException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @Auther: Chendongming
 * @Date: 2019/8/27 11:16
 * @Description: 节点缓存更新器
 */
@Component
public class StakingCacheUpdater {
    private static Logger logger = LoggerFactory.getLogger(StakingCacheUpdater.class);
    @Autowired
    private BlockChain bc;
    @Autowired
    private CacheHolder cacheHolder;

    String tpl = "节点ID:NODEID,现块号:CUR_NUM,前轮块数:PRE_COUNT,现轮块数:CUR_COUNT";
    /**
     * 更新质押中与区块相关的信息, 每采集到一个区块调用一次
     */
    public void updateStakingPerBlock() {
        NodeCache nodeCache = cacheHolder.getNodeCache();
        BlockChainStage stageData = cacheHolder.getStageData();
        CustomBlock curBlock = bc.getCurBlock();
        String info = tpl.replace("NODEID",curBlock.getNodeId().substring(0,10))
                .replace("CUR_NUM",curBlock.getBlockNumber().toString());
        try {
            CustomNode customNode = nodeCache.getNode(curBlock.getNodeId());
            CustomStaking customStaking = customNode.getLatestStaking();
            //if(customStaking.getIsConsensus()== CustomStaking.YesNoEnum.YES.code){
                info = info.replace("PRE_COUNT",customStaking.getPreConsBlockQty().toString());
                // 当前共识周期出块奖励
                BigDecimal curConsBlockReward = customStaking.decimalBlockRewardValue().add(bc.getBlockReward());
                customStaking.setBlockRewardValue(curConsBlockReward.toString());

                // 节点出块数加1
                customStaking.setCurConsBlockQty(customStaking.getCurConsBlockQty()+1);
                // 把更改后的内容暂存至待更新列表
                stageData.getStakingStage().updateStaking(customStaking);
                info = info.replace("CUR_COUNT",customStaking.getCurConsBlockQty().toString());
            //}
        } catch (NoSuchBeanException e) {
            logger.error("更新出块奖励和共识出块数错误,找不到符合条件的质押信息:{}",e.getMessage());
        }
        logger.debug("出块统计:{}", info);
    }


    static class Stat{
        private BigInteger statDelegateHas,statDelegateLocked,statDelegateReduction,statDelegateQty;
        void reset(){
            this.statDelegateHas = BigInteger.ZERO;
            this.statDelegateLocked = BigInteger.ZERO;
            this.statDelegateReduction = BigInteger.ZERO;
            this.statDelegateQty = BigInteger.ZERO;
        }
    }
    private Stat stat = new Stat();
    /**
     * 更新质押相关的统计信息，在批量采集后批量入库前执行
     *  1.补充统计质押相关数据
     *      a.stat_delegate_has  关联的委托记录中犹豫期金额汇总
     *      b.stat_delegate_locked  关联的委托记录中锁定期金额汇总
     *      c.stat_delegate_reduction   关联的委托记录中退回中金额汇总
     *      d.stat_delegate_qty  关联的委托地址数
     */
    public void updateStakingStatistics () {
        NodeCache nodeCache = cacheHolder.getNodeCache();
        BlockChainStage stageData = cacheHolder.getStageData();
        StakingStage stakingStage = cacheHolder.getStageData().getStakingStage();
        nodeCache.getAllStaking().forEach(staking -> {
            stat.reset(); // 重置统计bean状态, 复用实例，避免大量创建对象
            staking.getDelegations().forEach((senderAddr,delegation)->{
                if (delegation.getIsHistory()==CustomDelegation.YesNoEnum.NO.getCode()) {
                    stat.statDelegateHas = stat.statDelegateHas.add(delegation.integerDelegateHas());
                    stat.statDelegateLocked = stat.statDelegateLocked.add(delegation.integerDelegateLocked());
                    stat.statDelegateReduction = stat.statDelegateReduction.add(delegation.integerDelegateReduction());
                    stat.statDelegateQty = stat.statDelegateQty.add(BigInteger.ONE);
                }
            });
            staking.setStatDelegateHas(stat.statDelegateHas.toString());
            staking.setStatDelegateLocked(stat.statDelegateLocked.toString());
            staking.setStatDelegateReduction(stat.statDelegateReduction.toString());
            staking.setStatDelegateQty(stat.statDelegateQty.intValue());
            // 把质押信息改动暂存至待更新列表
            stakingStage.updateStaking(staking);
        });
    }
}
